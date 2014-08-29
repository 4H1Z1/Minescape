package me.johngreen.com.Functions;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DamageCalculation {

	public static HashMap<Player,String> Type = new HashMap<Player,String>();
	
	public static int daamgeCalculation(Player p){
		ItemStack itemInHand = p.getItemInHand();
		String itemName = "";
		if(itemInHand!=null&&itemInHand.hasItemMeta()&&itemInHand.getItemMeta().hasDisplayName()){
			itemName = ChatColor.stripColor(itemInHand.getItemMeta().getDisplayName());
		}
		int itemDamage = 1;
		int leveldamage = Skills.Strength.getLevel(p)/3;
		if(leveldamage<1){
			leveldamage = 1;
		}
		if(itemInHand!=null){
			switch(itemName){
				//Bronze
			 case "Bronze Dagger":
				 itemDamage = 1;
				 break;
			 case "Bronze Mace":
				 itemDamage = 2;
				 break;
			 case "Bronze Sword":
				 itemDamage = 3;
				 break;
			 case "Bronze Scimitar":
				 itemDamage = 4;
				 break;
			 case "Bronze Longsword":
				 itemDamage = 5;
				 break;
			 case "Bronze Warhammer":
				 itemDamage = 6;
				 break;
			 case "Bronze Battleaxe":
				 itemDamage = 7;
				 break;
			 case "Bronze TwoHandedSword":
				 itemDamage = 8;
				 break;
				 
				 
			 case "Iron Dagger":
				 itemDamage = 6;
				 break;
			 case "Iron Mace":
				 itemDamage = 7;
				 break;
			 case "Iron Sword":
				 itemDamage = 8;
				 break;
			 case "Iron Scimitar":
				 itemDamage = 9;
				 break;
			 case "Iron Longsword":
				 itemDamage = 10;
				 break;
			 case "Iron Warhammer":
				 itemDamage = 11;
				 break;
			 case "Iron Battleaxe":
				 itemDamage = 12;
				 break;
			 case "Iron TwoHandedSword":
				 itemDamage = 13;
				 break;
				 
			 case "Steel Dagger":
				 itemDamage = 11;
				 break;
			 case "Steel Mace":
				 itemDamage = 12;
				 break;
			 case "Steel Sword":
				 itemDamage = 13;
				 break;
			 case "Steel Scimitar":
				 itemDamage = 14;
				 break;
			 case "Steel Longsword":
				 itemDamage = 15;
				 break;
			 case "Steel Warhammer":
				 itemDamage = 16;
				 break;
			 case "Steel Battleaxe":
				 itemDamage = 17;
				 break;
			 case "Steel TwoHandedSword":
				 itemDamage = 18;
				 break;
				 
			 case "Mithrill Dagger":
				 itemDamage = 16;
				 break;
			 case "Mithrill Mace":
				 itemDamage = 17;
				 break;
			 case "Mithrill Sword":
				 itemDamage = 18;
				 break;
			 case "Mithrill Scimitar":
				 itemDamage = 19;
				 break;
			 case "Mithrill Longsword":
				 itemDamage = 20;
				 break;
			 case "Mithrill Warhammer":
				 itemDamage = 21;
				 break;
			 case "Mithrill Battleaxe":
				 itemDamage = 22;
				 break;
			 case "Mithrill TwoHandedSword":
				 itemDamage = 23;
				 break;
				 
			 case "Adamantite Dagger":
				 itemDamage = 21;
				 break;
			 case "Adamantite Mace":
				 itemDamage = 22;
				 break;
			 case "Adamantite Sword":
				 itemDamage = 23;
				 break;
			 case "Adamantite Scimitar":
				 itemDamage = 24;
				 break;
			 case "Adamantite Longsword":
				 itemDamage = 25;
				 break;
			 case "Adamantite Warhammer":
				 itemDamage = 26;
				 break;
			 case "Adamantite Battleaxe":
				 itemDamage = 27;
				 break;
			 case "Adamantite TwoHandedSword":
				 itemDamage = 28;
				 break;
				 
			 case "Rune Dagger":
				 itemDamage = 26;
				 break;
			 case "Rune Mace":
				 itemDamage = 27;
				 break;
			 case "Rune Sword":
				 itemDamage = 28;
				 break;
			 case "Rune Scimitar":
				 itemDamage = 29;
				 break;
			 case "Rune Longsword":
				 itemDamage = 30;
				 break;
			 case "Rune Warhammer":
				 itemDamage = 31;
				 break;
			 case "Rune Battleaxe":
				 itemDamage = 32;
				 break;
			 case "Rune TwoHandedSword":
				 itemDamage = 33;
				 break;
			}
		}
		if(itemDamage<1){
			itemDamage=1;
		}
		if((itemDamage+leveldamage)<=3){
			return itemDamage+leveldamage;
		}else{
			Random r = new Random();
			int rand = r.nextInt((itemDamage+leveldamage)+((itemDamage+leveldamage)/2)) + ((itemDamage+leveldamage)/2);
	    	return rand;
		}
		
	}
	
	public static boolean hasLevelToUse(ItemStack itemInHand,Player p){
		String itemName = "";
		if(itemInHand!=null&&itemInHand.hasItemMeta()&&itemInHand.getItemMeta().hasDisplayName()){
			itemName = ChatColor.stripColor(itemInHand.getItemMeta().getDisplayName());
		}
		int itemDamage = 1;
		int level = Skills.Attack.getLevel(p);
		if(itemInHand!=null){
			switch(itemName){
				//Bronze
			 case "Bronze Dagger":
				 itemDamage = 1;
				 break;
			 case "Bronze Mace":
				 itemDamage = 1;
				 break;
			 case "Bronze Sword":
				 itemDamage = 1;
				 break;
			 case "Bronze Scimitar":
				 itemDamage = 1;
				 break;
			 case "Bronze Longsword":
				 itemDamage = 1;
				 break;
			 case "Bronze Warhammer":
				 itemDamage = 1;
				 break;
			 case "Bronze Battleaxe":
				 itemDamage = 1;
				 break;
			 case "Bronze TwoHandedSword":
				 itemDamage = 1;
				 break;
				 
				 
			 case "Iron Dagger":
				 itemDamage = 10;
				 break;
			 case "Iron Mace":
				 itemDamage = 10;
				 break;
			 case "Iron Sword":
				 itemDamage = 10;
				 break;
			 case "Iron Scimitar":
				 itemDamage = 10;
				 break;
			 case "Iron Longsword":
				 itemDamage = 10;
				 break;
			 case "Iron Warhammer":
				 itemDamage = 10;
				 break;
			 case "Iron Battleaxe":
				 itemDamage = 10;
				 break;
			 case "Iron TwoHandedSword":
				 itemDamage = 10;
				 break;
				 
			 case "Steel Dagger":
				 itemDamage = 20;
				 break;
			 case "Steel Mace":
				 itemDamage = 20;
				 break;
			 case "Steel Sword":
				 itemDamage = 20;
				 break;
			 case "Steel Scimitar":
				 itemDamage = 20;
				 break;
			 case "Steel Longsword":
				 itemDamage = 20;
				 break;
			 case "Steel Warhammer":
				 itemDamage = 20;
				 break;
			 case "Steel Battleaxe":
				 itemDamage = 20;
				 break;
			 case "Steel TwoHandedSword":
				 itemDamage = 20;
				 break;
				 
			 case "Mithrill Dagger":
				 itemDamage = 30;
				 break;
			 case "Mithrill Mace":
				 itemDamage = 30;
				 break;
			 case "Mithrill Sword":
				 itemDamage = 30;
				 break;
			 case "Mithrill Scimitar":
				 itemDamage = 30;
				 break;
			 case "Mithrill Longsword":
				 itemDamage = 30;
				 break;
			 case "Mithrill Warhammer":
				 itemDamage = 30;
				 break;
			 case "Mithrill Battleaxe":
				 itemDamage = 30;
				 break;
			 case "Mithrill TwoHandedSword":
				 itemDamage = 30;
				 break;
				 
			 case "Adamantite Dagger":
				 itemDamage = 40;
				 break;
			 case "Adamantite Mace":
				 itemDamage = 40;
				 break;
			 case "Adamantite Sword":
				 itemDamage = 40;
				 break;
			 case "Adamantite Scimitar":
				 itemDamage = 40;
				 break;
			 case "Adamantite Longsword":
				 itemDamage = 40;
				 break;
			 case "Adamantite Warhammer":
				 itemDamage = 40;
				 break;
			 case "Adamantite Battleaxe":
				 itemDamage = 40;
				 break;
			 case "Adamantite TwoHandedSword":
				 itemDamage = 40;
				 break;
				 
			 case "Rune Dagger":
				 itemDamage = 60;
				 break;
			 case "Rune Mace":
				 itemDamage = 60;
				 break;
			 case "Rune Sword":
				 itemDamage = 60;
				 break;
			 case "Rune Scimitar":
				 itemDamage = 60;
				 break;
			 case "Rune Longsword":
				 itemDamage = 60;
				 break;
			 case "Rune Warhammer":
				 itemDamage = 60;
				 break;
			 case "Rune Battleaxe":
				 itemDamage = 60;
				 break;
			 case "Rune TwoHandedSword":
				 itemDamage = 60;
				 break;
			}
		}
		if(level>=itemDamage){
			return true;
		}else{
			return false;
		}
	}
	
}
