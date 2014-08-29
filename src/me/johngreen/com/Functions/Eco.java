package me.johngreen.com.Functions;

import me.johngreen.com.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Eco {
	
	public static void addFunds(Player p, int amount){
		int c = (int) Main.economy.getPlayerMoneyDouble(p.getDisplayName());
	    c += amount;
	    Main.economy.setPlayerMoney(p.getDisplayName(), (double)c, true);
	    p.sendMessage(ChatColor.GOLD+""+amount + " gold has been added to your money pouch");
	}
	
	public static void removeFunds(Player p, int amount){
	    int c = (int) Main.economy.getPlayerMoneyDouble(p.getDisplayName());
	    c -= amount;
	    Main.economy.setPlayerMoney(p.getDisplayName(), (double)c, true);
	    p.sendMessage(ChatColor.GOLD+""+amount+ " gold has been withdrawn from your money pouch");
	}
	public static Boolean hasEnoughMoney(int req, Player p){
		int c = (int) Main.economy.getPlayerMoneyDouble(p.getDisplayName());
		if (req <= c) {
			return Boolean.valueOf(true);
		}
		return Boolean.valueOf(false);
	}
}
