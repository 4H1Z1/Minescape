package me.johngreen.com.Events;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Trading;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class onPlayerPickupItemEvent implements Listener {
    public onPlayerPickupItemEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onSpawn(PlayerPickupItemEvent e)
	{
		if(Trading.inTrade.contains(e.getPlayer())){
			e.setCancelled(true);
		}
	}
}
