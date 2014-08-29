package me.johngreen.com.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.FloatingText;
import me.johngreen.com.Functions.Npcs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class onPlayerMove implements Listener {
    public onPlayerMove(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    public static HashMap<Player,List<Location>> LastBlock = new HashMap<Player,List<Location>>();
    @EventHandler
    public void onEntityTarget(PlayerMoveEvent e){
    	Player p = (Player)e.getPlayer();
    	Location l = new Location(p.getWorld(),(int)p.getLocation().getX(),(int)p.getLocation().getY(),(int)p.getLocation().getZ());
    	Location floor =new Location(p.getWorld(),(int)p.getLocation().getX(),(int)p.getLocation().getY()-1,(int)p.getLocation().getZ());
    	if(floor.getBlock().getType().isSolid()&&!l.getBlock().isLiquid()){
    		LastBlock.put(p, rebuildArray(p,l));
    	}else{
    		if(l.getBlock().isLiquid()){
    			if(LastBlock.get(p)==null){
    				p.teleport(new Location(p.getWorld(),-342,69,146));
    			}else{
    				if(LastBlock.get(p).size()>1){
	    				p.teleport(LastBlock.get(p).get(0));
	    				LastBlock.get(p).remove(0);
	    			}else{
	    				p.teleport(LastBlock.get(p).get(0));
	    				LastBlock.get(p).remove(0);
	    			}
    			}
    		}
    	}
    }
    
    
    
    private List<Location> rebuildArray(Player p,Location l){
    	List<Location> list = LastBlock.get(p);
    	if(list==null){
    		List<Location> a = new ArrayList<Location>();
    		a.add(l);
    		return a;
    	}
    	if(list.size()<=9){
    		if(list.get(list.size()-1).equals(l)){
    			return list;
    		}else{
    			List<Location> a = list;
    			a.add(l);
    			return a;
    		}
    	}else{
    		if(list.get(list.size()-1).equals(l)){
    			return list;
    		}else{
    			List<Location> a = list;
    			a.remove(0);
    			a.add(l);
    			return a;
    		}
    	}
    }
}
