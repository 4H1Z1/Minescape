package me.johngreen.com.Functions;

import me.johngreen.com.Main;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;

public class Bank {


	public static void openPage(Player p, int pageNumb) {
		Inventory inv = Bukkit.createInventory(p.getPlayer(), 54, p.getDisplayName()+" Bank, Page "+pageNumb);
		String page = Main.bankconfig.getString(p.getDisplayName()+"."+pageNumb);
		String[] parts = page.split(",");
		for(int a=0;a<9;a++){
			ItemStack tab = new ItemStack(Material.WOOL);
			ItemMeta im = tab.getItemMeta();
			im.setDisplayName(ChatColor.LIGHT_PURPLE+"Page: "+(a+1));
			tab.setItemMeta(im);
			inv.setItem(a, tab);
		}
		int count = 8;
		int i = 0;
		if(parts.toString()!=""){
			for(String s:parts){
				count++;
				if(!s.equals("")){
					int itemAmount = Integer.parseInt(parts[i].split(":")[1]);
					ItemStack item = Items.getByName(parts[i].split(":")[0]).generateItem();
					item.setAmount(itemAmount);
					inv.setItem(count, item);
				}
				i++;
			}
		}
		p.openInventory(inv);
	}

	public static void InventoryCloseHandler(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		int page = Integer.parseInt(e.getInventory().getTitle().substring(e.getInventory().getTitle().length()-1, e.getInventory().getTitle().length()));
		String data = "";
		for(int i=9;i<54;i++){
			if(e.getInventory().getItem(i)!=null){
				if(e.getInventory().getItem(i).hasItemMeta()&&e.getInventory().getItem(i).getItemMeta().hasDisplayName()){
					String name = ChatColor.stripColor(e.getInventory().getItem(i).getItemMeta().getDisplayName());
					if(data.equals("")){
						data = name+":"+e.getInventory().getItem(i).getAmount();
					}else{
						data = data+","+name+":"+e.getInventory().getItem(i).getAmount();
					}
				}
			}
		}
		Main.bankconfig.set(p.getDisplayName()+"."+page,data);
	    Main.saveBankConfig();
	}
	
}
