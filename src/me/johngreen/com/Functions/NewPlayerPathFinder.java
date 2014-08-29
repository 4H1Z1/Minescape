package me.johngreen.com.Functions;

import me.johngreen.com.Quests.TuturialIsland;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class NewPlayerPathFinder implements Runnable{

	
	public NewPlayerPathFinder(Player p){
		this.p = p;
	}
	private Player p;
	
	@Override
	public void run() {
		boolean running = true;
		Location pos1 = new Location(Bukkit.getWorld("Runescape"),55,96,524);
		Location pos2 = new Location(Bukkit.getWorld("Runescape"),-6,96,524);
		p.teleport(pos1);
		double current = 55.0;
		p.setGameMode(GameMode.CREATIVE);
		TuturialIsland.isInCreative.put(p, true);
		p.setFlying(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.sendMessage(ChatColor.GREEN+"Welcome "+p.getDisplayName()+" to the world of runescape!");
		while(running){
			if(p.getLocation().getX()<-6){
				Location pos4 = new Location(Bukkit.getWorld("Runescape"),-7,71,549);
				pos4.setYaw(180F);
				p.teleport(pos4);
				p.setFlying(false);
				p.setGameMode(GameMode.ADVENTURE);
				TuturialIsland.isInCreative.put(p, false);
				running=false;
			}else{
				Location pos3 = new Location(Bukkit.getWorld("Runescape"),current-0.20,96,524);
				//pos3.setPitch(90F);
				pos3.setYaw(90F);
				current = pos3.getX();
				p.teleport(pos3);
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
