package me.johngreen.com.Functions;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class destroyText implements Runnable { 
	
	public destroyText(int id,int id2) {
		this.id = id;
		this.id2 = id2;
	   }
	int id;
	int id2;
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WrapperPlayServerEntityDestroy de = new WrapperPlayServerEntityDestroy();
		int[] a =new int[]{id,id2};
		de.setEntities(a);
		for(World w:Bukkit.getServer().getWorlds()){
			for(Player p:Bukkit.getServer().getWorld(w.getName()).getPlayers()){
				de.sendPacket(p);
			}
		}
	}
}
