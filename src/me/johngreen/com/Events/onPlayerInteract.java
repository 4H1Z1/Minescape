package me.johngreen.com.Events;

import java.util.ArrayList;
import java.util.List;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.DamageCalculation;
import me.johngreen.com.Functions.DeathSign;
import me.johngreen.com.Functions.Eco;
import me.johngreen.com.Functions.FloatingText;
import me.johngreen.com.Functions.Skills;
import me.johngreen.com.Functions.SpellBook;
import me.johngreen.com.Skills.Cooking;
import me.johngreen.com.Skills.Firemaking;
import me.johngreen.com.Skills.Fishing;
import me.johngreen.com.Skills.Mining;
import me.johngreen.com.Skills.MiningBlocks;
import me.johngreen.com.Skills.Prayer;
import me.johngreen.com.Skills.Smithing;
import me.johngreen.com.Skills.Woodcutting;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class onPlayerInteract implements Listener {
    public onPlayerInteract(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onEntityTarget(PlayerInteractEvent e){
    	Player p = e.getPlayer();
    	if(e.getAction()==Action.LEFT_CLICK_AIR||e.getAction()==Action.RIGHT_CLICK_AIR){
    		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()){
    			String name = ChatColor.stripColor(p.getItemInHand().getItemMeta().getDisplayName());
    			if(name.equals("Gold Coin")){
    				p.getInventory().removeItem(Items.GoldCoin.generateItem());
    				Eco.addFunds(p, 1);
    			}else if(name.equals("Small Gold Pile")){
    				p.getInventory().removeItem(Items.SmallGoldPile.generateItem());
    				Eco.addFunds(p, 100);
    			}else if(name.equals("Large Gold Pile")){
    				p.getInventory().removeItem(Items.LargeGoldPile.generateItem());
    				Eco.addFunds(p, 1000);
    			}else if(name.equals("Shrimp")){
    				p.getInventory().remove(p.getItemInHand());
    				if((p.getMaxHealth()-p.getHealth())>=4){
    					p.setHealth(p.getHealth()+4);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+4),"damage");
    			}else if(name.equals("Herring")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=6){
    					p.setHealth(p.getHealth()+6);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+6),"damage");
    			}else if(name.equals("Trout")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=8){
    					p.setHealth(p.getHealth()+8);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+8),"damage");
    			}else if(name.equals("Tuna")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=10){
    					p.setHealth(p.getHealth()+10);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+10),"damage");
    			}else if(name.equals("Lobster")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=12){
    					p.setHealth(p.getHealth()+12);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+12),"damage");
    			}else if(name.equals("Swordfish")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=14){
    					p.setHealth(p.getHealth()+14);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+14),"damage");
    			}else if(name.equals("Monkfish")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=16){
    					p.setHealth(p.getHealth()+16);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+16),"damage");
    			}else if(name.equals("Shark")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=20){
    					p.setHealth(p.getHealth()+20);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+20),"damage");
    			}
    			p.updateInventory();
    		}
    	}
    	if(e.getAction()==Action.RIGHT_CLICK_BLOCK||e.getAction()==Action.RIGHT_CLICK_AIR){
    		if(staffInHand(p)){
    			
    		}else if(bowInHand(p)){
    			
    		}else if(swordInHand(p)){
    			if(DamageCalculation.Type.containsKey(p)){
    				if(DamageCalculation.Type.get(p)=="Agressive"){
    					DamageCalculation.Type.put(p, "Defence");
    					p.sendMessage(ChatColor.GREEN+"You are now traning:"+ChatColor.GRAY+"Defence");
    				}else if(DamageCalculation.Type.get(p)=="Defence"){
    					DamageCalculation.Type.put(p, "Strength");
    					p.sendMessage(ChatColor.GREEN+"You are now traning:"+ChatColor.GRAY+"Strength");
    				}else if(DamageCalculation.Type.get(p)=="Strength"){
    					DamageCalculation.Type.put(p, "Agressive");
    					p.sendMessage(ChatColor.GREEN+"You are now traning:"+ChatColor.GRAY+"Attack");
    				}else{
    					DamageCalculation.Type.put(p, "Defence");
    					p.sendMessage(ChatColor.GREEN+"You are now traning:"+ChatColor.GRAY+"Defence");
    				}
    			}else{
    				DamageCalculation.Type.put(p, "Defence");
					p.sendMessage(ChatColor.GREEN+"You are now traning:"+ChatColor.GRAY+"Defence");
    			}
    		}
    	}
    	if(e.getAction()==Action.LEFT_CLICK_BLOCK||e.getAction()==Action.RIGHT_CLICK_BLOCK){
    		if(Bukkit.getWorld("Runescape").getBlockAt(new Location(Bukkit.getWorld("Runescape"),e.getClickedBlock().getX(),(e.getClickedBlock().getY()+1),e.getClickedBlock().getZ())).isLiquid()){
    			if(!Fishing.PlayerFishing.contains(p)){
    				Fishing.PlayerFishing.add(p);
    				Runnable r = new Fishing(p,p.getItemInHand());
    				new Thread(r).start();
    			}else{
    				p.sendMessage("You are already fishing");
    			}
    			
    			e.setCancelled(true);
    		}
    		
    		if(e.getClickedBlock().getType()==Material.FURNACE){
    			Smithing.openMainPageFurnace(p);
    			e.setCancelled(true);
    		}
    		if(e.getClickedBlock().getType()==Material.ANVIL){
    			Smithing.openFirstPageAnvil(p);
    			e.setCancelled(true);
    		}
    		
    		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()){
    			String name = ChatColor.stripColor(p.getItemInHand().getItemMeta().getDisplayName());
    			if(name.equals("Gold Coin")){
    				p.getInventory().removeItem(Items.GoldCoin.generateItem());
    				Eco.addFunds(p, 1);
    			}else if(name.equals("Small Gold Pile")){
    				p.getInventory().removeItem(Items.SmallGoldPile.generateItem());
    				Eco.addFunds(p, 100);
    			}else if(name.equals("Large Gold Pile")){
    				p.getInventory().removeItem(Items.LargeGoldPile.generateItem());
    				Eco.addFunds(p, 1000);
    			}else if(name.contains("Bone")){
    				p.getInventory().remove(p.getItemInHand());
    				Prayer.buryEvent(p, name);
    			}else if(name.equals("Shrimp")){
    				p.getInventory().remove(p.getItemInHand());
    				if((p.getMaxHealth()-p.getHealth())>=4){
    					p.setHealth(p.getHealth()+4);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+4),"damage");
    			}else if(name.equals("Herring")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=6){
    					p.setHealth(p.getHealth()+6);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+6),"damage");
    			}else if(name.equals("Trout")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=8){
    					p.setHealth(p.getHealth()+8);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+8),"damage");
    			}else if(name.equals("Tuna")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=10){
    					p.setHealth(p.getHealth()+10);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+10),"damage");
    			}else if(name.equals("Lobster")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=12){
    					p.setHealth(p.getHealth()+12);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+12),"damage");
    			}else if(name.equals("Swordfish")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=14){
    					p.setHealth(p.getHealth()+14);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+14),"damage");
    			}else if(name.equals("Monkfish")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=16){
    					p.setHealth(p.getHealth()+16);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+16),"damage");
    			}else if(name.equals("Shark")){
    				p.setItemInHand(null);
    				if((p.getMaxHealth()-p.getHealth())>=20){
    					p.setHealth(p.getHealth()+20);
    				}else{
    					p.setHealth(p.getMaxHealth());
    				}
    				p.sendMessage(ChatColor.GREEN+"You feel refreshed");
    				FloatingText.spawnNametag(p.getLocation(), 0.5,ChatColor.GREEN+"-"+((int)+20),"damage");
    			}
    			p.updateInventory();
    		}
    		
    		if(Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).getType()==Material.FIRE){
    			Cooking.generateGUI(p);
    		}
    		
    		if(Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).getType()==Material.AIR&&e.getPlayer().getItemInHand()!=null&&e.getPlayer().getItemInHand().hasItemMeta()&&e.getPlayer().getItemInHand().getItemMeta().hasDisplayName()&&e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN+"TinderBox")){
    			e.setCancelled(true);
    			for(ItemStack i:p.getInventory()){
    				if(i!=null&&i.hasItemMeta()&&i.getItemMeta().hasDisplayName()){
    					String name = ChatColor.stripColor(i.getItemMeta().getDisplayName());
    	    			if(name.equals("Log")){
    	    				p.getInventory().remove(i);
    	    				Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).setType(Material.FIRE);
    	    				p.updateInventory();
    	    				Runnable r = new Firemaking(Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).getLocation(),3);
    	    				new Thread(r).start();
    	    				Skills.Firemaking.setXP(40, p);
    	    				break;
    	    			}else if(name.equals("Oak Log")){
    	    				if(Skills.Firemaking.getLevel(p)>=15){
    	    					p.getInventory().remove(i);
	    	    				Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).setType(Material.FIRE);
	    	    				p.updateInventory();
	    	    				Runnable r = new Firemaking(Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).getLocation(),5);
	    	    				new Thread(r).start();
	    	    				Skills.Firemaking.setXP(60, p);
    	    				}else{
    	    					p.sendMessage("You ned to be level 15 to burn this log!");
    	    				}
    	    				
    	    				break;
    	    			}else if(name.equals("Willow Log")){
    	    				if(Skills.Firemaking.getLevel(p)>=30){
    	    					p.getInventory().remove(i);
	    	    				Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).setType(Material.FIRE);
	    	    				p.updateInventory();
	    	    				Runnable r = new Firemaking(Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).getLocation(),7);
	    	    				new Thread(r).start();
	    	    				Skills.Firemaking.setXP(90, p);
    	    				}else{
    	    					p.sendMessage("You ned to be level 30 to burn this log!");
    	    				}
    	    				
    	    				break;
    	    			}else if(name.equals("Yew Log")){
    	    				if(Skills.Firemaking.getLevel(p)>=60){
    	    					p.getInventory().remove(i);
	    	    				Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).setType(Material.FIRE);
	    	    				p.updateInventory();
	    	    				Runnable r = new Firemaking(Bukkit.getWorld(e.getClickedBlock().getWorld().getName()).getBlockAt(e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ()).getLocation(),10);
	    	    				new Thread(r).start();
	    	    				Skills.Firemaking.setXP(203, p);
    	    				}else{
    	    					p.sendMessage("You ned to be level 60 to burn this log!");
    	    				}
    	    				
    	    				break;
    	    			}
    				}
    			}
    		}
    		
    		if(e.getClickedBlock().getType()==Material.SIGN_POST||e.getClickedBlock().getType()==Material.SIGN){
    			Sign sign = (Sign)e.getClickedBlock().getState();
    			switch(ChatColor.stripColor(sign.getLine(0))){
    			case "[Loadstone]":
    				SpellBook.addTeleport(p, sign.getLine(2));
    				break;
    			case "Grave Stone":
    				if(onPlayerDeathEvent.deathsign.containsKey(e.getPlayer())){
	    				if(p.getDisplayName().contains(ChatColor.stripColor(sign.getLine(2)))){
		    				Inventory inv = Bukkit.createInventory(null, 54, "GraveStone");
		    		    	for(ItemStack i:DeathSign.invs.get(p.getDisplayName())){
		    		    		inv.addItem(i);
		    		    	}
		    		    	p.openInventory(inv);
		    		    	e.getClickedBlock().setType(Material.AIR);
		    			}
	    			}
    				break;
    			}
    			
    			
    		}
    		List<String> miningblocks = new ArrayList<>();
    		miningblocks.add("REDSTONE_ORE");
    		miningblocks.add("LAPIS_ORE");
    		miningblocks.add("QUARTZ_ORE");
    		miningblocks.add("IRON_ORE");
    		miningblocks.add("IRON_BLOCK");
    		miningblocks.add("COAL_ORE");
    		miningblocks.add("GOLD_ORE");
    		miningblocks.add("EMERALD_ORE");
    		miningblocks.add("EMERALD_BLOCK");
    		miningblocks.add("DIAMOND_ORE");
    		
    		if(miningblocks.contains(e.getClickedBlock().getType()+"")){
    			if(Mining.ChopedOres.get(e.getClickedBlock().getLocation())==null){
    				if(!Mining.PlayerChopping.containsValue(e.getClickedBlock().getLocation())){
    					Mining.mineBlock(e.getClickedBlock(),e.getClickedBlock().getLocation(), p,e.getClickedBlock().getType()+"");
    				}else{
    					p.sendMessage(ChatColor.RED+"This ore is already being mined!");
    				}
				}else{
					p.sendMessage(ChatColor.RED+"This ore has already been minned!");
				}
    		}
    		if(e.getClickedBlock().getType()==Material.LOG){
    			if(e.getClickedBlock().getState().getData().getData()>=12){
    				if(Woodcutting.ChopedTrees.get(e.getClickedBlock().getLocation())==null){
    					if(!Woodcutting.PlayerChopping.containsValue(e.getClickedBlock().getLocation())){
    							Woodcutting.mineBlock(e.getClickedBlock(),e.getClickedBlock().getLocation(), p,e.getClickedBlock().getState().getData().getData());
    					}else{
    						p.sendMessage(ChatColor.RED+"This tree is already being choped!");
    					}
    				}else{
    					p.sendMessage(ChatColor.RED+"This tree has already been Choped!");
    				}
    			}
    		}
    	}
    }
    
	private boolean staffInHand(Player p) {
		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()&&p.getItemInHand().getItemMeta().getDisplayName().contains("Staff")){
			return true;
		}
		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()&&p.getItemInHand().getItemMeta().getDisplayName().contains("Wand")){
			return true;
		}
		return false;
	}

	private boolean bowInHand(Player p) {
		if(p.getItemInHand()!=null&&p.getItemInHand().hasItemMeta()&&p.getItemInHand().getItemMeta().hasDisplayName()&&p.getItemInHand().getItemMeta().getDisplayName().contains("Bow")){
			return true;
		}
		return false;
	}
	
	private boolean swordInHand(Player p) {
		if(p.getItemInHand().getType().equals(Material.WOOD_SWORD)||
				p.getItemInHand().getType().equals(Material.IRON_SWORD)||
				p.getItemInHand().getType().equals(Material.GOLD_SWORD)||
				p.getItemInHand().getType().equals(Material.DIAMOND_SWORD)){
			return true;
		}
		return false;
	}
}
