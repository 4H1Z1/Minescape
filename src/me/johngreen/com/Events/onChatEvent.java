package me.johngreen.com.Events;

import java.io.UnsupportedEncodingException;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Mobs;
import me.johngreen.com.Functions.PlayerInteraction;
import me.johngreen.com.Functions.Skills;
import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.IChatBaseComponent;
import net.minecraft.server.v1_7_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChatEvent implements Listener {
    public onChatEvent(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void highLogin(AsyncPlayerChatEvent e) {
    	customChat(e.getPlayer(),e.getMessage());
    	e.setCancelled(true);
    }
    
    
    private static void customChat(Player p,String message){
    	String start = ChatColor.GREEN+"["+Skills.CombatLevel.getLevel(p)+"]";
    	if(p.isOp()&&p.getDisplayName().equals("_Cloud_Strife_")){
    		start = start+ChatColor.BLUE+"[Dev]";
    	}else if(p.isOp()){
    		start = start+ChatColor.GOLD+"[Admin]";
    	}
    	String s = message;
    	String message2 = message;
    	byte[] b = null;
    	try {
			b = s.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			message2 = new String(b, "US-ASCII");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Player p1:Bukkit.getServer().getWorld("Runescape").getPlayers()){
			if(p1!=p){
				IChatBaseComponent comp = ChatSerializer
				            .a("{\"text\":\"" + 
				            "\",\"extra\":[{\"text\":\"" +start+" "+ChatColor.LIGHT_PURPLE+p.getDisplayName()+" "+ChatColor.GREEN +message2 + 
				            "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + 
				            "/player "+p.getDisplayName() + "\"}}]}");    
				PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
				((CraftPlayer) p1).getHandle().playerConnection.sendPacket(packet);
			}else{
				p1.sendMessage(start+" "+ChatColor.LIGHT_PURPLE+p.getDisplayName()+" "+ChatColor.GREEN+message);
			}
		}
    }
}
