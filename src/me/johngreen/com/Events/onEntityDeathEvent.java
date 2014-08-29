package me.johngreen.com.Events;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.DamageCalculation;
import me.johngreen.com.Functions.MobDrops;
import me.johngreen.com.Functions.Mobs;
import me.johngreen.com.Functions.Skills;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class onEntityDeathEvent implements Listener {
    public onEntityDeathEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void highLogin(EntityDeathEvent e) {
    	e.setDroppedExp(0);
    	e.getDrops().clear();
    	if(e.getEntity().getKiller() instanceof Player){
    		Player p = e.getEntity().getKiller();
    		
    		if(bowInHand(p)){
    			if(DamageCalculation.Type.containsKey(p)){
    				if(DamageCalculation.Type.get(p)=="Agressive"){
    					Skills.Range.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}else if(DamageCalculation.Type.get(p)=="Defence"){
    					Skills.Defence.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}else{
    					Skills.Range.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}
    			}else{
    				Skills.Range.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    			}
    		}else if(staffInHand(p)){
    			if(DamageCalculation.Type.containsKey(p)){
    				if(DamageCalculation.Type.get(p)=="Agressive"){
    					Skills.Magic.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}else if(DamageCalculation.Type.get(p)=="Defence"){
    					Skills.Defence.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}else{
    					Skills.Magic.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}
    			}else{
    				Skills.Magic.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    			}
    		}else{
    			if(DamageCalculation.Type.containsKey(p)){
    				if(DamageCalculation.Type.get(p)=="Agressive"){
    					Skills.Attack.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}else if(DamageCalculation.Type.get(p)=="Defence"){
    					Skills.Defence.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}else if(DamageCalculation.Type.get(p)=="Strength"){
    					Skills.Strength.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}else{
    					Skills.Attack.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    				}
    			}else{
    				Skills.Attack.setXP(Mobs.xpGained.get(e.getEntity().getUniqueId()), p);
    			}
    		}
    		Skills.Health.setXP((Mobs.xpGained.get(e.getEntity().getUniqueId())/3), p);
    		Mobs.xpGained.remove(e.getEntity().getUniqueId());
    		p.openInventory(MobDrops.items(Mobs.mobType.get(e.getEntity().getUniqueId()).getName(), MobDrops.getByName(Mobs.mobType.get(e.getEntity().getUniqueId()).getName())));
    		Mobs.mobType.remove(e.getEntity().getUniqueId());
    		Mobs.Level.remove(e.getEntity().getUniqueId());
    		Mobs.mobs.remove(e.getEntity().getUniqueId());
    	}
    	
    }

	private boolean staffInHand(Player p) {
		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()&&p.getItemInHand().getItemMeta().getDisplayName().contains("Staff")){
			return true;
		}
		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()&&p.getItemInHand().getItemMeta().getDisplayName().contains("Wand")){
			return true;
		}
		return false;
	}

	private boolean bowInHand(Player p) {
		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()&&p.getItemInHand().getItemMeta().getDisplayName().contains("Bow")){
			return true;
		}
		return false;
	}
}
