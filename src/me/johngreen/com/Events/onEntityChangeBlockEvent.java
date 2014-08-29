package me.johngreen.com.Events;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.MobDrops;
import me.johngreen.com.Functions.Mobs;
import me.johngreen.com.Functions.Skills;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class onEntityChangeBlockEvent implements Listener {
    public onEntityChangeBlockEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void highLogin(EntityChangeBlockEvent e) {
    	if(e.getEntityType().equals(EntityType.SILVERFISH)){
    		e.setCancelled(true);
    	}
    }
}
