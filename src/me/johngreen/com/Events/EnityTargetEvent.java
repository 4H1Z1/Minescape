package me.johngreen.com.Events;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.johngreen.com.Main;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class EnityTargetEvent implements Listener {
	static HashMap<Player,List<UUID>> Agro = new HashMap<Player,List<UUID>>();
    public EnityTargetEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void onEntityTarget(EntityTargetEvent e){
    	if(e.getTarget() instanceof Player){
    		if(!Agro.containsKey((Player)e.getTarget())){
        		e.setCancelled(true);
        	}else{
        		if(Agro.get(e.getTarget()).contains(e.getEntity().getUniqueId())){
        			
        		}else{
        			e.setCancelled(true);
        		}
        	}
    	}
    	if(e.getTarget() instanceof Villager){
    		e.setCancelled(true);
    	}
    }
}
