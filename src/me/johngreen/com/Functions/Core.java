package me.johngreen.com.Functions;

import java.util.ArrayList;
import java.util.List;

import me.johngreen.com.Main;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Core {

	@SuppressWarnings("deprecation")
	public static void refreshScoreBoard(Player p){
		System.out.println("Refreshing scoreboard for " + p.getName());
	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    Scoreboard board = manager.getNewScoreboard();

	    Objective stats = board.registerNewObjective("Stats", "dummy");
	    stats.setDisplaySlot(DisplaySlot.SIDEBAR);
	    stats.setDisplayName("Stats");
	    
	    Score Attack = stats.getScore(Bukkit.getOfflinePlayer("Attack:"));
	    Score Defence = stats.getScore(Bukkit.getOfflinePlayer("Defence:"));
	    Score Health = stats.getScore(Bukkit.getOfflinePlayer("Health:"));
	    Score Range = stats.getScore(Bukkit.getOfflinePlayer("Range:"));
	    Score Magic = stats.getScore(Bukkit.getOfflinePlayer("Magic:"));
	    Score Mining = stats.getScore(Bukkit.getOfflinePlayer("Mining:"));
	    Score Smithing = stats.getScore(Bukkit.getOfflinePlayer("Smithing:"));
	    Score Woodcutting = stats.getScore(Bukkit.getOfflinePlayer("Woodcutting:"));
	    Score Runecrafting = stats.getScore(Bukkit.getOfflinePlayer("Runecrafting:"));
	    Score Firemaking = stats.getScore(Bukkit.getOfflinePlayer("Firemaking:"));
	    Score Prayer = stats.getScore(Bukkit.getOfflinePlayer("Prayer:"));
	    Score Fishing = stats.getScore(Bukkit.getOfflinePlayer("Fishing:"));
	    
	    Score Cooking = stats.getScore(Bukkit.getOfflinePlayer("Cooking:"));
	    Score Crafting = stats.getScore(Bukkit.getOfflinePlayer("Crafting:"));
	    Score Dungeoneering = stats.getScore(Bukkit.getOfflinePlayer("Dungeoneering:"));
	    Score Strength = stats.getScore(Bukkit.getOfflinePlayer("Strength:"));
	    
	    
	    String l = Main.levelconfig.getString("Levels." + p.getName());
	    String[] parts = l.split(",");
	    String[] xp1 = parts[1].split(":");
	    String[] xp2 = parts[2].split(":");
	    String[] xp3 = parts[3].split(":");
	    String[] xp4 = parts[4].split(":");
	    String[] xp5 = parts[5].split(":");
	    String[] xp6 = parts[6].split(":");
	    String[] xp7 = parts[7].split(":");
	    String[] xp8 = parts[8].split(":");
	    String[] xp9 = parts[9].split(":");
	    String[] xp10 = parts[10].split(":");
	    String[] xp11 = parts[11].split(":");
	    String[] xp12 = parts[12].split(":");
	    String[] xp13 = parts[13].split(":");
	    String[] xp14 = parts[14].split(":");
	    String[] xp15 = parts[15].split(":");
	    String[] xp16 = parts[16].split(":");
	    Attack.setScore(Integer.parseInt(xp1[0]));
	    Defence.setScore(Integer.parseInt(xp2[0]));
	    Health.setScore(Integer.parseInt(xp3[0]));
	    Range.setScore(Integer.parseInt(xp4[0]));
	    Magic.setScore(Integer.parseInt(xp5[0]));
	    Mining.setScore(Integer.parseInt(xp6[0]));
	    Smithing.setScore(Integer.parseInt(xp7[0]));
	    Woodcutting.setScore(Integer.parseInt(xp8[0]));
	    Runecrafting.setScore(Integer.parseInt(xp9[0]));
	    Firemaking.setScore(Integer.parseInt(xp10[0]));
	    Prayer.setScore(Integer.parseInt(xp11[0]));
	    Fishing.setScore(Integer.parseInt(xp12[0]));
	    
	    Cooking.setScore(Integer.parseInt(xp13[0]));
	    //Crafting.setScore(Integer.parseInt(xp14[0]));
	    Dungeoneering.setScore(Integer.parseInt(xp15[0]));
	    Strength.setScore(Integer.parseInt(xp16[0]));
	    p.setScoreboard(board);
	}
	
	public static void reloadToolbar(Player p){
		List<String> Lore = new ArrayList<String>();
		Lore.add(ChatColor.GREEN+"Click Hear For More Information!");
		Lore.add(ChatColor.BLACK+"NoDrop");
		p.getInventory().setItem(4, Items.generateItem(Lore, ChatColor.LIGHT_PURPLE+"QuestLog", Material.COMPASS));
		p.getInventory().setItem(5, Items.generateItem(Lore, ChatColor.LIGHT_PURPLE+"Levels", Material.EXP_BOTTLE));
		p.getInventory().setItem(6, Items.generateItem(Lore, ChatColor.LIGHT_PURPLE+"SpellBook", Material.ENCHANTED_BOOK));
		p.getInventory().setItem(7, Items.generateItem(Lore, ChatColor.LIGHT_PURPLE+"Prayer", Material.NETHER_STAR));
		p.getInventory().setItem(8, Items.generateItem(Lore, ChatColor.LIGHT_PURPLE+"Friends", Material.DRAGON_EGG));
		
	}
	public static void setupPlayer(Player p){
	    if (Main.levelconfig.getString("Levels." + p.getName()) == null)
	    {
	      Main.levelconfig.set("Levels." + p.getName(), "4,1:0,1:0,10:1154,1:0,1:0,1:0,1:0,1:0,1:0,1:0,1:0,1:0,1:0,1:0,1:0,1:0");
	      Main.bankconfig.set(p.getDisplayName()+".1","Bronze Hatchet:1,Bronze Pickaxe:1,Gold Coin:25");
	      Main.bankconfig.set(p.getDisplayName()+".2","");
	      Main.bankconfig.set(p.getDisplayName()+".3","");
	      Main.bankconfig.set(p.getDisplayName()+".4","");
	      Main.bankconfig.set(p.getDisplayName()+".5","");
	      Main.bankconfig.set(p.getDisplayName()+".6","");
	      Main.bankconfig.set(p.getDisplayName()+".7","");
	      Main.bankconfig.set(p.getDisplayName()+".8","");
	      Main.bankconfig.set(p.getDisplayName()+".9","");
	      Main.saveBankConfig();
	      Main.saveLevelConfig();
	    	Runnable r = new NewPlayerPathFinder(p);
			new Thread(r).start();
	    }
	    String l = Main.levelconfig.getString("Levels." + p.getName());
	    String[] parts = l.split(",");
	    String[] health = parts[3].split(":");
	    refreshScoreBoard(p);
		p.setMaxHealth(Integer.parseInt(health[0]));
		System.out.println(p.getAddress().getAddress().toString().replaceFirst("/", "").replace(".", "-"));
		if(Main.playerconfig.getString("Teleports."+p.getDisplayName())==null){
			Main.playerconfig.set("Teleports."+p.getDisplayName(), "Lumbridge");
		}
		if(Main.playerconfig.getString(p.getAddress().getAddress().toString().replaceFirst("/", "").replace(".", "-"))==null){
			Main.playerconfig.set(p.getAddress().getAddress().toString().replaceFirst("/", "").replace(".", "-"), p.getDisplayName());
			Main.savePlayerConfig();
		}
	}
	public static void refreshHealth(Player p){
	    String l = Main.levelconfig.getString("Levels." + p.getName());
	    String[] parts = l.split(",");
	    String[] health = parts[3].split(":");
		p.setMaxHealth(Integer.parseInt(health[0]));
	}
}
