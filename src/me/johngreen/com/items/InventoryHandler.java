package me.johngreen.com.items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryHandler {

	
	
	public static boolean hasSpace(Player p){
		for(ItemStack i:p.getInventory().getContents()){
			if(i==null){
				return true;
			}
		}
		return false;
	}
	public static boolean hasSpace(Player p,int needed){
		int a=0;
		for(ItemStack i:p.getInventory().getContents()){
			if(i==null){
				a++;
			}
		}
		if(a>=needed){
			return true;
		}
		return false;
	}
}
