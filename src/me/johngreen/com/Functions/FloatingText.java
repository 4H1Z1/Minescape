package me.johngreen.com.Functions;

import java.util.List;
import java.util.UUID;

import me.johngreen.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.comphenix.protocol.wrappers.WrappedDataWatcher;

public class FloatingText{
    private static int entityId = Short.MAX_VALUE;
    private static Main plugin;
    
    public FloatingText(Main instance)
    {
      plugin = instance;
    }
    private static final int WITHER_SKULL = 66;
    
	public static void spawnNametag(Location locz, double dy,  String message,String type) {
        WrapperPlayServerSpawnEntityLiving horse = new WrapperPlayServerSpawnEntityLiving();
        WrapperPlayServerSpawnEntity skull = new WrapperPlayServerSpawnEntity();
        WrapperPlayServerAttachEntity attach = new WrapperPlayServerAttachEntity();
        Location loc = locz;
        loc.setY(locz.getY()+1);
        
        // Initialize horse packet
        horse.setEntityID(entityId++);
        horse.setType(EntityType.HORSE);
        setLocation(horse, dy, loc);
 
        WrappedDataWatcher wdw = new WrappedDataWatcher();
        wdw.setObject(10, message);
        wdw.setObject(11, (byte) 1);
        wdw.setObject(12, -1700000);
        horse.setMetadata(wdw);
        
        // Initialize skull packet
        skull.setEntityID(entityId++);
        skull.setType(WITHER_SKULL);
        setLocation(skull, dy, loc);
 
        // The horse is riding on the skull
        attach.setEntityId(horse.getEntityID());
        attach.setVehicleId(skull.getEntityID());
       for(World w:Bukkit.getWorlds()){
    	   for(Player p:Bukkit.getServer().getWorld(w.getName()).getPlayers()){
    	        horse.sendPacket(p);
    	        skull.sendPacket(p);
    	        attach.sendPacket(p);
           }
       }
       if(type=="damage"||type=="xp"){
    	   despawnNametag(horse.getEntityID(),skull.getEntityID());
       }
    }
	public static void despawnNametag(int id,int id2) {
		Runnable r = new destroyText(id,id2);
		new Thread(r).start();
	}
    private static void setLocation(WrapperPlayServerSpawnEntity living, double dy, Location location) {
        living.setX(location.getX());
        living.setY(location.getY() + dy + 55);
        living.setZ(location.getZ());
    }
    
    private static void setLocation(WrapperPlayServerSpawnEntityLiving living, double dy, Location location) {
        living.setX(location.getX());
        living.setY(location.getY() + dy + 55);
        living.setZ(location.getZ());
    }
    
    
}
