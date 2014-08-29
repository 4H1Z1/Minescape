package me.johngreen.com.Functions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import me.johngreen.com.items.Items;

public enum MobDrops {
	Chicken(2,6,Arrays.asList(Items.Bone,Items.RawChicken,Items.Feather),100),
    Cow(2,6,Arrays.asList(Items.Bone,Items.RawBeef,Items.CowHide),100),
    Ram(2,6,Arrays.asList(Items.Bone),100),
    GiantRat(2,6,Arrays.asList(Items.Bone),100),
    DarkWizard(10,15,Arrays.asList(Items.Bone),100),
    Guard(10,15,Arrays.asList(Items.Bone,Items.Platelegs_Iron,Items.Sword_Iron),3),
    
    Spider(2,6,Arrays.asList(Items.Bone),50),
    Man(2,6,Arrays.asList(Items.Bone),50),
    Wizard(4,8,Arrays.asList(Items.Bone),50),
    Goblin(2,6,Arrays.asList(Items.Bone,Items.Platelegs_Bronze,Items.Sword_Bronze,Items.Platebody_Bronze,Items.GoblinMail),3), 
    AlKharidWarrior(4,12,Arrays.asList(Items.Bone,Items.Platelegs_Iron,Items.Sword_Iron),3);
    
	static List<Items> multyDrop =Arrays.asList(Items.Feather);
    public static MobDrops getByName(String name){
    	String name1 = name.toLowerCase();
    	switch(name1){
    		case "alkharid warrior":
    			return MobDrops.AlKharidWarrior;
			case "spider":
				return MobDrops.Spider;
			case "goblin":
				return MobDrops.Goblin;
			case "man":
				return MobDrops.Man;
			case "wizard":
				return MobDrops.Wizard;
			case "chicken":
				return MobDrops.Chicken;
			case "cow":
				return MobDrops.Cow;
			case "ram":
				return MobDrops.Ram;
			case "giant rat":
				return MobDrops.GiantRat;
			case "dark wizard":
				return MobDrops.DarkWizard;
			case "guard":
				return MobDrops.Guard;
    	}
    	return null;
    }
    MobDrops(int minCoins,int maxCoins,List<Items> items,int chance){
    	this.minCoins = minCoins;
    	this.maxCoins = maxCoins;
    	this.chance = chance;
    	this.items = items;
    }
    private List<Items> items;
    private int minCoins;
    private int maxCoins;
    private int chance;
    
    
    public List<Items> getItems(){
    	return items;
    }
    public int getMinCoins(){
    	return minCoins;
    }
    public int getMaxCoins(){
    	return maxCoins;
    }
    public double getChance(){
    	return chance;
    }
    
    public static Inventory items(String mobName,MobDrops drops){
    	Inventory inv = Bukkit.createInventory(null, 9, mobName+" Drops");
    	
    	Random r = new Random();
    	int coins = r.nextInt(drops.getMaxCoins()-drops.getMinCoins()) + drops.getMinCoins();
		while(coins>0){
			if(coins>=1000){
				inv.addItem(Items.LargeGoldPile.generateItem());
				coins = coins-1000;
			}else if(coins>=100){
				inv.addItem(Items.SmallGoldPile.generateItem());
				coins = coins-100;
			}else if(coins>=1){
				inv.addItem(Items.GoldCoin.generateItem());
				coins = coins-1;
			}
		}
		for(Items i:drops.getItems()){
			if(i.getName().contains("Bone")){
				inv.addItem(Items.Bone.generateItem());
			}else{
				if(multyDrop.contains(i)){
					int rand = r.nextInt(100-1)+1;
					if(rand<=drops.getChance()){
						int rand2 = r.nextInt(5-1)+1;
						for(int x = 0;x<rand2;x++){
							inv.addItem(i.generateItem());
						}
					}
				}else{
					int rand = r.nextInt(100-1)+1;
					if(rand<=drops.getChance()){
						inv.addItem(i.generateItem());
					}
				}
				
			}
			
		}
    	return inv;
    }
    
}
