package me.johngreen.com.Events;

import java.util.HashMap;
import java.util.UUID;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.FloatingText;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class onEntityTakingDamage implements Listener {
	static HashMap<Player,UUID> Agro = new HashMap<Player,UUID>();
    public onEntityTakingDamage(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void onEntityTarget(EntityDamageEvent e){
    	if(e.getEntity() instanceof Player){
    		Player p = (Player)e.getEntity();
    		if(e.getCause() == DamageCause.DROWNING||
    				e.getCause() == DamageCause.FALL||
    				e.getCause() == DamageCause.FALLING_BLOCK||
    				e.getCause() == DamageCause.FIRE||
    				e.getCause() == DamageCause.LAVA||
    				e.getCause() == DamageCause.STARVATION||
    				e.getCause() == DamageCause.SUFFOCATION||
    				e.getCause() == DamageCause.FIRE_TICK){
    			e.setCancelled(true);
    		}
    	}
    }
}
