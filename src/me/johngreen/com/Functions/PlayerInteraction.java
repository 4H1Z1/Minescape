package me.johngreen.com.Functions;

import java.util.HashMap;

import me.johngreen.com.Main;
import net.minecraft.server.v1_7_R3.Material;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;

public class PlayerInteraction {

	public static HashMap<Player,Player> figting = new HashMap<Player,Player>();
	public static HashMap<Player,Player> Chanlenged = new HashMap<Player,Player>();
	
	public static HashMap<Player,Player> offerdTrade = new HashMap<Player,Player>();
	public static HashMap<Player,Player> trading = new HashMap<Player,Player>();
	
	public static HashMap<Player,Player> Clicked = new HashMap<Player,Player>();
	
	public static HashMap<Player,Player> ChatClicked = new HashMap<Player,Player>();
	
	
	public static void vewFriends(Player p){
		Inventory inv = Bukkit.createInventory(p, 54,"Friends");
		String  l = Main.playerconfig.getString(p.getDisplayName());
		if(l!=null){
			String[] parts = l.split(",");
			int count = 0;
			for(String s:parts){
				if(s!=null){
					ItemStack i = new ItemStack(org.bukkit.Material.SKULL_ITEM, 1, (short) 3);
						SkullMeta meta = (SkullMeta) i.getItemMeta();
						meta.setDisplayName(ChatColor.GREEN+s);
			            meta.setOwner(s);
			            i.setItemMeta(meta);
		            
		            inv.setItem(count, i);
					count++;
					boolean online = false;
					for(World w:Bukkit.getWorlds()){
						for(Player p2:w.getPlayers()){
							if(p2.getDisplayName().equals(s)){
								online = true;
								break;
							}
						}
					}
					
					if(online){
						ItemStack wool = new ItemStack(org.bukkit.Material.WOOL,1, DyeColor.GREEN.getData());
						ItemMeta painmeta = wool.getItemMeta();
						painmeta.setDisplayName(ChatColor.GREEN+"Online!");
						
						wool.setItemMeta(painmeta);
						inv.setItem(count, wool);
					}else{
						ItemStack pain = new ItemStack(org.bukkit.Material.WOOL,1, DyeColor.RED.getData());
						ItemMeta painmeta = pain.getItemMeta();
						painmeta.setDisplayName(ChatColor.RED+"Offline");
						pain.setItemMeta(painmeta);
						inv.setItem(count, pain);
					}
					count++;
					if(count==4||count==13||count==22||count==31||count==40||count==49){
						count++;
					}
				}
			}
		}
		p.openInventory(inv);
	}
	
}
