package me.johngreen.com.Quests;

import java.util.ArrayList;
import java.util.List;

import me.johngreen.com.Main;
import me.johngreen.com.Functions.Shop;
import me.johngreen.com.items.InventoryHandler;
import me.johngreen.com.items.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Quests {
	RuneMysteries("Rune Mysteries",0,1,new String[]{ChatColor.YELLOW+"Air Talisman",ChatColor.YELLOW+"Access to the Rune Essence Mine"},ChatColor.WHITE+"Start,Lumbridge,Speak to the Duke of Lumbridge to start."),
	BlackKnightsFortress("Black Knights Fortress",1,3,new String[]{ChatColor.YELLOW+"2,500gp"},ChatColor.WHITE+"Start,White Knights castle, Falador,Speak to Sir Amik Varze to start."),
	CooksAssistant("CooksAssistant",2,1,new String[]{ChatColor.YELLOW+"300 Cooking Xp"},ChatColor.WHITE+"Start,Lumbridge Castle,Speak to the Cook to start."),
	DemonSlayer("Demon Slayer",3,3,new String[]{ChatColor.YELLOW+"Silverlight sword"},ChatColor.WHITE+"Start,Varrock Square,Speak to the Gypsy to start."),
	DoricsQuest("Dorics Quest",4,1,new String[]{ChatColor.YELLOW+"300 Mining Xp",ChatColor.YELLOW+"180 Coins"},ChatColor.WHITE+"Start,Anvils north of Falador,Speak to Doric to start."),
	DragonSlayer("Dragon Slayer",5,2,new String[]{ChatColor.YELLOW+"18,650 Defence Xp",ChatColor.YELLOW+"18,650 Strength Xp",ChatColor.YELLOW+"Ability to wear Rune Plate Body armour",ChatColor.YELLOW+"and green dragonhide body"},ChatColor.WHITE+"Start,Champion's guild,Speak to the Guildmaster to start."),
	ErnestTheChicken("Ernest The Chicken",6,4,new String[]{ChatColor.YELLOW+"300 Gold Coins"},ChatColor.WHITE+"Start,Gates of Draynor Manor,Speak to Veronica to start."),
	GoblinDiplomacy("Goblin Diplomacy",7,5,new String[]{ChatColor.YELLOW+"200 Crafting Xp",ChatColor.YELLOW+"A Gold Bar"},ChatColor.WHITE+"Start,Port Sarim,Speak to the Barman to start."),
	ImpCatcher("Imp Catcher",8,1,new String[]{ChatColor.YELLOW+"875 Magic Xp",ChatColor.YELLOW+"Amulet of Accuracy "},ChatColor.WHITE+"Start,Wizard's Tower,Speak to Wizard Mizgog to start."),
	TheKnightsSword("The Knights Sword",9,1,new String[]{ChatColor.YELLOW+"12,725 Smithing Xp",ChatColor.YELLOW+"Faladian Sword"},ChatColor.WHITE+"Start,White knights castle, Falador,Speak to the Squire to start."),
	PiratesTreasure("Pirates Treasure",10,1,new String[]{ChatColor.YELLOW+"450 gold coins",ChatColor.YELLOW+"Emerald",ChatColor.YELLOW+"Gold ring"},ChatColor.WHITE+"Start,Port Sarim,Speak to Redbeard Frank to start."),
	PrinceAliRescue("Prince Ali Rescue",11,3,new String[]{ChatColor.YELLOW+"700 Gold Coins"},ChatColor.WHITE+"Start,Al Kharid palace,Speak to Hassan to start."),
	TheRestlessGhost("The Restless Ghost",12,1,new String[]{ChatColor.YELLOW+"1,125 Prayer Xp",ChatColor.YELLOW+"Amulet of Ghostspeak"},ChatColor.WHITE+"Start,Lumbridge,Speak to the Priest to start."),
	RomeoJuliet("Romeo & Juliet",13,5,new String[]{""},ChatColor.WHITE+"Start,Varrock,Speak to Juliet or Romeo to start."),
	SheepShearer("Sheep Shearer",14,1,new String[]{ChatColor.YELLOW+"450 Crafting Xp",ChatColor.YELLOW+"60 Gold Coins"},ChatColor.WHITE+"Start,North west of Lumbridge,Speak to Farmer Fred to start."),
	ShieldOfArrav("Shield Of Arrav",15,1,new String[]{ChatColor.YELLOW+"600 Gold Coins"},ChatColor.WHITE+"Start,Varrock Palace Library,Speak to Reldo to start."),
	WitchsPotion("Witch's Potion",16,1,new String[]{ChatColor.YELLOW+"325 Magic Xp"},ChatColor.WHITE+"Start,Rimmington,Speak to Hetty to start.");
	
	
	
	Quests(String name,int ID,int questpoints,String[] rewards,String startLoc){
		this.ID = ID;
		this.name = name;
		this.questpoints = questpoints;
		this.rewards = rewards;
		this.startLoc = startLoc;
	}
	private int ID;
	private String name;
	private String startLoc;
	private int questpoints;
	private String[] rewards;
	
	public static boolean hasQuest(final Player p, String npc){
		boolean taken = false;
		switch(ChatColor.stripColor(npc)){ 
		case "Aubury":
            if(RuneMysteries.isFinished(p)){
                return false;
            }else{
                if(RuneMysteries.isStarted(p)){
                        switch(Main.questconfig.getString(p.getDisplayName()+"."+RuneMysteries.ID+".Progress")){
                        case "18":
                                for(ItemStack item:p.getInventory().getContents()){
                                        if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains("Blue Reserch Package")){
                                                p.getInventory().remove(item);
                                                taken=true;
                                                break;
                                        }
                                }
                                if(taken){
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "19");
                                        p.sendMessage(ChatColor.GREEN+"Seridor has sent me hear with a package for you!");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Really? But... surely he can't have..? Please, let me have it, it must be extremely important for him to have sent a stranger.");
                                        Main.saveQuestConfig();
                                }else{
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"It dosent seem to be with you, maybe you left it back with him?");
                                }
                                return true;
                        case "19":
                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "20");
                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"This... this is incredible. Please, give me a few moments to quickly look over this, and then talk to me again.");
                                Main.saveQuestConfig();
                                return true;
                       
                        case "20":
                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "22");
                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"My gratitude to you adventurer for bringing me this Research Package. I notice that you brought the head wizard a special talisman that was the key to finally unlocking the puzzle.");
                                Main.saveQuestConfig();
                                return true;
                        case "22":
                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "23");
                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Combined with the information I had already collected regarding the Rune Essence. I think we have finally unlocked the power to");
                                Main.saveQuestConfig();
                                return true;
                        case "23":
                                if(InventoryHandler.hasSpace(p)){
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "24");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"..no. I am getting ahead of myself. Please take this summary of my reesearch back to the head wizard at the Wizards' Tower. I trust his judgement on whether to let you in on our little secret or not.");
                                        Main.saveQuestConfig();
                                        p.getInventory().addItem(Items.ResearchNotes.generateItem());
                                        return true;
                                }else{
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"You may need to free room in your backpack before i can give you the reserch items");
                                }
                                default:
                     //Shop.spawnShop(Shop.Auburyshop, p);
                        }
                        return false;
                }
        }
