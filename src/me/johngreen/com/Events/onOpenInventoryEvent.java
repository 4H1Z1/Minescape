package me.johngreen.com.Events;

import me.johngreen.com.Main;
import me.johngreen.com.Quests.TuturialIsland;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class onOpenInventoryEvent implements Listener {
    public onOpenInventoryEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCreatureSpawn(InventoryOpenEvent e) {
    	Player p = (Player) e.getPlayer();
    	if(TuturialIsland.isInCreative.containsKey(p)&&TuturialIsland.isInCreative.get(p).equals(true)){
    		e.setCancelled(true);
    	}
    	if(e.getInventory().getType()==InventoryType.ANVIL||
    			e.getInventory().getType()==InventoryType.BEACON||
    			e.getInventory().getType()==InventoryType.BREWING||
    			e.getInventory().getType()==InventoryType.CRAFTING||
    			e.getInventory().getType()==InventoryType.DISPENSER||
    			e.getInventory().getType()==InventoryType.ENCHANTING||
    			e.getInventory().getType()==InventoryType.FURNACE||
    			e.getInventory().getType()==InventoryType.HOPPER||
    			e.getInventory().getType()==InventoryType.MERCHANT||
    			e.getInventory().getType()==InventoryType.WORKBENCH){
    		e.setCancelled(true);
    	}
    }
}
