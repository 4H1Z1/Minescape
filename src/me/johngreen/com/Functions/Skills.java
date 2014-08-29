package me.johngreen.com.Functions;

import java.util.Random;

import me.johngreen.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public enum Skills {
	CombatLevel(0,"Combat Level"),
	Attack(1,"Attack"),
	Defence(2,"Defence"),
	Health(3,"Health"),
	Range(4,"Range"),
	Magic(5,"Magic"),
	Mining(6,"Mining"),
	Smithing(7,"Smithing"),
	Woodcutting(8,"Woodcutting"),
	Runecrafting(9,"Runecrafting"),
	Firemaking(10,"Firemaking"),
	Prayer(11,"Prayer"),
	Fishing(12,"Fishing"),
	
	Cooking(13,"Cooking"),
	Crafting(14,"Crafting"),
	Dungeoneering(15,"Dungeoneering"),
	Strength(16,"Strength");
	
	private int count;
	private String name;
	Skills(int count,String name) {
		this.count = count;
		this.name = name;
	}
	
	public void levelUp(Player p){
		String l = Main.levelconfig.getString("Levels." + p.getName());
		firwork(p);
	    String[] parts = l.split(",");
	    String allparts = "";
	    switch(count){
	    	case 1:
	    		allparts = damageLevelCalc(p, Attack)+","+(Integer.parseInt(parts[1].split(":")[0])+1)+":"+parts[1].split(":")[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 2:
	    		allparts = parts[0]+","+parts[1]+","+(Integer.parseInt(parts[2].split(":")[0])+1)+":"+parts[2].split(":")[1]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 3:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+(Integer.parseInt(parts[3].split(":")[0])+1)+":"+parts[3].split(":")[1]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		Core.refreshHealth(p);
	    		break;
	    	case 4:
	    		allparts = damageLevelCalc(p, Range)+","+parts[1]+","+parts[2]+","+parts[3]+","+(Integer.parseInt(parts[4].split(":")[0])+1)+":"+parts[4].split(":")[1]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 5:
	    		allparts = damageLevelCalc(p, Magic)+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+(Integer.parseInt(parts[5].split(":")[0])+1)+":"+parts[5].split(":")[1]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 6:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+(Integer.parseInt(parts[6].split(":")[0])+1)+":"+parts[6].split(":")[1]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 7:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+(Integer.parseInt(parts[7].split(":")[0])+1)+":"+parts[7].split(":")[1]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 8:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+(Integer.parseInt(parts[8].split(":")[0])+1)+":"+parts[8].split(":")[1]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 9:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+(Integer.parseInt(parts[9].split(":")[0])+1)+":"+parts[9].split(":")[1]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 10:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+(Integer.parseInt(parts[10].split(":")[0])+1)+":"+parts[10].split(":")[1]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 11:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+(Integer.parseInt(parts[11].split(":")[0])+1)+":"+parts[11].split(":")[1]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 12:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+(Integer.parseInt(parts[12].split(":")[0])+1)+":"+parts[12].split(":")[1]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    		
	    	case 13:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+(Integer.parseInt(parts[13].split(":")[0])+1)+":"+parts[13].split(":")[1]+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 14:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+(Integer.parseInt(parts[14].split(":")[0])+1)+":"+parts[14].split(":")[1]+","+parts[15]+","+parts[16];
	    		break;
	    	case 15:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+(Integer.parseInt(parts[15].split(":")[0])+1)+":"+parts[15].split(":")[1]+","+parts[16];
	    		break;
	    	case 16:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+(Integer.parseInt(parts[16].split(":")[0])+1)+":"+parts[16].split(":")[1];
	    		break;
	    }
	    Main.levelconfig.set("Levels."+p.getName(), null);
	    Main.levelconfig.set("Levels."+p.getName(), allparts);
	    Main.saveLevelConfig();
	    Core.refreshScoreBoard(p);
	    p.sendMessage(ChatColor.GREEN+"Congratulations you are now level "+getLevel(p)+" in "+name+"!");
	}
	public void setXP(int xp,Player p){
		String l = Main.levelconfig.getString("Levels." + p.getName());
	    String[] parts = l.split(",");
	    String allparts = null;
	    switch(count){
	    	case 1:
	    		allparts = parts[0]+","+parts[1].split(":")[0]+":"+(Integer.parseInt(parts[1].split(":")[1])+xp)+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 2:
	    		allparts = parts[0]+","+parts[1]+","+parts[2].split(":")[0]+":"+(Integer.parseInt(parts[2].split(":")[1])+xp)+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 3:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3].split(":")[0]+":"+(Integer.parseInt(parts[3].split(":")[1])+xp)+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 4:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4].split(":")[0]+":"+(Integer.parseInt(parts[4].split(":")[1])+xp)+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 5:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5].split(":")[0]+":"+(Integer.parseInt(parts[5].split(":")[1])+xp)+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 6:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6].split(":")[0]+":"+(Integer.parseInt(parts[6].split(":")[1])+xp)+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 7:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7].split(":")[0]+":"+(Integer.parseInt(parts[7].split(":")[1])+xp)+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 8:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8].split(":")[0]+":"+(Integer.parseInt(parts[8].split(":")[1])+xp)+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 9:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9].split(":")[0]+":"+(Integer.parseInt(parts[9].split(":")[1])+xp)+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 10:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10].split(":")[0]+":"+(Integer.parseInt(parts[10].split(":")[1])+xp)+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 11:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11].split(":")[0]+":"+(Integer.parseInt(parts[11].split(":")[1])+xp)+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    	case 12:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12].split(":")[0]+":"+(Integer.parseInt(parts[12].split(":")[1])+xp)+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16];;
	    		break;
	    		
	    	case 13:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13].split(":")[0]+":"+(Integer.parseInt(parts[13].split(":")[1])+xp)+","+parts[14]+","+parts[15]+","+parts[16];
	    		break;
	    	case 14:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14].split(":")[0]+":"+(Integer.parseInt(parts[14].split(":")[1])+xp)+","+parts[15]+","+parts[16];
	    		break;
	    	case 15:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15].split(":")[0]+":"+(Integer.parseInt(parts[15].split(":")[1])+xp)+","+parts[16];
	    		break;
	    	case 16:
	    		allparts = parts[0]+","+parts[1]+","+parts[2]+","+parts[3]+","+parts[4]+","+parts[5]+","+parts[6]+","+parts[7]+","+parts[8]+","+parts[9]+","+parts[10]+","+parts[11]+","+parts[12]+","+parts[13]+","+parts[14]+","+parts[15]+","+parts[16].split(":")[0]+":"+(Integer.parseInt(parts[16].split(":")[1])+xp);
	    		break;
	    }
	    Main.levelconfig.set("Levels."+p.getName(), null);
	    Main.levelconfig.set("Levels."+p.getName(), allparts);
	    Main.saveLevelConfig();
	    if(checkForLevelUp(getXP(p),getLevel(p))){
	    	levelUp(p);
	    }else{
	    	p.sendMessage(ChatColor.GREEN+"Your "+ChatColor.GRAY+name+ChatColor.GREEN+" experience has increased by "+ChatColor.GRAY+xp+ChatColor.GREEN+" Exp! "+ChatColor.GRAY+"("+getXP(p)+"/"+getToNextLevel(p)+")");
	    }
	}
	private int getToNextLevel(Player p) {
		int lvl = getLevel(p);
		 	if ((lvl == 1)) {
		      return 83;
		    }
		    if ((lvl == 2)) {
		      return 174;
		    }
		    if ((lvl == 3)) {
		      return 276;
		    }
		    if ((lvl == 4)) {
		      return 388;
		    }
		    if ((lvl == 5)) {
		      return 512;
		    }
		    if ((lvl == 6)) {
		      return 650;
		    }
		    if ((lvl == 7)) {
		      return 801;
		    }
		    if ((lvl == 8)) {
		      return 969;
		    }
		    if ((lvl == 9)) {
		      return 1154;
		    }
		    if ((lvl == 10)) {
		      return 1254;
		    }
		    if ((lvl == 11)) {
		      return 1358;
		    }
		    if ((lvl == 12)) {
		      return 1584;
		    }
		    if ((lvl == 13)) {
		      return 1833;
		    }
		    if ((lvl == 14)) {
		      return 2107;
		    }
		    if ((lvl == 15)) {
		      return 2411;
		    }
		    if ((lvl == 16)) {
		      return 2746;
		    }
		    if ((lvl == 17)) {
		      return 3115;
		    }
		    if ((lvl == 18)) {
		      return 3523;
		    }
		    if ((lvl == 19)) {
		      return 3973;
		    }
		    if ((lvl == 20)) {
		      return 4470;
		    }
		    if ((lvl == 21)) {
		      return 5018;
		    }
		    if ((lvl == 22)) {
		      return 5624;
		    }
		    if ((lvl == 23)) {
		      return 6291;
		    }
		    if ((lvl == 24)) {
		      return 7028;
		    }
		    if ((lvl == 25)) {
		      return 7842;
		    }
		    if ((lvl == 26)) {
		      return 8740;
		    }
		    if ((lvl == 27)) {
		      return 9730;
		    }
		    if ((lvl == 28)) {
		      return 10824;
		    }
		    if ((lvl == 29)) {
		      return 12031;
		    }
		    if ((lvl == 30)) {
		      return 13363;
		    }
		    if ((lvl == 31)) {
		      return 14833;
		    }
		    if ((lvl == 32)) {
		      return 16456;
		    }
		    if ((lvl == 33)) {
		      return 18247;
		    }
		    if ((lvl == 34)) {
		      return 20224;
		    }
		    if ((lvl == 35)) {
		      return 22406;
		    }
		    if ((lvl == 36)) {
		      return 24815;
		    }
		    if ((lvl == 37)) {
		      return 27473;
		    }
		    if ((lvl == 38)) {
		      return 30408;
		    }
		    if ((lvl == 39)) {
		      return 33648;
		    }
		    if ((lvl == 40)) {
		      return 37224;
		    }
		    if ((lvl == 41)) {
		      return 41171;
		    }
		    if ((lvl == 42)) {
		      return 45529;
		    }
		    if ((lvl == 43)) {
		      return 50339;
		    }
		    if ((lvl == 44)) {
		      return 55649;
		    }
		    if ((lvl == 45)) {
		      return 61512;
		    }
		    if ((lvl == 46)) {
		      return 67983;
		    }
		    if ((lvl == 47)) {
		      return 75127;
		    }
		    if ((lvl == 48)) {
		      return 83014;
		    }
		    if ((lvl == 49)) {
		      return 91721;
		    }
		    if ((lvl == 50)) {
		      return 101333;
		    }
		    if ((lvl == 51)) {
		      return 111945;
		    }
		    if ((lvl == 52)) {
		      return 123660;
		    }
		    if ((lvl == 53)) {
		      return 136594;
		    }
		    if ((lvl == 54)) {
		      return 150872;
		    }
		    if ((lvl == 55)) {
		      return 166636;
		    }
		    if ((lvl == 56)) {
		      return 184040;
		    }
		    if ((lvl == 57)) {
		      return 203254;
		    }
		    if ((lvl == 58)) {
		      return 224466;
		    }
		    if ((lvl == 59)) {
		      return 247886;
		    }
		    if ((lvl == 60)) {
		      return 273742;
		    }
		    if ((lvl == 61)) {
		      return 302288;
		    }
		    if ((lvl == 62)) {
		      return 333804;
		    }
		    if ((lvl == 63)) {
		      return 368599;
		    }
		    if ((lvl == 64)) {
		      return 407015;
		    }
		    if ((lvl == 65)) {
		      return 449428;
		    }
		    if ((lvl == 66)) {
		      return 496254;
		    }
		    if ((lvl == 67)) {
		      return 547953;
		    }
		    if ((lvl == 68)) {
		      return 605032;
		    }
		    if ((lvl == 69)) {
		      return 668051;
		    }
		    if ((lvl == 70)) {
		      return 737627;
		    }
		    if ((lvl == 71)) {
		      return 814445;
		    }
		    if ((lvl == 72)) {
		      return 899257;
		    }
		    if ((lvl == 73)) {
		      return 992895;
		    }
		    if ((lvl == 74)) {
		      return 1096278;
		    }
		    if ((lvl == 75)) {
		      return 1210421;
		    }
		    if ((lvl == 76)) {
		      return 1336443;
		    }
		    if ((lvl == 77)) {
		      return 1475581;
		    }
		    if ((lvl == 78)) {
		      return 1629200;
		    }
		    if ((lvl == 79)) {
		      return 1798808;
		    }
		    if ((lvl == 80)) {
		      return 1986068;
		    }
		    if ((lvl == 81)) {
		      return 2192818;
		    }
		    if ((lvl == 82)) {
		      return 2421087;
		    }
		    if ((lvl == 83)) {
		      return 2673114;
		    }
		    if ((lvl == 84)) {
		      return 2951373;
		    }
		    if ((lvl == 85)) {
		      return 3258594;
		    }
		    if ((lvl == 86)) {
		      return 3597792;
		    }
		    if ((lvl == 87)) {
		      return 3972294;
		    }
		    if ((lvl == 88)) {
		      return 4385776;
		    }
		    if ((lvl == 89)) {
		      return 4842295;
		    }
		    if ((lvl == 90)) {
		      return 5346332;
		    }
		    if ((lvl == 91)) {
		      return 5902831;
		    }
		    if ((lvl == 92)) {
		      return 6517253;
		    }
		    if ((lvl == 93)) {
		      return 7195629;
		    }
		    if ((lvl == 94)) {
		      return 7944614;
		    }
		    if ((lvl == 95)) {
		      return 8771558;
		    }
		    if ((lvl == 96)) {
		      return 9684577;
		    }
		    if ((lvl == 97)) {
		      return 10692629;
		    }
		    if ((lvl == 98)) {
		      return 11805606;
		    }
		return 0;
	}

	public int getLevel(Player p){
		String l = Main.levelconfig.getString("Levels." + p.getName());
	    String[] parts = l.split(",");
	    String[] xp = parts[count].split(":");
		return Integer.parseInt(xp[0]);
	}
	public int getXP(Player p){
		String l = Main.levelconfig.getString("Levels." + p.getName());
	    String[] parts = l.split(",");
	    String[] xp1 = parts[count].split(":");
		return Integer.parseInt(xp1[1]);
	}
	private boolean checkForLevelUp(int newxp, int lvl)
	  {
	    if ((lvl == 1) && (newxp > 83)) {
	      return true;
	    }
	    if ((lvl == 2) && (newxp > 174)) {
	      return true;
	    }
	    if ((lvl == 3) && (newxp > 276)) {
	      return true;
	    }
	    if ((lvl == 4) && (newxp > 388)) {
	      return true;
	    }
	    if ((lvl == 5) && (newxp > 512)) {
	      return true;
	    }
	    if ((lvl == 6) && (newxp > 650)) {
	      return true;
	    }
	    if ((lvl == 7) && (newxp > 801)) {
	      return true;
	    }
	    if ((lvl == 8) && (newxp > 969)) {
	      return true;
	    }
	    if ((lvl == 9) && (newxp > 1154)) {
	      return true;
	    }
	    if ((lvl == 10) && (newxp > 1254)) {
	      return true;
	    }
	    if ((lvl == 11) && (newxp > 1358)) {
	      return true;
	    }
	    if ((lvl == 12) && (newxp > 1584)) {
	      return true;
	    }
	    if ((lvl == 13) && (newxp > 1833)) {
	      return true;
	    }
	    if ((lvl == 14) && (newxp > 2107)) {
	      return true;
	    }
	    if ((lvl == 15) && (newxp > 2411)) {
	      return true;
	    }
	    if ((lvl == 16) && (newxp > 2746)) {
	      return true;
	    }
	    if ((lvl == 17) && (newxp > 3115)) {
	      return true;
	    }
	    if ((lvl == 18) && (newxp > 3523)) {
	      return true;
	    }
	    if ((lvl == 19) && (newxp > 3973)) {
	      return true;
	    }
	    if ((lvl == 20) && (newxp > 4470)) {
	      return true;
	    }
	    if ((lvl == 21) && (newxp > 5018)) {
	      return true;
	    }
	    if ((lvl == 22) && (newxp > 5624)) {
	      return true;
	    }
	    if ((lvl == 23) && (newxp > 6291)) {
	      return true;
	    }
	    if ((lvl == 24) && (newxp > 7028)) {
	      return true;
	    }
	    if ((lvl == 25) && (newxp > 7842)) {
	      return true;
	    }
	    if ((lvl == 26) && (newxp > 8740)) {
	      return true;
	    }
	    if ((lvl == 27) && (newxp > 9730)) {
	      return true;
	    }
	    if ((lvl == 28) && (newxp > 10824)) {
	      return true;
	    }
	    if ((lvl == 29) && (newxp > 12031)) {
	      return true;
	    }
	    if ((lvl == 30) && (newxp > 13363)) {
	      return true;
	    }
	    if ((lvl == 31) && (newxp > 14833)) {
	      return true;
	    }
	    if ((lvl == 32) && (newxp > 16456)) {
	      return true;
	    }
	    if ((lvl == 33) && (newxp > 18247)) {
	      return true;
	    }
	    if ((lvl == 34) && (newxp > 20224)) {
	      return true;
	    }
	    if ((lvl == 35) && (newxp > 22406)) {
	      return true;
	    }
	    if ((lvl == 36) && (newxp > 24815)) {
	      return true;
	    }
	    if ((lvl == 37) && (newxp > 27473)) {
	      return true;
	    }
	    if ((lvl == 38) && (newxp > 30408)) {
	      return true;
	    }
	    if ((lvl == 39) && (newxp > 33648)) {
	      return true;
	    }
	    if ((lvl == 40) && (newxp > 37224)) {
	      return true;
	    }
	    if ((lvl == 41) && (newxp > 41171)) {
	      return true;
	    }
	    if ((lvl == 42) && (newxp > 45529)) {
	      return true;
	    }
	    if ((lvl == 43) && (newxp > 50339)) {
	      return true;
	    }
	    if ((lvl == 44) && (newxp > 55649)) {
	      return true;
	    }
	    if ((lvl == 45) && (newxp > 61512)) {
	      return true;
	    }
	    if ((lvl == 46) && (newxp > 67983)) {
	      return true;
	    }
	    if ((lvl == 47) && (newxp > 75127)) {
	      return true;
	    }
	    if ((lvl == 48) && (newxp > 83014)) {
	      return true;
	    }
	    if ((lvl == 49) && (newxp > 91721)) {
	      return true;
	    }
	    if ((lvl == 50) && (newxp > 101333)) {
	      return true;
	    }
	    if ((lvl == 51) && (newxp > 111945)) {
	      return true;
	    }
	    if ((lvl == 52) && (newxp > 123660)) {
	      return true;
	    }
	    if ((lvl == 53) && (newxp > 136594)) {
	      return true;
	    }
	    if ((lvl == 54) && (newxp > 150872)) {
	      return true;
	    }
	    if ((lvl == 55) && (newxp > 166636)) {
	      return true;
	    }
	    if ((lvl == 56) && (newxp > 184040)) {
	      return true;
	    }
	    if ((lvl == 57) && (newxp > 203254)) {
	      return true;
	    }
	    if ((lvl == 58) && (newxp > 224466)) {
	      return true;
	    }
	    if ((lvl == 59) && (newxp > 247886)) {
	      return true;
	    }
	    if ((lvl == 60) && (newxp > 273742)) {
	      return true;
	    }
	    if ((lvl == 61) && (newxp > 302288)) {
	      return true;
	    }
	    if ((lvl == 62) && (newxp > 333804)) {
	      return true;
	    }
	    if ((lvl == 63) && (newxp > 368599)) {
	      return true;
	    }
	    if ((lvl == 64) && (newxp > 407015)) {
	      return true;
	    }
	    if ((lvl == 65) && (newxp > 449428)) {
	      return true;
	    }
	    if ((lvl == 66) && (newxp > 496254)) {
	      return true;
	    }
	    if ((lvl == 67) && (newxp > 547953)) {
	      return true;
	    }
	    if ((lvl == 68) && (newxp > 605032)) {
	      return true;
	    }
	    if ((lvl == 69) && (newxp > 668051)) {
	      return true;
	    }
	    if ((lvl == 70) && (newxp > 737627)) {
	      return true;
	    }
	    if ((lvl == 71) && (newxp > 814445)) {
	      return true;
	    }
	    if ((lvl == 72) && (newxp > 899257)) {
	      return true;
	    }
	    if ((lvl == 73) && (newxp > 992895)) {
	      return true;
	    }
	    if ((lvl == 74) && (newxp > 1096278)) {
	      return true;
	    }
	    if ((lvl == 75) && (newxp > 1210421)) {
	      return true;
	    }
	    if ((lvl == 76) && (newxp > 1336443)) {
	      return true;
	    }
	    if ((lvl == 77) && (newxp > 1475581)) {
	      return true;
	    }
	    if ((lvl == 78) && (newxp > 1629200)) {
	      return true;
	    }
	    if ((lvl == 79) && (newxp > 1798808)) {
	      return true;
	    }
	    if ((lvl == 80) && (newxp > 1986068)) {
	      return true;
	    }
	    if ((lvl == 81) && (newxp > 2192818)) {
	      return true;
	    }
	    if ((lvl == 82) && (newxp > 2421087)) {
	      return true;
	    }
	    if ((lvl == 83) && (newxp > 2673114)) {
	      return true;
	    }
	    if ((lvl == 84) && (newxp > 2951373)) {
	      return true;
	    }
	    if ((lvl == 85) && (newxp > 3258594)) {
	      return true;
	    }
	    if ((lvl == 86) && (newxp > 3597792)) {
	      return true;
	    }
	    if ((lvl == 87) && (newxp > 3972294)) {
	      return true;
	    }
	    if ((lvl == 88) && (newxp > 4385776)) {
	      return true;
	    }
	    if ((lvl == 89) && (newxp > 4842295)) {
	      return true;
	    }
	    if ((lvl == 90) && (newxp > 5346332)) {
	      return true;
	    }
	    if ((lvl == 91) && (newxp > 5902831)) {
	      return true;
	    }
	    if ((lvl == 92) && (newxp > 6517253)) {
	      return true;
	    }
	    if ((lvl == 93) && (newxp > 7195629)) {
	      return true;
	    }
	    if ((lvl == 94) && (newxp > 7944614)) {
	      return true;
	    }
	    if ((lvl == 95) && (newxp > 8771558)) {
	      return true;
	    }
	    if ((lvl == 96) && (newxp > 9684577)) {
	      return true;
	    }
	    if ((lvl == 97) && (newxp > 10692629)) {
	      return true;
	    }
	    if ((lvl == 98) && (newxp > 11805606)) {
	      return true;
	    }
	    return false;
	  }
	private int damageLevelCalc(Player p,Skills s){
		int a = 0;
		int r = 0;
		int m = 0;
		if(s==Skills.Attack){
			a = Attack.getLevel(p)+1;
		}else{
			a = Attack.getLevel(p);
		}
		if(s==Skills.Range){
			r = Range.getLevel(p)+1;
		}else{
			r = Range.getLevel(p);
		}
		if(s==Skills.Magic){
			m = Magic.getLevel(p)+1;
		}else{
			m = Magic.getLevel(p);
		}
		int otherLevels = Defence.getLevel(p)+2;
		if(a>r&&r>m){
			return a+otherLevels;
		}
		if(r>m&&m>a){
			return r+otherLevels;
		}
		if(m>a&&a>r){
			return m+otherLevels;
		}
		if(a==r&&r==m){
			//all the same
			return a+otherLevels;
		}
		if(a>r&&r==m){
			//attack bigger others simmiler
			return a+otherLevels;
		}
		if(r>a&&a==m){
			//range bigger others simmiler
			return r+otherLevels;
		}
		if(m>r&&r==m){
			//magic bigger others simmiler
			return m+otherLevels;
		}
		if(a==r&&r>m){
			//attack and range bigger
			return a+otherLevels;
		}
		if(r==m&&m>a){
			//magic and range bigger
			return r+otherLevels;
		}
		if(m==a&&a>r){
			//magic and attack bigger
			return a+otherLevels;
		}
		return 2+otherLevels;
	}
	
	private static void firwork(Player p){
		 
        //Spawn the Firework, get the FireworkMeta.
        Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
       
        //Our random generator
        Random r = new Random();   

        //Get the type
        int rt = r.nextInt(4) + 1;
        Type type = Type.BALL;       
        if (rt == 1) type = Type.BALL;
        if (rt == 2) type = Type.BALL_LARGE;
        if (rt == 3) type = Type.BURST;
        if (rt == 4) type = Type.CREEPER;
        if (rt == 5) type = Type.STAR;
       
        //Get our random colours   
        int r1i = r.nextInt(17) + 1;
        int r2i = r.nextInt(17) + 1;
        Color c1 = Color.GREEN;
        Color c2 = Color.GREEN;
       
        //Create our effect with this
        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
       
        //Then apply the effect to the meta
        fwm.addEffect(effect);
       
        //Generate some random power and set it
        int rp = r.nextInt(2) + 1;
        fwm.setPower(rp);
       
        //Then apply this to our rocket
        fw.setFireworkMeta(fwm);        
	}
	
	
}
