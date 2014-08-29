package me.johngreen.com.Functions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public class MobSpawner implements Runnable {
	
	public MobSpawner(List<Mobs> mob,
		List<Location> l) {
		this.l = l;
		this.mob = mob;
	}
	private List<Location> l;
	private List<Mobs> mob;
	
	@Override
	public void run() {
		boolean running = true;
		while(running){
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
			for(int i = 0; i<l.size();i++){
				if(Bukkit.getServer().getWorld("Runescape").getChunkAt(l.get(i))!=null){
					if(Bukkit.getServer().getWorld("Runescape").getChunkAt(l.get(i)).isLoaded()){
						
						if(Mobs.mobs.get(i)==null){
							List<Integer> id = new ArrayList<Integer>();
							id.add(Mobs.spawnMobID(mob.get(i), l.get(i)));
							Mobs.mobs.put(i, id);
						}else if(Mobs.mobs.get(i).size()<5){
							
							
							List<Integer> ids = new ArrayList<Integer>();
							ids.add(Mobs.spawnMobID(mob.get(i), l.get(i)));
							ids.addAll(Mobs.mobs.get(i));
							Mobs.mobs.put(i, ids);
						}
					}
				}
			}
			try {
			 	Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
