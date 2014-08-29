package me.johngreen.com.Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum Npcs {
	//desert npcs
	LouieLegs("LouieLegs",false,Profession.LIBRARIAN,"Woman.png"),
	GemTrader("Gem Trader",false,Profession.LIBRARIAN,"Man.png"),
    Bob("Bob",false,Profession.BLACKSMITH,"Man.png"),
    Zeke("Zeke",false,Profession.FARMER,"Man.png"),
    Karim("Karim",false,Profession.PRIEST,"Man.png"),
    //falador
	
	Flynn("Flynn",false,Profession.PRIEST,"Man.png"),
	Megan("Megan",false,Profession.PRIEST,"Man.png"),
	Lucy("Lucy",false,Profession.PRIEST,"Woman.png"),
	PartyPete("PartyPete",false,Profession.PRIEST,"Man.png"),
	Mime("Mime",false,Profession.PRIEST,"Man.png"),
	HeraldOfFalador("HeraldOfFalador",false,Profession.PRIEST,"Man.png"),
	Wayne("Wayne",false,Profession.PRIEST,"Man.png"),
	AmbassadorSpanfipple("Ambassador Spanfipple",false,Profession.PRIEST,"Man.png"),
	Akrisae("Akrisae",false,Profession.PRIEST,"Man.png"),
	Silif("Silif",false,Profession.PRIEST,"Man.png"),
	//draynar
	MysteriousOldMan("Mysterious Old Man",false,Profession.BLACKSMITH,"Man.png"),
	Morgan("Morgan",false,Profession.BLACKSMITH,"Woman.png"),
	WiseOldMan("Wise Old Man",false,Profession.BLACKSMITH,"Man.png"),
	BankGuard("Bank Guard",false,Profession.BLACKSMITH,"Man.png"),
	Diango("Diango",false,Profession.BLACKSMITH,"Woman.png"),
	TownCirer("Tow Cirer",false,Profession.BLACKSMITH,"Man.png"),
	Aggie("Aggie",false,Profession.BLACKSMITH,"Man.png"),
	//port sirim
	Gurm("Gurm",false,Profession.BLACKSMITH,"Man.png"),
	Betty("Betty",false,Profession.BLACKSMITH,"Woman.png"),
	Brian("Brian",false,Profession.BLACKSMITH,"Man.png"),
	BardRoberts("Bard Roberts",false,Profession.BLACKSMITH,"Man.png"),
	Bartender("Bartender",false,Profession.BLACKSMITH,"Man.png"),
	Ahab("Ahab",false,Profession.BLACKSMITH,"Man.png"),
	RedbeardFrank("Redbeard Frank",false,Profession.BLACKSMITH,"Man.png"),
	MonkOfEntrane("Monk Of Entrane",false,Profession.BLACKSMITH,"Man.png"),
	SeamanLoris("Seaman Loris",false,Profession.BLACKSMITH,"Man.png"),
	SeamanTobias("Seaman Tobias",false,Profession.BLACKSMITH,"Man.png"),
	Widin("Widin",false,Profession.BLACKSMITH,"Man.png"),
	Thief("Thief",false,Profession.BLACKSMITH,"Man.png"),
	Pirate("Pirate",false,Profession.BLACKSMITH,"Man.png"),
	CaptinHand("Captin Hand",false,Profession.BLACKSMITH,"Man.png"),
	Blackknight("Black Knight",false,Profession.BLACKSMITH,"Man.png"),
	Guard("Guard",false,Profession.BLACKSMITH,"Man.png"),
	Gerrant("Gerrant",false,Profession.BLACKSMITH,"Man.png"),
    //tut island
    Skippy("Skippy",false,Profession.BLACKSMITH,"Man.png"),
    JamesBlond("James Blond",false,Profession.BLACKSMITH,"Man.png"),
    FishEyeJoe("Fish Eye Joe",false,Profession.LIBRARIAN,"Man.png"),
    Smithy("Smithy",false,Profession.LIBRARIAN,"Man.png"),
    KnightAlbert("KnightAlbert",false,Profession.LIBRARIAN,"Man.png"),
    FatherPaul("FatherPaul",false,Profession.BLACKSMITH,"Man.png"),
    //lummy
    Seridor("Seridor",false,Profession.LIBRARIAN,"Man.png"),
    Banker("Banker",false,Profession.LIBRARIAN,"Banker.png"),
    GrandExchangeClerk("Grand Exchange Clerk",false,Profession.LIBRARIAN,"Man.png"),
    Ellis("Ellis",false,Profession.BLACKSMITH,"Man.png"),
    Victoria("Victoria",false,Profession.FARMER,"Woman.png"),
    FatherAereck("Father Aereck",false,Profession.PRIEST,"Man.png"),
    LumbridgeSage("Lumbridge Sage",false,Profession.PRIEST,"Lumbridge Sage.png"),
    ShopKeeper("ShopKeeper",false,Profession.FARMER,"Man.png"),
    ShopAssistant("Shop Assistant",false,Profession.FARMER,"Man.png"),
    ExplorerJack("Explorer Jack",false,Profession.BLACKSMITH,"Man.png"),
    BarfyBill("Barfy Bill",false,Profession.FARMER,"Man.png"),
    DukeHoracio("Duke Horacio",false,Profession.PRIEST,"Duke Horacio.png"),
    GuardsmanDeShawn("Guardsman DeShawn",false,Profession.FARMER,"Man.png"),
    GuardsmanPazel("Guardsman Pazel",false,Profession.FARMER,"Man.png"),
    GuardsmanDante("Guardsman Dante",false,Profession.FARMER,"Man.png"),
    GuardsmanPeale("Guardsman Peale",false,Profession.FARMER,"Man.png"),
    Hans("Hans",false,Profession.FARMER,"Hans.png"),
    Cook("Cook",true,Profession.BUTCHER,"Man.png"),
    Hank("Hank",false,Profession.FARMER,"Man.png"),
    Lachtopher("Lachtopher",false,Profession.FARMER,"Man.png"),
	
	//varrock
    Clive("Clive",false,Profession.FARMER,"Man.png"),
    SirPrysin("Sir Prysin",false,Profession.FARMER,"Man.png"),
    Reldo("Reldo",false,Profession.FARMER,"Man.png"),
    AmbassadoreFerrnook("Ambassadore Ferrnook",false,Profession.FARMER,"Man.png"),
    GrufeldBalch("Grufeld Balch",false,Profession.FARMER,"Man.png"),
    FatherLawrance("Father Lawrance",false,Profession.FARMER,"Man.png"),
    BarnabusHurma("Barnabus Hurma",false,Profession.FARMER,"Man.png"),
    MariusGiste("Marius Giste",false,Profession.FARMER,"Man.png"),
    SchoolBoy("SchoolBoy",false,Profession.FARMER,"Man.png"),
    SchoolGirl("SchoolGirl",false,Profession.FARMER,"Woman.png"),
    Teacher("Teacher",false,Profession.FARMER,"Woman.png"),
    MuseumGuard("Museum Guard",false,Profession.FARMER,"Man.png"),
    CuratorHaigHelen("Curator Haig Helen",false,Profession.FARMER,"Man.png"),
    CardenAzro("Carden Azro",false,Profession.FARMER,"Man.png"),
    ThiasLeacke("Thias Leacke",false,Profession.FARMER,"Man.png"),
    Lowe("Lowe",false,Profession.FARMER,"Woman.png"),
    Horvik("Horvik",false,Profession.FARMER,"Man.png"),
    Aubury("Aubury",false,Profession.FARMER,"Man.png"),
    Sani("Sani",false,Profession.FARMER,"Man.png"),
    Zaff("Zaff",false,Profession.FARMER,"Man.png"),
    Xuan("Xuan",false,Profession.FARMER,"Man.png"),
    GypsyAris("Gypsy Aris",false,Profession.FARMER,"Woman.png"),
    Iffie("Iffie",false,Profession.FARMER,"Woman.png"),
    Apothecary("Apothecary",false,Profession.FARMER,"Man.png"),
    SwordShopAssistant("Sword Shop Assistant",false,Profession.FARMER,"Man.png"),
    SwordShopKeeper("Sword Shop Keeper",false,Profession.FARMER,"Man.png"),
    CharlieTheTramp("CharlieTheTramp",false,Profession.FARMER,"Man.png");
    
    
    public static List<UUID> npcs = new ArrayList<UUID>();
    
	@SuppressWarnings("unused")
	private final String name;
	private boolean hasQuest;
	private Profession profession;
	private String headLoc;
    Npcs(String name,boolean hasQuest,Profession profession,String headLoc) {
    	this.name = name;
    	this.hasQuest=hasQuest;
    	this.profession = profession;
    	this.headLoc = headLoc;
    }
    
    public String getHead(){
    	return headLoc;
    }
    public static String npcChat(String name){
    	String name1 = ChatColor.stripColor(name);
    	name1 = name1.replace("★", "");
    	switch(name){
    	//varrock
    	

        case "FatherPaul":
                                return "";
                        case "KnightAlbert":
                                return "";
                        case "OldCook":
                                return "";
                        case "Smithy":
                                return "";
                        case "FishEyeJoe":
                                return "";
                        case "JamesBlond":
                                return "";
                        case "Skippy":
                                return "Skip Skip away!";
                             
                             
                        case "Banker":
                                return "Welcome, feel free to deposit and withdraw items and money, it is safe with us!";
                        case "GrandExchangeClerk":
                                return "Welcome to the grand exchange";
                        case "Bob":
                                return "Welcome to my shop, I sell axes and can repair items";
                        case "Victoria":
                                return "Greeting traveller, have you seen my brother Lachtopher around in the town?";
                        case "FatherAereck":
                                return "May Guthix shine upon you and your venture!";
                        case "ShopKeeper":
                                return "Welcome to my shop, we sell many items here";
                        case "ShopAssistant":
                                return "This is my fathers shop, some day I will get out of this job";
                        case "ExplorerJack":
                                return "I havent been on a good quest lately, shame for a man with my talent";
                        case "BarfyBill":
                                return "The art of canoeing is simple, just chop down the tree and float on it down the river";
                        case "DukeHoracio":
                                return "Welcome to my castle, please make your self at home!";
                        case "GuardsmanDeShawn":
                                return "My Duke is just and fair, I'm priviliged to be under his command";
                        case "GuardsmanPazel":
                                return "Welcome to the castle, young one";
                        case "GuardsmanDante":
                                return "I have been a Guard here for many years, and through that time I have always loved my job";
                        case "GuardsmanPeale":
                                return "My Duke is just and fair, I am priviliged to be under his command";
                        case "Hans":
                                return "If you are looking for the Duke he is on the first floor";
                        case "LumbridgeSage":
                                return "Lumbridge is one of the oldest towns in the human controlled kingdoms, it was founded over 200 years ago!";
                        case "Cook":
                                return "I cook many exquisite items here in the Castle for our Duke";
                        case "Hank":
                                return "Welcome to my fishing shop, how can I help";
                        case "Lachtopher":
                                return "Can i borrow some money? my sister wont let me have any more, she says I should work for it... pfft.";
               }


    	return null;
    }
    public static void spawnNPC(Npcs npc, Location l){
    	
    	LivingEntity entity = (LivingEntity) Bukkit.getWorld(l.getWorld().getName()).spawnEntity(l, EntityType.VILLAGER);
    	entity.setCanPickupItems(false);
    	entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 20*60*60*24));
    	if(npc.hasQuest){
    		entity.setCustomName(ChatColor.GOLD+"★"+ChatColor.LIGHT_PURPLE+npc.name());
    	}else{
    		entity.setCustomName(ChatColor.LIGHT_PURPLE+npc.name());
    	}
    	entity.setCustomNameVisible(true);
    	npcs.add(entity.getUniqueId());
    }
    public static Npcs getByName(String name){
    	switch(name){
    	//falador
    	case "Seridor":
    		return Npcs.Seridor;
    	case "Flynn":
    		return Npcs.Flynn;
    	case "Megan":
    		return Npcs.Megan;
    	case "Lucy":
    		return Npcs.Lucy;
    	case "PartyPete":
    		return Npcs.PartyPete;
    	case "Mime":
    		return Npcs.Mime;
    	case "HeraldOfFalador":
    		return Npcs.HeraldOfFalador;
    	case "Wayne":
    		return Npcs.Wayne;
    	case "AmbassadorSpanfipple":
    		return Npcs.AmbassadorSpanfipple;
    	case "Akrisae":
    		return Npcs.Akrisae;
    	case "Silif":
    		return Npcs.Silif;
    	
	    	case "FatherPaul":
				return Npcs.FatherPaul;
	    	case "KnightAlbert":
				return Npcs.KnightAlbert;
	    	case "Smithy":
				return Npcs.Smithy;
	    	case "FishEyeJoe":
				return Npcs.FishEyeJoe;
	    	case "JamesBlond":
				return Npcs.JamesBlond;
	    	case "Skippy":
				return Npcs.Skippy;
    	
    		case "Banker":
    			return Npcs.Banker;
    		case "GrandExchangeClerk":
    			return Npcs.GrandExchangeClerk;
    		case "Bob":
    			return Npcs.Bob;
    		case "Victoria":
    			return Npcs.Victoria;
    		case "FatherAereck":
    			return Npcs.FatherAereck;
    		case "ShopKeeper":
    			return Npcs.ShopKeeper;
    		case "ShopAssistant":
    			return Npcs.ShopAssistant;
    		case "ExplorerJack":
    			return Npcs.ExplorerJack;
    		case "BarfyBill":
    			return Npcs.BarfyBill;
    		case "DukeHoracio":
    			return Npcs.DukeHoracio;
    		case "GuardsmanDeShawn":
    			return Npcs.GuardsmanDeShawn;
    		case "GuardsmanPazel":
    			return Npcs.GuardsmanPazel;
    		case "GuardsmanDante":
    			return Npcs.GuardsmanDante;
    		case "GuardsmanPeale":
    			return Npcs.GuardsmanPeale;
    		case "Hans":
    			return Npcs.Hans;
    		case "LumbridgeSage":
    			return Npcs.LumbridgeSage;
    		case "Cook":
    			return Npcs.Cook;
    		case "Hank":
    			return Npcs.Hank;
    		case "Lachtopher":
    			return Npcs.Lachtopher;
    			
    		case "LouieLegs":
    			return Npcs.LouieLegs;
    		case "GemTrader":
    			return Npcs.GemTrader;
    		case "Ellis":
    			return Npcs.Ellis;
    		case "Zeke":
    			return Npcs.Zeke;
    		case "Karim":
    			return Npcs.Karim;
    			
    			//varock
    		case "Clive":
    			return Npcs.Clive;
    		case "SirPrysin":
    			return Npcs.SirPrysin;
    		case "Reldo":
    			return Npcs.Reldo;
    		case "AmbassadoreFerrnook":
    			return Npcs.AmbassadoreFerrnook;
    		case "GrufeldBalch":
    			return Npcs.GrufeldBalch;
    		case "FatherLawrance":
    			return Npcs.FatherLawrance;
    		case "BarnabusHurma":
    			return Npcs.BarnabusHurma;
    		case "MariusGiste":
    			return Npcs.MariusGiste;
    		case "SchoolBoy":
    			return Npcs.SchoolBoy;
    		case "SchoolGirl":
    			return Npcs.SchoolGirl;
    		case "Teacher":
    			return Npcs.Teacher;
    		case "MuseumGuard":
    			return Npcs.MuseumGuard;
    		case "CuratorHaigHelen":
    			return Npcs.CuratorHaigHelen;
    		case "CardenAzro":
    			return Npcs.CardenAzro;
    		case "ThiasLeacke":
    			return Npcs.ThiasLeacke;
    		case "Lowe":
    			return Npcs.Lowe;
    		case "Horvik":
    			return Npcs.Horvik;
    		case "Aubury":
    			return Npcs.Aubury;
    		case "Sani":
    			return Npcs.Sani;
    		case "Zaff":
    			return Npcs.Zaff;
    		case "Xuan":
    			return Npcs.Xuan;
    		case "GypsyAris":
    			return Npcs.GypsyAris;
    		case "Iffie":
    			return Npcs.Iffie;
    		case "Apothecary":
    			return Npcs.Apothecary;
    		case "SwordShopAssistant":
    			return Npcs.SwordShopAssistant;
    		case "SwordShopKeeper":
    			return Npcs.SwordShopKeeper;
    		case "CharlieTheTramp":
    			return Npcs.CharlieTheTramp;
    			
    			//draynar
    		case "MysteriousOldMan":
    			return Npcs.MysteriousOldMan;
    		case "Morgan":
    			return Npcs.Morgan;
    		case "Aggie":
    			return Npcs.Aggie;
    		case "WiseOldMan":
    			return Npcs.WiseOldMan;
    		case "BankGuard":
    			return Npcs.BankGuard;
    		case "Diango":
    			return Npcs.Diango;
    		case "TownCirer":
    			return Npcs.TownCirer;
    			//port sirim
    		case "Bartender":
    			return Npcs.Bartender;
    		case "Ahab":
    			return Npcs.Ahab;
    		case "BardRoberts":
    			return Npcs.BardRoberts;
    		case "RedbeardFrank":
    			return Npcs.RedbeardFrank;
    		case "MonkOfEntrane":
    			return Npcs.MonkOfEntrane;
    		case "SeamanLoris":
    			return Npcs.SeamanLoris;
    		case "SeamanTobias":
    			return Npcs.SeamanTobias;
    		case "Widin":
    			return Npcs.Widin;
    		case "Thief":
    			return Npcs.Thief;
    		case "Pirate":
    			return Npcs.Pirate;
    		case "CaptinHand":
    			return Npcs.CaptinHand;
    		case "Blackknight":
    			return Npcs.Blackknight;
    		case "Guard":
    			return Npcs.Guard;
    		case "Gerrant":
    			return Npcs.Gerrant;
    		case "Gurm":
    			return Npcs.Gurm;
    		case "Betty":
    			return Npcs.Betty;
    		case "Brian":
    			return Npcs.Brian;
    	}
    	return null;
    }
	public static void spawnNPC(String string, Location l) {
		Npcs npc = Npcs.getByName(string);
		if(npc!=null){
			if(Bukkit.getWorld("Runescape").getChunkAt(l).isLoaded()){
				LivingEntity entity = (LivingEntity) Bukkit.getWorld(l.getWorld().getName()).spawnEntity(l, EntityType.VILLAGER);
		    	Villager v = (Villager) entity;
		    	v.setProfession(npc.profession);
				entity.setCanPickupItems(false);
		    	entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180067, 6776767));
		    	if(npc.hasQuest){
		    		entity.setCustomName(ChatColor.GOLD+"★"+ChatColor.LIGHT_PURPLE+npc.name());
		    	}else{
		    		entity.setCustomName(ChatColor.LIGHT_PURPLE+npc.name());
		    	}
		    	npcs.add(entity.getUniqueId());
		    	entity.setCustomNameVisible(true);	
			}else{
				Bukkit.getServer().getWorld("Runescape").getChunkAt(l).load();
				LivingEntity entity = (LivingEntity) Bukkit.getWorld(l.getWorld().getName()).spawnEntity(l, EntityType.VILLAGER);
		    	Villager v = (Villager) entity;
		    	v.setProfession(npc.profession);
				entity.setCanPickupItems(false);
		    	entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180067, 6776767));
		    	if(npc.hasQuest){
		    		entity.setCustomName(ChatColor.GOLD+"★"+ChatColor.LIGHT_PURPLE+npc.name());
		    	}else{
		    		entity.setCustomName(ChatColor.LIGHT_PURPLE+npc.name());
		    	}
		    	npcs.add(entity.getUniqueId());
		    	entity.setCustomNameVisible(true);
			}
		}else{
			Bukkit.broadcastMessage("Unable to spawn npc "+string);
		}
		
	}
	
	public static void loadWorldNpcs(){
		//edge vill
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1180.699999988079, 69.0,  562.6999999880791));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1180.699999988079, 69.0,  567.6999999880791));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1173.570703821847, 69.0,  567.6999999880791));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1167.6148231438217, 69.0,  567.6769304854383));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1163.5228322424916, 69.0,  567.6999999880791));
		//alkheric
		spawnNPC("LouieLegs", new Location(Bukkit.getWorld("Runescape"), -216.36197835169418, 69.0,  -90.95088048129912));
		spawnNPC("ShopKeeper", new Location(Bukkit.getWorld("Runescape"), -232.5855483797049, 69.0,  -87.486286464865));
		spawnNPC("GemTrader", new Location(Bukkit.getWorld("Runescape"), -322.85734668514635, 69.0,  -20.230925200120375));
		spawnNPC("Ellis", new Location(Bukkit.getWorld("Runescape"), -260.29115107378664, 70.0,  21.354817707534746));
		spawnNPC("Zeke", new Location(Bukkit.getWorld("Runescape"), -251.949081634688, 69.0,  -10.670463514885213));
		spawnNPC("Karim", new Location(Bukkit.getWorld("Runescape"), -237.37633144150348, 70.0,  24.242933652879692));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -198.4272900297645, 70.0,  41.30000001192093));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -195.62150243415982, 70.0,  41.356644259765744));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -192.61384888798634, 70.0,  41.31718804780394));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -189.59897337249205, 70.0,  41.30000001192093));
		
		//lummy
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -350.3023111228831, 82.0,  223.93095693879854));
		spawnNPC("LumbridgeSage", new Location(Bukkit.getWorld("Runescape"), -346.5884261956177, 69.0, 141.3712129345042));
		spawnNPC("FatherAereck", new Location(Bukkit.getWorld("Runescape"), -304.69999998807907, 70.0, 119.9860480175175));
		spawnNPC("Victoria", new Location(Bukkit.getWorld("Runescape"), -312.56224344382315, 69.0, 160.12635642423433));
		spawnNPC("Bob", new Location(Bukkit.getWorld("Runescape"), -302.29611694295744, 69.0, 164.5514807861309));
		spawnNPC("Hans", new Location(Bukkit.getWorld("Runescape"), -362.21259626935165, 69.0, 192.5619285024572));
		spawnNPC("Cook", new Location(Bukkit.getWorld("Runescape"), -330.74400124185, 71.0, 219.42010127308546));
		spawnNPC("GuardsmanPeale", new Location(Bukkit.getWorld("Runescape"), -369.0077899827587, 71.0, 229.4479869232443));
		spawnNPC("GuardsmanDante", new Location(Bukkit.getWorld("Runescape"), -341.6511942137673, 77.0, 236.7559596556398));
		spawnNPC("GuardsmanPazel", new Location(Bukkit.getWorld("Runescape"), -317.2126946740318, 76.0, 220.64600307668272));
		spawnNPC("GuardsmanDeShawn", new Location(Bukkit.getWorld("Runescape"), -363.33374659653134, 77.0, 235.05736013260614));
		spawnNPC("DukeHoracio", new Location(Bukkit.getWorld("Runescape"), -353.8139787921942, 77.0, 223.31650617764626));
		spawnNPC("BarfyBill", new Location(Bukkit.getWorld("Runescape"), -431.86001380282045, 69.0, 152.40693712280626));
		spawnNPC("ExplorerJack", new Location(Bukkit.getWorld("Runescape"), -408.40226394092963, 69.0, 237.63900640902236));
		spawnNPC("ShopAssistant", new Location(Bukkit.getWorld("Runescape"), -409.5542526478647, 69.0, 217.51044745361614));
		spawnNPC("ShopKeeper", new Location(Bukkit.getWorld("Runescape"), -405.3470005646429, 69.0, 207.44518260712417));
		spawnNPC("Hank", new Location(Bukkit.getWorld("Runescape"), -431.97117923080236, 69.0, 264.3177545450786));
		spawnNPC("Lachtopher", new Location(Bukkit.getWorld("Runescape"), -396.332262729004, 69.0, 172.0452291118791));
		spawnNPC("Seridor", new Location(Bukkit.getWorld("Runescape"), -171.31018760551197, 71.0,  517.2394000897182));
		
		
		//tut island
		spawnNPC("JamesBlond", new Location(Bukkit.getWorld("Runescape"), -13.494509608777207, 69.0,  542.3946145163846));
		spawnNPC("ShopKeeper", new Location(Bukkit.getWorld("Runescape"), -2.800800608512166, 69.0,  545.5698359990823));
		spawnNPC("FishEyeJoe", new Location(Bukkit.getWorld("Runescape"), 42.33317029607193, 69.0,  530.2590454333952));
		spawnNPC("Smithy", new Location(Bukkit.getWorld("Runescape"), 11.26373126388943, 52.0,  566.8633933725265));
		spawnNPC("KnightAlbert", new Location(Bukkit.getWorld("Runescape"), -24.34761729848379, 52.0,  528.7512629703756));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -58.40182893415681, 69.0,  463.50279654871986));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -58.307047462496996, 69.0,  458.56291944402983));
		spawnNPC("FatherPaul", new Location(Bukkit.getWorld("Runescape"), -1.8913570722427397, 69.0,  470.4927820129163));
		spawnNPC("Skippy", new Location(Bukkit.getWorld("Runescape"), 56.489185148192405, 69.0,  398.4597391558422));
		
		//varock
		spawnNPC("CharlieTheTramp", new Location(Bukkit.getWorld("Runescape"), -866.7311645683704, 69.0,  224.57747249272597));
		spawnNPC("SwordShopKeeper", new Location(Bukkit.getWorld("Runescape"), -888.8097480633463, 69.0,  233.6439693330877));
		spawnNPC("SwordShopAssistant", new Location(Bukkit.getWorld("Runescape"), -880.5493155946649, 69.0,  241.76279194831085));
		spawnNPC("Apothecary", new Location(Bukkit.getWorld("Runescape"), -901.0882100532292, 69.0,  272.16485187087187));
		spawnNPC("Ellis", new Location(Bukkit.getWorld("Runescape"), -910.0194637898711, 69.0,  290.1969671413349));
		spawnNPC("Iffie", new Location(Bukkit.getWorld("Runescape"), -939.0157715931966, 69.0,  235.65441111441976));
		spawnNPC("ShopKeeper", new Location(Bukkit.getWorld("Runescape"), -943.1204800070306, 69.0,  206.24646443460688));
		spawnNPC("ShopAssistant", new Location(Bukkit.getWorld("Runescape"), -933.8306953062715, 69.0,  193.93585757024817));
		spawnNPC("GypsyAris", new Location(Bukkit.getWorld("Runescape"), -965.5890100254909, 69.0,  248.44946040123406));
		spawnNPC("Xuan", new Location(Bukkit.getWorld("Runescape"), -995.5665840127575, 69.0,  231.31927869840015));
		spawnNPC("Zaff", new Location(Bukkit.getWorld("Runescape"), -990.4699726962633, 69.0,  244.4277980965041));
		spawnNPC("Sani", new Location(Bukkit.getWorld("Runescape"), -963.0846439430879, 69.0,  293.302035945096));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1005.0059378116232, 69.0,  313.30000001192093));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1010.0843548729514, 69.0,  313.30000001192093));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1014.8706093318118, 69.0,  313.30000001192093));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1020.0784703104434, 69.0,  313.30000001192093));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1024.9812746871407, 69.0,  313.30000001192093));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1021.1232092760112, 69.0,  290.69999998807907));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1194.8022560534105, 70.0,  311.5300490980483));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1205.425436184445, 70.0,  316.42224802540727));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1201.415853210145, 70.0,  318.6943923665101));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1199.5957349016899, 70.0,  307.30000001192093));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1133.300000011921, 70.0,  307.30000001192093));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1129.300000011921, 70.0,  318.69999998807907));
		spawnNPC("Aubury", new Location(Bukkit.getWorld("Runescape"), -892.917118493756, 69.0,  91.93449666195887));
		spawnNPC("Horvik", new Location(Bukkit.getWorld("Runescape"), -1006.8426515974284, 69.0,  168.62110725017916));
		spawnNPC("Lowe", new Location(Bukkit.getWorld("Runescape"), -967.6824581616673, 69.0,  151.29833994384705));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -948.6911722060465, 71.0,  92.94494664185207));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -948.6955860966989, 71.0,  89.99255375895174));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -948.6969559253191, 71.0,  86.97494785040647));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -948.6999999880788, 71.0,  84.0016865081742));
		spawnNPC("ThiasLeacke", new Location(Bukkit.getWorld("Runescape"), -1024.3000000119212, 72.0,  78.45807116554764));
		spawnNPC("CardenAzro", new Location(Bukkit.getWorld("Runescape"), -1027.7578166061455, 72.0,  77.70703320514295));
		spawnNPC("CuratorHaigHelen", new Location(Bukkit.getWorld("Runescape"), -1038.4510618755917, 72.0,  83.94050581893282));
		spawnNPC("MuseumGuard", new Location(Bukkit.getWorld("Runescape"), -1034.122019306449, 72.0,  73.12116890025604));
		spawnNPC("Teacher", new Location(Bukkit.getWorld("Runescape"), -1048.1370627119807, 72.0,  72.65238515522451));
		spawnNPC("SchoolGirl", new Location(Bukkit.getWorld("Runescape"), -1044.1991570768037, 72.0,  78.64205321720581));
		spawnNPC("SchoolBoy", new Location(Bukkit.getWorld("Runescape"), -1052.7846191163792, 72.0,  76.43893567374877));
		spawnNPC("MariusGiste", new Location(Bukkit.getWorld("Runescape"), -1028.4625634635256, 72.0,  89.6784373549173));
		spawnNPC("BarnabusHurma", new Location(Bukkit.getWorld("Runescape"), -1026.4766060610839, 72.0,  86.02617666592623));
		spawnNPC("FatherLawrance", new Location(Bukkit.getWorld("Runescape"), -1146.7353148941477, 69.0,  94.01781992287516));
		spawnNPC("GrufeldBalch", new Location(Bukkit.getWorld("Runescape"), -1137.9719935579212, 69.0,  102.09439821790917));
		spawnNPC("AmbassadoreFerrnook", new Location(Bukkit.getWorld("Runescape"), -1148.9661703659972, 76.0,  233.316769931779));
		spawnNPC("Reldo", new Location(Bukkit.getWorld("Runescape"), -1170.3280001716807, 69.0,  216.75342080140004));
		spawnNPC("Clive", new Location(Bukkit.getWorld("Runescape"), -1126.4930663729147, 69.0,  246.95132653300004));
		spawnNPC("SirPrysin", new Location(Bukkit.getWorld("Runescape"), -1110.4709938753886, 69.0,  240.84600216201795));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1199.6651312366284, 70.0,  385.69999998807907));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1201.300000011921, 70.0,  374.8806314398195));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1205.699999988079, 70.0,  379.69999998807907));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1194.300000011921, 70.0,  381.38168564031884));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1127.300000011921, 70.0,  379.29079792894004));
		spawnNPC("GrandExchangeClerk", new Location(Bukkit.getWorld("Runescape"), -1138.699999988079, 70.0,  381.3071459425362));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1133.300000011921, 70.0,  385.69999998807907));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1131.6790962654036, 70.0,  374.30000001192093));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1137.699999988079, 70.0,  313.69999998807907));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -1127.300000011921, 70.0,  313.3068048938219));

		
		//port sirim
		spawnNPC("Gurm", new Location(Bukkit.getWorld("Runescape"), -423.828098469657, 72.0,  815.5375465314185));
		spawnNPC("Betty", new Location(Bukkit.getWorld("Runescape"), -460.86376283840184, 72.0,  814.1171643755902));
		spawnNPC("Brian", new Location(Bukkit.getWorld("Runescape"), -433.43431794066055, 72.0,  775.4941196882052));
		spawnNPC("Gerrant", new Location(Bukkit.getWorld("Runescape"), -349.6465373686914, 72.0,  821.9369123201906));
		spawnNPC("Guard", new Location(Bukkit.getWorld("Runescape"), -267.7323295318529, 72.0,  827.8036390991126));
		spawnNPC("Guard", new Location(Bukkit.getWorld("Runescape"), -247.2916743050333, 72.0,  830.5265047462314));
		spawnNPC("Blackknight", new Location(Bukkit.getWorld("Runescape"), -232.3247743870037, 71.5,  818.9097469178207));
		spawnNPC("CaptinHand", new Location(Bukkit.getWorld("Runescape"), -259.9355043147099, 71.5,  817.142327303363));
		spawnNPC("Pirate", new Location(Bukkit.getWorld("Runescape"), -261.62869685858936, 71.5,  820.1563929016633));
		spawnNPC("Thief", new Location(Bukkit.getWorld("Runescape"), -271.22815029903904, 71.5,  820.9766940712059));
		spawnNPC("Widin", new Location(Bukkit.getWorld("Runescape"), -298.57275528794895, 72.0,  819.8658594863999));
		spawnNPC("SeamanTobias", new Location(Bukkit.getWorld("Runescape"), -333.9090956623429, 72.0,  775.6764696169986));
		spawnNPC("SeamanLoris", new Location(Bukkit.getWorld("Runescape"), -344.7246169716384, 72.0,  775.7946788849214));
		spawnNPC("MonkOfEntrane", new Location(Bukkit.getWorld("Runescape"), -378.92218840095194, 72.0,  718.6318658368798));
		spawnNPC("MonkOfEntrane", new Location(Bukkit.getWorld("Runescape"), -394.4481338134551, 72.0,  725.3166474740154));
		spawnNPC("MonkOfEntrane", new Location(Bukkit.getWorld("Runescape"), -386.86682968413373, 72.0,  730.6797326058017));
		spawnNPC("MonkOfEntrane", new Location(Bukkit.getWorld("Runescape"), -391.04714402839704, 72.0,  713.8661398240461));
		spawnNPC("RedbeardFrank", new Location(Bukkit.getWorld("Runescape"), -434.07837133374915, 72.0,  699.6017265351777));
		spawnNPC("BardRoberts", new Location(Bukkit.getWorld("Runescape"), -459.30000001192093, 72.0,  713.6963769701006));
		spawnNPC("Ahab", new Location(Bukkit.getWorld("Runescape"), -452.30000001192093, 72.0,  712.4087605285265));
		spawnNPC("Bartender", new Location(Bukkit.getWorld("Runescape"), -456.5259424235789, 72.0,  721.3000000119209));
		spawnNPC("TownCirer", new Location(Bukkit.getWorld("Runescape"), -438.8948388544298, 69.0,  613.7238229270357));
		spawnNPC("Diango", new Location(Bukkit.getWorld("Runescape"), -430.91711249250983, 69.0,  607.5653710533988));
		spawnNPC("BankGuard", new Location(Bukkit.getWorld("Runescape"), -430.7164634360507, 69.0,  590.1458901715997));
		spawnNPC("WiseOldMan", new Location(Bukkit.getWorld("Runescape"), -447.86311229829795, 69.0,  590.0187621022342));
		spawnNPC("Aggie", new Location(Bukkit.getWorld("Runescape"), -469.36171025350467, 69.0,  596.5129314629056));
		spawnNPC("Morgan", new Location(Bukkit.getWorld("Runescape"), -494.75495237853227, 69.0,  557.4101929169717));
		spawnNPC("MysteriousOldMan", new Location(Bukkit.getWorld("Runescape"), -522.738150852588, 69.0,  553.3310758358583));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -419.54724793518386, 69.0,  581.3000000119209));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -412.326871889308, 69.0,  581.3066513680387));
		//falador
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -783.6903426676478, 69.0,  1011.5375363639703));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -783.4406389939389, 69.0,  1019.4804971097244));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -783.5283767665527, 69.0,  1015.6228861064557));
		spawnNPC("Flynn", new Location(Bukkit.getWorld("Runescape"), -844.1565642503391, 69.0,  1007.1822681795412));
		spawnNPC("ShopAssistant", new Location(Bukkit.getWorld("Runescape"), -851.0437985587719, 69.0,  978.4900648866378));
		spawnNPC("ShopKeeper", new Location(Bukkit.getWorld("Runescape"), -845.5104861861512, 69.0,  981.076451443262));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -747.6999999880791, 69.0,  811.5616361043113));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -747.6999999880791, 69.0,  817.7948165712173));
		spawnNPC("Banker", new Location(Bukkit.getWorld("Runescape"), -747.6999999880791, 69.0,  821.0196589020161));
		spawnNPC("Megan", new Location(Bukkit.getWorld("Runescape"), -830.3161595085635, 74.0,  727.9689703015716));
		spawnNPC("Lucy", new Location(Bukkit.getWorld("Runescape"), -808.4996616330114, 74.0,  729.1276507981914));
		spawnNPC("PartyPete", new Location(Bukkit.getWorld("Runescape"), -810.3712910631871, 69.0,  706.7873579066496));
		spawnNPC("Mime", new Location(Bukkit.getWorld("Runescape"), -836.6219869086959, 69.0,  725.9664139938698));
		spawnNPC("HeraldOfFalador", new Location(Bukkit.getWorld("Runescape"), -742.6243024455921, 71.0,  744.2841015319534));
		spawnNPC("Wayne", new Location(Bukkit.getWorld("Runescape"), -620.2688378739186, 69.0,  939.6281624816124));
		spawnNPC("AmbassadorSpanfipple", new Location(Bukkit.getWorld("Runescape"), -708.6357066642537, 77.0,  900.0743832336058));
		spawnNPC("Akrisae", new Location(Bukkit.getWorld("Runescape"), -709.6600736937079, 72.0,  894.1521417065964));
		spawnNPC("Silif", new Location(Bukkit.getWorld("Runescape"), -710.4822803505866, 72.0,  908.1872237538081));
	
	}
}
