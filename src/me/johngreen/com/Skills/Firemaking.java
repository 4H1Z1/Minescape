package me.johngreen.com.Skills;

import java.util.Random;

import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Firemaking implements Runnable {
	
	public Firemaking(Location l, int time) {
		this.l = l;
		this.time = time;
	   }
	private Location l;
	private int time;
	
	@Override
	public void run() {
		   boolean running = true;
		   int i=0;
		   while (running) {
			   if(i==(time*10)){
				   running = false;
				   l.getBlock().setType(Material.AIR);
				   Random r = new Random();
			    	int aaa = r.nextInt(3)+1;
			    	if(aaa==1){
			    		Bukkit.getWorld("Runescape").dropItem(l, Items.Ashes.generateItem());
			    	}
				   break;
			   }
			   if(l.getBlock().getType()!=Material.FIRE){
				   l.getBlock().setType(Material.FIRE);
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

}
