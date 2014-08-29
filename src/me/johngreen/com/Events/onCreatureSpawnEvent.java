package me.johngreen.com.Events;


import me.johngreen.com.Main;
import me.johngreen.com.Functions.Mobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class onCreatureSpawnEvent implements Listener {
    public onCreatureSpawnEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
    	if(event.getSpawnReason()!=SpawnReason.CUSTOM){
    		event.setCancelled(true);
    	}else{
    		
    		LivingEntity ent = event.getEntity();
    		if(event.getEntity().getType().equals(EntityType.PIG_ZOMBIE)){
    			
    					Mobs.customMob.put(event.getEntity().getUniqueId(), Mobs.Cow);
    				
    			
    		}
    	}
    }
}
