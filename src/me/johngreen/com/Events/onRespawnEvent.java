package me.johngreen.com.Events;

import java.util.HashMap;

import me.johngreen.com.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class onRespawnEvent implements Listener {
    public onRespawnEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    public static HashMap<Player,Location> location = new HashMap<Player,Location>();
    @EventHandler
    public void onEntityTarget(PlayerRespawnEvent e){
    	if(location.containsKey(e.getPlayer())){
    		e.setRespawnLocation(location.get(e.getPlayer()));
    		location.remove(e.getPlayer());
    	}
    	
    }
    
    
}
