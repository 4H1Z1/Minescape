package me.johngreen.com.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Bank;
import me.johngreen.com.Functions.DeathSign;
import me.johngreen.com.Functions.Eco;
import me.johngreen.com.Functions.Guis;
import me.johngreen.com.Functions.PlayerInteraction;
import me.johngreen.com.Functions.Shop;
import me.johngreen.com.Functions.Skills;
import me.johngreen.com.Functions.Trading;
import me.johngreen.com.Skills.Cooking;
import me.johngreen.com.Skills.Smithing;
import me.johngreen.com.Skills.Teleport;
import me.johngreen.com.items.InventoryHandler;
import me.johngreen.com.items.Items;
import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.server.v1_7_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.ItemStack;

public class onInventoryClickEvent implements Listener {
    public onInventoryClickEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        plugin = plugin;
    }
    
    private static Main plugin;
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityTarget(InventoryClickEvent e){Player p = (Player)e.getWhoClicked();
    	if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY&&!e.getInventory().getTitle().contains("Bank")&&!e.getInventory().getTitle().contains("GraveStone")&&!e.getInventory().getTitle().contains("Drops")&&e.getInventory().getType()!=InventoryType.CRAFTING){
    		e.setCancelled(true);
    	}
    	if(e.getInventory().getTitle().contains("Bank")){
    		if(e.getRawSlot()<=8){
    			e.setCancelled(true);
    			p.closeInventory();
    			Bank.openPage(p, (e.getRawSlot()+1));
    		}
    	}
    	if(e.getInventory().getTitle().equals("Trading menu")){
    		int[] padding = {0,1,2,3,4,5,6,7,8,9,13,14,15,16,17,18,22,23,24,25,26,27,31,32,33,34,35,36,40,41,42,43,44,45,46,47,48,49,50,51,52,53};
    		for(int i:padding){
    			if(i==48||i==47||i==46){
    				e.getInventory().setItem(48, (new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData())));
    				e.getInventory().setItem(47, (new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData())));
    				e.getInventory().setItem(46, (new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData())));
    				Trading.AcceptedTrade.add(p);
    			}
    			if(i==e.getRawSlot()){
    				e.setCancelled(true);
    				break;
    			}
    		}
    	}
    		
    	if(e.getCurrentItem()!=null&&e.getCurrentItem().hasItemMeta()&&e.getCurrentItem().getItemMeta().hasLore()&&e.getCurrentItem().getItemMeta().getLore().contains(ChatColor.BLACK+"NoDrop")){
    		e.setCancelled(true);
    	}
    	//armour
    	if(e.getInventory().getType().equals(InventoryType.CRAFTING)&&e.getSlotType().equals(SlotType.ARMOR)&&e.getAction().equals(InventoryAction.PLACE_ALL)){
    		if(e.getCursor()!=null&&e.getCursor().hasItemMeta()&&e.getCursor().getItemMeta().hasDisplayName()){
    			int level = Skills.Defence.getLevel(p);
    			switch(e.getRawSlot()){
    				case 5:
	    			switch(ChatColor.stripColor(e.getCursor().getItemMeta().getDisplayName())){
	    				case "Red partyhat":
		    				break;
		    			case "Blue partyhat":
		    				break;
	    				case "White partyhat":
		    				break;
		    			case "Green partyhat":
		    				break;
	    				case "Yellow partyhat":
		    				break;
		    			case "Purple partyhat":
		    				break;
	    				case "Bronze MediumHelmet":
		    				break;
		    			case "Bronze FullHelmet":
		    				break;
	    				case "Iron MediumHelmet":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Iron FullHelmet":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Steel MediumHelmet":
	    					if(!(level>=20)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Steel FullHelmet":
	    					if(!(level>=20)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Mithrill MediumHelmet":
	    					if(!(level>=30)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Mithrill FullHelmet":
	    					if(!(level>=30)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Adamantite MediumHelmet":
	    					if(!(level>=40)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Adamantite FullHelmet":
	    					if(!(level>=40)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Rune MediumHelmet":
	    					if(!(level>=50)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Rune FullHelmet":
	    					if(!(level>=50)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			default:
		    				e.setCancelled(true);
		    				break;
	    			}
	    			break;
    				case 6:
	    			switch(ChatColor.stripColor(e.getCursor().getItemMeta().getDisplayName())){
		    			
	    				case "Bronze Chainbody":
		    				break;
		    			case "Bronze Platebody":
		    				break;
	    				case "Iron Chainbody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Iron Platebody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Steel Chainbody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Steel Platebody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Mithrill Chainbody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Mithrill Platebody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Adamantite Chainbody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Adamantite Platebody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Rune Chainbody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Rune Platebody":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			default:
		    				e.setCancelled(true);
		    				break;
	    			}
	    			break;
    				case 7:
	    			switch(ChatColor.stripColor(e.getCursor().getItemMeta().getDisplayName())){
		    			
	    				case "Bronze Plateskirt":
		    				break;
		    			case "Bronze Platelegs":
		    				break;
	    				case "Iron Plateskirt":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Iron Platelegs":
	    					if(!(level>=10)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Steel Plateskirt":
	    					if(!(level>=20)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Steel Platelegs":
	    					if(!(level>=20)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Mithrill Plateskirt":
	    					if(!(level>=30)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Mithrill Platelegs":
	    					if(!(level>=30)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
	    				case "Adamantite Plateskirt":
	    					if(!(level>=40)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Adamantite Platelegs":
	    					if(!(level>=40)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Rune Plateskirt":
	    					if(!(level>=50)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			case "Rune Platelegs":
	    					if(!(level>=50)){
	    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this!");
	    						e.setCancelled(true);
	    					}
		    				break;
		    			default:
		    				e.setCancelled(true);
		    				break;
	    			}
	    			break;
    				case 8:
	    			switch(ChatColor.stripColor(e.getCursor().getItemMeta().getDisplayName())){
		    			case "":
		    				break;
	    			}
	    			break;
    			}
    		}else{
    			e.setCancelled(true);
    		}
    	}
    	
    	if(e.getInventory().getTitle().contains("Chose Action")){
    		e.setCancelled(true);
    		String itemname = "";
    		if(e.getCurrentItem()!=null&&e.getCurrentItem().hasItemMeta()&&e.getCurrentItem().getItemMeta().hasDisplayName()){
    			 itemname = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
    		}
    		switch(itemname){
    		case "Add Friend":
    			String  l = Main.playerconfig.getString(p.getDisplayName());
    			boolean isThere = false;
    			if(l!=null){
    				String[] parts = l.split(",");
    				for(String s:parts){
    					if(PlayerInteraction.ChatClicked.get(p).getDisplayName().equals(s)){
    						isThere = true;
    						break;
    					}
    				}
    			}
    			if(isThere==true){
    				p.sendMessage(ChatColor.RED+"You already have them as a friend");
    			}else{
    				String pre = Main.playerconfig.getString(p.getDisplayName());
	    			if(pre==null||pre==""){
	    				pre = PlayerInteraction.ChatClicked.get(p).getDisplayName();
	    			}else{
	    				pre = pre+","+PlayerInteraction.ChatClicked.get(p).getDisplayName();
	    			}
	    			Main.playerconfig.set(p.getDisplayName(), pre);
	    			Main.savePlayerConfig();
	    			p.sendMessage(ChatColor.GREEN+PlayerInteraction.ChatClicked.get(p).getDisplayName()+" has been added to your friends list");
    			}
    			break;
    		case "Mute":
    			if(Main.playerconfig.getString(p.getDisplayName()+"-Muted")!=null){
    				if(Main.playerconfig.getString(p.getDisplayName()+"-Muted").contains(PlayerInteraction.ChatClicked.get(p).getDisplayName())){
    					String a = Main.playerconfig.getString(p.getDisplayName()+"-Muted");
    				    String[] parts = a.split(",");
    				    String remake = "";
    				    for(String s:parts){
    				    	Bukkit.broadcastMessage(PlayerInteraction.ChatClicked.get(p).getDisplayName()+PlayerInteraction.ChatClicked.get(p).getDisplayName().length()+" "+s+s.length());
    				    	if(!s.equals(PlayerInteraction.ChatClicked.get(p).getDisplayName())){
    				    		Bukkit.broadcastMessage("2");
    				    		if(remake==""){
    				    			remake = s;
    				    		}else{
    				    			remake = remake+","+s;
    				    		}
    				    	}
    				    }
    					Main.playerconfig.set(p.getDisplayName()+"-Muted", remake);
    				    p.sendMessage("You have re-enabled seeing "+PlayerInteraction.ChatClicked.get(p).getDisplayName()+"'s messages!");
	    			}else{
	    				p.sendMessage("You have dissabled seeing "+PlayerInteraction.ChatClicked.get(p).getDisplayName()+"'s messages!");
	    				Main.playerconfig.set(p.getDisplayName()+"-Muted", Main.playerconfig.getString(p.getDisplayName()+"-Muted")+","+PlayerInteraction.ChatClicked.get(p).getDisplayName());
	    			}
    			}else{
    				p.sendMessage("You have dissabled seeing "+PlayerInteraction.ChatClicked.get(p).getDisplayName()+"'s messages!");
    				Main.playerconfig.set(p.getDisplayName()+"-Muted", PlayerInteraction.ChatClicked.get(p).getDisplayName());
    			}
    			
    			break;
    		}
    	}
    	
    	if(e.getInventory().getTitle().contains("Spell Book")){
    		if(e.getCurrentItem()!=null&&e.getCurrentItem().hasItemMeta()&&e.getCurrentItem().getItemMeta().hasDisplayName()){
    			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Lumbridge")){
    				Location l = new Location(p.getWorld(),-342,69,146);
    				Runnable r = new Teleport(l, 5, p);
    				new Thread(r).start();
    			}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Al-Kharid")){
    				Location l = new Location(p.getWorld(),-245,69,-33);
    				Runnable r = new Teleport(l, 5, p);
    				new Thread(r).start();
    			}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Varrock")){
    				Location l = new Location(p.getWorld(),-823,69,209);
    				Runnable r = new Teleport(l, 5, p);
    				new Thread(r).start();
    			}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("PortSarim")){
    				Location l = new Location(p.getWorld(),-326,72,826);
    				Runnable r = new Teleport(l, 5, p);
    				new Thread(r).start();
    			}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Draynor")){
    				Location l = new Location(p.getWorld(),-572,69,533);
    				Runnable r = new Teleport(l, 5, p);
    				new Thread(r).start();
    			}else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Karamja")){
    				Location l = new Location(p.getWorld(),-124,70,1050);
    				Runnable r = new Teleport(l, 5, p);
    				new Thread(r).start();
    			}
    		}
    	}
    	
    	
    	if(e.getInventory().getTitle().contains("Quests")){
    		if(e.getCurrentItem()!=null&&e.getCurrentItem().hasItemMeta()&&e.getCurrentItem().getItemMeta().hasDisplayName()){
    			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Rune Mysteries")){
    				p.sendMessage(ChatColor.GREEN+"Quest compass is now pointing to the start location of \"Rune Mysteries\"");
	   			 	p.setCompassTarget(new Location(p.getWorld(), -353, 77, 225));
    			}
	   		}
    	}
    	

    	for(String s:Shop.getAllShops()){
    		if(s.equals(e.getInventory().getTitle())){
    			e.setCancelled(true);
    			if(e.getRawSlot()<54){
	    			String itemname = "";
	        		if(e.getCurrentItem()!=null&&e.getCurrentItem().hasItemMeta()&&e.getCurrentItem().getItemMeta().hasDisplayName()){
	        			 itemname = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
	        		}
	        		if(itemname!=""){
	        			if(Eco.hasEnoughMoney(Items.getByName(itemname).getCost(), p)){
							if(InventoryHandler.hasSpace(p)){
								Eco.removeFunds(p, Items.getByName(itemname).getCost());
								p.getInventory().addItem(Items.getByName(itemname).generateItem());
							}else{
								p.sendMessage(ChatColor.RED+"You dont have enough inventory space!");
							}
						}else{
							p.sendMessage(ChatColor.RED+"You dont have enough money");
						}
	        		}
					
				}
    		}
    	}
    	
    	
    	List<String> titles = new ArrayList<String>();
    	titles.add("Levels");
    	
    	titles.add("AttackInformation");
    	titles.add("DefenceInformation");
    	titles.add("HealthInformation");
    	titles.add("RangeInformation");
    	titles.add("MagicInformation");
    	titles.add("MiningInformation");
    	titles.add("SmithingInformation");
    	titles.add("WoodcuttingInformation");
    	titles.add("FiremakingInformation");
    	titles.add("PrayerInformation");
    	titles.add("Prayer");
    	titles.add("Chose Action");
    	titles.add("Furnace");
    	titles.add("Anvil");
    	titles.add("Friends");
    	titles.add("Quests");
    	titles.add("Spell Book");
    	titles.add("Cooking");
    	if(titles.contains(e.getInventory().getTitle())){
    		if(e.getRawSlot()<=(e.getInventory().getSize()-1)){
    			e.setCancelled(true);
    		}
    		String itemname = "";
    		if(e.getCurrentItem()!=null&&e.getCurrentItem().hasItemMeta()&&e.getCurrentItem().getItemMeta().hasDisplayName()){
    			 itemname = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
    		}
    		switch(e.getInventory().getTitle()){
    			case "Cooking":
    				int CookingLevel = Skills.Cooking.getLevel(p);
    				switch(itemname){
    				case "Cooking:Shrimp":
    					if(CookingLevel>=1){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Shrimp")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Shrimp);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Shrimp");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				case "Cooking:Herring":
    					if(CookingLevel>=5){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Herring")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Herring);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Herring");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				case "Cooking:Trout":
    					if(CookingLevel>=15){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Trout")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Trout);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Trout");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				case "Cooking:Tuna":
    					if(CookingLevel>=30){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Tuna")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Tuna);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Tuna");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				case "Cooking:Lobster":
    					if(CookingLevel>=40){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Lobster")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Lobster);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Lobster");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				case "Cooking:Swordfish":
    					if(CookingLevel>=45){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Swordfish")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Swordfish);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Swordfish");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				case "Cooking:Monkfish":
    					if(CookingLevel>=62){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Monkfish")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Monkfish);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Monkfish");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				case "Cooking:Shark":
    					if(CookingLevel>=80){
    						boolean hasFish = false;
    						for(ItemStack i:p.getInventory().getContents()){
    							if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().contains("Raw Shark")){
    								p.getInventory().remove(i);
    								hasFish=true;
    								break;
    							}
    						}
    						if(hasFish){
    							Runnable r = new Cooking(p,CookingItems.Shark);
    							new Thread(r).start();
    						}else{
    							p.sendMessage(ChatColor.RED+"You need 1X Raw Shark");
    						}
    						
    					}else{
    						p.sendMessage(ChatColor.RED+"You do not have the required cooking level to make this!");
    					}
    					break;
    				}
    				break;
    		
    			case "Anvil":
    				int BronzeCount=0;
    				int IronCount=0;
    				int SteelCount=0;
    				int MithrillCount=0;
    				int AdamantiteCount=0;
    				int RuneCount=0;
    				switch(itemname){
    				
    					//bronze page
    				case "Smithing:Bronze Arrowhead":
    					if(Skills.Smithing.getLevel(p)>=5){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								for(int x = 0;x<10;x++){
									p.getInventory().addItem(Items.Arrowhead_Bronze.generateItem());
								}
								Skills.Smithing.setXP(13, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 5 to smith this!");
						}
						break;
    				case "Smithing:Bronze Dagger":
    					if(Skills.Smithing.getLevel(p)>=1){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Dagger_Bronze.generateItem());
								Skills.Smithing.setXP(13, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 1 to smith this!");
						}
						break;
    				case "Smithing:Bronze Hatchet":
    					if(Skills.Smithing.getLevel(p)>=1){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Bronze_Hatchet.generateItem());
								Skills.Smithing.setXP(13, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 1 to smith this!");
						}
						break;
    				case "Smithing:Bronze Pickaxe":
    					if(Skills.Smithing.getLevel(p)>=5){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Bronze_Pickaxe.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 5 to smith this!");
						}
						break;
    				case "Smithing:Bronze Mace":
    					if(Skills.Smithing.getLevel(p)>=2){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mace_Bronze.generateItem());
								Skills.Smithing.setXP(13, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 2 to smith this!");
						}
						break;
    				case "Smithing:Bronze MediumHelmet":
    					if(Skills.Smithing.getLevel(p)>=1){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.MediumHelmet_Bronze.generateItem());
								Skills.Smithing.setXP(13, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 1 to smith this!");
						}
						break;
    				case "Smithing:Bronze Sword":
    					if(Skills.Smithing.getLevel(p)>=4){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Sword_Bronze.generateItem());
								Skills.Smithing.setXP(13, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 4 to smith this!");
						}
						break;
    				case "Smithing:Bronze Scimitar":
    					if(Skills.Smithing.getLevel(p)>=5){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=2){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Scimitar_Bronze.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 5 to smith this!");
						}
						break;
    				case "Smithing:Bronze Longsword":
    					if(Skills.Smithing.getLevel(p)>=6){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=2){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Longsword_Bronze.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 6 to smith this!");
						}
						break;
    				case "Smithing:Bronze FullHelmet":
    					if(Skills.Smithing.getLevel(p)>=7){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=2){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.FullHelmet_Bronze.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 7 to smith this!");
						}
						break;
    				case "Smithing:Bronze Warhammer":
    					if(Skills.Smithing.getLevel(p)>=9){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=3){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Warhammer_Bronze.generateItem());
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X BronzeBar");
									Skills.Smithing.setXP(38, p);
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 9 to smith this!");
						}
						break;
    				case "Smithing:Bronze Battleaxe":
    					if(Skills.Smithing.getLevel(p)>=10){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=3){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Battleaxe_Bronze.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 10 to smith this!");
						}
						break;
    				case "Smithing:Bronze Chainbody":
    					if(Skills.Smithing.getLevel(p)>=11){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=3){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Chainbody_Bronze.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 11 to smith this!");
						}
						break;
    				case "Smithing:Bronze TwoHandedSword":
    					if(Skills.Smithing.getLevel(p)>=14){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=3){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.TwoHandedSword_Bronze.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 14 to smith this!");
						}
						break;
    				case "Smithing:Bronze Platelegs":
    					if(Skills.Smithing.getLevel(p)>=16){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=3){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platelegs_Bronze.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 16 to smith this!");
						}
						break;
    				case "Smithing:Bronze Plateskirt":
    					if(Skills.Smithing.getLevel(p)>=16){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=3){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Plateskirt_Bronze.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 16 to smith this!");
						}
						break;
    				case "Smithing:Bronze Platebody":
    					if(Skills.Smithing.getLevel(p)>=18){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
										if(BronzeCount!=5){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==5){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.BronzeBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platebody_Bronze.generateItem());
								Skills.Smithing.setXP(63, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 5X BronzeBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 18 to smith this!");
						}
						break;
						
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
						//iron
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
    				case "Smithing:Iron Arrowhead":
    					if(Skills.Smithing.getLevel(p)>=20){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								for(int x = 0;x<10;x++){
									p.getInventory().addItem(Items.Arrowhead_Iron.generateItem());
								}
								Skills.Smithing.setXP(25, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X Iron");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 20 to smith this!");
						}
						break;
    				case "Smithing:Iron Dagger":
    					if(Skills.Smithing.getLevel(p)>=15){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=1){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Dagger_Iron.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 15 to smith this!");
						}
						break;
    				case "Smithing:Iron Hatchet":
    					if(Skills.Smithing.getLevel(p)>=16){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=1){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Iron_Hatchet.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 16 to smith this!");
						}
						break;
    				case "Smithing:Iron Pickaxe":
    					if(Skills.Smithing.getLevel(p)>=20){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=1){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Iron_Pickaxe.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 20 to smith this!");
						}
						break;
    				case "Smithing:Iron Mace":
    					if(Skills.Smithing.getLevel(p)>=17){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=1){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mace_Iron.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 17 to smith this!");
						}
						break;
    				case "Smithing:Iron MediumHelmet":
    					if(Skills.Smithing.getLevel(p)>=18){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=1){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.MediumHelmet_Iron.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 18 to smith this!");
						}
						break;
    				case "Smithing:Iron Sword":
    					if(Skills.Smithing.getLevel(p)>=19){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=1){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Sword_Iron.generateItem());
								Skills.Smithing.setXP(25, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 19 to smith this!");
						}
						break;
    				case "Smithing:Iron Scimitar":
    					if(Skills.Smithing.getLevel(p)>=20){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=2){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Scimitar_Iron.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 20 to smith this!");
						}
						break;
    				case "Smithing:Iron Longsword":
    					if(Skills.Smithing.getLevel(p)>=21){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=2){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Longsword_Iron.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 21 to smith this!");
						}
						break;
    				case "Smithing:Iron FullHelmet":
    					if(Skills.Smithing.getLevel(p)>=22){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=2){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.FullHelmet_Iron.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 22 to smith this!");
						}
						break;
    				case "Smithing:Iron Warhammer":
    					if(Skills.Smithing.getLevel(p)>=24){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=3){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Warhammer_Iron.generateItem());
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X IronBar");
									Skills.Smithing.setXP(75, p);
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 24 to smith this!");
						}
						break;
    				case "Smithing:Iron Battleaxe":
    					if(Skills.Smithing.getLevel(p)>=25){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=3){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Battleaxe_Iron.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 25 to smith this!");
						}
						break;
    				case "Smithing:Iron Chainbody":
    					if(Skills.Smithing.getLevel(p)>=26){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=3){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Chainbody_Iron.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 26 to smith this!");
						}
						break;
    				case "Smithing:Iron TwoHandedSword":
    					if(Skills.Smithing.getLevel(p)>=29){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=3){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.TwoHandedSword_Iron.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 29 to smith this!");
						}
						break;
    				case "Smithing:Iron Platelegs":
    					if(Skills.Smithing.getLevel(p)>=31){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=3){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platelegs_Iron.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 31 to smith this!");
						}
						break;
    				case "Smithing:Iron Plateskirt":
    					if(Skills.Smithing.getLevel(p)>=31){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=3){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Plateskirt_Iron.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 31 to smith this!");
						}
						break;
    				case "Smithing:Iron Platebody":
    					if(Skills.Smithing.getLevel(p)>=33){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
										if(IronCount!=5){
											IronCount++;
										}
									}
								}
								
							}
							if(IronCount==5){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.IronBar.getName())){
											if(IronCount!=0){
												p.getInventory().remove(i);
												IronCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platebody_Iron.generateItem());
								Skills.Smithing.setXP(125, p);
							}else{
								if(IronCount==0){
									p.sendMessage(ChatColor.RED+"You need 5X IronBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 33 to smith this!");
						}
						break;
						
						

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//steel
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
						
						
						
    				case "Smithing:Steel Arrowhead":
    					if(Skills.Smithing.getLevel(p)>=35){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								for(int x = 0;x<10;x++){
									p.getInventory().addItem(Items.Arrowhead_Steel.generateItem());
								}
								Skills.Smithing.setXP(38, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X Steel");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 35 to smith this!");
						}
						break;
    				case "Smithing:Steel Dagger":
    					if(Skills.Smithing.getLevel(p)>=30){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=1){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Dagger_Steel.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 30 to smith this!");
						}
						break;
    				case "Smithing:Steel Hatchet":
    					if(Skills.Smithing.getLevel(p)>=31){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=1){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Steel_Hatchet.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 31 to smith this!");
						}
						break;
    				case "Smithing:Steel Pickaxe":
    					if(Skills.Smithing.getLevel(p)>=35){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=1){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Steel_Pickaxe.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 35 to smith this!");
						}
						break;
    				case "Smithing:Steel Mace":
    					if(Skills.Smithing.getLevel(p)>=32){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=1){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mace_Steel.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 32 to smith this!");
						}
						break;
    				case "Smithing:Steel MediumHelmet":
    					if(Skills.Smithing.getLevel(p)>=33){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=1){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.MediumHelmet_Steel.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 33 to smith this!");
						}
						break;
    				case "Smithing:Steel Sword":
    					if(Skills.Smithing.getLevel(p)>=34){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=1){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Sword_Steel.generateItem());
								Skills.Smithing.setXP(38, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 34 to smith this!");
						}
						break;
    				case "Smithing:Steel Scimitar":
    					if(Skills.Smithing.getLevel(p)>=35){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=2){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Scimitar_Steel.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 35 to smith this!");
						}
						break;
    				case "Smithing:Steel Longsword":
    					if(Skills.Smithing.getLevel(p)>=36){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=2){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Longsword_Steel.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 36 to smith this!");
						}
						break;
    				case "Smithing:Steel FullHelmet":
    					if(Skills.Smithing.getLevel(p)>=37){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=2){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.FullHelmet_Steel.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 37 to smith this!");
						}
						break;
    				case "Smithing:Steel Warhammer":
    					if(Skills.Smithing.getLevel(p)>=39){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=3){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Warhammer_Steel.generateItem());
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X SteelBar");
									Skills.Smithing.setXP(113, p);
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 39 to smith this!");
						}
						break;
    				case "Smithing:Steel Battleaxe":
    					if(Skills.Smithing.getLevel(p)>=40){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=3){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Battleaxe_Steel.generateItem());
								Skills.Smithing.setXP(113, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 40 to smith this!");
						}
						break;
    				case "Smithing:Steel Chainbody":
    					if(Skills.Smithing.getLevel(p)>=41){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=3){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Chainbody_Steel.generateItem());
								Skills.Smithing.setXP(113, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 41 to smith this!");
						}
						break;
    				case "Smithing:Steel TwoHandedSword":
    					if(Skills.Smithing.getLevel(p)>=44){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=3){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.TwoHandedSword_Steel.generateItem());
								Skills.Smithing.setXP(113, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 44 to smith this!");
						}
						break;
    				case "Smithing:Steel Platelegs":
    					if(Skills.Smithing.getLevel(p)>=46){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=3){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platelegs_Steel.generateItem());
								Skills.Smithing.setXP(113, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 46 to smith this!");
						}
						break;
    				case "Smithing:Steel Plateskirt":
    					if(Skills.Smithing.getLevel(p)>=46){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=3){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Plateskirt_Steel.generateItem());
								Skills.Smithing.setXP(113, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 46 to smith this!");
						}
						break;
    				case "Smithing:Steel Platebody":
    					if(Skills.Smithing.getLevel(p)>=48){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
										if(SteelCount!=5){
											SteelCount++;
										}
									}
								}
								
							}
							if(SteelCount==5){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.SteelBar.getName())){
											if(SteelCount!=0){
												p.getInventory().remove(i);
												SteelCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platebody_Steel.generateItem());
								Skills.Smithing.setXP(188, p);
							}else{
								if(SteelCount==0){
									p.sendMessage(ChatColor.RED+"You need 5X SteelBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 48 to smith this!");
						}
						break;
						
						
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//Mithrill
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
						
						
    				case "Smithing:Mithrill Arrowhead":
    					if(Skills.Smithing.getLevel(p)>=55){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								for(int x = 0;x<10;x++){
									p.getInventory().addItem(Items.Arrowhead_Mithrill.generateItem());
								}
								Skills.Smithing.setXP(50, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X Mithrill");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 55 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Dagger":
    					if(Skills.Smithing.getLevel(p)>=50){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=1){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Dagger_Mithrill.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 50 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Hatchet":
    					if(Skills.Smithing.getLevel(p)>=51){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=1){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mithrill_Hatchet.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 51 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Pickaxe":
    					if(Skills.Smithing.getLevel(p)>=55){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=1){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mithrill_Pickaxe.generateItem());
								Skills.Smithing.setXP(100, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 55 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Mace":
    					if(Skills.Smithing.getLevel(p)>=52){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=1){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mace_Mithrill.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 52 to smith this!");
						}
						break;
    				case "Smithing:Mithrill MediumHelmet":
    					if(Skills.Smithing.getLevel(p)>=53){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=1){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.MediumHelmet_Mithrill.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 53 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Sword":
    					if(Skills.Smithing.getLevel(p)>=54){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=1){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Sword_Mithrill.generateItem());
								Skills.Smithing.setXP(50, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 54 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Scimitar":
    					if(Skills.Smithing.getLevel(p)>=55){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=2){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Scimitar_Mithrill.generateItem());
								Skills.Smithing.setXP(100, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 55 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Longsword":
    					if(Skills.Smithing.getLevel(p)>=56){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=2){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Longsword_Mithrill.generateItem());
								Skills.Smithing.setXP(100, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 56 to smith this!");
						}
						break;
    				case "Smithing:Mithrill FullHelmet":
    					if(Skills.Smithing.getLevel(p)>=57){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=2){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.FullHelmet_Mithrill.generateItem());
								Skills.Smithing.setXP(100, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 57 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Warhammer":
    					if(Skills.Smithing.getLevel(p)>=59){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=3){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Warhammer_Mithrill.generateItem());
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X MithrillBar");
									Skills.Smithing.setXP(150, p);
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 59 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Battleaxe":
    					if(Skills.Smithing.getLevel(p)>=60){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=3){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Battleaxe_Mithrill.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 60 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Chainbody":
    					if(Skills.Smithing.getLevel(p)>=61){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=3){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Chainbody_Mithrill.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 61 to smith this!");
						}
						break;
    				case "Smithing:Mithrill TwoHandedSword":
    					if(Skills.Smithing.getLevel(p)>=64){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=3){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.TwoHandedSword_Mithrill.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 64 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Platelegs":
    					if(Skills.Smithing.getLevel(p)>=66){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=3){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platelegs_Mithrill.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 66 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Plateskirt":
    					if(Skills.Smithing.getLevel(p)>=66){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=3){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Plateskirt_Mithrill.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 66 to smith this!");
						}
						break;
    				case "Smithing:Mithrill Platebody":
    					if(Skills.Smithing.getLevel(p)>=68){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
										if(MithrillCount!=5){
											MithrillCount++;
										}
									}
								}
								
							}
							if(MithrillCount==5){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.MithrillBar.getName())){
											if(MithrillCount!=0){
												p.getInventory().remove(i);
												MithrillCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platebody_Mithrill.generateItem());
								Skills.Smithing.setXP(250, p);
							}else{
								if(MithrillCount==0){
									p.sendMessage(ChatColor.RED+"You need 5X MithrillBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 68 to smith this!");
						}
						break;
						
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//Adamantite
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
						
    				case "Smithing:Adamantite Arrowhead":
    					if(Skills.Smithing.getLevel(p)>=75){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								for(int x = 0;x<10;x++){
									p.getInventory().addItem(Items.Arrowhead_Adamantite.generateItem());
								}
								Skills.Smithing.setXP(63, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X Adamantite");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 75 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Dagger":
    					if(Skills.Smithing.getLevel(p)>=70){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=1){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Dagger_Adamantite.generateItem());
								Skills.Smithing.setXP(63, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 70 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Hatchet":
    					if(Skills.Smithing.getLevel(p)>=71){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=1){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Adamant_Hatchet.generateItem());
								Skills.Smithing.setXP(63, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 71 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Pickaxe":
    					if(Skills.Smithing.getLevel(p)>=75){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=1){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Adamant_Pickaxe.generateItem());
								Skills.Smithing.setXP(125, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 75 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Mace":
    					if(Skills.Smithing.getLevel(p)>=72){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=1){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mace_Adamantite.generateItem());
								Skills.Smithing.setXP(63, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 72 to smith this!");
						}
						break;
    				case "Smithing:Adamantite MediumHelmet":
    					if(Skills.Smithing.getLevel(p)>=71){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=1){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.MediumHelmet_Adamantite.generateItem());
								Skills.Smithing.setXP(63, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 71 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Sword":
    					if(Skills.Smithing.getLevel(p)>=74){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=1){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Sword_Adamantite.generateItem());
								Skills.Smithing.setXP(63, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 74 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Scimitar":
    					if(Skills.Smithing.getLevel(p)>=75){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=2){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Scimitar_Adamantite.generateItem());
								Skills.Smithing.setXP(125, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 75 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Longsword":
    					if(Skills.Smithing.getLevel(p)>=76){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=2){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Longsword_Adamantite.generateItem());
								Skills.Smithing.setXP(125, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 76 to smith this!");
						}
						break;
    				case "Smithing:Adamantite FullHelmet":
    					if(Skills.Smithing.getLevel(p)>=77){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=2){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.FullHelmet_Adamantite.generateItem());
								Skills.Smithing.setXP(125, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 77 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Warhammer":
    					if(Skills.Smithing.getLevel(p)>=79){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=3){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Warhammer_Adamantite.generateItem());
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X AdamantiteBar");
									Skills.Smithing.setXP(188, p);
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 79 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Battleaxe":
    					if(Skills.Smithing.getLevel(p)>=80){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=3){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Battleaxe_Adamantite.generateItem());
								Skills.Smithing.setXP(188, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 80 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Chainbody":
    					if(Skills.Smithing.getLevel(p)>=81){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=3){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Chainbody_Adamantite.generateItem());
								Skills.Smithing.setXP(188, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 81 to smith this!");
						}
						break;
    				case "Smithing:Adamantite TwoHandedSword":
    					if(Skills.Smithing.getLevel(p)>=84){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=3){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.TwoHandedSword_Adamantite.generateItem());
								Skills.Smithing.setXP(188, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 84 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Platelegs":
    					if(Skills.Smithing.getLevel(p)>=86){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=3){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platelegs_Adamantite.generateItem());
								Skills.Smithing.setXP(188, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 86 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Plateskirt":
    					if(Skills.Smithing.getLevel(p)>=86){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=3){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Plateskirt_Adamantite.generateItem());
								Skills.Smithing.setXP(188, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 86 to smith this!");
						}
						break;
    				case "Smithing:Adamantite Platebody":
    					if(Skills.Smithing.getLevel(p)>=88){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
										if(AdamantiteCount!=5){
											AdamantiteCount++;
										}
									}
								}
								
							}
							if(AdamantiteCount==5){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.AdamantBar.getName())){
											if(AdamantiteCount!=0){
												p.getInventory().remove(i);
												AdamantiteCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platebody_Adamantite.generateItem());
								Skills.Smithing.setXP(313, p);
							}else{
								if(AdamantiteCount==0){
									p.sendMessage(ChatColor.RED+"You need 5X AdamantiteBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 88 to smith this!");
						}
						break;
						
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//Rune
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
						
    				case "Smithing:Rune Arrowhead":
    					if(Skills.Smithing.getLevel(p)>=90){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(BronzeCount!=1){
											BronzeCount++;
										}
									}
								}
								
							}
							if(BronzeCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(BronzeCount!=0){
												p.getInventory().remove(i);
												BronzeCount--;
											}
										}
									}
								}
								for(int x = 0;x<10;x++){
									p.getInventory().addItem(Items.Arrowhead_Rune.generateItem());
								}
								Skills.Smithing.setXP(75, p);
							}else{
								if(BronzeCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X Rune");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 90 to smith this!");
						}
						break;
    				case "Smithing:Rune Dagger":
    					if(Skills.Smithing.getLevel(p)>=85){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=1){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Dagger_Rune.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 85 to smith this!");
						}
						break;
    				case "Smithing:Rune Hatchet":
    					if(Skills.Smithing.getLevel(p)>=86){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=1){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Rune_Hatchet.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 86 to smith this!");
						}
						break;
    				case "Smithing:Rune Pickaxe":
    					if(Skills.Smithing.getLevel(p)>=90){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=1){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Rune_Pickaxe.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 90 to smith this!");
						}
						break;
    				case "Smithing:Rune Mace":
    					if(Skills.Smithing.getLevel(p)>=87){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=1){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Mace_Rune.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 87 to smith this!");
						}
						break;
    				case "Smithing:Rune MediumHelmet":
    					if(Skills.Smithing.getLevel(p)>=88){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=1){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.MediumHelmet_Rune.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 88 to smith this!");
						}
						break;
    				case "Smithing:Rune Sword":
    					if(Skills.Smithing.getLevel(p)>=89){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=1){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Sword_Rune.generateItem());
								Skills.Smithing.setXP(75, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 1X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 89 to smith this!");
						}
						break;
    				case "Smithing:Rune Scimitar":
    					if(Skills.Smithing.getLevel(p)>=90){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=2){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Scimitar_Rune.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 90 to smith this!");
						}
						break;
    				case "Smithing:Rune Longsword":
    					if(Skills.Smithing.getLevel(p)>=91){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=2){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Longsword_Rune.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 91 to smith this!");
						}
						break;
    				case "Smithing:Rune FullHelmet":
    					if(Skills.Smithing.getLevel(p)>=92){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=2){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==2){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.FullHelmet_Rune.generateItem());
								Skills.Smithing.setXP(150, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 2X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 92 to smith this!");
						}
						break;
    				case "Smithing:Rune Warhammer":
    					if(Skills.Smithing.getLevel(p)>=94){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=3){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Warhammer_Rune.generateItem());
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X RuneBar");
									Skills.Smithing.setXP(225, p);
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 94 to smith this!");
						}
						break;
    				case "Smithing:Rune Battleaxe":
    					if(Skills.Smithing.getLevel(p)>=95){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=3){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Battleaxe_Rune.generateItem());
								Skills.Smithing.setXP(225, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 95 to smith this!");
						}
						break;
    				case "Smithing:Rune Chainbody":
    					if(Skills.Smithing.getLevel(p)>=96){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=3){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Chainbody_Rune.generateItem());
								Skills.Smithing.setXP(225, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 96 to smith this!");
						}
						break;
    				case "Smithing:Rune TwoHandedSword":
    					if(Skills.Smithing.getLevel(p)>=99){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=3){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.TwoHandedSword_Rune.generateItem());
								Skills.Smithing.setXP(225, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 99 to smith this!");
						}
						break;
    				case "Smithing:Rune Platelegs":
    					if(Skills.Smithing.getLevel(p)>=99){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=3){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platelegs_Rune.generateItem());
								Skills.Smithing.setXP(225, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 99 to smith this!");
						}
						break;
    				case "Smithing:Rune Plateskirt":
    					if(Skills.Smithing.getLevel(p)>=99){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=3){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==3){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Plateskirt_Rune.generateItem());
								Skills.Smithing.setXP(225, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 3X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 99 to smith this!");
						}
						break;
    				case "Smithing:Rune Platebody":
    					if(Skills.Smithing.getLevel(p)>=99){
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
										if(RuneCount!=5){
											RuneCount++;
										}
									}
								}
								
							}
							if(RuneCount==5){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.RuneBar.getName())){
											if(RuneCount!=0){
												p.getInventory().remove(i);
												RuneCount--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.Platebody_Rune.generateItem());
								Skills.Smithing.setXP(375, p);
							}else{
								if(RuneCount==0){
									p.sendMessage(ChatColor.RED+"You need 5X RuneBar");
								}
							}
						}else{
							p.sendMessage(ChatColor.RED+"You have to be level 99 to smith this!");
						}
						break;
						
						
						
						
						
						
						
						
						
						
						
						
						
						
    					//back button
					case "Back":
    					Smithing.openFirstPageAnvil(p);
    					break;
    					//first menu
    				case "Smithing:Bronze Items":
						Smithing.openAnvilPage(p, 1);
						break;
					case "Smithing:Iron Items":
						Smithing.openAnvilPage(p, 2);
						break;
					case "Smithing:Silver Items":
						Smithing.openAnvilPage(p, 3);
						break;
					case "Smithing:Steel Items":
						Smithing.openAnvilPage(p, 4);
						break;
					case "Smithing:Gold Items":
						Smithing.openAnvilPage(p, 5);
						break;
					case "Smithing:Mithrill Items":
						Smithing.openAnvilPage(p, 6);
						break;
					case "Smithing:Adamant Items":
						Smithing.openAnvilPage(p, 7);
						break;
					case "Smithing:Rune Items":
						Smithing.openAnvilPage(p, 8);
						break;
    				}
    				break;
    			case "Furnace":
    				if(e.getRawSlot()<9){
    				switch(itemname){
	    				case "Smithing:Bronze Bar":
							int a=0;
							int b=0;
							for(ItemStack i:p.getInventory()){
								if(i!=null){
									if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Copper_Ore.getName())){
										if(a!=1){
											a++;
										}
									}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Tin_Ore.getName())){
										if(b!=1){
											b++;
										}
									}
								}
								
							}
							if(a==1&&b==1){
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Copper_Ore.getName())){
											if(a!=0){
												p.getInventory().remove(i);
												a--;
											}
										}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Tin_Ore.getName())){
											if(b!=0){
												p.getInventory().remove(i);
												b--;
											}
										}
									}
								}
								p.getInventory().addItem(Items.BronzeBar.generateItem());
								Skills.Smithing.setXP(7, p);
							}else{
								if(a==0){
									p.sendMessage(ChatColor.RED+"You need 1X CopperOre");
								}
								if(b==0){
									p.sendMessage(ChatColor.RED+"You need 1X TinOre");
								}
							}
							break;
						case "Smithing:Iron Bar":
							if(Skills.Smithing.getLevel(p)>=15){
								int c=0;
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Iron_Ore.getName())){
											if(c!=1){
												c++;
											}
										}
									}
									
								}
								if(c==1){
									for(ItemStack i:p.getInventory()){
										if(i!=null){
											if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Iron_Ore.getName())){
												if(c!=0){
													p.getInventory().remove(i);
													c--;
												}
											}
										}
									}
									p.getInventory().addItem(Items.IronBar.generateItem());
									Skills.Smithing.setXP(13, p);
								}else{
									if(c==0){
										p.sendMessage(ChatColor.RED+"You need 1X IronOre");
									}
								}
								}else{
									p.sendMessage(ChatColor.RED+"You have to be level 15 to smith this!");
								}
								break;
							case "Smithing:Silver Bar":
								if(Skills.Smithing.getLevel(p)>=20){
								int d=0;
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Silver_Ore.getName())){
											if(d!=1){
												d++;
											}
										}
									}
									
								}
								if(d==1){
									for(ItemStack i:p.getInventory()){
										if(i!=null){
											if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Silver_Ore.getName())){
												if(d!=0){
													p.getInventory().remove(i);
													d--;
												}
											}
										}
									}
									p.getInventory().addItem(Items.SilverBar.generateItem());
									Skills.Smithing.setXP(14, p);
								}else{
									if(d==0){
										p.sendMessage(ChatColor.RED+"You need 1X SilverOre");
									}
								}
							}else{
								p.sendMessage(ChatColor.RED+"You have to be level 20 to smith this!");
							}
							break;
						case "Smithing:Steel Bar":
							if(Skills.Smithing.getLevel(p)>=30){
								int f=0;
								int g=0;
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Iron_Ore.getName())){
											if(f!=1){
												f++;
											}
										}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
											if(g!=2){
												g++;
											}
										}
									}
									
								}
								if(f==1&&g==2){
									for(ItemStack i:p.getInventory()){
										if(i!=null){
											if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Iron_Ore.getName())){
												if(f!=0){
													p.getInventory().remove(i);
													f--;
												}
											}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
												if(g!=0){
													p.getInventory().remove(i);
													g--;
												}
											}
										}
									}
									Random r = new Random();
							    	int rand = r.nextInt(2-1) + 1;
							    	if(rand==1){
							    		p.getInventory().addItem(Items.SteelBar.generateItem());
							    		Skills.Smithing.setXP(18, p);
							    	}else{
							    		p.sendMessage(ChatColor.RED+"Dam the ingot dident set properly in its mould!");
							    		Skills.Smithing.setXP(18, p);
							    	}
									
								}else{
									if(f==0){
										p.sendMessage(ChatColor.RED+"You need 1X IronOre");
									}
									if(g==0){
										p.sendMessage(ChatColor.RED+"You need 2X Coal");
									}
								}
							}else{
								p.sendMessage(ChatColor.RED+"You have to be level 30 to smith this!");
							}
							break;
						case "Smithing:Gold Bar":
							if(Skills.Smithing.getLevel(p)>=40){
								int h=0;
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Gold_Ore.getName())){
											if(h!=1){
												h++;
											}
										}
									}
									
								}
								if(h==1){
									for(ItemStack i:p.getInventory()){
										if(i!=null){
											if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Gold_Ore.getName())){
												if(h!=0){
													p.getInventory().remove(i);
													h--;
												}
											}
										}
									}
									p.getInventory().addItem(Items.GoldBar.generateItem());
									Skills.Smithing.setXP(23, p);
								}else{
									if(h==0){
										p.sendMessage(ChatColor.RED+"You need 1X GoldOre");
									}
								}
							}else{
								p.sendMessage(ChatColor.RED+"You have to be level 40 to smith this!");
							}
							break;
						case "Smithing:Mithrill Bar":
							if(Skills.Smithing.getLevel(p)>=50){
								int j=0;
								int k=0;
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Mithrill_Ore.getName())){
											if(j!=1){
												j++;
											}
										}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
											if(k!=4){
												k++;
											}
										}
									}
									
								}
								if(j==1&&k==4){
									for(ItemStack i:p.getInventory()){
										if(i!=null){
											if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Mithrill_Ore.getName())){
												if(j!=0){
													p.getInventory().remove(i);
													j--;
												}
											}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
												if(k!=0){
													p.getInventory().remove(i);
													k--;
												}
											}
										}
									}
									p.getInventory().addItem(Items.MithrillBar.generateItem());
									Skills.Smithing.setXP(30, p);
								}else{
									if(j==0){
										p.sendMessage(ChatColor.RED+"You need 1X MithrillOre");
									}
									if(k==0){
										p.sendMessage(ChatColor.RED+"You need 4X Coal");
									}
								}
							}else{
								p.sendMessage(ChatColor.RED+"You have to be level 50 to smith this!");
							}
							break;
						case "Smithing:Adamant Bar":
							if(Skills.Smithing.getLevel(p)>=70){
								int l=0;
								int m=0;
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Adamantite_Ore.getName())){
											if(l!=1){
												l++;
											}
										}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
											if(m!=6){
												m++;
											}
										}
									}
									
								}
								if(l==1&&m==6){
									for(ItemStack i:p.getInventory()){
										if(i!=null){
											if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Adamantite_Ore.getName())){
												if(l!=0){
													p.getInventory().remove(i);
													l--;
												}
											}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
												if(m!=0){
													p.getInventory().remove(i);
													m--;
												}
											}
										}
									}
									p.getInventory().addItem(Items.AdamantBar.generateItem());
									Skills.Smithing.setXP(38, p);
								}else{
									if(l==0){
										p.sendMessage(ChatColor.RED+"You need 1X AdamantOre");
									}
									if(m==0){
										p.sendMessage(ChatColor.RED+"You need 6X Coal");
									}
								}
							}else{
								p.sendMessage(ChatColor.RED+"You have to be level 70 to smith this!");
							}
							break;
						case "Smithing:Rune Bar":
							if(Skills.Smithing.getLevel(p)>=85){
								int n=0;
								int o=0;
								for(ItemStack i:p.getInventory()){
									if(i!=null){
										if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Runite_Ore.getName())){
											if(n!=1){
												n++;
											}
										}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
											if(o!=8){
												o++;
											}
										}
									}
									
								}
								if(n==1&&o==8){
									for(ItemStack i:p.getInventory()){
										if(i!=null){
											if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Runite_Ore.getName())){
												if(n!=0){
													p.getInventory().remove(i);
													n--;
												}
											}else if(i.hasItemMeta()&&i.getItemMeta().hasDisplayName()&&i.getItemMeta().getDisplayName().equals(Items.Coal.getName())){
												if(o!=0){
													p.getInventory().remove(i);
													o--;
												}
											}
										}
									}
									p.getInventory().addItem(Items.RuneBar.generateItem());
									Skills.Smithing.setXP(50, p);
								}else{
									if(n==0){
										p.sendMessage(ChatColor.RED+"You need 1X RuniteOre");
									}
									if(o==0){
										p.sendMessage(ChatColor.RED+"You need 8X Coal");
									}
								}
							}else{
								p.sendMessage(ChatColor.RED+"You have to be level 85 to smith this!");
							}
							break;
	    				}
    				}
    				break;
    			case "Levels":
    				
    					if(itemname.contains("Attack")){
    						Guis.generateGUI(Guis.AttackInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Defence")){
    						Guis.generateGUI(Guis.DefenceInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Health")){
    						Guis.generateGUI(Guis.HealthInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Range")){
    						Guis.generateGUI(Guis.RangeInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Magic")){
    						Guis.generateGUI(Guis.MagicInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Mining")){
    						Guis.generateGUI(Guis.MiningInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Smithing")){
    						Guis.generateGUI(Guis.SmithingInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Woodcutting")){
    						Guis.generateGUI(Guis.WoodcuttingInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Firemaking")){
    						Guis.generateGUI(Guis.FiremakingInformation, (Player) e.getWhoClicked());
    						
    					}else if(itemname.contains("Prayer")){
    						Guis.generateGUI(Guis.PrayerInformation, (Player) e.getWhoClicked());
    						
    					}
    				
    				break;
    			case "Chose Action":
    				Player p2 = PlayerInteraction.Clicked.get(p);
    				switch(itemname){
    					case "Trade":
    						if(p2.isOnline()){
    							if(PlayerInteraction.offerdTrade.containsKey(p)&&PlayerInteraction.offerdTrade.get(p).equals(p2)){
    								p.sendMessage("You have already challenged "+p2.getDisplayName()+" To a trade!");
    							}else if(PlayerInteraction.offerdTrade.containsKey(p)){
    								p.sendMessage("Chalenge Cansled with "+PlayerInteraction.offerdTrade.get(p2).getDisplayName());
    								p.sendMessage("You have challenged "+p2.getDisplayName()+" To a trade!");
        							p2.sendMessage(ChatColor.GREEN+p.getDisplayName()+" has chalenged you to a trade, do you accept?");
        							PlayerInteraction.offerdTrade.put(p,p2);
        							PlayerInteraction.Clicked.remove(p);
        							
    	    						IChatBaseComponent comp = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.GOLD+ChatColor.BOLD+ "Accept" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/Accepttrade "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet);
    	
    	    						IChatBaseComponent comp2 = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.RED+ChatColor.BOLD+ "Deny" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/Denytrade "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet2 = new PacketPlayOutChat(comp2, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet2);
    							}else{
    								p.sendMessage("You have challenged "+p2.getDisplayName()+" To a trade!");
        							p2.sendMessage(ChatColor.GREEN+p.getDisplayName()+" has chalenged you to a trade, do you accept?");
        							PlayerInteraction.offerdTrade.put(p,p2);
        							PlayerInteraction.Clicked.remove(p);
        							
    	    						IChatBaseComponent comp = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.GOLD+ChatColor.BOLD+ "Accept" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/Accepttrade "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet);
    	
    	    						IChatBaseComponent comp2 = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.RED+ChatColor.BOLD+ "Deny" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/Denytrade "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet2 = new PacketPlayOutChat(comp2, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet2);
    							}
    						}
    						
    						break;
    					case "PvP":
    						if(p2.isOnline()){
    							if(PlayerInteraction.Chanlenged.containsKey(p)&&PlayerInteraction.Chanlenged.get(p).equals(p2)){
    								p.sendMessage("You have already challenged "+p2.getDisplayName()+" To a fight!");
    							}else if(PlayerInteraction.Chanlenged.containsKey(p)){
    								p.sendMessage("Chalenge Cansled with "+PlayerInteraction.Chanlenged.get(p2).getDisplayName());
    								p.sendMessage("You have challenged "+p2.getDisplayName()+" To a fight!");
        							p2.sendMessage(ChatColor.GREEN+p.getDisplayName()+" has chalenged you to a fight, do you accept?");
        							PlayerInteraction.Chanlenged.put(p,p2);
        							PlayerInteraction.Clicked.remove(p);
        							
    	    						IChatBaseComponent comp = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.GOLD+ChatColor.BOLD+ "Accept" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/AcceptFight "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet);
    	
    	    						IChatBaseComponent comp2 = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.RED+ChatColor.BOLD+ "Deny" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/DenyFight "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet2 = new PacketPlayOutChat(comp2, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet2);
    							}else{
    								p.sendMessage("You have challenged "+p2.getDisplayName()+" To a fight!");
        							p2.sendMessage(ChatColor.GREEN+p.getDisplayName()+" has chalenged you to a fight, do you accept?");
        							PlayerInteraction.Chanlenged.put(p,p2);
        							PlayerInteraction.Clicked.remove(p);
        							
    	    						IChatBaseComponent comp = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.GOLD+ChatColor.BOLD+ "Accept" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/AcceptFight "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet);
    	
    	    						IChatBaseComponent comp2 = ChatSerializer
    	    						            .a("{\"text\":\"" + 
    	    						            "\",\"extra\":[{\"text\":\"" +ChatColor.RED+ChatColor.BOLD+ "Deny" + 
    	    						            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
    	    						            "/DenyFight "+p.getDisplayName() + "\"}}]}");    
    	    						PacketPlayOutChat packet2 = new PacketPlayOutChat(comp2, true);
    	    						((CraftPlayer) p2).getHandle().playerConnection.sendPacket(packet2);
    							}
    						}
    						
    						break;
    				}
    				break;
    		}
    	}
    }
}
