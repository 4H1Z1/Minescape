package me.johngreen.com.Functions;

import java.util.HashMap;
import java.util.List;

import me.johngreen.com.Events.onPlayerDeathEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DeathSign implements Runnable { 
	public static HashMap<String,List<ItemStack>> invs = new HashMap<String,List<ItemStack>>();
	public DeathSign(Location l,Player p,List<ItemStack> inv) {
		this.p = p;
		this.l = l;
		this.inv = inv;
	   }
	private Location l;
	private Player p;
	private List<ItemStack> inv;
	   public void run() { 
		   boolean running = true;
		   int i = 120;
		   p.sendMessage(ChatColor.GREEN+"You have 120 secconds to get your items back before your grave stone breaks");
	       while (running) {
	    	   if(l.getBlock().getType()==Material.AIR){
	    		   running=false;
	    		   break;
	    	   }
	    	   if(!onPlayerDeathEvent.deathsign.containsKey(p)){
	    		   running=false;
	    		   break;
	    	   }
	    	   if(i==60){
	    		   p.sendMessage(ChatColor.GREEN+"You have 60 secconds remaining");
	    	   }else
	    	   if(i==30){
	    		   p.sendMessage(ChatColor.YELLOW+"You have 30 secconds remaining");
	    	   }else
	    	   if(i==10){
	    		   p.sendMessage(ChatColor.YELLOW+"You have 10 secconds remaining");
	    	   }else
	    	   if(i==3){
	    		   p.sendMessage(ChatColor.RED+"You have 3 secconds remaining");
	    	   }else
	    	   if(i==2){
	    		   p.sendMessage(ChatColor.RED+"You have 2 secconds remaining");
	    	   }else
	    	   if(i==1){
	    		   p.sendMessage(ChatColor.RED+"You have 1 secconds remaining");
	    	   }else
	    	   if(i==0){
	    		   p.sendMessage(ChatColor.RED+"Your gravestone has been destroyed");
	    		   l.getBlock().setType(Material.AIR);
	    		   for(ItemStack item:inv){
	    			   Bukkit.getServer().getWorld(l.getWorld().getName()).dropItemNaturally(l, item);
	    		   }
	    		   running = false;
	    		   break;
	    	   }
				Sign sign = (Sign) l.getBlock().getState();
				sign.setLine(0, ChatColor.DARK_BLUE+"Grave Stone");
				sign.setLine(1, ChatColor.DARK_BLUE+"Hear lies");
				sign.setLine(2, ChatColor.DARK_BLUE+p.getDisplayName());
				sign.setLine(3, ChatColor.DARK_GREEN+"TimeLeft:"+i);
				sign.update();
	    	   i--;
	    	   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
	       onPlayerDeathEvent.deathsign.remove(p);
	   }
	} 
