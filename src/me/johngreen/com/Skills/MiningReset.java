package me.johngreen.com.Skills;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MiningReset implements Runnable{

	
	public MiningReset(Block b) {
		this.b = b;
	   }
	private Block b;
	
	@Override
	public void run() {
		boolean running = true;
		int i = 0;
		while(running){
			i++;
			
			for(World w:Bukkit.getWorlds()){
				for(Player p:w.getPlayers()){
					p.sendBlockChange(b.getLocation(), 1, (byte)0);
				}
			}
			if(i==15){
				running =false;
				Mining.ChopedOres.put(b.getLocation(), null);
				for(World w:Bukkit.getWorlds()){
					for(Player p:w.getPlayers()){
						p.sendBlockChange(b.getLocation(), b.getType(), (byte)0);
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
