package me.johngreen.com.Functions;

import java.util.ArrayList;
import java.util.List;

import me.johngreen.com.items.InventoryHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Trading implements Runnable  {
	
	public static List<Player> inTrade = new ArrayList<Player>();
	public static List<Player> AcceptedTrade = new ArrayList<Player>();
	
	public Trading(Player p1, Player p2,Inventory in1,Inventory in2){
		this.p1 = p1;
		this.p2 = p2;
		this.in1 = in1;
		this.in2 = in2;
	}
	private Player p1;
	private Player p2;
	private Inventory in1;
	private Inventory in2;
	public static Inventory openGui(Player p1){
		Inventory inv = Bukkit.createInventory(null, 54,"Trading menu");
		int[] padding = {0,1,2,3,4,5,6,7,8,9,13,17,18,22,26,27,31,35,36,40,44,45,46,47,48,49,50,51,52,53};
		for(int i:padding){
			if(i==52||i==51||i==50||i==48||i==47||i==46){
				ItemStack is = new ItemStack(Material.WOOL,1,DyeColor.RED.getData());
				inv.setItem(i,is);
			}else{
				inv.setItem(i,new ItemStack(Material.LOG));
			}
		}
		p1.openInventory(inv);
		return inv;
	}
	
	
	

	@Override
	public void run() {
		boolean running = true;
		List<ItemStack> pi1 = new ArrayList<ItemStack>();
		List<ItemStack> pi2 = new ArrayList<ItemStack>();
		inTrade.add(p1);
		inTrade.add(p2);
		if(AcceptedTrade.contains(p1)){
			AcceptedTrade.remove(p1);
		}
		if(AcceptedTrade.contains(p2)){
			AcceptedTrade.remove(p2);
		}
		Bukkit.broadcastMessage("started!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(running){
			if(AcceptedTrade.contains(p1)&&AcceptedTrade.contains(p2)){
				p1.closeInventory();
				p2.closeInventory();
				if(InventoryHandler.hasSpace(p1, pi2.size())&&InventoryHandler.hasSpace(p2, pi1.size())){
					Bukkit.broadcastMessage("2");
					for(ItemStack item :pi2){
						p1.getInventory().addItem(item);	
					}
					for(ItemStack item :pi1){
						p2.getInventory().addItem(item);	
					}
				}else{
					if(!InventoryHandler.hasSpace(p1, pi2.size())){
						p1.sendMessage(ChatColor.RED+"You dont have enough inventory space!");
						p2.sendMessage(ChatColor.RED+p1.getDisplayName()+" dose not have enough inventory space!");
					}
					if(!InventoryHandler.hasSpace(p2, pi1.size())){
						p2.sendMessage(ChatColor.RED+"You dont have enough inventory space!");
						p1.sendMessage(ChatColor.RED+p2.getDisplayName()+" dose not have enough inventory space!");
					}
				}
				AcceptedTrade.remove(p1);
				AcceptedTrade.remove(p2);
				PlayerInteraction.trading.remove(p2);
				inTrade.remove(p1);
				inTrade.remove(p2);
				running=false;
			}else if(!in1.getViewers().contains(p1)||!in2.getViewers().contains(p2)){
				Bukkit.broadcastMessage("1");
				p1.closeInventory();
				p2.closeInventory();
				for(ItemStack item :pi1){
					p1.getInventory().addItem(item);	
				}
				for(ItemStack item :pi2){
					p2.getInventory().addItem(item);	
				}
				if(AcceptedTrade.contains(p1)){
					AcceptedTrade.remove(p1);
				}
				if(AcceptedTrade.contains(p2)){
					AcceptedTrade.remove(p2);
				}
				PlayerInteraction.trading.remove(p2);
				inTrade.remove(p1);
				inTrade.remove(p2);
				running=false;
			}
			if(running!=false){
				pi1 = new ArrayList<ItemStack>();
				pi2 = new ArrayList<ItemStack>();
					int[] area1 = {10,11,12,19,20,21,28,29,30,37,38,39};
					int[] area2 = {14,15,16,23,24,25,32,33,34,41,42,43};
					for(int a:area1){
							if(in1.getItem(a)!=null){
								if(in1.getItem(a).hasItemMeta()&&in1.getItem(a).getItemMeta().hasDisplayName()){
									pi1.add(in1.getItem(a));
								}
							}
							if(in2.getItem(a)!=null){
								if(in2.getItem(a).hasItemMeta()&&in2.getItem(a).getItemMeta().hasDisplayName()){
									pi2.add(in2.getItem(a));
								}
							}
					}
					int mma = 0;
					int mmb = 0;
					for(int a:area2){
						in1.setItem(a, null);
						in2.setItem(a, null);
						if(pi1!=null&&!(pi1.size()<=mma)){
							if(pi1.get(mma)!=null){
								in2.setItem(a, pi1.get(mma));
							}
						}
						if(pi2!=null&&!(pi2.size()<=mmb)){
							if(pi2.get(mmb)!=null){
								in1.setItem(a, pi2.get(mmb));
							}
						}
						mma++;
						mmb++;
					}
					if(AcceptedTrade.contains(p1)){
						in2.setItem(50, new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData()));
						in2.setItem(51, new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData()));
						in2.setItem(52, new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData()));
					}else{
						in2.setItem(50, new ItemStack(Material.WOOL,1,DyeColor.RED.getData()));
						in2.setItem(51, new ItemStack(Material.WOOL,1,DyeColor.RED.getData()));
						in2.setItem(52, new ItemStack(Material.WOOL,1,DyeColor.RED.getData()));
					}
					if(AcceptedTrade.contains(p2)){
						in1.setItem(50, new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData()));
						in1.setItem(51, new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData()));
						in1.setItem(52, new ItemStack(Material.WOOL,1,DyeColor.GREEN.getData()));
					}else{
						in1.setItem(50, new ItemStack(Material.WOOL,1,DyeColor.RED.getData()));
						in1.setItem(51, new ItemStack(Material.WOOL,1,DyeColor.RED.getData()));
						in1.setItem(52, new ItemStack(Material.WOOL,1,DyeColor.RED.getData()));
					}
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Bukkit.broadcastMessage("done!");
		
	}
	
}
