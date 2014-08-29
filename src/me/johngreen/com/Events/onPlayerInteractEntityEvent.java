package me.johngreen.com.Events;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Bank;
import me.johngreen.com.Functions.Core;
import me.johngreen.com.Functions.Guis;
import me.johngreen.com.Functions.NPCChat;
import me.johngreen.com.Functions.Npcs;
import me.johngreen.com.Functions.PlayerInteraction;
import me.johngreen.com.Functions.Shop;
import me.johngreen.com.Functions.Skills;
import me.johngreen.com.Quests.Quests;
import me.johngreen.com.Quests.TuturialIsland;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class onPlayerInteractEntityEvent implements Listener {
    public onPlayerInteractEntityEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }
 private Main plugin;
    @EventHandler(priority = EventPriority.HIGHEST)
    public void highLogin(PlayerInteractEntityEvent e) {
    	//npc's
    	final Player p = e.getPlayer();
    	if(e.getRightClicked() instanceof Player){
    		Player p2 = (Player) e.getRightClicked();
    		PlayerInteraction.Clicked.put(p, p2);
    		Guis.generateGUI(Guis.PlayerInteraction, p);
    	}
    	if(e.getRightClicked() instanceof Villager){
    		boolean quest = false;
    		LivingEntity ent = (LivingEntity) e.getRightClicked();
    		String entName = ChatColor.stripColor(ent.getCustomName());
    		if(Quests.hasQuest(p, entName)){
    			quest=true;
    		}
    		String message = Npcs.npcChat(entName);
    		
    		if(entName.equals(Npcs.Banker.name())){
    	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    	        {
    	          public void run()
    	          {
    	        	  Bank.openPage(p, 1);
    	          }
    	        }, 2L);
    			
    		}
    		if(entName.equals(Npcs.SwordShopKeeper.name())||entName.equals(Npcs.SwordShopAssistant.name())){
    	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    	        {
    	          public void run()
    	          {
    	        	  Shop.spawnShop(Shop.VarockSwordshop, p);
    	          }
    	        }, 2L);
    		}
    		if(entName.equals(Npcs.Bob.name())){
    	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    	        {
    	          public void run()
    	          {
    	        	  Shop.spawnShop(Shop.BobsAxes, p);
    	          }
    	        }, 2L);
    		}
    		if(entName.equals(Npcs.Hank.name())){
    	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    	        {
    	          public void run()
    	          {
    	        	  Shop.spawnShop(Shop.HanksFishingSupplys, p);
    	          }
    	        }, 2L);
    		}
    		if(entName.equals(Npcs.Zeke.name())){
    	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    	        {
    	          public void run()
    	          {
    	        	  Shop.spawnShop(Shop.ZekesShop, p);
    	          }
    	        }, 2L);
    		}
    		 if(entName.equals(Npcs.JamesBlond.name())){
                 quest=true;
                 
                 if(TuturialIsland.JamesBlond.get(p)==null){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Welcome "+p.getDisplayName()+" To the world of Runescape");
                	 TuturialIsland.JamesBlond.put(p, 1);
                 }else if(TuturialIsland.JamesBlond.get(p)==1){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"as you progress through this tuturial you will learn the basic skills you need to survive!");
                	 TuturialIsland.JamesBlond.put(p, 2);
                 }else if(TuturialIsland.JamesBlond.get(p)==2){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Firstly, to talk to a npc in the game you just have to right click on them");
                	 TuturialIsland.JamesBlond.put(p, 3);
                 }else if(TuturialIsland.JamesBlond.get(p)==3){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Seccondly, You will see there is 5 items in your hotbar");
                	 TuturialIsland.JamesBlond.put(p, 4);
                 }else if(TuturialIsland.JamesBlond.get(p)==4){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Theses items open a veriaty of GUI's that will help you with your adventure (Click keys 5-9 to open them)");
                	 TuturialIsland.JamesBlond.put(p, 5);
                 }else if(TuturialIsland.JamesBlond.get(p)==5){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Now to get started!, Take this Bronze Hatchet");
                	 TuturialIsland.JamesBlond.put(p, 6);
                	 p.getInventory().addItem(Items.Bronze_Hatchet.generateItem());
                 }else if(TuturialIsland.JamesBlond.get(p)==6){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"now to use it you just have to right click on a tree to begin the wood cutting prosess");
                	 TuturialIsland.JamesBlond.put(p, 7);
                 }else if(TuturialIsland.JamesBlond.get(p)==7){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Now you understand that, can you chop 5 Logs, I shall reward you for the help");
                	 TuturialIsland.JamesBlond.put(p, 8);
                 }else if(TuturialIsland.JamesBlond.get(p)==8){
                	 int count = 0;
                     for(ItemStack item:p.getInventory().getContents()){
                             if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains(ChatColor.GREEN+"Log")){
                                     count++;
                             }
                     }
                     if(count>=5){
                    	 	NPCChat.sendMessage(p, Npcs.getByName(entName),"Thank you for getting me the Logs, here is a reward! 100 Woodcutting XP and 30 gold!");
                             TuturialIsland.JamesBlond.put(p, 9);
                             ItemStack gold = Items.GoldCoin.generateItem();
                             gold.setAmount(30);
                             p.getInventory().addItem(gold);
                             Skills.Woodcutting.setXP(100, p);
                     }else{
                    	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You need to collect "+(5-count)+" more Logs");
                     }
                 }else if(TuturialIsland.JamesBlond.get(p)==9){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You can now continue onto the next instructor "+ChatColor.YELLOW+Npcs.FishEyeJoe.name());
                 }
         }
    		 
    		 
    		 
         if(entName.equals(Npcs.FishEyeJoe.name())){
                 quest=true;
                 if(TuturialIsland.FishEyeJoe.get(p)==null){
                	 	NPCChat.sendMessage(p, Npcs.getByName(entName),"Hello, Welcome to your basic fishing lesson!");
                        TuturialIsland.FishEyeJoe.put(p, 1);
                 }else if(TuturialIsland.FishEyeJoe.get(p)==1){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Here is a fishing net, to use it you only have to click onto a body of water and wait till a fish wiggles its way in!");
                         p.getInventory().addItem(Items.Net.generateItem());
                         TuturialIsland.FishEyeJoe.put(p, 2);
                 }else if(TuturialIsland.FishEyeJoe.get(p)==2){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Now, to see if you remembered what I said collect "+ChatColor.YELLOW+"3 Shrimp");
                         TuturialIsland.FishEyeJoe.put(p, 3);
                 }else if(TuturialIsland.FishEyeJoe.get(p)==3){
                         int count = 0;
                         for(ItemStack item:p.getInventory().getContents()){
                                 if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains(ChatColor.GREEN+"Raw Shrimp")){
                                         count++;
                                 }
                         }
                         if(count>=3){
                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Thank you for getting me the Fish, here is a reward! 100 Fishing XP and 20 gold!");
                                 TuturialIsland.FishEyeJoe.put(p, 4);
                                 ItemStack gold = Items.GoldCoin.generateItem();
                                 gold.setAmount(20);
                                 p.getInventory().addItem(gold);
                                 Skills.Fishing.setXP(100, p);
                         }else{
                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You need to collect "+(3-count)+" more Shrimp");
                         }
                 }else if(TuturialIsland.FishEyeJoe.get(p)==4){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Now you have the fish you are able to cook it on a bonfire");
                	 TuturialIsland.FishEyeJoe.put(p, 5);
                 }else if(TuturialIsland.FishEyeJoe.get(p)==5){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"To make a bonfire, you need to make sure you have a Log in your inventory.");
                	 TuturialIsland.FishEyeJoe.put(p, 6);
                 }else if(TuturialIsland.FishEyeJoe.get(p)==6){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Then you need to make the fire by clicking on the floor with a tinderbox");
                	 p.getInventory().addItem(Items.TinderBox.generateItem());
                	 TuturialIsland.FishEyeJoe.put(p, 7);
                 }else if(TuturialIsland.FishEyeJoe.get(p)==7){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Then all you need to do is click on the fire and cook up some lovely Shrimp");
                	 TuturialIsland.FishEyeJoe.put(p, 8);
                 }else if(TuturialIsland.FishEyeJoe.get(p)==8){
                	 
                	 
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You can now continue onto the next instructor "+ChatColor.YELLOW+Npcs.Smithy.name());
                 }
         }
         if(entName.equals(Npcs.Smithy.name())){
                 quest=true;
                 if(TuturialIsland.Smithy.get(p)==null){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Welcome, My name is George or Smithy as my friends call me, i am here to teach you the age old skills of mining and smithing!");
                         TuturialIsland.Smithy.put(p, 1);
                 }else if(TuturialIsland.Smithy.get(p)==1){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"But we cant have you hitting ores with your hands now can we? Here is a "+ChatColor.YELLOW+"Bronze Pickaxe"+ChatColor.GREEN+" to help you get started");
                         TuturialIsland.Smithy.put(p, 2);
                         p.getInventory().addItem(Items.Bronze_Pickaxe.generateItem());
                 }else if(TuturialIsland.Smithy.get(p)==2){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"When Smithing some bars need more then one ingredient to make them, so getting an equal amount of them on mining trips is the key");
                         TuturialIsland.Smithy.put(p, 3);
                 }else if(TuturialIsland.Smithy.get(p)==3){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Now to get started, please mine 1X Copper ore and 1X Tin ore (Right click to start mining)");
                         TuturialIsland.Smithy.put(p, 4);
                 }else if(TuturialIsland.Smithy.get(p)==4){
                         int count1 = 0;
                         int count2 = 0;
                         for(ItemStack item:p.getInventory().getContents()){
                                 if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains(ChatColor.GREEN+"Copper Ore")){
                                         count1++;
                                 }else if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains(ChatColor.GREEN+"Tin Ore")){
                                         count2++;
                                 }
                         }
                         if(count1>=1&&count2>=1){
                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Well done! now to make weapons from it you first need to make a bronze bar, to do this click on a furnace and select the bronze bar!");
                                         TuturialIsland.Smithy.put(p, 5);
                                 }else{
                                         if(count1<1){
                                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You need 1X Copper Ore");
                                         }
                                         if(count2<1){
                                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You need 1X Tin Ore");
                                         }
                                 }
                 }else if(TuturialIsland.Smithy.get(p)==5){
                         int count1 = 0;
                         for(ItemStack item:p.getInventory().getContents()){
                                 if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains(ChatColor.GREEN+"Bronze Bar")){
                                         count1++;
                                 }
                         }
                         if(count1>=1){
                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Well done, maybe there is hope for you yet, now you need to smith it into a Bronze Dagger, to do this click on the anvil and select bronze sword");
                                         TuturialIsland.Smithy.put(p, 6);
                                 }else{
                                         if(count1>=1){
                                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You need to smith a bronze bar in the furnace!");
                                         }
                                 }
                 }else if(TuturialIsland.Smithy.get(p)==6){
                         int count1 = 0;
                         for(ItemStack item:p.getInventory().getContents()){
                                 if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains(ChatColor.GREEN+"Bronze Dagger")){
                                         count1++;
                                 }
                         }
                         if(count1>=1){
                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Well done, here is a reward for your efforts!");
                                         TuturialIsland.Smithy.put(p, 7);
                                         Skills.Mining.setXP(100, p);
                                         Skills.Smithing.setXP(100, p);
                                 }else{
                                         if(count1>=1){
                                        	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You need to smith a bronze bar into a sword!");
                                         }
                                 }
                 }else if(TuturialIsland.Smithy.get(p)==7){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"You can now continue onto the next instructor "+ChatColor.YELLOW+Npcs.KnightAlbert.name());
                 }
         }
         if(entName.equals(Npcs.FatherPaul.name())){
                 quest=true;
                 if(TuturialIsland.FatherPaul.get(p)==null){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Prayer is a very powerful skill when it comes to fighting monsters and players");
                         TuturialIsland.FatherPaul.put(p, 1);
                 }else if(TuturialIsland.FatherPaul.get(p)==1){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"it gives you the ability to boost specific stats for a short period of time");
                         TuturialIsland.FatherPaul.put(p, 2);
                 }else if(TuturialIsland.FatherPaul.get(p)==2    ){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"To gain XP in this skill you need to bury the bones of those you kill");
                         TuturialIsland.FatherPaul.put(p, 3);
                 }else if(TuturialIsland.FatherPaul.get(p)==3){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"by doing this you are showing the gods that you care about the dead just as much as the living and they will reward you with the powers");
                     TuturialIsland.FatherPaul.put(p, 4);
	             }else if(TuturialIsland.FatherPaul.get(p)==4){
	            	 NPCChat.sendMessage(p, Npcs.getByName(entName),"To access the prayer menu Press '8' on your keyboard");
	             }
         }
         if(entName.equals(Npcs.KnightAlbert.name())){
                 quest=true;
                 if(TuturialIsland.KnightAlbert.get(p)==null){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"Hello adventurer, the basics of fighting is very simple");
                     TuturialIsland.KnightAlbert.put(p, 1);
                 }else if(TuturialIsland.KnightAlbert.get(p)==1){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"the amount of damage you do depends on the weapon you use and your attack level combined");
                     TuturialIsland.KnightAlbert.put(p, 2);
                 }else if(TuturialIsland.KnightAlbert.get(p)==2){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"to test this, fight some of those Giant Rats over there!");
                     TuturialIsland.KnightAlbert.put(p, 3);
                 }else if(TuturialIsland.KnightAlbert.get(p)==3){
                	 NPCChat.sendMessage(p, Npcs.getByName(entName),"After ypu fight some you can head over to "+ChatColor.YELLOW+Npcs.FatherPaul.name());
                 }
         }
    		if(entName.equals(Npcs.Skippy.name())){
    			p.teleport(Bukkit.getWorld("Runescape").getSpawnLocation());
    		}
    		if(entName.equals(Npcs.ShopAssistant.name())||entName.equals(Npcs.ShopKeeper.name())){
    	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    	        {
    	          public void run()
    	          {
    	        	  Shop.spawnShop(Shop.GeneralStore, p);
    	          }
    	        }, 2L);
    		}
    		if(message!=null&&quest==false){
    			NPCChat.sendMessage(p, Npcs.getByName(entName),message);
    		}
    	}
    }
}
