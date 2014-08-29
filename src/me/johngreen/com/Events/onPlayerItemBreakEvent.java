package me.johngreen.com.Events;

import me.johngreen.com.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

public class onPlayerItemBreakEvent implements Listener {
    public onPlayerItemBreakEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void onEntityTarget(PlayerItemBreakEvent e){
    	ItemStack i = e.getBrokenItem();
    	i.setDurability((short) 1);
    	Player p = (Player)e.getPlayer();
    	p.getInventory().addItem(i);
    }
}
