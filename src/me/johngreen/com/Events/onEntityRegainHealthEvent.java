package me.johngreen.com.Events;

import me.johngreen.com.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class onEntityRegainHealthEvent implements Listener {
    public onEntityRegainHealthEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }
 private Main plugin;
    @EventHandler
    public void onEntityTarget(EntityRegainHealthEvent e){
    	if(e.getEntity() instanceof Player){
    		e.setCancelled(true);
    	}
    }
}