case "Seridor":
       
        if(RuneMysteries.isFinished(p)){
                return false;
        }else{
                if(RuneMysteries.isStarted(p)){
                        switch(Main.questconfig.getString(p.getDisplayName()+"."+RuneMysteries.ID+".Progress")){
                                case "5":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "6");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Welcome adventurer, to the world renowned Wizards' Tower. How may I help you? A strange Talismen you say, mind if i look?");
                                        Main.saveQuestConfig();
                                        return true;
                                case "6":
                                        for(ItemStack item:p.getInventory().getContents()){
                                                if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains("Unidentified Talasman")){
                                                        p.getInventory().remove(item);
                                                        taken=true;
                                                        break;
                                                }
                                        }
                                        if(taken){
                                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "7");
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Well that IS interesting. Hand it over then adventurer, let me see what all the hubbub about it is");
                                                p.sendMessage(ChatColor.GREEN+"You hand the Talisman to the wizard");
                                                Main.saveQuestConfig();
                                        }
                                        return true;
                                case "7":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "8");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Wow! This is... incredible!");
                                        p.sendMessage(ChatColor.GOLD+"Th-this talisman you brought me...! It is the last piece of the puzzle. I think! Finally! The legacy of our ancestors... it will return to us one more.");
                                        Main.saveQuestConfig();
                                        return true;
                                case "8":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "9");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"I need time to study this. Can you please do me this task while I study this talisman you have brought me? In the mighty town of Varrock, which");
                                        Main.saveQuestConfig();
                                        return true;
                                case "9":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "10");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"is located North East of here, there is a certain shop that sells magical runes. I have in this package all of the research I have done relating to the Rune Stones, and");
                                        Main.saveQuestConfig();
                                        return true;
                                case "10":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "11");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"require somebody to take them to the shopkeeper so that he may share my research and offer me his insights. Do this thing for me, and bring back what he gives you,");
                                        Main.saveQuestConfig();
                                        return true;
                                case "11":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "12");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"and if my suspicions are correct, I will let you into the knowledge of one of the greatest secrets this world has ever known! A secret so powerful that it destroyed the");
                                        Main.saveQuestConfig();
                                        return true;
                                case "12":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "13");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"original Wizards' Tower all of those centuries ago! MY research, combined with this mysterious talisman... I cannot believe the answer to the mysteries is so close now!");
                                        Main.saveQuestConfig();
                                        return true;
                                case "13":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "14");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Do this thing for me. Be rewarded in a way you can never imagine.");
                                        Main.saveQuestConfig();
                                        return true;
                                case "14":
                                        if(InventoryHandler.hasSpace(p)){
                                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "15");
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Take this package, and head directly North from here, through Draynor village, until you reach the Barbarian village. Then head East from there until you reach Varrock.");
                                                Main.saveQuestConfig();
                                                p.getInventory().addItem(Items.BlueReserchPackage.generateItem());
                                        }else{
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"You may need to free room in your backpack before i can give you the research items");
                                        }
                                        return true;
                                case "15":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "16");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Once in varrock, take this package to the owner of the rune shop. His name is Aubury. You may find it helpful to ask one of Varrock's citizens for directions");
                                        Main.saveQuestConfig();
                                        return true;
                                case "16":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "17");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"as Varrock can be a confusing place for the first time visitor. He will give you a special item - bring it back to me, and I shall show you the mystery of the runes...");
                                        Main.saveQuestConfig();
                                        return true;
                                case "17":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "18");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"(Objective: Find Aubury in Varrock and take him the Blue Research Package)");
                                        Main.saveQuestConfig();
                                        return true;
                               
                               
                               
                                case "24":
                                        for(ItemStack item:p.getInventory().getContents()){
                                                if(item!=null&&item.hasItemMeta()&&item.getItemMeta().hasDisplayName()&&item.getItemMeta().getDisplayName().contains("Research Notes")){
                                                        p.getInventory().remove(item);
                                                        taken=true;
                                                        break;
                                                }
                                        }
                                        if(taken){
                                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "25");
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"May I have his notes then?");
                                                Main.saveQuestConfig();
                                        }else{
                                                p.sendMessage(ChatColor.GREEN+"Ohh no where did i put the Reserch notes!!!");
                                        }
                                        return true;
                                case "25":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "26");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Well, before you hand them over to me, as you");
                                        Main.saveQuestConfig();
                                        return true;
                                case "26":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "27");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Now as you may or may not know, many centuries ago, the wizards at this Tower learnt the secret of creating Rune Stones, which allowed us to cast Magic very easily");
                                        Main.saveQuestConfig();
                                        return true;
                                case "27":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "28");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"When this Tower was burnt down the secret of creating runes was lost to us for all time... except it wasn't. Some months ago, while searching these ruins for information from the old days,");
                                        Main.saveQuestConfig();
                                        return true;
                                case "28":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "29");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"I came upon a scroll, almost destroyed, that detailed a magical rock deep in the icefields of the North closed off from access by anything other than magical means");
                                        Main.saveQuestConfig();
                                        return true;
                                case "29":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "30");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"This rock was called the Rune Essence by the magicians who studied its powers. Apparantly, by simply breaking a chunk from it, a Rune Stone could be fashioned very quickly and easily at certain");
                                        Main.saveQuestConfig();
                                        return true;
                                case "30":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "31");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"elemental altars that were scattered across the land back then. Now, this is an interesting little piece of history, but not much use to us as modern wizards without access to the Rune Essence.");
                                        Main.saveQuestConfig();
                                        return true;
                                case "31":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "32");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"or these elemental altars. This is where you and Aubury come into this story. A few weeks back, Aubury discovered in a standard delivery of runes to his store, a parchment detailing a");
                                        Main.saveQuestConfig();
                                        return true;
                                case "32":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "33");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"teleportation spell that he had never come across before. To his shock, when cast it took him to a strange rock he had never encountered before... yet that felt strangely familliar...");
                                        Main.saveQuestConfig();
                                        return true;
                                case "33":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "34");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"As I'm sure you have now guessed, he had discovered a portal leading to the mythical Rune Essence. As soon as he told me of this spell. I saw the importance of his find,");
                                        Main.saveQuestConfig();
                                        return true;
                                case "34":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "35");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"for if we could but find the elemental altars spoken of in the ancient texts, we would once more be able to create runes as our ancestors had done! It would be the saviour of the wizards' art!");
                                        Main.saveQuestConfig();
                                        return true;
                                case "35":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "36");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"You haven't guessed? This talisman you brought me... it is the key to the elemental altar of air! When you hold it next, it will direct you towards");
                                        Main.saveQuestConfig();
                                        return true;
                                case "36":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "37");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"the entrance to the long forgotten air Altar! By bringing pieces of the Rune Essence to the Air Temple, you will be able to fashion your own Air Runes!");
                                        Main.saveQuestConfig();
                                        return true;
                                case "37":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "38");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"And this is not all! By finding other talismans similar to this one, you will eventually be able to craft every rune that is available on this world! Just");
                                        Main.saveQuestConfig();
                                        return true;
                                case "38":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "39");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"as our ancestors did! I cannot stress enough what a find this is! Now, due to the risks involved of letting this mighty power fall into the wrong hands");
                                        Main.saveQuestConfig();
                                        return true;
                                case "39":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "40");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"I will keep the teleport skill to the Rune Essence a closely guarded secret, shared only by myself and those Magic users around the world whom I trust enough to keep it.");
                                        Main.saveQuestConfig();
                                        return true;
                                case "40":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "41");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"This means that if any evil power should discover the talisman required to enter the elemental temples, we will be able to prevent their access to the Rune Essence and prevent");
                                        Main.saveQuestConfig();
                                        return true;
                                case "41":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "42");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"tragedy befalling this world. I know not where the temples are located, nor do I know where the talismans have been scattered to in this land, but I now");
                                        Main.saveQuestConfig();
                                        return true;
                                case "42":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "43");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"return your Air Talisman to you. Find the Air Temple, and you will be able too charge your Rune Essences to become Air Runes at will. Any time");
                                        Main.saveQuestConfig();
                                        return true;
                                case "43":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "44");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"\"you wish to visit the Rune Essence, speak to me or Aubury and we will open a portal to that mystical place for you to visit.\"");
                                        Main.saveQuestConfig();
                                        return true;
                                case "44":
                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "45");
                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Use the Air Talisman to locate the air temple and use any further talismans you find to locate the other missing elemental temples. Now... my research notes please?");
                                        Main.saveQuestConfig();
                                        return true;
                                case "45":
                                        if(InventoryHandler.hasSpace(p)){
                                                RuneMysteries.finishQuest(p);
                                                p.getInventory().addItem(Items.AirTalasman.generateItem());
                                        }else{
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"You may need to free room in your backpack before i can give you the research items");
                                        }

                                        return true;
                        }
                }
                return false;
        }
       
        case "DukeHoracio":
               
                if(RuneMysteries.isFinished(p)){
                        return false;
                }else{
                        if(RuneMysteries.isStarted(p)){
                                switch(Main.questconfig.getString(p.getDisplayName()+"."+RuneMysteries.ID+".Progress")){
                                        case "1":
                                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "2");
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"I Found a Strange Talisman, well im not too sure what it is");
                                                Main.saveQuestConfig();
                                                return true;
                                        case "2":
                                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "3");
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"and was hoping you would help me find out what it is");
                                                Main.saveQuestConfig();
                                                return true;
                                        case "3":
                                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "4");
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"It seems to be mystical and I have never seen anything like it before. Would you take it to the head wizard at the Wizards' Tower for me? It's just south-west of here and should not take you very long at all. I would be awfully grateful.");
                                                Main.saveQuestConfig();
                                                return true;
                                        case "4":
                                                if(InventoryHandler.hasSpace(p)){
                                                        Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "5");
                                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"I am sure the head wizard will reward you for such an interesting find");
                                                        Main.saveQuestConfig();
                                                        p.getInventory().addItem(Items.UnidentifiedTalasman.generateItem());
                                                }else{
                                                        p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Im sorry friend, but you seem like your hands are full, please come back when you have room in your backpack");
                                                }
                                                return true;
                                        case "5":
                                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"(Objective: Find the head wizard and show him the talisman, Head SW from lumbrige)");
                                                Main.saveQuestConfig();
                                                return true;
                                       
                                }
                        }else{
                                Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "1");
                                p.sendMessage(ChatColor.LIGHT_PURPLE+"["+npc+"] "+ChatColor.GOLD+"Hello adventurer i was hoping you would help me with something");
                                return true;
                        }
                        return false;
                }}
		return false;
	}
	private boolean isFinished(Player p) {
		if(Main.questconfig.getString(p.getDisplayName()+"."+ID+".Progress")!=null&&Main.questconfig.getString(p.getDisplayName()+"."+ID+".Progress")=="Done"){
			return true;
		}
		return false;
	}
	private boolean isStarted(Player p) {
		if(Main.questconfig.getString(p.getDisplayName()+"."+ID+".Progress")!=null&&Main.questconfig.getString(p.getDisplayName()+"."+ID+".Progress")!="0"){
			return true;
		}
		return false;
	}
	public void finishQuest(Player p){
		Main.questconfig.set(p.getDisplayName()+"."+RuneMysteries.ID+".Progress", "Done");
		p.sendMessage(ChatColor.YELLOW+"You have finished Rune Mysteries!!");
		Main.saveQuestConfig();
	}
	public static void createQuestGui(Player p){
		int size = Quests.values().length;
		if(size<=8){
			size=9;
		}else if(size<=17){
			size=18;
		}else if(size<=26){
			size=27;
		}else if(size<=35){
			size=36;
		}else if(size<=44){
			size=44;
		}else if(size<=53){
			size=54;
		}
		Inventory inv = Bukkit.createInventory(null, size, "Quests");
		for (Quests quest : Quests.values()) {
			ItemStack item = null;
			if(Main.questconfig.getString(p.getDisplayName()+"."+quest.ID+".Progress")!=null){
				if(!Main.questconfig.getString(p.getDisplayName()+"."+quest.ID+".Progress").equalsIgnoreCase("Done")){
					//not finished
					item = new ItemStack(org.bukkit.Material.WOOL,1, DyeColor.ORANGE.getData());
					ItemMeta im = item.getItemMeta();
					im.setDisplayName(ChatColor.YELLOW+quest.name+" : In Progress");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.GREEN+""+ChatColor.UNDERLINE+"Rewards!");
					lore.add("Quest Points:"+quest.questpoints);
					for(String s:quest.rewards){
						lore.add(s);
					}
					lore.add(quest.startLoc);
					im.setLore(lore);
					item.setItemMeta(im);
					inv.addItem(item);
				}else{
					//done
					item = new ItemStack(org.bukkit.Material.WOOL,1, DyeColor.GREEN.getData());
					ItemMeta im = item.getItemMeta();
					im.setDisplayName(ChatColor.GREEN+quest.name+" : Finished");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.GREEN+""+ChatColor.UNDERLINE+"Rewards!");
					lore.add("Quest Points:"+quest.questpoints);
					for(String s:quest.rewards){
						lore.add(s);
					}
					lore.add(quest.startLoc);
					im.setLore(lore);
					item.setItemMeta(im);
					inv.addItem(item);
				}
			}else{
				//not started
				item = new ItemStack(org.bukkit.Material.WOOL,1, DyeColor.RED.getData());
				ItemMeta im = item.getItemMeta();
				im.setDisplayName(ChatColor.RED+quest.name+" : Not Started");
				List<String> lore = new ArrayList<String>();
				lore.add(ChatColor.GREEN+""+ChatColor.UNDERLINE+"Rewards!");
				lore.add("QuestPoints: "+quest.questpoints);
				for(String s:quest.rewards){
					lore.add(s);
				}
				lore.add(quest.startLoc);
				im.setLore(lore);
				item.setItemMeta(im);
				inv.addItem(item);
			}
		}
		
		p.openInventory(inv);
		
	}
}
