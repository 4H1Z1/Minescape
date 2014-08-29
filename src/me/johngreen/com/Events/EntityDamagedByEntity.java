package me.johngreen.com.Events;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Bank;
import me.johngreen.com.Functions.DamageCalculation;
import me.johngreen.com.Functions.FloatingText;
import me.johngreen.com.Functions.Mobs;
import me.johngreen.com.Functions.Npcs;
import me.johngreen.com.Functions.PlayerInteraction;
import me.johngreen.com.Functions.Shop;
import me.johngreen.com.Functions.Skills;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamagedByEntity implements Listener {
    public EntityDamagedByEntity(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }
 private Main plugin;
    @EventHandler
    public void onEntityTarget(final EntityDamageByEntityEvent e){
    	if(e.getDamager() instanceof Player&&!(e.getEntity() instanceof Player)){
            final Player p = (Player) e.getDamager();
            if(EnityTargetEvent.Agro.containsKey(p)&&!EnityTargetEvent.Agro.get(p).contains(e.getEntity().getUniqueId())){
            	List<UUID> list = EnityTargetEvent.Agro.get(p);
            	list.add(e.getEntity().getUniqueId());
            	EnityTargetEvent.Agro.put(p,list);
            }else{
            	if(!EnityTargetEvent.Agro.containsKey(p)){
	            	List<UUID> list = new ArrayList<UUID>();
	            	list.add(e.getEntity().getUniqueId());
	            	EnityTargetEvent.Agro.put(p,list);	
            	}	
            	
            }
            if(DamageCalculation.hasLevelToUse(p.getItemInHand(), p)){
            	e.setDamage(DamageCalculation.daamgeCalculation(p));
            }else{
            	p.sendMessage(ChatColor.RED+"you dont have the required level to use this");
            	e.setCancelled(true);
            }
            if(p.getItemInHand()!=null){
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
					public void run(){
						p.getItemInHand().setDurability((short)0);
					}
				}, 1L);
            }
    	}
    		if(e.getEntity() instanceof Player&&e.getDamager() instanceof LivingEntity){
    			if(e.getDamage()>=1.0){
    				if(Mobs.maxHit.containsKey(e.getDamager().getUniqueId())){
		    			Random r = new Random();
			    	    int chance = r.nextInt(50);
			    	    if(chance>40){
			    	    	e.setDamage(0.0);
		    	    		//Bukkit.broadcastMessage("0a");
			    	    }else{
			    	    	if(Mobs.maxHit.containsKey(e.getDamager().getUniqueId())){
			    	    		double max = Mobs.maxHit.get(e.getDamager().getUniqueId());
			    	    		double random = new Random().nextDouble();
			    	    		double damage = 0 + (random * (max - 0));
			    	    		if(damage<1.0)damage= 1;
			    	    		e.setDamage(damage);
			    	    		//Bukkit.broadcastMessage(damage+"");
			    	    	}
			    	    }
		    		}
    			}
    	}
    	
    	if(e.getEntity() instanceof Player){
    		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	        {
	          public void run()
	          {
	        	  Player p = (Player) e.getEntity();
	      		if(p.getInventory().getHelmet()!=null){
	      			p.getInventory().getHelmet().setDurability((short)0);
	      		}
	      		if(p.getInventory().getChestplate()!=null){
	      			p.getInventory().getChestplate().setDurability((short)0);
	      		}
	      		if(p.getInventory().getLeggings()!=null){
	      			p.getInventory().getLeggings().setDurability((short)0);
	      		}
	      		if(p.getInventory().getBoots()!=null){
	      			p.getInventory().getBoots().setDurability((short)0);
	      		}
	          }
	        }, 2L);
    	}
    	if(e.getDamager() instanceof Player&&e.getEntity() instanceof Player){
    		Player p1 = (Player) e.getDamager();
    		Player p2 = (Player) e.getEntity();
            if(PlayerInteraction.figting.containsKey(p1)&&PlayerInteraction.figting.containsValue(p2)||PlayerInteraction.figting.containsKey(p2)&&PlayerInteraction.figting.containsValue(p1)){
            }else{
            	e.setCancelled(true);
            }
    	}
    	if(e.getDamage()>0){
	    	if(e.getEntity() instanceof LivingEntity){
	    		if(Npcs.npcs.contains(e.getEntity().getUniqueId())){
	    			e.setCancelled(true);
	    		}else{
	    			if(e.getDamager() instanceof Player){
		    			FloatingText.spawnNametag(e.getEntity().getLocation(), 0.5,ChatColor.RED+"-"+((int)e.getDamage()),"damage");
		    		}
	    		}
	    	}
    	}
    }
}
