package me.johngreen.com.Events;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Mobs;
import me.johngreen.com.Functions.Npcs;
import me.johngreen.com.Functions.Skills;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public class onChunkLoad implements Listener {
    public onChunkLoad(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void highLogin(ChunkLoadEvent e) {
    	for(Entity ent:e.getChunk().getEntities()){
	    		ent.remove();
    	}
    }
    @EventHandler
    public void highLogin(ChunkUnloadEvent e) {
    	for(Entity ent:e.getChunk().getEntities()){
	    		ent.remove();
    	}
    }
}
