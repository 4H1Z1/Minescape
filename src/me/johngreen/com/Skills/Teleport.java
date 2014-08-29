package me.johngreen.com.Skills;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Teleport implements Runnable {
	
	public Teleport(Location l, int time,Player p) {
		this.l = l;
		this.time = time;
		this.p = p;
	   }
	private Location l;
	private Player p;
	private int time;
	
	@Override
	public void run() {
		   boolean running = true;
		   int i=0;
		   Location pl = new Location(p.getWorld(),(int)p.getLocation().getX(),(int)p.getLocation().getY(),(int)p.getLocation().getZ());
		   p.sendMessage(ChatColor.GREEN+"Dont move during teleport!");
		   while (running) {
			   Location p2 = new Location(p.getWorld(),(int)p.getLocation().getX(),(int)p.getLocation().getY(),(int)p.getLocation().getZ());
			   if (p2.getBlockX()!=pl.getBlockX()||p2.getBlockY()!=pl.getBlockY()||p2.getBlockZ()!=pl.getBlockZ()){
				   running =false;
				   p.sendMessage(ChatColor.RED+"Teleport Canceled due to movment!");
				   break;
			   }
			   if(i==(time*10)){
				   running = false;
				   if(!Bukkit.getWorld(l.getWorld().getName()).getChunkAt(l).isLoaded()){
					   Bukkit.getWorld(l.getWorld().getName()).getChunkAt(l).load();
				   }
				   p.teleport(l);
				   break;
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
