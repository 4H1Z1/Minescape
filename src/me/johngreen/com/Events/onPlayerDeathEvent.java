package me.johngreen.com.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Death;
import me.johngreen.com.Functions.DeathSign;
import me.johngreen.com.Functions.PlayerInteraction;
import me.johngreen.com.items.InventoryHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;

public class onPlayerDeathEvent implements Listener {
	static HashMap<Player,UUID> Agro = new HashMap<Player,UUID>();
	public static HashMap<Player,Location> deathsign = new HashMap<Player,Location>();
    public onPlayerDeathEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void onEntityTarget(PlayerDeathEvent e){
    	if(isWithinRegion(e.getEntity().getLocation())){
    		onRespawnEvent.location.put(e.getEntity(), e.getEntity().getLocation());
    	}
    	Player p = e.getEntity();
    	Inventory inv = p.getInventory();
    	inv.addItem(p.getInventory().getArmorContents());
    	e.getDrops().clear();
    	if(EnityTargetEvent.Agro.containsKey(p)){
    		EnityTargetEvent.Agro.remove(p);
    	}
    	List<ItemStack> inv2 = new ArrayList<ItemStack>();
    	for(ItemStack i:inv.getContents()){
    		if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasLore()&&!i.getItemMeta().getLore().contains(ChatColor.BLACK+"NoDrop")){
        	    inv2.add(i);			
    		}
    	}
    	if(inv2.size()>0){
    		DeathSign.invs.put(p.getDisplayName(), inv2);
    		Death.creatSign(p, p.getLocation(),inv2);
    	}
    	e.getDrops().clear();
    	if(PlayerInteraction.figting.containsKey(p)){
    		PlayerInteraction.figting.get(p).sendMessage(ChatColor.GREEN+"You won!");
    		p.sendMessage(ChatColor.RED+"You lost!");
    		PlayerInteraction.figting.remove(p);
    	}
    	if(PlayerInteraction.figting.containsValue(p)){
    		p.sendMessage(ChatColor.RED+"You lost!");
    		for(Player p2:PlayerInteraction.figting.keySet()){
    			if(PlayerInteraction.figting.get(p2)==p){
    				PlayerInteraction.figting.remove(p2);
    				p2.sendMessage(ChatColor.GREEN+"You won!");
    				break;
    			}
    		}
    	}
    }
    
    
    public boolean isWithinRegion(Location loc)
    {
    	if(loc.getX() < 116 && loc.getX() > -100 && loc.getZ()< 630 && loc.getZ() > 372){
    		return true;
      }else{
    	  return false;
      }
    }
    
    
}
