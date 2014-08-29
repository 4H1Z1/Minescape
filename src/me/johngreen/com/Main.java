package me.johngreen.com;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.johngreen.com.Events.EnityTargetEvent;
import me.johngreen.com.Events.LoginEvent;
import me.johngreen.com.Events.EntityDamagedByEntity;
import me.johngreen.com.Events.onChatEvent;
import me.johngreen.com.Events.onChunkLoad;
import me.johngreen.com.Events.onCreatureSpawnEvent;
import me.johngreen.com.Events.onEntityChangeBlockEvent;
import me.johngreen.com.Events.onEntityDeathEvent;
import me.johngreen.com.Events.onEntityRegainHealthEvent;
import me.johngreen.com.Events.onEntityTakingDamage;
import me.johngreen.com.Events.onInventoryClickEvent;
import me.johngreen.com.Events.onInventoryCloseEvent;
import me.johngreen.com.Events.onItemSpawn;
import me.johngreen.com.Events.onOpenInventoryEvent;
import me.johngreen.com.Events.onPlayerDeathEvent;
import me.johngreen.com.Events.onPlayerFishEvent;
import me.johngreen.com.Events.onPlayerInteract;
import me.johngreen.com.Events.onPlayerInteractEntityEvent;
import me.johngreen.com.Events.onPlayerItemBreakEvent;
import me.johngreen.com.Events.onPlayerItemHeldEvent;
import me.johngreen.com.Events.onPlayerMove;
import me.johngreen.com.Events.onPlayerPickupItemEvent;
import me.johngreen.com.Events.onPrepareItemCraftEvent;
import me.johngreen.com.Events.onProjectileHitEvent;
import me.johngreen.com.Events.onRespawnEvent;
import me.johngreen.com.Functions.Core;
import me.johngreen.com.Functions.DeathSign;
import me.johngreen.com.Functions.Eco;
import me.johngreen.com.Functions.Guis;
import me.johngreen.com.Functions.Mobs;
import me.johngreen.com.Functions.NPCChat;
import me.johngreen.com.Functions.Npcs;
import me.johngreen.com.Functions.PlayerInteraction;
import me.johngreen.com.Functions.Skills;
import me.johngreen.com.Functions.Trading;
import me.johngreen.com.Quests.Quests;
import me.johngreen.com.items.InventoryHandler;
import me.johngreen.com.items.Items;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import cosine.boseconomy.BOSEconomy;

public final class Main extends JavaPlugin implements Listener{
	
	private static String MOTD = ChatColor.GREEN+"Welcome "+ChatColor.LIGHT_PURPLE+"%player%"+ChatColor.GREEN+", to the world of Runescape!\n"+ChatColor.LIGHT_PURPLE+"Hover over for server stats-------------^";
	private static String MOTDDefault = ChatColor.GREEN+"Welcome newcomer to the world of Runescape!\n"+ChatColor.LIGHT_PURPLE+"Hover over for server stats-------------^";
	private static String[] ServerMessages = {

	    "We are in beta! So there might be a few bugs here and there but message a admin or send the developer a message and he will fix it!",
	    "All skills are setup excluding Magic, Runecrafting and Cooking, these skills are still under development!",
	    "We would love to here what you think about the server so drop us a message in-game or on our website! http://goo.gl/UHFDqg",
	   "When trading with other players you can trade money by typing /withdraw [amount] and giving them the physical money in the trade menu!",
	    "We are aiming to get 1 new quest out every 1-2 days!",
	    "We still need staff! We need people to fill specific roles to help us make this server amazing and those people are; Script writers for quests and npcs, Graphics designers for npc faces and for the texture pack and builders! if you feel like you are up for this send the project manager a message on Skype at @mythirdleg35",

};
	private int SPAWN_MOB_TYPE = 1;
	  static File levelconf;
	  public static FileConfiguration levelconfig;
	  static File questconf;
	  public static FileConfiguration questconfig;
	  static File playerconf;
	  public static FileConfiguration playerconfig;
	  static File mobconf;
	  public static FileConfiguration mobconfig;
	  static File bankconf;
	  public static FileConfiguration bankconfig;
	public static ProtocolManager protocolManager;
	 public static BOSEconomy economy = null;
	 
