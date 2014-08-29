package me.johngreen.com.Functions;

import java.util.ArrayList;
import java.util.List;

import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public enum Guis {
	PlayerInteraction("Chose Action", 9,new String[]{"GUI:PlayerInteraction,ITEM:Fight","GUI:PlayerInteraction,ITEM:Trade"}),
	ChatPlayerInteraction("Chose Action", 9,new String[]{"GUI:ChatPlayerInteraction,ITEM:AddFriend","GUI:ChatPlayerInteraction,ITEM:Mute","GUI:ChatPlayerInteraction,ITEM:Report"}),
	
	
    Levels("Levels", 18,new String[]{"GUI:Level,ITEM:Attack","GUI:Level,ITEM:Defence","GUI:Level,ITEM:Health","GUI:Level,ITEM:Range","GUI:Level,ITEM:Magic","GUI:Level,ITEM:Mining","GUI:Level,ITEM:Smithing","GUI:Level,ITEM:Woodcutting","GUI:Level,ITEM:Firemaking","GUI:Level,ITEM:Prayer"}),
    AttackInformation("AttackInformation", 9,new String[]{}),
    DefenceInformation("DefenceInformation", 9,new String[]{}),
    HealthInformation("HealthInformation", 9,new String[]{}),
    RangeInformation("RangeInformation", 9,new String[]{}),
    MagicInformation("MagicInformation", 9,new String[]{}),
    MiningInformation("MiningInformation", 9,new String[]{}),
    SmithingInformation("SmithingInformation", 9,new String[]{}),
    WoodcuttingInformation("WoodcuttingInformation", 9,new String[]{}),
	FiremakingInformation("FiremakingInformation", 9,new String[]{}),
    PrayerInformation("PrayerInformation", 9,new String[]{});
	
	private final String name;
	private int size;
	private String[] invMap;
    
    Guis(String name,int size,String[] invMap) {
    	this.name = name;
    	this.size = size;
    	this.invMap = invMap;
    }
    private String getName(){
		return name;
    }
    private String[] getInvMap(){
		return invMap;
    }
    private int getSize(){
		return size;
    }    
    public static void generateGUI(Guis g,Player p,String Title){
    	Inventory myInventory = Bukkit.createInventory(null, g.getSize(), g.getName()+" :"+Title);
    	int i = 0;
    	for(String s:g.getInvMap()){
    		Material m = null;
    		String name = null;
    		List<String> lore = new ArrayList<String>();
    		switch(s){
				case"GUI:ChatPlayerInteraction,ITEM:Report":
					m=Material.MAP;
					name=ChatColor.LIGHT_PURPLE+"Report Player";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Report a player");
					break;
				case"GUI:ChatPlayerInteraction,ITEM:AddFriend":
					m=Material.GOLDEN_APPLE;
					name=ChatColor.LIGHT_PURPLE+"Add Friend";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Add As Friend");
					break;
				case"GUI:ChatPlayerInteraction,ITEM:Mute":
					m=Material.NOTE_BLOCK;
					name=ChatColor.LIGHT_PURPLE+"Mute";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Mute Player");
					break;
				case"GUI:PlayerInteraction,ITEM:Trade":
					m=Material.GOLD_INGOT;
					name=ChatColor.LIGHT_PURPLE+"Trade";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Start A Trade");
					break;
				case"GUI:PlayerInteraction,ITEM:Fight":
					m=Material.DIAMOND_SWORD;
					name=ChatColor.LIGHT_PURPLE+"PvP";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Start A PvP Fight");
					break;
    			case"GUI:Level,ITEM:Attack":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Attack";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Defence":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Defence";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Health":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Health";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Range":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Range";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Magic":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Magic";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Mining":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Mining";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Smithing":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Smithing";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Woodcutting":
    				m=Material.LOG;
    				name=ChatColor.LIGHT_PURPLE+"Woodcutting";
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    		}
    		myInventory.setItem(i,Items.generateItem(lore, name, m));
    		i++;
    	}
    	p.openInventory(myInventory);
    }
    public static void generateGUI(Guis g,Player p){
    	Inventory myInventory = Bukkit.createInventory(null, g.getSize(), g.getName());
    	int i = 0;
    	for(String s:g.getInvMap()){
    		Material m = null;
    		String name = null;
    		List<String> lore = new ArrayList<String>();
    		switch(s){
				case"GUI:ChatPlayerInteraction,ITEM:Report":
					m=Material.GOLD_INGOT;
					name=ChatColor.LIGHT_PURPLE+"Trade";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Start A Trade");
					break;
				case"GUI:ChatPlayerInteraction,ITEM:AddFriend":
					m=Material.GOLD_INGOT;
					name=ChatColor.LIGHT_PURPLE+"Trade";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Start A Trade");
					break;
				case"GUI:ChatPlayerInteraction,ITEM:Mute":
					m=Material.DIAMOND_SWORD;
					name=ChatColor.LIGHT_PURPLE+"PvP";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Start A PvP Fight");
					break;
				case"GUI:PlayerInteraction,ITEM:Trade":
					m=Material.GOLD_INGOT;
					name=ChatColor.LIGHT_PURPLE+"Trade";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Start A Trade");
					break;
				case"GUI:PlayerInteraction,ITEM:Fight":
					m=Material.DIAMOND_SWORD;
					name=ChatColor.LIGHT_PURPLE+"PvP";
					lore.add(ChatColor.BLUE+"");
					lore.add(ChatColor.BLUE+"Click Hear To Start A PvP Fight");
					break;
    			case"GUI:Level,ITEM:Attack":
    				m=Material.GOLD_SWORD;
    				name=ChatColor.LIGHT_PURPLE+"Attack Xp:"+Skills.Attack.getXP(p)+" Level:"+Skills.Attack.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Defence":
    				m=Material.IRON_HELMET;
    				name=ChatColor.LIGHT_PURPLE+"Defence Xp:"+Skills.Defence.getXP(p)+" Level:"+Skills.Defence.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Health":
    				m=Material.GOLDEN_APPLE;
    				name=ChatColor.LIGHT_PURPLE+"Health Xp:"+Skills.Health.getXP(p)+" Level:"+Skills.Health.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Range":
    				m=Material.BOW;
    				name=ChatColor.LIGHT_PURPLE+"Range Xp:"+Skills.Range.getXP(p)+" Level:"+Skills.Range.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Magic":
    				m=Material.BLAZE_ROD;
    				name=ChatColor.LIGHT_PURPLE+"Magic Xp:"+Skills.Magic.getXP(p)+" Level:"+Skills.Magic.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Mining":
    				m=Material.WOOD_PICKAXE;
    				name=ChatColor.LIGHT_PURPLE+"Mining Xp:"+Skills.Mining.getXP(p)+" Level:"+Skills.Mining.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Smithing":
    				m=Material.IRON_INGOT;
    				name=ChatColor.LIGHT_PURPLE+"Smithing Xp:"+Skills.Smithing.getXP(p)+" Level:"+Skills.Smithing.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Woodcutting":
    				m=Material.WOOD_AXE;
    				name=ChatColor.LIGHT_PURPLE+"Woodcutting Xp:"+Skills.Woodcutting.getXP(p)+" Level:"+Skills.Woodcutting.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Firemaking":
    				m=Material.FLINT_AND_STEEL;
    				name=ChatColor.LIGHT_PURPLE+"Firemaking Xp:"+Skills.Firemaking.getXP(p)+" Level:"+Skills.Firemaking.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    			case"GUI:Level,ITEM:Prayer":
    				m=Material.NETHER_STAR;
    				name=ChatColor.LIGHT_PURPLE+"Prayer Xp:"+Skills.Prayer.getXP(p)+" Level:"+Skills.Prayer.getLevel(p);
    				lore.add(ChatColor.BLUE+"");
    				lore.add(ChatColor.BLUE+"Click Hear For More Information");
    				break;
    		}
    		myInventory.setItem(i,Items.generateItem(lore, name, m));
    		i++;
    	}
    	p.openInventory(myInventory);
    }
}
