package me.johngreen.com.Functions;

import me.johngreen.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpellBook {

	
	public static void generateGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 54,"Spell Book");
		String l = Main.playerconfig.getString("Teleports."+p.getDisplayName());
	    String[] parts = l.split(",");
	    for(String s:parts){
	    	ItemStack item = new ItemStack(Material.ENDER_PEARL);
	    	ItemMeta meta = item.getItemMeta();
	    	meta.setDisplayName(ChatColor.GREEN+s);
	    	item.setItemMeta(meta);
	    	inv.addItem(item);
	    }
		p.openInventory(inv);
	}
	
	
	
	public static void addTeleport(Player p, String name){
		String l = Main.playerconfig.getString("Teleports."+p.getDisplayName());
		switch(name.toLowerCase()){
		case "lumbridge":
			p.sendMessage("You already have this teleoprt unlocked");
			break;
		case "varrock":
			if(l.contains("Varrock")){
				p.sendMessage("You already have this teleoprt unlocked");
			}else{
				l = l+",Varrock";
				Main.playerconfig.set("Teleports."+p.getDisplayName(), l);
				p.sendMessage("This teleport has been added to your spell book!");
			}
			break;
		case "al kharid":
			if(l.contains("Al-Kharid")){
				p.sendMessage("You already have this teleoprt unlocked");
			}else{
				l = l+",Al-Kharid";
				Main.playerconfig.set("Teleports."+p.getDisplayName(), l);
				p.sendMessage("This teleport has been added to your spell book!");
			}
			break;
		case "portsarim":
			if(l.contains("PortSarim")){
				p.sendMessage("You already have this teleoprt unlocked");
			}else{
				l = l+",PortSarim";
				Main.playerconfig.set("Teleports."+p.getDisplayName(), l);
				p.sendMessage("This teleport has been added to your spell book!");
			}
			break;
		case "draynor":
			if(l.contains("Draynor")){
				p.sendMessage("You already have this teleoprt unlocked");
			}else{
				l = l+",Draynor";
				Main.playerconfig.set("Teleports."+p.getDisplayName(), l);
				p.sendMessage("This teleport has been added to your spell book!");
			}
			break;
		case "karamja":
			if(l.contains("Karamja")){
				p.sendMessage("You already have this teleoprt unlocked");
			}else{
				l = l+",Karamja";
				Main.playerconfig.set("Teleports."+p.getDisplayName(), l);
				p.sendMessage("This teleport has been added to your spell book!");
			}
			break;
		}
		Main.savePlayerConfig();
	}
}
