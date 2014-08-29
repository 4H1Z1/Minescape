package me.johngreen.com.Skills;


import java.util.HashMap;

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

public class Woodcutting implements Runnable {
	
	public Woodcutting(Block b,Player p, ItemStack hand,WoodcuttingBlocks wcb) {
		this.p = p;
		this.b = b;
		this.hand = hand;
		this.wcb = wcb;
	   }
	private Player p;
	private Block b;
	private ItemStack hand;
	private WoodcuttingBlocks wcb;
	
	public static HashMap<Player,Location> PlayerChopping = new HashMap<Player,Location>();
	public static HashMap<Location,WoodcuttingBlocks> ChopedTrees = new HashMap<Location,WoodcuttingBlocks>();
	public static boolean isHatchet(ItemStack i){
		if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Hatchet")){
			return true;
		}
		return false;
	}
	public static boolean hasLevelToUse(ItemStack i,Player p){
		if(isHatchet(i)){
			String name = ChatColor.stripColor(i.getItemMeta().getDisplayName());
			int level = Skills.Woodcutting.getLevel(p);
			name = name.toLowerCase();
			switch(name){
				case "bronze hatchet":
					return true;
				case "iron hatchet":
					return true;
				case "steel hatchet":
					if(level>=6){
						return true;
					}else{
						return false;
					}
				case "black hatchet":
					if(level>=6){
						return true;
					}else{
						return false;
					}
				case "mithril hatchet":
					if(level>=21){
						return true;
					}else{
						return false;
					}
				case "adamant hatchet":
					if(level>=31){
						return true;
					}else{
						return false;
					}
				case "rune hatchet":
					if(level>=41){
						return true;
					}else{
						return false;
					}
				case "dragon hatchet":
					if(level>=61){
						return true;
					}else{
						return false;
					}
			}
		}
		return false;
	}
	
	public static boolean hasLevelToChop(Player p,int meta){
		int level = Skills.Woodcutting.getLevel(p);
		switch(meta){
			case 12:
				return true;
			case 13:
				if(level>=15){
					return true;
				}
				return false;
			case 14:
				if(level>=30){
					return true;
				}
				return false;
			case 15:
				if(level>=60){
					return true;
				}
				return false;
		}
		return false;
	}
	
	public static void mineBlock(Block b,Location block, Player p,int meta){
		if(isHatchet(p.getItemInHand())){
			if(hasLevelToUse(p.getItemInHand(),p)){
				if(hasLevelToChop(p,meta)){
					Runnable r = new Woodcutting(b, p, p.getItemInHand(),WoodcuttingBlocks.getByMeta(meta));
					new Thread(r).start();
				}else{
					p.sendMessage(ChatColor.RED+"You do not have a high enough level to chop this! "+ChatColor.GRAY+WoodcuttingBlocks.getByMeta(meta).getLevel()+ChatColor.RED+" is needed!");
				}
			}else{
				p.sendMessage(ChatColor.RED+"You are not a high enough level to use this hatchet");
			}
		}else{
			p.sendMessage(ChatColor.RED+"You need a hatchet to cut the tree down");
		}
	}
	@Override
	public void run() {
		   boolean running = true;
		   int i = 1;
		   p.sendMessage(ChatColor.YELLOW+"Chopping Tree");
		   Location a = new Location(b.getWorld(),(int) b.getX(),(int) b.getY(),(int) b.getZ());
		   PlayerChopping.put(p, a);
		   Double time = (double) (wcb.getTimeToChop()+getTimeReduced(p));
		   if(time<1.0){
			   time=1.0;
		   }
		   while (running) {
			   if(b.getLocation()!=null&&PlayerChopping.get(p)!=null&&!PlayerChopping.get(p).equals(b.getLocation())){
				   p.sendMessage(ChatColor.RED+"Chopping Canceled");
	    		   running=false;
	    		   PlayerChopping.put(p, null);
	    		   break;
			   }
			   Location c = new Location(p.getTargetBlock(null, 6).getWorld(),(int) p.getTargetBlock(null, 6).getX(),(int) p.getTargetBlock(null, 6).getY(),(int) p.getTargetBlock(null, 6).getZ());
	    	   if(a.getX()!=c.getX()&&a.getY()!=c.getY()&&a.getZ()!=c.getZ()){
	    		   p.sendMessage(ChatColor.RED+"Chopping Canceled");
	    		   running=false;
	    		   PlayerChopping.put(p, null);
	    		   break;
	    	   }
	    	   if(i==(time*10)){
	    		   running=false;
	    		   for(World w:Bukkit.getServer().getWorlds()){
	    			   for(Player pla:w.getPlayers()){
	    				   pla.sendBlockChange(b.getLocation(), 5, (byte)0);
	    			   }
	    		   }
	    		   if(InventoryHandler.hasSpace(p)){
	    			   p.sendMessage(ChatColor.GREEN+"You choped a log sucsessfully!");
	    			   Skills.Woodcutting.setXP(wcb.getXp(), p);
	    			   if(wcb.equals(WoodcuttingBlocks.Log)){
	    				   p.getInventory().addItem(Items.Log.generateItem());
	    			   }else if(wcb.equals(WoodcuttingBlocks.OakLog)){
	    				   p.getInventory().addItem(Items.Oak_Log.generateItem());
	    			   }else if(wcb.equals(WoodcuttingBlocks.Willow)){
	    				   p.getInventory().addItem(Items.Willow_Log.generateItem());
	    			   }else if(wcb.equals(WoodcuttingBlocks.Yew)){
	    				   p.getInventory().addItem(Items.Yew_Log.generateItem());
	    			   }
	    		   }else{
	    			   p.sendMessage(ChatColor.RED+"You have no more inventory space!");
	    		   }
	    		   
				   PlayerChopping.put(p, null);
				   Woodcutting.ChopedTrees.put(b.getLocation(), wcb);
				   Runnable r = new WoodcuttingReset(b, b.getState().getData().getData());
					new Thread(r).start();
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
	public static double getTimeReduced(Player p){
		int time = 0;
		Double level = (double) (Skills.Woodcutting.getLevel(p)/10);
		String name = ChatColor.stripColor(p.getItemInHand().getItemMeta().getDisplayName());
		
		switch(name){
		case "Bronze Hatchet":
			time = time + 0;
			break;
		case "Iron Hatchet":
			time = time + 0;
			break;
		case "Steel Hatchet":
			time = time + -1;
			break;
		case "Black Hatchet":
			time = time + -1;
			break;
		case "Mithril Hatchet":
			time = time + -2;
			break;
		case "Adamant Hatchet":
			time = time + -3;
			break;
		case "Rune Hatchet":
			time = time + -4;
			break;
		case "Dragon Hatchet":
			time = time + -5;
			break;
	}
		return time+level;
	}
}
