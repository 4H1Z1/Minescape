package me.johngreen.com.Events;

import java.util.List;
import java.util.UUID;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.DamageCalculation;
import me.johngreen.com.Functions.Guis;
import me.johngreen.com.Functions.PlayerInteraction;
import me.johngreen.com.Functions.SpellBook;
import me.johngreen.com.Quests.Quests;
import me.johngreen.com.Skills.Prayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class onPlayerItemHeldEvent implements Listener {
    public onPlayerItemHeldEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onEntityTarget(PlayerItemHeldEvent e){
    	if(!DamageCalculation.hasLevelToUse(e.getPlayer().getItemInHand(), e.getPlayer())){
    		e.getPlayer().sendMessage(ChatColor.YELLOW+"You cant use this this item in combat");
    	}
    	switch(e.getNewSlot()){
    	case 4:
    		Quests.createQuestGui(e.getPlayer());
    		e.setCancelled(true);
    		break;
    	case 5:
    		Guis.generateGUI(Guis.Levels, e.getPlayer());
    		e.setCancelled(true);
    		break;
    	case 6:
    		SpellBook.generateGUI(e.getPlayer());
    		e.setCancelled(true);
    		break;
    	case 7:
    		Prayer.generatePrayer(e.getPlayer());
    		e.setCancelled(true);
    		break;
    	case 8:
    		PlayerInteraction.vewFriends(e.getPlayer());
    		e.setCancelled(true);
    		break;
    	}
    }
}
