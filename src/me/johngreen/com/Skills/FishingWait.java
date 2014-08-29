package me.johngreen.com.Skills;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class FishingWait implements Runnable{
	
	public FishingWait(Player p, Entity fishHook) {
		this.p = p;
		this.fishHook = fishHook;
	   }
	private Player p;
	private Entity fishHook;
	
	public static List<Player> PlayerFishing = new ArrayList<Player>();
	@Override
	public void run() {
		
		 boolean running = true;
		   p.sendMessage(ChatColor.YELLOW+"You have cast your line out!");
		   while (running) {
			   if(fishHook==null||!fishHook.isValid()||fishHook.isDead()){
				   running=false;
				   p.sendMessage(ChatColor.RED+"You pull the hook back!");
				   return;
			   }
			   if(fishHook.getLocation().getBlock().getType()!=Material.AIR&&fishHook.getLocation().getBlock().isLiquid()){
				   running=false;
				   Fishing.PlayerFishing.add(p);
				   Runnable r = new Fishing(p,p.getItemInHand());
   					new Thread(r).start();
				   return;
			   }
	    	   try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	       }
		
	}
}
