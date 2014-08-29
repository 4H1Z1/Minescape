package me.johngreen.com.Events;


import me.johngreen.com.Main;
import me.johngreen.com.Functions.Skills;
import me.johngreen.com.Skills.Fishing;
import me.johngreen.com.Skills.FishingWait;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class onPlayerFishEvent implements Listener {
    public onPlayerFishEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	@EventHandler
    public void onEntityTarget(PlayerFishEvent e){
		if(e.getState()==PlayerFishEvent.State.CAUGHT_FISH){
			e.setCancelled(true);
			e.getHook().remove();
		}
		if(Skills.Fishing.getLevel(e.getPlayer())>=10){
			if(e.getState()==PlayerFishEvent.State.FISHING){
				if(!Fishing.PlayerFishing.contains(e.getPlayer())){
					Runnable r = new FishingWait(e.getPlayer(), e.getHook());
					new Thread(r).start();
				}else{
					e.getPlayer().sendMessage("You are already fishing");
				}
				
			}
		}else{
			e.getPlayer().sendMessage(ChatColor.RED+"You need to be level 10 to use this!");
			e.setCancelled(true);
		}

    }
}