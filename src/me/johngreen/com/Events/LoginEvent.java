package me.johngreen.com.Events;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Core;
import me.johngreen.com.Functions.DeathSign;
import me.johngreen.com.Functions.NewPlayerPathFinder;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class LoginEvent implements Listener {
    public LoginEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void highLogin(PlayerJoinEvent e) {
    	Core.setupPlayer(e.getPlayer());
    }
}
