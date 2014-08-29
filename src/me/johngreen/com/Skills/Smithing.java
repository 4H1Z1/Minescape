package me.johngreen.com.Skills;

import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Smithing {


	public static void openMainPageFurnace(Player p){
		Inventory inv = Bukkit.createInventory(null, 9,"Furnace");
		inv.addItem(Items.Furnace_BronzeBar.generateItem());
		inv.addItem(Items.Furnace_IronBar.generateItem());
		inv.addItem(Items.Furnace_SilverBar.generateItem());
		inv.addItem(Items.Furnace_SteelBar.generateItem());
		inv.addItem(Items.Furnace_GoldBar.generateItem());
		inv.addItem(Items.Furnace_MithrillBar.generateItem());
		inv.addItem(Items.Furnace_AdamantBar.generateItem());
		inv.addItem(Items.Furnace_RuneBar.generateItem());
		p.openInventory(inv);
	}
	
	public static void openFirstPageAnvil(Player p){
		Inventory inv = Bukkit.createInventory(null, 27,"Anvil");
		inv.addItem(Items.Anvil_BronzeBar.generateItem());
		inv.addItem(Items.Anvil_IronBar.generateItem());
		inv.addItem(Items.Anvil_SilverBar.generateItem());
		inv.addItem(Items.Anvil_SteelBar.generateItem());
		inv.addItem(Items.Anvil_GoldBar.generateItem());
		inv.addItem(Items.Anvil_MithrillBar.generateItem());
		inv.addItem(Items.Anvil_AdamantBar.generateItem());
		inv.addItem(Items.Anvil_RuneBar.generateItem());
		p.openInventory(inv);
	}
	
	public static void openAnvilPage(Player p,int page){
		Inventory inv = Bukkit.createInventory(null, 27,"Anvil");
		switch(page){
		case 1:
			inv.addItem(Items.Anvil_Arrowhead_Bronze.generateItem());
			inv.addItem(Items.Anvil_Dagger_Bronze.generateItem());
			inv.addItem(Items.Anvil_Hatchet_Bronze.generateItem());
			inv.addItem(Items.Anvil_Pickaxe_Bronze.generateItem());
			inv.addItem(Items.Anvil_Mace_Bronze.generateItem());
			inv.addItem(Items.Anvil_MediumHelmet_Bronze.generateItem());
			inv.addItem(Items.Anvil_Sword_Bronze.generateItem());
			inv.addItem(Items.Anvil_Scimitar_Bronze.generateItem());
			inv.addItem(Items.Anvil_Longsword_Bronze.generateItem());
			inv.addItem(Items.Anvil_FullHelmet_Bronze.generateItem());
			inv.addItem(Items.Anvil_Warhammer_Bronze.generateItem());
			inv.addItem(Items.Anvil_Battleaxe_Bronze.generateItem());
			inv.addItem(Items.Anvil_Chainbody_Bronze.generateItem());
			inv.addItem(Items.Anvil_TwoHandedSword_Bronze.generateItem());
			inv.addItem(Items.Anvil_Platelegs_Bronze.generateItem());
			inv.addItem(Items.Anvil_Plateskirt_Bronze.generateItem());
			inv.addItem(Items.Anvil_Platebody_Bronze.generateItem());
			break;
		case 2:
			inv.addItem(Items.Anvil_Arrowhead_Iron.generateItem());
			inv.addItem(Items.Anvil_Dagger_Iron.generateItem());
			inv.addItem(Items.Anvil_Hatchet_Iron.generateItem());
			inv.addItem(Items.Anvil_Pickaxe_Iron.generateItem());
			inv.addItem(Items.Anvil_Mace_Iron.generateItem());
			inv.addItem(Items.Anvil_MediumHelmet_Iron.generateItem());
			inv.addItem(Items.Anvil_Sword_Iron.generateItem());
			inv.addItem(Items.Anvil_Scimitar_Iron.generateItem());
			inv.addItem(Items.Anvil_Longsword_Iron.generateItem());
			inv.addItem(Items.Anvil_FullHelmet_Iron.generateItem());
			inv.addItem(Items.Anvil_Warhammer_Iron.generateItem());
			inv.addItem(Items.Anvil_Battleaxe_Iron.generateItem());
			inv.addItem(Items.Anvil_Chainbody_Iron.generateItem());
			inv.addItem(Items.Anvil_TwoHandedSword_Iron.generateItem());
			inv.addItem(Items.Anvil_Platelegs_Iron.generateItem());
			inv.addItem(Items.Anvil_Plateskirt_Iron.generateItem());
			inv.addItem(Items.Anvil_Platebody_Iron.generateItem());
			break;
		case 3:
			//
			break;
		case 4:
			inv.addItem(Items.Anvil_Arrowhead_Steel.generateItem());
			inv.addItem(Items.Anvil_Dagger_Steel.generateItem());
			inv.addItem(Items.Anvil_Hatchet_Steel.generateItem());
			inv.addItem(Items.Anvil_Pickaxe_Steel.generateItem());
			inv.addItem(Items.Anvil_Mace_Steel.generateItem());
			inv.addItem(Items.Anvil_MediumHelmet_Steel.generateItem());
			inv.addItem(Items.Anvil_Sword_Steel.generateItem());
			inv.addItem(Items.Anvil_Scimitar_Steel.generateItem());
			inv.addItem(Items.Anvil_Longsword_Steel.generateItem());
			inv.addItem(Items.Anvil_FullHelmet_Steel.generateItem());
			inv.addItem(Items.Anvil_Warhammer_Steel.generateItem());
			inv.addItem(Items.Anvil_Battleaxe_Steel.generateItem());
			inv.addItem(Items.Anvil_Chainbody_Steel.generateItem());
			inv.addItem(Items.Anvil_TwoHandedSword_Steel.generateItem());
			inv.addItem(Items.Anvil_Platelegs_Steel.generateItem());
			inv.addItem(Items.Anvil_Plateskirt_Steel.generateItem());
			inv.addItem(Items.Anvil_Platebody_Steel.generateItem());
			break;
		case 5:
			//
			break;
		case 6:
			inv.addItem(Items.Anvil_Arrowhead_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Dagger_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Hatchet_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Pickaxe_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Mace_Mithrill.generateItem());
			inv.addItem(Items.Anvil_MediumHelmet_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Sword_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Scimitar_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Longsword_Mithrill.generateItem());
			inv.addItem(Items.Anvil_FullHelmet_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Warhammer_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Battleaxe_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Chainbody_Mithrill.generateItem());
			inv.addItem(Items.Anvil_TwoHandedSword_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Platelegs_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Plateskirt_Mithrill.generateItem());
			inv.addItem(Items.Anvil_Platebody_Mithrill.generateItem());
			break;
		case 7:
			inv.addItem(Items.Anvil_Arrowhead_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Dagger_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Hatchet_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Pickaxe_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Mace_Adamantite.generateItem());
			inv.addItem(Items.Anvil_MediumHelmet_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Sword_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Scimitar_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Longsword_Adamantite.generateItem());
			inv.addItem(Items.Anvil_FullHelmet_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Warhammer_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Battleaxe_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Chainbody_Adamantite.generateItem());
			inv.addItem(Items.Anvil_TwoHandedSword_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Platelegs_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Plateskirt_Adamantite.generateItem());
			inv.addItem(Items.Anvil_Platebody_Adamantite.generateItem());
			break;
		case 8:
			inv.addItem(Items.Anvil_Arrowhead_Rune.generateItem());
			inv.addItem(Items.Anvil_Dagger_Rune.generateItem());
			inv.addItem(Items.Anvil_Hatchet_Rune.generateItem());
			inv.addItem(Items.Anvil_Pickaxe_Rune.generateItem());
			inv.addItem(Items.Anvil_Mace_Rune.generateItem());
			inv.addItem(Items.Anvil_MediumHelmet_Rune.generateItem());
			inv.addItem(Items.Anvil_Sword_Rune.generateItem());
			inv.addItem(Items.Anvil_Scimitar_Rune.generateItem());
			inv.addItem(Items.Anvil_Longsword_Rune.generateItem());
			inv.addItem(Items.Anvil_FullHelmet_Rune.generateItem());
			inv.addItem(Items.Anvil_Warhammer_Rune.generateItem());
			inv.addItem(Items.Anvil_Battleaxe_Rune.generateItem());
			inv.addItem(Items.Anvil_Chainbody_Rune.generateItem());
			inv.addItem(Items.Anvil_TwoHandedSword_Rune.generateItem());
			inv.addItem(Items.Anvil_Platelegs_Rune.generateItem());
			inv.addItem(Items.Anvil_Plateskirt_Rune.generateItem());
			inv.addItem(Items.Anvil_Platebody_Rune.generateItem());
			break;
		}
		inv.setItem(26, Items.Anvil_Back.generateItem());
		//inv.addItem(Items.Anvil_BronzeBar.generateItem());
		//inv.addItem(Items.Anvil_IronBar.generateItem());
		////inv.addItem(Items.Anvil_SilverBar.generateItem());
		//inv.addItem(Items.Anvil_SteelBar.generateItem());
		////inv.addItem(Items.Anvil_GoldBar.generateItem());
		//inv.addItem(Items.Anvil_MithrillBar.generateItem());
		//inv.addItem(Items.Anvil_AdamantBar.generateItem());
		//inv.addItem(Items.Anvil_RuneBar.generateItem());
		p.openInventory(inv);
	}
	
}
