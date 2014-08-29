package me.johngreen.com.Events;



import me.johngreen.com.Main;
import me.johngreen.com.Functions.Bank;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class onInventoryCloseEvent implements Listener {
    public onInventoryCloseEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityTarget(InventoryCloseEvent e){
    	Player p = (Player) e.getPlayer();
    	p.updateInventory();
    	if(e.getInventory().getTitle().contains("Bank")){
    		Bank.InventoryCloseHandler(e);
    	}
    }
}
