package me.johngreen.com.Events;

import me.johngreen.com.Main;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class onProjectileHitEvent implements Listener {
    public onProjectileHitEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onSpawn(ProjectileHitEvent e)
	{
		if(e.getEntity() instanceof Arrow){
		    Arrow arrow = (Arrow) e.getEntity();
		    arrow.remove();
		  }
	}
}
