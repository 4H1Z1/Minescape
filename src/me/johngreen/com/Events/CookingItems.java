package me.johngreen.com.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import me.johngreen.com.items.Items;

public enum CookingItems {

	Shrimp(Items.Shrimp,30,10,15),
	Herring(Items.Herring,50,10,15),
	Trout(Items.Trout,70,9,15),
	Tuna(Items.Tuna,100,9,15),
	Lobster(Items.Lobster,120,8,15),
	Swordfish(Items.Swordfish,140,8,15),
	Monkfish(Items.Monkfish,150,6,15),
	Shark(Items.Shark,210,6,15);
	
	
	CookingItems(Items item,int xp,int r1, int r2){
		this.item = item;
		this.xp = xp;
		this.r1 =r1;
		this.r2 = r2;
	}
	private int xp;
	private int r2;
	private int r1;
	private Items item;
	
	public Items getItem(){
		return item;
	}

	public int getXP() {
		return xp;
	}
	public int getR2() {
		return r2;
	}
	public int getR1() {
		return r1;
	}
}
