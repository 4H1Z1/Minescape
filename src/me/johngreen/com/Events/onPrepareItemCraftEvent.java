package me.johngreen.com.Events;

import java.util.Iterator;

import me.johngreen.com.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Recipe;

public class onPrepareItemCraftEvent  implements Listener {
    public onPrepareItemCraftEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }
 private Main plugin;
    @EventHandler
    public void onEntityTarget(PrepareItemCraftEvent e){
    	Iterator<Recipe>
    	recipes = plugin.getServer().recipeIterator();
    	Recipe recipe;
    	while (recipes.hasNext()) {
    	recipe = recipes.next();
    	recipes.remove();
    	}
    }
}