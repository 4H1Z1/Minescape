package me.johngreen.com.Functions;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum Mobs {
	Barbarian("Barbarian",14,15,EntityType.PIG_ZOMBIE,Material.LEATHER_HELMET,Material.LEATHER_CHESTPLATE,Material.LEATHER_LEGGINGS,null,Material.IRON_SWORD,12),
	Chicken("Chicken",1,2,EntityType.CHICKEN,null,null,null,null,null,12),
    Cow("Cow",5,6,EntityType.COW,null,null,null,null,null,15),
    Ram("Ram",4,5,EntityType.SHEEP,null,null,null,null,null,15),
    GiantRat("Giant Rat",2,3,EntityType.SILVERFISH,null,null,null,null,null,15),
    GiantRat14("Giant Rat",14,15,EntityType.SILVERFISH,null,null,null,null,null,15),
    DarkWizard("Dark Wizard",19,21,EntityType.WITCH,null,null,null,null,Material.BLAZE_ROD,15),
    Guard("Guard",30,37,EntityType.ZOMBIE,Material.IRON_HELMET,Material.CHAINMAIL_CHESTPLATE,Material.CHAINMAIL_LEGGINGS,Material.CHAINMAIL_BOOTS,Material.WOOD_SWORD,15),
    
    AlKharidWarrior("AlKharid Warrior",20,23,EntityType.ZOMBIE,Material.CHAINMAIL_HELMET,Material.IRON_CHESTPLATE,Material.IRON_LEGGINGS,null,Material.IRON_SWORD,25),//xp needs fixed
    Spider("Spider",2,5,EntityType.CAVE_SPIDER,null,null,null,null,null,25),
    Dragon("Spider",80,100,EntityType.ZOMBIE,Material.CHAINMAIL_HELMET,null,null,null,null,125),
    Man("Man",4,5,EntityType.VILLAGER,null,null,null,null,null,25),
    WhiteKnight50("White Knight",50,51,EntityType.ZOMBIE,Material.CHAINMAIL_HELMET,Material.CHAINMAIL_CHESTPLATE,Material.CHAINMAIL_LEGGINGS,Material.CHAINMAIL_BOOTS,null,25),
    Wizard("Wizard",24,26,EntityType.WITCH,null,null,null,null,Material.BLAZE_ROD,37),
    Dwarf64("Dwarf",64,67,EntityType.ZOMBIE,null,null,null,null,Material.IRON_SWORD,37),
    Zombie18("Zombie",18,19,EntityType.ZOMBIE,null,null,null,null,Material.IRON_SWORD,37),
    Skeleton24("Skeleton",22,24,EntityType.SKELETON,null,null,null,null,Material.IRON_SWORD,37),
    Scorpion20("Scorpion",14,18,EntityType.SPIDER,null,null,null,null,null,37),//xp needs fixed
    DeadlyReadSpider125("DeadlyRedSpider",123,125,EntityType.SPIDER,null,null,null,null,Material.BLAZE_ROD,37),
    MossGiant75("MossGiant" ,75,76,EntityType.GIANT,null,null,null,null,null,37),
    Goblin("Goblin",2,3,EntityType.ZOMBIE,Material.IRON_HELMET,null,null,Material.CHAINMAIL_BOOTS,Material.WOOD_SWORD,20);
	
	
    
    public static Mobs getByName(String name){
    	if(name==null){
    		return null;
    	}
    	String name1 = name.toLowerCase();
    	switch(name1){
    		case "dragon":
    			return Mobs.Dragon;
    		case "whiteknight50":
    			return Mobs.WhiteKnight50;
    		case "dwarf64":
    			return Mobs.Dwarf64;
    		case "deadlyreadspider125":
    			return Mobs.DeadlyReadSpider125;
    		case "mossgiant75":
    			return Mobs.MossGiant75;
    		case "scorpion20":
    			return Mobs.Scorpion20;
    		case "giantrat14":
    			return Mobs.GiantRat14;
    		case "skeleton24":
    			return Mobs.Skeleton24;
    		case "zombie18":
    			return Mobs.Zombie18;
			case "spider":
				return Mobs.Spider;
			case "alkharidwarrior":
				return Mobs.AlKharidWarrior;
			case "goblin":
				return Mobs.Goblin;
			case "man":
				return Mobs.Man;
			case "wizard":
				return Mobs.Wizard;
			case "chicken":
				return Mobs.Chicken;
			case "cow":
				return Mobs.Cow;
			case "ram":
				return Mobs.Ram;
			case "sheep":
				return Mobs.Ram;
			case "giantrat":
				return Mobs.GiantRat;
			case "darkwizard":
				return Mobs.DarkWizard;
			case "guard":
				return Mobs.Guard;
    	}
    	return null;
    }
	
	
	private final String name;
	private int maxLevel;
	private int minLevel;
	private ItemStack helm;
	private ItemStack chest;
	private ItemStack legs;
	private ItemStack boots;
	private ItemStack hand;
	private EntityType type;
	private int xp;
    public static HashMap<UUID,Integer> Level = new HashMap<UUID,Integer>();
    public static HashMap<Integer,List<Integer>> mobs = new HashMap<Integer,List<Integer>>();
    public static HashMap<UUID,Integer> xpGained = new HashMap<UUID,Integer>();
    public static HashMap<UUID,Double> maxHit = new HashMap<UUID,Double>();
    public static HashMap<UUID,Mobs> mobType = new HashMap<UUID,Mobs>();
    
    
    public static HashMap<UUID,Mobs> customMob = new HashMap<UUID,Mobs>();
	
    Mobs(String name,int minLevel,int maxLevel,
    		EntityType type,Material helm,Material chest,Material legs,Material boots
    		,Material hand,int xp) {
    	this.xp = xp;
    	if(helm!=null){
    		this.helm = new ItemStack(helm);
    	}
    	if(chest!=null){
    		this.chest = new ItemStack(chest);
    	}
    	if(legs!=null){
    		this.legs = new ItemStack(legs);
    	}
    	if(boots!=null){
    		this.boots = new ItemStack(boots);
    	}
    	if(hand!=null){
    		this.hand = new ItemStack(hand);
    	}
    	this.name = name;
    	this.maxLevel = maxLevel;
    	this.minLevel = minLevel;
    	this.type = type;
    }
    private EntityType type() { 
    	return type; 
    }
    
    
    public static void spawnMob(Mobs npc, Location l){
    	
    	LivingEntity entity = (LivingEntity) Bukkit.getWorld("Runescape").spawnEntity(l, npc.type());
    	if(entity.getType().equals(EntityType.ZOMBIE)){
    		Zombie z = (Zombie) entity;
    		if(z.isBaby()){
    			z.setBaby(false);
    		}
    	}
    	entity.setCanPickupItems(false);
    	Random r = new Random();
    	int level = r.nextInt(npc.maxLevel-npc.minLevel) + npc.minLevel;
    	int health = calcHealth(level);
    	double damage = 1;
    	if((level/10)>1){
    		damage =level/10 ;
    	}
    	maxHit.put(entity.getUniqueId(),damage);
    	entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180067, 5));
    	entity.setMaxHealth(health);
    	if(npc.helm!=null){
    		entity.getEquipment().setHelmet(npc.helm);
    	}
    	if(npc.chest!=null){
    		entity.getEquipment().setChestplate(npc.chest);
    	}
    	if(npc.legs!=null){
    		entity.getEquipment().setLeggings(npc.legs);
    	}
    	if(npc.boots!=null){
    		entity.getEquipment().setBoots(npc.boots);
    	}
    	if(npc.hand!=null){
    		entity.getEquipment().setItemInHand(npc.hand);
    	}
    	entity.setHealth(health);
    	Level.put(entity.getUniqueId(), level);
    	mobType.put(entity.getUniqueId(), npc);
    	xpGained.put(entity.getUniqueId(), npc.xp);
    	if(npc.type.equals(Mobs.Dragon)){
    		customMob.put(entity.getUniqueId(), npc);
    	}
    	entity.setCustomName(ChatColor.RED+"["+ChatColor.DARK_RED+level+ChatColor.RED+"]"+ChatColor.GRAY+npc.getName());
    	entity.setCustomNameVisible(true);
    }
	private static int calcHealth(int level) {
		return level*10;
	}
	public static int spawnMobID(Mobs npc, Location l){
    	
    	LivingEntity entity = (LivingEntity) Bukkit.getWorld("Runescape").spawnEntity(l, npc.type());
    	if(entity.getType().equals(EntityType.ZOMBIE)){
    		Zombie z = (Zombie) entity;
    		if(z.isBaby()){
    			z.setBaby(false);
    		}
    	}
    	entity.setCanPickupItems(false);
    	Random r = new Random();
    	int level = r.nextInt(npc.maxLevel-npc.minLevel) + npc.minLevel;
    	int health = calcHealth(level);
    	double damage = 1;
    	if((level/10)>1){
    		damage =level/10 ;
    	}
    	maxHit.put(entity.getUniqueId(),damage);
    	entity.setMaxHealth(health);
    	if(npc.helm!=null){
    		entity.getEquipment().setHelmet(npc.helm);
    	}
    	if(npc.chest!=null){
    		entity.getEquipment().setChestplate(npc.chest);
    	}
    	if(npc.legs!=null){
    		entity.getEquipment().setLeggings(npc.legs);
    	}
    	if(npc.boots!=null){
    		entity.getEquipment().setBoots(npc.boots);
    	}
    	if(npc.hand!=null){
    		entity.getEquipment().setItemInHand(npc.hand);
    	}
    	entity.setHealth(health);
    	Level.put(entity.getUniqueId(), level);
    	xpGained.put(entity.getUniqueId(), npc.xp);
    	mobType.put(entity.getUniqueId(), npc);
    	entity.setCustomName(ChatColor.RED+"["+ChatColor.DARK_RED+level+ChatColor.RED+"]"+ChatColor.GRAY+npc.getName());
    	entity.setCustomNameVisible(true);
    	if(npc.type.equals(Mobs.Dragon)){
    		customMob.put(entity.getUniqueId(), npc);
    	}
    	return entity.getEntityId();
    }
    
    public static void spawnMob(String name, Location l){
    	Mobs npc = getByName(name);
    	if(npc!=null){
	    	LivingEntity entity = (LivingEntity) Bukkit.getWorld("Runescape").spawnEntity(l, npc.type());
	    	if(entity.getType().equals(EntityType.ZOMBIE)){
	    		Zombie z = (Zombie) entity;
	    		if(z.isBaby()){
	    			z.setBaby(false);
	    		}
	    	}
	    	entity.setCanPickupItems(false);
	    	Random r = new Random();
	    	int level = r.nextInt(npc.maxLevel-npc.minLevel) + npc.minLevel;
	    	int health = calcHealth(level);
	    	double damage = 1;
	    	if((level/10)>1){
	    		damage =level/10 ;
	    	}
	    	maxHit.put(entity.getUniqueId(),damage);
	    	entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180067, 5));
	    	entity.setMaxHealth(health);
	    	if(npc.helm!=null){
	    		entity.getEquipment().setHelmet(npc.helm);
	    	}
	    	if(npc.chest!=null){
	    		entity.getEquipment().setChestplate(npc.chest);
	    	}
	    	if(npc.legs!=null){
	    		entity.getEquipment().setLeggings(npc.legs);
	    	}
	    	if(npc.boots!=null){
	    		entity.getEquipment().setBoots(npc.boots);
	    	}
	    	if(npc.hand!=null){
	    		entity.getEquipment().setItemInHand(npc.hand);
	    	}
	    	entity.setHealth(health);
	    	Level.put(entity.getUniqueId(), level);
	    	if(npc.type.equals(Mobs.Dragon)){
	    		customMob.put(entity.getUniqueId(), npc);
	    	}
	    	xpGained.put(entity.getUniqueId(), npc.xp);
	    	entity.setCustomName(ChatColor.RED+"["+ChatColor.DARK_RED+level+ChatColor.RED+"]"+ChatColor.GRAY+npc.getName());
	    	entity.setCustomNameVisible(true);
    	}
    }
    
	public String getName() {
		return name;
	}
}
