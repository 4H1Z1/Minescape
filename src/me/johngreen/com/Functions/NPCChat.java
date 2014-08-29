package me.johngreen.com.Functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import me.johngreen.com.Main;

import org.bukkit.entity.Player;

public class NPCChat {

    public NPCChat(Main plugin) {
        this.plugin = plugin;
    }
private static Main plugin;
		private static BufferedImage loadImage(String file)
		{
		  File f = new File(plugin.getDataFolder(), "NPCHeads" + File.separatorChar + file);
		  BufferedImage image = null;
		  if (!f.exists()) {
		    return null;
		  }
		  try
		  {
		    image = ImageIO.read(f);
		  }
		  catch (IOException e)
		  {
		    e.printStackTrace();
		  }
		  return image;
		}

	public static void sendMessage(Player p, Npcs npc,String message){
		BufferedImage imageToSend = loadImage(npc.getHead());
		new ImageMessage(
				imageToSend,
				8,
				ImageChar.BLOCK.getChar()
			).appendCenteredText(
				"",
				"["+npc.name()+"]",
				"",
				message
		).sendToPlayer(p);
		p.sendMessage("");
	}
	
}
