package me.johngreen.com.Skills;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import me.johngreen.com.items.Items;

public enum Fish {
	Shrimp(10,Items.Shrimp),
	Herring(30,Items.Herring),
	Trout(50,Items.Trout),
	Tuna(80,Items.Tuna),
	Lobster(90,Items.Lobster),
	Swordfish(100,Items.Swordfish),
	Monkfish(120,Items.Monkfish),
	Shark(110,Items.Shark);
	
	Fish(int xp,Items item){
		this.xp = xp;
		this.item = item;
	}
	private int xp;
	private Items item;
	
	public int getXp(){
		return xp;
	}
	public Items getItem(){
		return item;
	}
}