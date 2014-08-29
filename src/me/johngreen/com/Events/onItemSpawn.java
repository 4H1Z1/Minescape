package me.johngreen.com.Events;

import me.johngreen.com.Main;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class onItemSpawn implements Listener {
    public onItemSpawn(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
@EventHandler(priority=EventPriority.HIGHEST)
public void onSpawn(ItemSpawnEvent event)
{
	World eworld = event.getLocation().getWorld();
	Item test = event.getEntity();
	ItemStack is = test.getItemStack();
		if (is.getType() != Material.EGG) {
			return;
		}else{
			event.setCancelled(true);
		}
    }
}
