package me.johngreen.com.Skills;

import java.util.HashMap;

import me.johngreen.com.Functions.Skills;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public enum Prayer {
	ThickSkin(),
	BurstOfStrength(),
	ClarityOfThought(),
	UnstoppableForce(),
	Charge(),
	RockSkin(),
	SuperhumanStrength(),
	ImprovedReflexes(),
	UnrelentingForce(),
	SuperCharge(),
	SteelSkin(),
	IncredibleReflexes(),
	ProtectfromMagic(),
	ProtectfromRange(),
	ProtectfromMelee(),
	OverpoweringForce(),
	Overcharge();
	
	public static HashMap<Player,Prayer> selectedPrayer = new HashMap<Player,Prayer>();
	
	public static void buryEvent(Player p, String name){
		String name1 = ChatColor.stripColor(name);
		switch(name1){
			case "Bone":
				Skills.Prayer.setXP(5, p);
			break;
			case "Bat Bones":
				Skills.Prayer.setXP(6, p);
			break;
			case "Big Bones":
				Skills.Prayer.setXP(15, p);
			break;
			case "BabyDragon Bones":
				Skills.Prayer.setXP(30, p);
			break;
			case "Dragon Bones":
				Skills.Prayer.setXP(72, p);
			break;
			case "Frost Dragon Bones":
				Skills.Prayer.setXP(72, p);
			break;
		}
	}
	public static void generatePrayer(Player p){
		Inventory inv = Bukkit.createInventory(null, 18,"Prayer");
		inv.addItem(Items.Prayer_ThickSkin.generateItem());
		inv.addItem(Items.Prayer_BurstOfStrength.generateItem());
		inv.addItem(Items.Prayer_ClarityOfThought.generateItem());
		inv.addItem(Items.Prayer_UnstoppableForce.generateItem());
		inv.addItem(Items.Prayer_Charge.generateItem());
		inv.addItem(Items.Prayer_RockSkin.generateItem());
		inv.addItem(Items.Prayer_SuperhumanStrength.generateItem());
		inv.addItem(Items.Prayer_ImprovedReflexes.generateItem());
		inv.addItem(Items.Prayer_UnrelentingForce.generateItem());
		inv.addItem(Items.Prayer_SuperCharge.generateItem());
		inv.addItem(Items.Prayer_SteelSkin.generateItem());
		inv.addItem(Items.Prayer_IncredibleReflexes.generateItem());
		inv.addItem(Items.Prayer_ProtectfromMagic.generateItem());
		inv.addItem(Items.Prayer_ProtectfromRange.generateItem());
		inv.addItem(Items.Prayer_ProtectfromMelee.generateItem());
		inv.addItem(Items.Prayer_OverpoweringForce.generateItem());
		inv.addItem(Items.Prayer_Overcharge.generateItem());
		p.openInventory(inv);
	}
	
}
