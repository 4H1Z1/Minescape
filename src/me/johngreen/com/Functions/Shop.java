package me.johngreen.com.Functions;

import java.util.ArrayList;
import java.util.List;

import me.johngreen.com.Main;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Shop {
	GeneralStore("General Store",54, new String[]{"TinderBox","Bronze Pickaxe","Bronze Hatchet","Bronze Dagger","Bronze Mace","Bronze MediumHelmet","Bronze Sword","Bronze Scimitar","Bronze Longsword","Bronze FullHelmet","Bronze Warhammer","Bronze Battleaxe","Bronze Chainbody","Bronze TwoHandedSword","Bronze Platelegs","Bronze Plateskirt","Bronze Platebody"}),
	BobsAxes("Bobs Axes",54, new String[]{"Bronze Pickaxe","Bronze Hatchet","Iron Hatchet","Steel Hatchet"}),
	HanksFishingSupplys("Hanks Fishing Supplys",54, new String[]{"Bait","Net","Big Net","Fishing Rod"}),
	Auburyshop("Auburys Magic Supplys",54, new String[]{""}),
	VarockSwordshop("Varrock Sword Shop",54, new String[]{"Bronze Sword","Iron Sword","Steel Sword","Mithrill Sword","Adamantite Sword","Bronze Longsword","Iron Longsword","Steel Longsword","Mithrill Longsword","Adamantite Longsword","Bronze Dagger","Iron Dagger","Steel Dagger","Mithrill Dagger","Adamantite Dagger"}),
	VarockArmourshop("Auburys Magic Supplys",54, new String[]{""}),
	VarockStaffshop("Auburys Magic Supplys",54, new String[]{""}),
	ZekesShop("Zekes Superior Scimitars",54, new String[]{"Bronze Scimitar","Iron Scimitar","Steel Scimitar","Mithrill Scimitar"});
	
	Shop(String name, int size, String[] items){
		this.size = size;
		this.name= name;
		this.items = items;
	}
	private String[] items;
	private String name;
	private int size;
	public int getSize(){
		return size;
	}
	public String[] getItems(){
		return items;
	}
	public String getName(){
		return name;
	}
	public static void spawnShop(Shop shop,Player p){
		Inventory inv = Bukkit.createInventory(null, shop.getSize(), shop.getName());
		for(String s:shop.getItems()){
			inv.addItem(Items.getByName(s).generateShopItem());
		}
		p.openInventory(inv);
		
	}
	public static List<String> getAllShops(){
		Shop[] values = Shop.values();
		List<String> a = new ArrayList<String>();
		for(Shop s:values){
			a.add(s.getName());
		}
		return a;
	}
	
}
