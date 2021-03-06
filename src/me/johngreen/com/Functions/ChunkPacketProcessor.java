package me.johngreen.com.Functions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.World.Environment;

import com.comphenix.protocol.Packets;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;

/**
 * Used to process a chunk.
 * 
 * @author Kristian
 */
public class ChunkPacketProcessor {
    /**
	 * Process the content of a single 16x16x16 chunklet in a 16x256x16 chunk.
	 * @author Kristian
	 */
	public interface ChunkletProcessor {
		public void processChunklet(Location origin, byte[] data, int blockIndex, int dataIndex);
	}
	
	// Useful Minecraft constants
	protected static final int BYTES_PER_NIBBLE_PART = 2048;
	protected static final int CHUNK_SEGMENTS = 16;
	protected static final int NIBBLES_REQUIRED = 4;
	protected static final int BIOME_ARRAY_LENGTH = 256;
	
    private int chunkX;
    private int chunkZ;
    private int chunkMask;
    private int extraMask;
    private int chunkSectionNumber;
    private int extraSectionNumber;
    private boolean hasContinous = true;

    private int startIndex;
    private int size;
    private int blockSize;
    
    private byte[] data;
    private World world;
    
    private ChunkPacketProcessor() {
    	// Use factory methods
    }
    
    /**
     * Construct a chunk packet processor from a givne MAP_CHUNK packet.
     * @param packet - the map chunk packet.
     * @return The chunk packet processor.
     */
    public static ChunkPacketProcessor fromMapPacket(PacketContainer packet, World world) {
    	if (packet.getID() != Packets.Server.MAP_CHUNK)
    		throw new IllegalArgumentException(packet + " must be a MAP_CHUNK packet.");
    	
    	StructureModifier<Integer> ints = packet.getIntegers();
    	StructureModifier<byte[]> byteArray = packet.getByteArrays();
        
        // Create an info objects
    	ChunkPacketProcessor processor = new ChunkPacketProcessor();
    	processor.world = world;
        processor.chunkX = ints.read(0); 	 // packet.a;
        processor.chunkZ = ints.read(1); 	 // packet.b;
        processor.chunkMask = ints.read(2);  // packet.c;
        processor.extraMask = ints.read(3);  // packet.d;
        processor.data = byteArray.read(1);  // packet.inflatedBuffer;
        processor.startIndex = 0;

        if (packet.getBooleans().size() > 0) {
        	processor.hasContinous = packet.getBooleans().read(0);
        }
        return processor;
    }
    
    /**
     * Construct an array of chunk packet processors from a given MAP_CHUNK_BULK packet.
     * @param packet - the map chunk bulk packet.
     * @return The chunk packet processors.
     */
    public static ChunkPacketProcessor[] fromMapBulkPacket(PacketContainer packet, World world) {
    	if (packet.getID() != Packets.Server.MAP_CHUNK_BULK)
    		throw new IllegalArgumentException(packet + " must be a MAP_CHUNK_BULK packet.");
    	
    	StructureModifier<int[]> intArrays = packet.getIntegerArrays();
    	StructureModifier<byte[]> byteArrays = packet.getByteArrays();
    	
        int[] x = intArrays.read(0); // packet.c;
        int[] z = intArrays.read(1); // packet.d;
    	
        ChunkPacketProcessor[] processors = new ChunkPacketProcessor[x.length];

        int[] chunkMask = intArrays.read(2); // packet.a;
        int[] extraMask = intArrays.read(3); // packet.b;
        int dataStartIndex = 0;
        
        for (int chunkNum = 0; chunkNum < processors.length; chunkNum++) {
            // Create an info objects
        	ChunkPacketProcessor processor = new ChunkPacketProcessor();
            processors[chunkNum] = processor;
            processor.world = world;
            processor.chunkX = x[chunkNum];
            processor.chunkZ = z[chunkNum];
            processor.chunkMask = chunkMask[chunkNum];
            processor.extraMask = extraMask[chunkNum];
            processor.hasContinous = true; // Always true
            processor.data = byteArrays.read(1); //packet.buildBuffer;
            
            // Check for Spigot
            if (processor.data == null || processor.data.length == 0) {
            	processor.data = packet.getSpecificModifier(byte[][].class).read(0)[chunkNum];
            } else {
            	processor.startIndex = dataStartIndex;
            }
            dataStartIndex += processor.size;
        }
        return processors;
    }
    
    public void process(ChunkletProcessor processor) {
        // Compute chunk number
        for (int i = 0; i < CHUNK_SEGMENTS; i++) {
            if ((chunkMask & (1 << i)) > 0) {
                chunkSectionNumber++;
            }
            if ((extraMask & (1 << i)) > 0) {
                extraSectionNumber++;
            }
        }
        
        // There's no sun/moon in the end or in the nether, so Minecraft doesn't sent any skylight information
        // This optimization was added in 1.4.6. Note that ideally you should get this from the "f" (skylight) field.
        int skylightCount = world.getEnvironment() == Environment.NORMAL ? 1 : 0;
        
        // The total size of a chunk is the number of blocks sent (depends on the number of sections) multiplied by the 
        // amount of bytes per block. This last figure can be calculated by adding together all the data parts:
        //   For any block:
        //    * Block ID          -   8 bits per block (byte)
        //    * Block metadata    -   4 bits per block (nibble)
        //    * Block light array -   4 bits per block
        //   If 'worldProvider.skylight' is TRUE
        //    * Sky light array   -   4 bits per block
        //   If the segment has extra data:
        //    * Add array         -   4 bits per block
        //   Biome array - only if the entire chunk (has continous) is sent:
        //    * Biome array       -   256 bytes
        // 
        // A section has 16 * 16 * 16 = 4096 blocks. 
        size = BYTES_PER_NIBBLE_PART * (
        					(NIBBLES_REQUIRED + skylightCount) * chunkSectionNumber + 
        					extraSectionNumber) + 
        			(hasContinous ? BIOME_ARRAY_LENGTH : 0);
        
        blockSize = 4096 * chunkSectionNumber;
        
        if (startIndex + blockSize > data.length) {
            return;
        }

        // Make sure the chunk is loaded 
        if (isChunkLoaded(world, chunkX, chunkZ)) {
            translate(processor);
        }
    }
    
    private void translate(ChunkletProcessor processor) {
        // Loop over 16x16x16 chunks in the 16x256x16 column
        int idIndexModifier = 0;
        
        int idOffset = startIndex;
        int dataOffset = idOffset + chunkSectionNumber * 4096;

        for (int i = 0; i < 16; i++) {
            // If the bitmask indicates this chunk is sent
            if ((chunkMask & 1 << i) > 0) {
                int relativeIDStart = idIndexModifier * 4096;
                int relativeDataStart = idIndexModifier * 2048;
                
                int blockIndex = idOffset + relativeIDStart;
                int dataIndex = dataOffset + relativeDataStart;

                // The lowest block (in x, y, z) in this chunklet
                Location origin = new Location(world, chunkX << 4, i * 16, chunkZ << 4);
             
                processor.processChunklet(origin, data, blockIndex, dataIndex);
                idIndexModifier++;
            }
        }
    }
    
    private boolean isChunkLoaded(World world, int x, int z) {
        return world.isChunkLoaded(x, z);
    }
}