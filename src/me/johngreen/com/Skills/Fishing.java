package me.johngreen.com.Skills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.johngreen.com.Functions.DeathSign;
import me.johngreen.com.Functions.Skills;
import me.johngreen.com.items.InventoryHandler;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Fishing implements Runnable{
	
	public Fishing(Player p, ItemStack hand) {
		this.p = p;
		this.hand = hand;
	   }
	private Player p;
	private ItemStack hand;
	
	public static void getCaughtFish(Player p,ItemStack hand){
		p.sendMessage(ChatColor.GREEN+"");
		int level = Skills.Fishing.getLevel(p);
		ItemStack item = hand;
		if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()){
			String name = ChatColor.stripColor(item.getItemMeta().getDisplayName());
			switch(name){
			case "Net":
				if(level>=1){
						if(InventoryHandler.hasSpace(p)){
							p.getInventory().addItem(Items.Raw_Shrimp.generateItem());
							Skills.Fishing.setXP(Fish.Shrimp.getXp(), p);
						}else{
							p.sendMessage(ChatColor.RED+"Not enough inv space!");
						}
				}
				break;
			case "Fishing Rod":
				if(level>=20){
					int count = 0;
					for(ItemStack itemBait : p.getInventory()){
						if(itemBait!=null&&itemBait.hasItemMeta()&&itemBait.getItemMeta().hasDisplayName()&&itemBait.getItemMeta().getDisplayName().contains("Feather")){
							count++;
							if(itemBait.getAmount()>=1){
								itemBait.setAmount(itemBait.getAmount()-1);
							}else{
								p.getInventory().remove(itemBait);
							}
							
							break;
						}
					}
					if(count>0){
						if(InventoryHandler.hasSpace(p)){
							p.getInventory().remove(Items.Feather.generateItem());
							p.getInventory().addItem(Items.Raw_Trout.generateItem());
							Skills.Fishing.setXP(Fish.Trout.getXp(), p);
						}else{
							p.sendMessage(ChatColor.RED+"Not enough inv space!");
						}
					}else{
						p.sendMessage(ChatColor.RED+"Not enough Feathers!");
					}
				}else if(level>=10){
					int count = 0;
					for(ItemStack itemBait : p.getInventory()){
						if(itemBait!=null&&itemBait.hasItemMeta()&&itemBait.getItemMeta().hasDisplayName()&&itemBait.getItemMeta().getDisplayName().contains("Bait")){
							count++;
							if(itemBait.getAmount()>=1){
								itemBait.setAmount(itemBait.getAmount()-1);
							}else{
								p.getInventory().remove(itemBait);
							}
							
							break;
						}
					}
					if(count>0){
						if(InventoryHandler.hasSpace(p)){
							p.getInventory().remove(Items.Bait.generateItem());
							p.getInventory().addItem(Items.Raw_Herring.generateItem());
							Skills.Fishing.setXP(Fish.Herring.getXp(), p);
						}else{
							p.sendMessage(ChatColor.RED+"Not enough inv space!");
						}
					}else{
						p.sendMessage(ChatColor.RED+"Not enough Bait!");
					}
				}
				break;
			}
		}
	}
	public static List<Player> PlayerFishing = new ArrayList<Player>();
	@Override
	public void run() {
		
		 boolean running = true;
		   int i = 1;
		   p.sendMessage(ChatColor.YELLOW+"Fishing");
		   int time = 7+getTimeReduced(p);
		   while (running) {
			  if(i==(time*10)){
	    		   running=false;
	    		   getCaughtFish(p,hand);
	    		   PlayerFishing.remove(p);
	    	   }
	    	   i++;
	    	   try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       }
		
	}
	public static int getTimeReduced(Player p){
		int time = 0;
		int level = Skills.Fishing.getLevel(p);
		
		if(level>25&&level<=50){
			time = -2;
		}else if(level>50&&level<=75){
			time = -4;
		}else if(level>75&&level<=99){
			time = -6;
		}
		return time;
	}
}
