package me.johngreen.com.Functions;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.PacketConstructor;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class WrapperPlayServerSpawnEntityLiving
  extends AbstractPacket
{
  public static final PacketType TYPE = PacketType.Play.Server.SPAWN_ENTITY_LIVING;
  private static PacketConstructor entityConstructor;
  
  public WrapperPlayServerSpawnEntityLiving()
  {
    super(new PacketContainer(TYPE), TYPE);
    this.handle.getModifier().writeDefaults();
  }
  
  public WrapperPlayServerSpawnEntityLiving(PacketContainer packet)
  {
    super(packet, TYPE);
  }
  
  public WrapperPlayServerSpawnEntityLiving(Entity entity)
  {
    super(fromEntity(entity), TYPE);
  }
  
  private static PacketContainer fromEntity(Entity entity)
  {
    if (entityConstructor == null) {
      entityConstructor = ProtocolLibrary.getProtocolManager().createPacketConstructor(TYPE, new Object[] { entity });
    }
    return entityConstructor.createPacket(new Object[] { entity });
  }
  
  public int getEntityID()
  {
    return ((Integer)this.handle.getIntegers().read(0)).intValue();
  }
  
  public Entity getEntity(World world)
  {
    return (Entity)this.handle.getEntityModifier(world).read(0);
  }
  
  public Entity getEntity(PacketEvent event)
  {
    return getEntity(event.getPlayer().getWorld());
  }
  
  public void setEntityID(int value)
  {
    this.handle.getIntegers().write(0, Integer.valueOf(value));
  }
  
  public EntityType getType()
  {
    return EntityType.fromId(((Integer)this.handle.getIntegers().read(1)).intValue());
  }
  
  public void setType(EntityType value)
  {
    this.handle.getIntegers().write(1, Integer.valueOf(value.getTypeId()));
  }
  
  public double getX()
  {
    return ((Integer)this.handle.getIntegers().read(2)).intValue() / 32.0D;
  }
  
  public void setX(double value)
  {
    this.handle.getIntegers().write(2, Integer.valueOf((int)Math.floor(value * 32.0D)));
  }
  
  public double getY()
  {
    return ((Integer)this.handle.getIntegers().read(3)).intValue() / 32.0D;
  }
  
  public void setY(double value)
  {
    this.handle.getIntegers().write(3, Integer.valueOf((int)Math.floor(value * 32.0D)));
  }
  
  public double getZ()
  {
    return ((Integer)this.handle.getIntegers().read(4)).intValue() / 32.0D;
  }
  
  public void setZ(double value)
  {
    this.handle.getIntegers().write(4, Integer.valueOf((int)Math.floor(value * 32.0D)));
  }
  
  public float getYaw()
  {
    return ((Byte)this.handle.getBytes().read(0)).byteValue() * 360.0F / 256.0F;
  }
  
  public void setYaw(float value)
  {
    this.handle.getBytes().write(0, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
  }
  
  public float getHeadPitch()
  {
    return ((Byte)this.handle.getBytes().read(1)).byteValue() * 360.0F / 256.0F;
  }
  
  public void setHeadPitch(float value)
  {
    this.handle.getBytes().write(1, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
  }
  
  public float getHeadYaw()
  {
    return ((Byte)this.handle.getBytes().read(2)).byteValue() * 360.0F / 256.0F;
  }
  
  public void setHeadYaw(float value)
  {
    this.handle.getBytes().write(2, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
  }
  
  public double getVelocityX()
  {
    return ((Integer)this.handle.getIntegers().read(5)).intValue() / 8000.0D;
  }
  
  public void setVelocityX(double value)
  {
    this.handle.getIntegers().write(5, Integer.valueOf((int)(value * 8000.0D)));
  }
  
  public double getVelocityY()
  {
    return ((Integer)this.handle.getIntegers().read(6)).intValue() / 8000.0D;
  }
  
  public void setVelocityY(double value)
  {
    this.handle.getIntegers().write(6, Integer.valueOf((int)(value * 8000.0D)));
  }
  
  public double getVelocityZ()
  {
    return ((Integer)this.handle.getIntegers().read(7)).intValue() / 8000.0D;
  }
  
  public void setVelocityZ(double value)
  {
    this.handle.getIntegers().write(7, Integer.valueOf((int)(value * 8000.0D)));
  }
  
  public WrappedDataWatcher getMetadata()
  {
    return (WrappedDataWatcher)this.handle.getDataWatcherModifier().read(0);
  }
  
  public void setMetadata(WrappedDataWatcher value)
  {
    this.handle.getDataWatcherModifier().write(0, value);
  }
}
