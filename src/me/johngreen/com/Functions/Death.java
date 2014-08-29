package me.johngreen.com.Functions;

import java.util.List;

import me.johngreen.com.Events.onPlayerDeathEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Death {

	
	public static void creatSign(Player p,Location l,List<ItemStack> inv){
		if(l.getBlock().getType()==Material.AIR){
			l.getBlock().setType(Material.SIGN_POST);
			Sign sign = (Sign) l.getBlock().getState();
			sign.setLine(0, ChatColor.DARK_BLUE+"Grave Stone");
			sign.setLine(1, ChatColor.DARK_BLUE+"Hear lies");
			sign.setLine(2, ChatColor.DARK_BLUE+p.getDisplayName());
			sign.setLine(3, ChatColor.DARK_GREEN+"TimeLeft:120");
			sign.update();
			onPlayerDeathEvent.deathsign.put(p, l);
			Runnable r = new DeathSign(l,p,inv);
			new Thread(r).start();
			
		}else{
			for(int i=0;i<5;i++){
				Location loc = l;
				loc.setY(l.getY()+i);
				Bukkit.broadcastMessage(l.getBlockY()+"");
				if(loc.getBlock().getType()==Material.AIR){
					loc.getBlock().setType(Material.SIGN_POST);
					Sign sign = (Sign) l.getBlock().getState();
					sign.setLine(0, ChatColor.DARK_BLUE+"Grave Stone");
					sign.setLine(1, ChatColor.DARK_BLUE+"Hear lies");
					sign.setLine(2, ChatColor.DARK_BLUE+p.getDisplayName());
					sign.setLine(3, ChatColor.DARK_GREEN+"TimeLeft:120");
					sign.update();
					onPlayerDeathEvent.deathsign.put(p, loc);
					Runnable r = new DeathSign(loc,p,inv);
					new Thread(r).start();
					break;
				}
			}
		}
		
	}
}