	 private static int mobSpawnerCount = 0;
	 private static int downMobSpawnerCount = 0;
	 
	public void onLoad() {
	    protocolManager = ProtocolLibrary.getProtocolManager();
	}
    @Override
    public void onEnable() {
    	
    	for(World w:Bukkit.getServer().getWorlds()){
			for(Entity e : w.getEntities()) {
				if(!Npcs.npcs.contains(e.getUniqueId())){
					e.remove();
				}
			}
		}
    	new NPCChat(this);
    	loadBOSEconomy();
    	if (playerconf == null) {
    		playerconf = new File(getDataFolder(), "Player.yml");
		}
    	playerconfig = YamlConfiguration.loadConfiguration(playerconf);
		savePlayerConfig();
		if (levelconf == null) {
			levelconf = new File(getDataFolder(), "Levels.yml");
		}
		levelconfig = YamlConfiguration.loadConfiguration(levelconf);
		saveLevelConfig();
		if (bankconf == null) {
			bankconf = new File(getDataFolder(), "Banks.yml");
		}
		bankconfig = YamlConfiguration.loadConfiguration(bankconf);
		saveBankConfig();
		if (mobconf == null) {
			mobconf = new File(getDataFolder(), "Mobs.yml");
		}
		mobconfig = YamlConfiguration.loadConfiguration(mobconf);
		saveMobConfig();
		
		if (questconf == null) {
			questconf = new File(getDataFolder(), "Quest.yml");
		}
		questconfig = YamlConfiguration.loadConfiguration(questconf);
		saveQuestConfig();
		
		new onEntityRegainHealthEvent(this);
    	new LoginEvent(this);
    	new EnityTargetEvent(this);
    	new EntityDamagedByEntity(this);
    	new onInventoryClickEvent(this);
    	new onPlayerItemHeldEvent(this);
    	new onPlayerDeathEvent(this);
    	new onEntityTakingDamage(this);
    	new onCreatureSpawnEvent(this);
    	new onPlayerInteract(this);
    	new onOpenInventoryEvent(this);
    	new onPlayerInteractEntityEvent(this);
    	new onPlayerMove(this);
    	new onEntityDeathEvent(this);
    	new onChatEvent(this);
    	new onInventoryCloseEvent(this);
    	new onChunkLoad(this);
    	new onEntityChangeBlockEvent(this);
    	new onPlayerItemBreakEvent(this);
    	new onItemSpawn(this);
    	new onPlayerPickupItemEvent(this);
    	new onProjectileHitEvent(this);
    	new onPlayerFishEvent(this);
    	new onPrepareItemCraftEvent(this);
    	new onRespawnEvent(this);
    	
    	
    	
    	getServer().clearRecipes();
    	
		final List<Location> locat = new ArrayList<Location>();
		final List<Mobs> mobType = new ArrayList<Mobs>();
		
		for(int i =1;i<mobconfig.getInt("Count");i++){
			Mobs mob = Mobs.getByName(mobconfig.getString("MobSpawner."+i+".Type"));
			if(mob!=null){
				Location l = new Location(Bukkit.getServer().getWorld(mobconfig.getString("MobSpawner."+i+".World")), mobconfig.getInt("MobSpawner."+i+".X"), mobconfig.getInt("MobSpawner."+i+".Y"), mobconfig.getInt("MobSpawner."+i+".Z"));
				locat.add(l);
				mobType.add(Mobs.getByName(mobconfig.getString("MobSpawner."+i+".Type")));
				mobSpawnerCount++;
			}else{
				System.out.println("Error Spawning mobs "+i);
				downMobSpawnerCount++;
			}
		}
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
          public void run()
          {
      			List<LivingEntity> le = Bukkit.getServer().getWorld("Runescape").getLivingEntities();
      			for(int i = 0;i<Mobs.mobs.size();i++){
      				List<Integer> id = new ArrayList<Integer>();
      				for(int x = 0;x<Mobs.mobs.get(i).size();x++){
      					for(LivingEntity moba:le){
      						if(moba.getEntityId()==Mobs.mobs.get(i).get(x)){
      							id.add(moba.getEntityId());
      						}
      					}
      				}
      				Mobs.mobs.put(i, id);
      			}
      			for(int i = 0; i<locat.size();i++){
      				if(Bukkit.getServer().getWorld("Runescape").getChunkAt(locat.get(i))!=null){
      					if(Bukkit.getServer().getWorld("Runescape").getChunkAt(locat.get(i)).isLoaded()){
      						
      						if(Mobs.mobs.get(i)==null){
      							List<Integer> id = new ArrayList<Integer>();
      							id.add(Mobs.spawnMobID(mobType.get(i), locat.get(i)));
      							Mobs.mobs.put(i, id);
      						}else if(Mobs.mobs.get(i).size()<5){
      							
      							
      							List<Integer> ids = new ArrayList<Integer>();
      							ids.add(Mobs.spawnMobID(mobType.get(i), locat.get(i)));
      							ids.addAll(Mobs.mobs.get(i));
      							Mobs.mobs.put(i, ids);
      						}
      					}
      				}
      			}
      		
      	
          }
        }, 0L, 300L);
    	
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
          public void run()
          {
        	 Random r = new Random();
        	 Bukkit.broadcastMessage(ChatColor.GREEN+"[Server] "+ChatColor.LIGHT_PURPLE+ServerMessages[r.nextInt(ServerMessages.length)]);
          }
        }, 0L, 4800L);
    	
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
          public void run()
          {
        	  
        	  //clear npcs
            for (UUID npc:Npcs.npcs)
            {
              for(World w:Bukkit.getWorlds()){
            	  for(Entity e:w.getEntities()){
            		  if(e.getUniqueId()==npc){
            			  e.remove();
            			  break;
            		  }
            	  }
              }
            }
            Npcs.npcs.clear();
            Npcs.loadWorldNpcs();
          }
        }, 0L, 200L);
        
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
          public void run()
          {
            for (World w : Bukkit.getServer().getWorlds())
            {
              w.setTime(0L);
              w.setWeatherDuration(1000000);
            }
          }
        }, 0L, 10000L);
        
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
          public void run()
          {
            for (World w : Bukkit.getServer().getWorlds())
            {
              for(Player p: Bukkit.getServer().getWorld(w.getName()).getPlayers()){
            	  p.setFoodLevel(20);
            	  Core.reloadToolbar(p);
            	  int level = Skills.Defence.getLevel(p);
            	  if(p.getInventory().getHelmet() != null){
            		  if(p.getInventory().getHelmet().hasItemMeta()&&p.getInventory().getHelmet().getItemMeta().hasDisplayName()){
	            		  switch(p.getInventory().getHelmet().getItemMeta().getDisplayName()){
		    				case "Red partyhat":
			    				break;
			    			case "Blue partyhat":
			    				break;
		    				case "White partyhat":
			    				break;
			    			case "Green partyhat":
			    				break;
		    				case "Yellow partyhat":
			    				break;
			    			case "Purple partyhat":
			    				break;
		    				case "Bronze MediumHelmet":
			    				break;
			    			case "Bronze FullHelmet":
			    				break;
		    				case "Iron MediumHelmet":
		    					if(!(level>=10)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Iron FullHelmet":
		    					if(!(level>=10)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Steel MediumHelmet":
		    					if(!(level>=20)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Steel FullHelmet":
		    					if(!(level>=20)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Mithrill MediumHelmet":
		    					if(!(level>=30)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Mithrill FullHelmet":
		    					if(!(level>=30)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Adamantite MediumHelmet":
		    					if(!(level>=40)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Adamantite FullHelmet":
		    					if(!(level>=40)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Rune MediumHelmet":
		    					if(!(level>=50)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Rune FullHelmet":
		    					if(!(level>=50)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this Helmet!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getHelmet());
		    				    		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			default:
			    				
			    				break;
		    			}
	            	  }
            	  }
            	  if(p.getInventory().getChestplate() != null){

            		  if(p.getInventory().getChestplate().hasItemMeta()&&p.getInventory().getChestplate().getItemMeta().hasDisplayName()){
	            		  switch(p.getInventory().getChestplate().getItemMeta().getDisplayName()){
		    				case "Bronze Chainbody":
			    				break;
			    			case "Bronze Chestplate":
			    				break;
		    				case "Iron Chainbody":
		    					if(!(level>=10)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Iron Chestplate":
		    					if(!(level>=10)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Steel Chainbody":
		    					if(!(level>=20)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Steel Chestplate":
		    					if(!(level>=20)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Mithrill Chainbody":
		    					if(!(level>=30)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Mithrill Chestplate":
		    					if(!(level>=30)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Adamantite Chainbody":
		    					if(!(level>=40)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Adamantite Chestplate":
		    					if(!(level>=40)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Rune Chainbody":
		    					if(!(level>=50)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Rune Chestplate":
		    					if(!(level>=50)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this Chestplate!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getChestplate());
		    				    		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			default:
			    				
			    				break;
		    			}
	            	  }
            	  
            	  }
            	  if(p.getInventory().getLeggings() != null){
            		  
            		  if(p.getInventory().getLeggings().hasItemMeta()&&p.getInventory().getLeggings().getItemMeta().hasDisplayName()){
	            		  switch(p.getInventory().getLeggings().getItemMeta().getDisplayName()){
		    				case "Bronze Plateskirt":
			    				break;
			    			case "Bronze Platelegs":
			    				break;
		    				case "Iron Plateskirt":
		    					if(!(level>=10)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Iron Platelegs":
		    					if(!(level>=10)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 10 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Steel Plateskirt":
		    					if(!(level>=20)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Steel Platelegs":
		    					if(!(level>=20)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 20 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Mithrill Plateskirt":
		    					if(!(level>=30)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Mithrill Platelegs":
		    					if(!(level>=30)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 30 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
		    				case "Adamantite Plateskirt":
		    					if(!(level>=40)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Adamantite Platelegs":
		    					if(!(level>=40)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 40 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Rune Plateskirt":
		    					if(!(level>=50)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			case "Rune Platelegs":
		    					if(!(level>=50)){
		    						p.sendMessage(ChatColor.RED+"You need to have level 50 in defence to use this Leggings!");
		    						if(InventoryHandler.hasSpace(p)){
		    				    		p.getInventory().addItem(p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}else{
		    				    		Bukkit.getWorld(p.getWorld().getName()).dropItem(p.getLocation(), p.getInventory().getLeggings());
		    				    		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    				    	}
		    					}
			    				break;
			    			default:
			    				
			    				break;
		    			}
	            	  }
            	  
            	  }
            	  if(p.getInventory().getBoots() != null){
            		  
            	  }
              }
            }
          }
        }, 0L, 15L);
       /* protocolManager.addPacketListener(
                new PacketAdapter(this, ListenerPriority.NORMAL,
                        PacketType.Play.Server.SPAWN_ENTITY_LIVING,PacketType.Play.Server.ENTITY_METADATA) {
                    @Override
                    public void onPacketSending(PacketEvent event) {
                    	PacketContainer packet = event.getPacket();
                    	if (event.getPacketType().getCurrentId() == PacketType.Play.Server.SPAWN_ENTITY_LIVING.getCurrentId()) {
                    		final Entity entity = packet.getEntityModifier(event.getPlayer().getWorld()).read(0);
                    		if(Mobs.customMob.containsKey(entity.getUniqueId())){
                    			Bukkit.broadcastMessage("got meta data "+Mobs.customMob.get(entity.getUniqueId()));
                    			switch(Mobs.customMob.get(entity.getUniqueId()).toString()){
                    			case "Cow":
                    				MobSpawn(event.getPacket(),"Cow");
                    				break;
                    			}
                    			
                    		}else{
                    			Bukkit.broadcastMessage("got meta data");
                    		}
                    		
                        } else {
                        	//Bukkit.broadcastMessage("spawned mob");
                        }
                    }
            });*/
        
        // Listeners
        getServer().getPluginManager().registerEvents(this, this);
        
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, Arrays.asList(new PacketType[] { PacketType.Status.Server.OUT_SERVER_INFO }), new ListenerOptions[] { ListenerOptions.ASYNC })
        {
          public void onPacketSending(PacketEvent e)
          {
            WrappedServerPing ping = (WrappedServerPing)e.getPacket().getServerPings().read(0);
            InetAddress address = e.getPlayer().getAddress().getAddress();
            List<String> playerMessage = new ArrayList<>();
            playerMessage.add(ChatColor.BLUE+"   Welcome to the world of Runescape!   ");
            playerMessage.add("");
            playerMessage.add(ChatColor.YELLOW+"   We dont like to keep secrets from    ");
            playerMessage.add(ChatColor.YELLOW+"      our players so here are some      ");
            playerMessage.add(ChatColor.YELLOW+"  current server stats before you join! ");
            playerMessage.add("");
            playerMessage.add(ChatColor.GREEN+"          Mob Count:"+ChatColor.YELLOW+"%mobstats%");
            playerMessage.add(ChatColor.GREEN+"          Mob Spawner Count:"+ChatColor.YELLOW+"%alivespawner%");
            playerMessage.add(ChatColor.GREEN+"          Mob Spawners Being Fixed:"+ChatColor.YELLOW+"%deadspawner%");
            playerMessage.add(ChatColor.GREEN+"          Npc Count:"+ChatColor.YELLOW+"%npcstats%");
            playerMessage.add(ChatColor.GREEN+"          Quest Count:"+ChatColor.YELLOW+"%queststats%");
            playerMessage.add(ChatColor.GREEN+"          Custom Items Count:"+ChatColor.YELLOW+"%itemsstats%");
            ping.setPlayers(getPlayersMOTDMessage(playerMessage, address));
            ping.setMotD(createMOTD(MOTD,address.toString().replaceFirst("/", "").replace(".", "-")));
            System.out.println(address.toString().replaceFirst("/", "").replace(".", "-"));
          }
        });
        
        
        protocolManager.addPacketListener(
                new PacketAdapter(this, ListenerPriority.NORMAL,
                        PacketType.Play.Server.CHAT) {
          public void onPacketSending(PacketEvent e)
          {
        	if(e.getPlayer() != null){
        		
        	}
          }
        });
        Npcs.loadWorldNpcs();
        
    }
    protected String createMOTD(String MOTD, String address) {
    	if(playerconfig.getString(address)!=null){
	    	String motd = MOTD;
	    	if (MOTD.toLowerCase().contains("%player%".toLowerCase())) {
	    		motd = motd.replace("%player%", playerconfig.getString(address));
	    		motd = motd.replace("%mobstats%", "MobCount:"+(mobSpawnerCount*5));
	    		return motd;
	    	}else{
	    		return MOTDDefault;
	    	}
    	}
		return MOTDDefault;
	}
    private static String generateText(String text){
    	String text2 = text;
    	text2 = text2.replace("%npcstats%", ""+Npcs.npcs.size());
    	text2 = text2.replace("%queststats%", ""+Quests.values().length);
    	text2 = text2.replace("%itemsstats%", ""+Items.values().length);

    	text2 = text2.replace("%mobstats%", ""+(mobSpawnerCount*5));
    	text2 = text2.replace("%deadspawner%", ""+downMobSpawnerCount);
    	text2 = text2.replace("%alivespawner%", ""+mobSpawnerCount);
    	return text2;
    }
    public static List<WrappedGameProfile> getPlayersMOTDMessage(List<String> msgs, InetAddress address)
    {
      List<WrappedGameProfile> output = new ArrayList();
      for (String msg : msgs) {
        output.add(new WrappedGameProfile("1", generateText(msg)));
      }
      return output;
    }
	@Override
    public void onDisable() {
    	
    }
	private void MobSpawn(PacketContainer packet,String mobType) {
    	StructureModifier<Integer> ints = packet.getIntegers();
        StructureModifier<WrappedDataWatcher> watchers = packet.getDataWatcherModifier();
        
        Integer originalType = ints.read(SPAWN_MOB_TYPE);
        Integer translatedType =  ints.read(SPAWN_MOB_TYPE);
        switch(mobType){
        case "Dragon":
        	translatedType = 63;
        	break;
        case "Cow":
        	translatedType = (int) EntityType.COW.getTypeId();
        	break;
        }
        EntityType type = EntityType.fromId(originalType);
        Bukkit.broadcastMessage(type+"");
        
        if (originalType != translatedType) {
            WrappedDataWatcher watcher = watchers.read(0);
            
            // Change the mob type
            ints.write(SPAWN_MOB_TYPE, translatedType);
        }
    }
    @SuppressWarnings("unused")
	private void processDatawatcher(EntityType type, WrappedDataWatcher watcher) {
        // Ensure that we're sending the correct data type
        if (type == EntityType.CHICKEN)
            setNewObject(watcher, 12, watcher.getInteger(12).byteValue());
        else if (type == EntityType.ZOMBIE)
            setNewObject(watcher, 12, watcher.getByte(12).intValue());
    }
    private void setNewObject(WrappedDataWatcher watcher, int index, Object value) {
        watcher.removeObject(index);
        watcher.setObject(index, value);
    }
    public static void saveQuestConfig()
    {
      if (questconfig != null) {}
      try
      {
    	  questconfig.save(questconf);
      }
      catch (IOException e)
      {
        System.out.println("[NPCbanker] Unable to Save Config.");
      }
    }
    public static void saveLevelConfig()
    {
      if (levelconfig != null) {}
      try
      {
        levelconfig.save(levelconf);
      }
      catch (IOException e)
      {
        System.out.println("[NPCbanker] Unable to Save Config.");
      }
    }
    public static void savePlayerConfig()
    {
      if (playerconfig != null) {}
      try
      {
    	  playerconfig.save(playerconf);
      }
      catch (IOException e)
      {
        System.out.println("[NPCbanker] Unable to Save Config.");
      }
    }
    public static void saveBankConfig()
    {
      if (bankconfig != null) {}
      try
      {
        bankconfig.save(bankconf);
      }
      catch (IOException e)
      {
        System.out.println("[NPCbanker] Unable to Save Config.");
      }
    }
    public static void saveMobConfig()
    {
      if (mobconfig != null) {}
      try
      {
    	  mobconfig.save(mobconf);
      }
      catch (IOException e)
      {
        System.out.println("[NPCbanker] Unable to Save Config.");
      }
    }
    
    
    public static void ook(){
    	int i=0;
    	switch(i){
    	case 50:
    		//creeper
    		break;
    	case 51:
    		//skelinton
    		break;
    	case 52:
    		//spider
    		break;
    	case 53:
    		//giant
    		break;
    	case 55:
    		//slime
    		break;
    	case 56:
    		//ghast
    		break;
    	case 58:
    		//endermen
    		break;
    	case 59:
    		//cavespider
    		break;
    	case 60:
    		//silverfish
    		break;
    	case 61:
    		//blaze
    		break;
    	case 62:
    		//magma cube
    		break;
    	case 63:
    		//enderdragon
    		break;
    	}
    }
    
    
    
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			Location l = p.getLocation();
			
			if(cmd.getName().equalsIgnoreCase("createnpc")){
				if(p.isOp()){
					if(args.length==0){
						p.sendMessage("usage /createnpc [name]");
					}else if(args.length>0){
						System.out.println("spawnNPC(\""+args[0]+"\", new Location(Bukkit.getWorld(\"Runescape\"), "+p.getLocation().getX()+", "+p.getLocation().getY()+",  "+p.getLocation().getZ()+"));");
					}
				}
			}
			if(cmd.getName().equalsIgnoreCase("createmob")){
				if(p.isOp()){
					if(args.length==0){
						p.sendMessage("usage /createmob [name]");
					}else if(args.length>0){
						int mobscount = mobconfig.getInt("Count");
						mobconfig.set("Count", (mobscount+1));
						mobconfig.set("MobSpawner."+(mobscount+1)+".X", l.getX());
						mobconfig.set("MobSpawner."+(mobscount+1)+".Y", l.getY());
						mobconfig.set("MobSpawner."+(mobscount+1)+".Z", l.getZ());
						mobconfig.set("MobSpawner."+(mobscount+1)+".World", l.getWorld().getName());
						mobconfig.set("MobSpawner."+(mobscount+1)+".Type", args[0]);
						saveMobConfig();
					}
				}
			}
			if(cmd.getName().equalsIgnoreCase("withdraw")){
				if(args.length==0){
					p.sendMessage("usage /withdraw [amount]");
				}else if(args.length>0){
					int amount = Integer.parseInt(args[0]);
					if(Eco.hasEnoughMoney(amount, p)){
						Eco.removeFunds(p, amount);
						while(amount>0){
							if(amount>=1000){
								p.getInventory().addItem(Items.LargeGoldPile.generateItem());
								amount = amount-1000;
							}else if(amount>=100){
								p.getInventory().addItem(Items.SmallGoldPile.generateItem());
								amount = amount-100;
							}else if(amount>=1){
								p.getInventory().addItem(Items.GoldCoin.generateItem());
								amount = amount-1;
							}
						}
					}
				}
			}
			if(cmd.getName().equalsIgnoreCase("acceptfight")){
				if(args.length>0){
					for(Player p2:Bukkit.getServer().getWorld("Runescape").getPlayers()){
						if(p2.getDisplayName().equals(args[0])){
							if(PlayerInteraction.Chanlenged.containsKey(p2)){
								PlayerInteraction.figting.put(p2, p);
								PlayerInteraction.Chanlenged.remove(p2);
								p2.sendMessage(p.getDisplayName()+" has accepted your fight!");
								p2.sendMessage("Let the fight begin");
								p.sendMessage("Let the fight begin");
							}else{
								p.sendMessage("This link is no longer valid");
							}
							break;
						}
					}
				}
			}
			if(cmd.getName().equalsIgnoreCase("denyfight")){
				if(args.length>0){
					for(Player p2:Bukkit.getServer().getWorld("Runescape").getPlayers()){
						if(p2.getDisplayName().equals(args[0])){
							if(PlayerInteraction.Chanlenged.containsKey(p2)){
								PlayerInteraction.Chanlenged.remove(p2);
								p.sendMessage("You have declined the fight!");
								p2.sendMessage(p.getDisplayName()+" has declined your fight!");
							}else{
								p.sendMessage("This link is no longer valid");
							}
							break;
						}
					}
				}
			}
			if(cmd.getName().equalsIgnoreCase("accepttrade")){
				if(args.length>0){
					for(Player p2:Bukkit.getServer().getWorld("Runescape").getPlayers()){
						if(p2.getDisplayName().equals(args[0])){
							if(PlayerInteraction.offerdTrade.containsKey(p2)){
								PlayerInteraction.trading.put(p2, p);
								PlayerInteraction.offerdTrade.remove(p2);
								Trading.openGui(p);
								Runnable r = new Trading(p,p2,Trading.openGui(p),Trading.openGui(p2));
								new Thread(r).start();
							}else{
								p.sendMessage("This link is no longer valid");
							}
						}
					}
				}
			}
			if(cmd.getName().equalsIgnoreCase("denytrade")){
				if(args.length>0){
					for(Player p2:Bukkit.getServer().getWorld("Runescape").getPlayers()){
						if(p2.getDisplayName().equals(args[0])){
							if(PlayerInteraction.offerdTrade.containsKey(p2)){
								PlayerInteraction.offerdTrade.remove(p2);
								p.sendMessage("You have declined the trade!");
								p2.sendMessage(p.getDisplayName()+" has declined your trade!");
							}else{
								p.sendMessage("This link is no longer valid");
							}
						}
					}
				}
			}
			if(cmd.getName().equalsIgnoreCase("player")){
				for(Player p2:Bukkit.getServer().getWorld("Runescape").getPlayers()){
					if(p2.getDisplayName().equals(args[0])){
						Guis.generateGUI(Guis.ChatPlayerInteraction, p, p2.getDisplayName());
						PlayerInteraction.ChatClicked.put(p, p2);
					}
				}
			}
		}else{
			if(cmd.getName().equalsIgnoreCase("playervote")){
				if(args.length>0){
					for(Player p2:Bukkit.getServer().getWorld("Runescape").getPlayers()){
						if(p2.getDisplayName().equals(args[0])){
							Eco.addFunds(p2, 100);
							Random r = new Random();
							int chance1 = r.nextInt(500);
							if(chance1<10){
								int color = r.nextInt(5);
								Bukkit.broadcastMessage(ChatColor.GOLD+p2.getDisplayName()+" Just got a PartyHat from voteing!");
								switch(color){
								case 0:
									p2.getInventory().addItem(Items.PartyHat_BLUE.generateItem());
									break;
								case 1:
									p2.getInventory().addItem(Items.PartyHat_RED.generateItem());
									break;
								case 2:
									p2.getInventory().addItem(Items.PartyHat_YELLOW.generateItem());
									break;
								case 3:
									p2.getInventory().addItem(Items.PartyHat_WHITE.generateItem());
									break;
								case 4:
									p2.getInventory().addItem(Items.PartyHat_GREEN.generateItem());
									break;
								case 5:
									p2.getInventory().addItem(Items.PartyHat_PURPLE.generateItem());
									break;
								}
								
							}
							int chance2 = r.nextInt(100);
							if(chance2<10){
								p2.getInventory().addItem(Items.RuneBar.generateItem());
								p2.getInventory().addItem(Items.RuneBar.generateItem());
								p2.getInventory().addItem(Items.RuneBar.generateItem());
							}
							int chance3 = r.nextInt(50);
							if(chance3<5){
								p2.getInventory().addItem(Items.LargeGoldPile.generateItem());
								
							}
							int chance4 = r.nextInt(50);
							if(chance4<5){
								p2.getInventory().addItem(Items.Yew_Log.generateItem());
								p2.getInventory().addItem(Items.Yew_Log.generateItem());
								p2.getInventory().addItem(Items.Yew_Log.generateItem());
								p2.getInventory().addItem(Items.Yew_Log.generateItem());
								p2.getInventory().addItem(Items.Yew_Log.generateItem());
							}
							int chance5 = r.nextInt(50);
							if(chance5<5){
								p2.getInventory().addItem(Items.Shark.generateItem());
								p2.getInventory().addItem(Items.Shark.generateItem());
								p2.getInventory().addItem(Items.Shark.generateItem());
								p2.getInventory().addItem(Items.Shark.generateItem());
								p2.getInventory().addItem(Items.Shark.generateItem());
							}
							int chance6 = r.nextInt(20);
							if(chance6<5){
								p2.getInventory().addItem(Items.LargeGoldPile.generateItem());
								
							}
						}
					}
				}
			}
			
		}
	return false;
	}
    
	public void loadBOSEconomy(){
		Plugin temp = getServer().getPluginManager().getPlugin("BOSEconomy");
		if (temp == null) {
			economy = null;
		} else {
			economy = (BOSEconomy)temp;
		}
	}
	
	
	
	public WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null;
	    }
	 
	    return (WorldGuardPlugin) plugin;
	}
	
}