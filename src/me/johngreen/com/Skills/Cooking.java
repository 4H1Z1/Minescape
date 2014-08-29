package me.johngreen.com.Skills;

import java.util.Random;

import me.johngreen.com.Events.CookingItems;
import me.johngreen.com.Functions.Skills;
import me.johngreen.com.items.InventoryHandler;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Cooking implements Runnable{

	public Cooking(Player p, CookingItems item){
		this.p = p;
		this.item = item;
	}
	private Player p;
	private CookingItems item;
	@Override
	public void run() {
		boolean running = true;
		int i = 0;
		p.sendMessage(ChatColor.GREEN+"Cooking");
		while(running){
			
			if(i==50){
				if(InventoryHandler.hasSpace(p)){
					Random r = new Random();
					if(r.nextInt(item.getR2())>item.getR1()){
						p.getInventory().addItem(Items.Ashes.generateItem());	
					}else{
						p.sendMessage(ChatColor.GREEN+"You cooked the food sucsessfully");
						Skills.Cooking.setXP(item.getXP(), p);
						p.getInventory().addItem(item.getItem().generateItem());	
					}
					
				}else{
					p.sendMessage(ChatColor.RED+"You dont have the required space");
				}
			}
			
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void generateGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 54,"Cooking");
		inv.addItem(Items.Cooking_Shrimp.generateItem());
		inv.addItem(Items.Cooking_Herring.generateItem());
		inv.addItem(Items.Cooking_Trout.generateItem());
		inv.addItem(Items.Cooking_Tuna.generateItem());
		inv.addItem(Items.Cooking_Lobster.generateItem());
		inv.addItem(Items.Cooking_Swordfish.generateItem());
		inv.addItem(Items.Cooking_Monkfish.generateItem());
		inv.addItem(Items.Cooking_Shark.generateItem());
		p.openInventory(inv);
	}
}
