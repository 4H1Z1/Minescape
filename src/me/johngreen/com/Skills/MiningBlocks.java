package me.johngreen.com.Skills;

import java.util.Random;

import me.johngreen.com.items.Items;

import org.bukkit.Material;

public enum MiningBlocks {
	Copper(8,12,1,18,Items.Copper_Ore),
	Tin(8,12,1,18,Items.Tin_Ore),
	Iron(9,12,15,35,Items.Iron_Ore),
	Silver(13,15,20,40,Items.Silver_Ore),
	Coal(9,12,30,50,Items.Coal),
	Gold(13,15,40,65,Items.Gold_Ore),
	Mithril(9,12,55,80,Items.Mithrill_Ore),
	Adamantite(13,15,70,95,Items.Adamantite_Ore),
	Runite(13,15,85,125,Items.Runite_Ore);
	
	MiningBlocks(int minSecconds,int maxSecconds,int level,int xp,Items ore){
		this.minSecconds = minSecconds;
		this.maxSecconds = maxSecconds;
		this.level = level;
		this.xp = xp;
		this.ore = ore;
	}
	private int minSecconds;
	private int maxSecconds;
	private int level;
	private int xp;
	private Items ore;
	
	public int getXp(){
		return xp;
	}
	public Items getOre(){
		return ore;
	}
	public int getLevel(){
		return level;
	}
	public int getMaxSecconds(){
		return maxSecconds;
	}
	public int getMinSecconds(){
		return minSecconds;
	}
	public int getTimeToChop(){
		Random r = new Random();
		int i1 = r.nextInt(maxSecconds - minSecconds) + minSecconds;
		return i1;
	}
	public static MiningBlocks getByMaterialName(String name){
		switch(name){
		case "LAPIS_ORE":
			return MiningBlocks.Copper;
		case "QUARTZ_ORE":
			return MiningBlocks.Tin;
		case "IRON_ORE":
			return MiningBlocks.Iron;
		case "IRON_BLOCK":
			return MiningBlocks.Silver;
		case "COAL_ORE":
			return MiningBlocks.Coal;
		case "GOLD_ORE":
			return MiningBlocks.Gold;
		case "EMERALD_ORE":
			return MiningBlocks.Mithril;
		case "EMERALD_BLOCK":
			return MiningBlocks.Adamantite;
		case "DIAMOND_ORE":
			return MiningBlocks.Runite;
		}
		return null;
	}
}
