package me.johngreen.com.Skills;


import java.util.HashMap;

import me.johngreen.com.Functions.Skills;
import me.johngreen.com.items.InventoryHandler;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Mining implements Runnable {
	
	public Mining(Block b,Player p, ItemStack hand,MiningBlocks wcb) {
		this.p = p;
		this.b = b;
		this.hand = hand;
		this.wcb = wcb;
	   }
	private Player p;
	private Block b;
	private ItemStack hand;
	private MiningBlocks wcb;
	
	public static HashMap<Player,Location> PlayerChopping = new HashMap<Player,Location>();
	public static HashMap<Location,MiningBlocks> ChopedOres = new HashMap<Location,MiningBlocks>();
	public static boolean isHatchet(ItemStack i){
		if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Pickaxe")){
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
				case "bronze pickaxe":
					return true;
				case "iron pickaxe":
					return true;
				case "steel pickaxe":
					if(level>=6){
						return true;
					}else{
						return false;
					}
				case "mithril pickaxe":
					if(level>=21){
						return true;
					}else{
						return false;
					}
				case "adamant pickaxe":
					if(level>=31){
						return true;
					}else{
						return false;
					}
				case "rune pickaxe":
					if(level>=41){
						return true;
					}else{
						return false;
					}
				case "dragon pickaxe":
					if(level>=61){
						return true;
					}else{
						return false;
					}
			}
		}
		return false;
	}
	
	public static boolean hasLevelToMine(Player p,String name){
		int level = Skills.Mining.getLevel(p);
		switch(name){
		case "LAPIS_ORE":
				return true;
		case "QUARTZ_ORE":
				return true;
		case "IRON_ORE":
			if(level>=15){
				return true;
			}
			return false;
		case "IRON_BLOCK":
			if(level>=20){
				return true;
			}
			return false;
		case "COAL_ORE":
			if(level>=30){
				return true;
			}
			return false;
		case "GOLD_ORE":
			if(level>=40){
				return true;
			}
			return false;
		case "EMERALD_ORE":
			if(level>=55){
				return true;
			}
			return false;
		case "EMERALD_BLOCK":
			if(level>=70){
				return true;
			}
			return false;
		case "DIAMOND_ORE":
			if(level>=85){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public static void mineBlock(Block b,Location block, Player p,String name){
		if(isHatchet(p.getItemInHand())){
			if(hasLevelToUse(p.getItemInHand(),p)){
				if(hasLevelToMine(p,name)){
					Runnable r = new Mining(b, p, p.getItemInHand(),MiningBlocks.getByMaterialName(name));
					new Thread(r).start();
				}else{
					p.sendMessage(ChatColor.RED+"You do not have a high enough level to mine this! "+ChatColor.GRAY+MiningBlocks.getByMaterialName(name).getLevel()+ChatColor.RED+" is needed!");
				}
			}else{
				p.sendMessage(ChatColor.RED+"You are not a high enough level to use this pickaxe");
			}
		}else{
			p.sendMessage(ChatColor.RED+"You need a pickaxe to mine the ore");
		}
	}
	@Override
	public void run() {
		   boolean running = true;
		   int i = 1;
		   p.sendMessage(ChatColor.YELLOW+"Minning ore");
		   Location a = new Location(b.getWorld(),(int) b.getX(),(int) b.getY(),(int) b.getZ());
		   PlayerChopping.put(p, a);
		   int time = wcb.getTimeToChop()+getTimeReduced(p);
		   while (running) {
			   if(b.getLocation()!=null&&PlayerChopping.get(p)!=null&&!PlayerChopping.get(p).equals(b.getLocation())){
				   p.sendMessage(ChatColor.RED+"Mining Canceled");
	    		   running=false;
	    		   PlayerChopping.put(p, null);
	    		   break;
			   }
			   Location c = new Location(p.getTargetBlock(null, 6).getWorld(),(int) p.getTargetBlock(null, 6).getX(),(int) p.getTargetBlock(null, 6).getY(),(int) p.getTargetBlock(null, 6).getZ());
	    	   if(a.getX()!=c.getX()&&a.getY()!=c.getY()&&a.getZ()!=c.getZ()){
	    		   p.sendMessage(ChatColor.RED+"Mining Canceled");
	    		   running=false;
	    		   PlayerChopping.put(p, null);
	    		   break;
	    	   }
	    	   if(i==(time*10)){
	    		   running=false;
	    		   for(World w:Bukkit.getServer().getWorlds()){
	    			   for(Player pla:w.getPlayers()){
	    				   pla.sendBlockChange(b.getLocation(), 1, (byte)0);
	    			   }
	    		   }
	    		   if(InventoryHandler.hasSpace(p)){
	    			   p.sendMessage(ChatColor.GREEN+"You have mined a ore sucsessfully!");
	    			   Skills.Mining.setXP(wcb.getXp(), p);
	    			   p.getInventory().addItem(wcb.getOre().generateItem());
	    		   }else{
	    			   p.sendMessage(ChatColor.RED+"You have no more inventory space!");
	    		   }
	    		   
				   PlayerChopping.put(p, null);
				   Mining.ChopedOres.put(b.getLocation(), wcb);
				   Runnable r = new MiningReset(b);
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
	public static int getTimeReduced(Player p){
		int time = 0;
		int level = Skills.Mining.getLevel(p);
		String name = ChatColor.stripColor(p.getItemInHand().getItemMeta().getDisplayName());
		
		if(level>25&&level<=50){
			time = -1;
		}else if(level>50&&level<=75){
			time = -2;
		}else if(level>75&&level<=99){
			time = -3;
		}
		
		switch(name){
		case "Bronze Pickaxe":
			time = time + 0;
			break;
		case "Iron Pickaxe":
			time = time + 0;
			break;
		case "Steel Pickaxe":
			time = time + -1;
			break;
		case "Black Pickaxe":
			time = time + -1;
			break;
		case "Mithril Pickaxe":
			time = time + -2;
			break;
		case "Adamant Pickaxe":
			time = time + -3;
			break;
		case "Rune Pickaxe":
			time = time + -4;
			break;
		case "Dragon Pickaxe":
			time = time + -5;
			break;
	}
		return time;
	}
	
}
