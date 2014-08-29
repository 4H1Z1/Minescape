package me.johngreen.com.Skills;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WoodcuttingReset implements Runnable{

	
	public WoodcuttingReset(Block b,int meta) {
		this.b = b;
		this.meta = meta;
	   }
	private Block b;
	private int meta;
	
	@Override
	public void run() {
		boolean running = true;
		int i = 0;
		while(running){
			i++;
			if(i==15){
				running =false;
				Woodcutting.ChopedTrees.put(b.getLocation(), null);
				for(World w:Bukkit.getWorlds()){
					for(Player p:w.getPlayers()){
						p.sendBlockChange(b.getLocation(), Material.LOG, (byte)b.getState().getData().getData());
					}
				}
				break;
			}
			for(World w:Bukkit.getWorlds()){
				if(w.getPlayers().size()!=0){
					for(Player p:w.getPlayers()){
						p.sendBlockChange(b.getLocation(), 5, (byte)0);
					}
				}
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
