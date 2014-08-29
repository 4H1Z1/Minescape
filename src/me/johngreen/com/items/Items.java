package me.johngreen.com.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public enum Items {
	Ashes(Material.SUGAR,ChatColor.GREEN+"Ashes",new String[]{ChatColor.GOLD+"Type:Miscellaneous"},false,0,0),
	
	FireRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Fire Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,15,0),
	WaterRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Water Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,10,0),
	AirRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Air Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,13,0),
	EarthRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Earth Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,11,0),
	MindRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Mind Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,15,0),
	BodyRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Body Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,3,0),
	ChaosRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Chaos Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,90,0),
	DeathRune(Material.MAGMA_CREAM,ChatColor.GREEN+"Death Rune",new String[]{ChatColor.GOLD+"Type:Magic"},true,180,0),
	
	
	//cooking items
	Shrimp(Material.RAW_FISH,ChatColor.GREEN+"Shrimp",new String[]{ChatColor.GOLD+"Type:Food","Health:4"},false,0,0),
	Herring(Material.RAW_FISH,ChatColor.GREEN+"Herring",new String[]{ChatColor.GOLD+"Type:Food","Health:6"},false,0,0),
	Trout(Material.RAW_FISH,ChatColor.GREEN+"Trout",new String[]{ChatColor.GOLD+"Type:Food","Health:8"},false,0,1),
	Tuna(Material.RAW_FISH,ChatColor.GREEN+"Tuna",new String[]{ChatColor.GOLD+"Type:Food","Health:10"},false,0,1),
	Lobster(Material.RAW_FISH,ChatColor.GREEN+"Lobster",new String[]{ChatColor.GOLD+"Type:Food","Health:12"},false,0,2),
	Swordfish(Material.RAW_FISH,ChatColor.GREEN+"Swordfish",new String[]{ChatColor.GOLD+"Type:Food","Health:14"},false,0,2),
	Monkfish(Material.RAW_FISH,ChatColor.GREEN+"Monkfish",new String[]{ChatColor.GOLD+"Type:Food","Health:16"},false,0,3),
	Shark(Material.RAW_FISH,ChatColor.GREEN+"Shark",new String[]{ChatColor.GOLD+"Type:Food","Health:20"},false,0,3),
	
	
	Cooking_Shrimp(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Shrimp",new String[]{ChatColor.GOLD+"Level:1","XP:30"},false,0,0),
	Cooking_Herring(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Herring",new String[]{ChatColor.GOLD+"Level:5","XP:50"},false,0,0),
	Cooking_Trout(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Trout",new String[]{ChatColor.GOLD+"Level:15","XP:70"},false,0,1),
	Cooking_Tuna(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Tuna",new String[]{ChatColor.GOLD+"Level:30","XP:100"},false,0,1),
	Cooking_Lobster(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Lobster",new String[]{ChatColor.GOLD+"Level:40","XP:120"},false,0,2),
	Cooking_Swordfish(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Swordfish",new String[]{ChatColor.GOLD+"Level:45","XP:140"},false,0,2),
	Cooking_Monkfish(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Monkfish",new String[]{ChatColor.GOLD+"Level:62","XP:150"},false,0,3),
	Cooking_Shark(Material.RAW_FISH,ChatColor.LIGHT_PURPLE+"Cooking:"+ChatColor.GREEN+"Shark",new String[]{ChatColor.GOLD+"Level:80","XP:210"},false,0,3),
	
	
	UnidentifiedTalasman(Material.NETHER_STAR,ChatColor.GREEN+"Unidentified Talasman",new String[]{ChatColor.GOLD+"Type:Quest","\"I should take this to the Head Mage\""},false,0,0),
	BlueReserchPackage(Material.CHEST,ChatColor.GREEN+"Blue Reserch Package",new String[]{ChatColor.GOLD+"Type:Quest","\"I should take this to Aubury\""},false,0,0),
	ResearchNotes(Material.PAPER,ChatColor.GREEN+"Research Notes",new String[]{ChatColor.GOLD+"Type:Quest","\"I should take this to the Head Mage\""},false,0,0),
	
	AirTalasman(Material.NETHER_STAR,ChatColor.GREEN+"Air Talasman",new String[]{ChatColor.GOLD+"Type:Runecrafting"},false,0,0),
	
	Raw_Shrimp(Material.RAW_FISH,ChatColor.GREEN+"Raw Shrimp",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,0),
	Raw_Herring(Material.RAW_FISH,ChatColor.GREEN+"Raw Herring",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,0),
	Raw_Trout(Material.RAW_FISH,ChatColor.GREEN+"Raw Trout",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,1),
	Raw_Tuna(Material.RAW_FISH,ChatColor.GREEN+"Raw Tuna",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,1),
	Raw_Lobster(Material.RAW_FISH,ChatColor.GREEN+"Raw Lobster",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,2),
	Raw_Swordfish(Material.RAW_FISH,ChatColor.GREEN+"Raw Swordfish",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,2),
	Raw_Monkfish(Material.RAW_FISH,ChatColor.GREEN+"Raw Monkfish",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,3),
	Raw_Shark(Material.RAW_FISH,ChatColor.GREEN+"Raw Shark",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,3),
	
	Bait(Material.PUMPKIN_SEEDS,ChatColor.GREEN+"Bait",new String[]{ChatColor.GOLD+"Type:Fishing"},true,3,0),
	Net(Material.WEB,ChatColor.GREEN+"Net",new String[]{ChatColor.GOLD+"Type:Fishing"},false,40,0),
	BigNet(Material.WEB,ChatColor.GREEN+"Big Net",new String[]{ChatColor.GOLD+"Type:Fishing"},false,100,0),
	FishingRod(Material.FISHING_ROD,ChatColor.GREEN+"Fishing Rod",new String[]{ChatColor.GOLD+"Type:Fishing"},false,5,0),

	PartyHat_RED(Material.LEATHER_HELMET,ChatColor.GREEN+"Red partyhat",new String[]{ChatColor.GOLD+"PARTY!!!"},false,0,1),
	PartyHat_BLUE(Material.LEATHER_HELMET,ChatColor.GREEN+"Blue partyhat",new String[]{ChatColor.GOLD+"PARTY!!!"},false,0,2),
	PartyHat_WHITE(Material.LEATHER_HELMET,ChatColor.GREEN+"White partyhat",new String[]{ChatColor.GOLD+"PARTY!!!"},false,0,3),
	PartyHat_GREEN(Material.LEATHER_HELMET,ChatColor.GREEN+"Green partyhat",new String[]{ChatColor.GOLD+"PARTY!!!"},false,0,4),
	PartyHat_YELLOW(Material.LEATHER_HELMET,ChatColor.GREEN+"Yellow partyhat",new String[]{ChatColor.GOLD+"PARTY!!!"},false,0,5),
	PartyHat_PURPLE(Material.LEATHER_HELMET,ChatColor.GREEN+"Purple partyhat",new String[]{ChatColor.GOLD+"PARTY!!!"},false,0,6),
	
	
	//prayer items
	Prayer_ThickSkin(Material.LEATHER_CHESTPLATE,ChatColor.GREEN+"Thick Skin",new String[]{ChatColor.GOLD+"Level:1","+2% Defence","-1 Prayer Point Per 6 Secconds"},false,0,0),
	Prayer_BurstOfStrength(Material.POTION,ChatColor.GREEN+"Burst Of Strength",new String[]{ChatColor.GOLD+"Level:4","+2% Attack","-1 Prayer Point Per 6 Secconds"},false,0,0),
	Prayer_ClarityOfThought(Material.WOOD_SWORD,ChatColor.GREEN+"Clarity Of Thought",new String[]{ChatColor.GOLD+"Level:7","+2 Attack","-1 Prayer Point Per 6 Secconds"},false,0,0),
	Prayer_UnstoppableForce(Material.BOW,ChatColor.GREEN+"Unstoppable Force",new String[]{ChatColor.GOLD+"Level:8","+2% Range","-1 Prayer Point Per 6 Secconds"},false,0,0),
	Prayer_Charge(Material.NETHER_STAR,ChatColor.GREEN+"Charge",new String[]{ChatColor.GOLD+"Level:9","+2% magic","-1 Prayer Point Per 6 Secconds"},false,0,0),
	
	Prayer_RockSkin(Material.GOLD_CHESTPLATE,ChatColor.GREEN+"Rock Skin",new String[]{ChatColor.GOLD+"Level:10","+4% Defence","-1 Prayer Point Per 2 Secconds"},false,0,0),
	Prayer_SuperhumanStrength(Material.POTION,ChatColor.GREEN+"Superhuman Strength",new String[]{ChatColor.GOLD+"Level:13","+4% Attack","-1 Prayer Point Per 2 Secconds"},false,0,0),
	Prayer_ImprovedReflexes(Material.IRON_SWORD,ChatColor.GREEN+"Improved Reflexes",new String[]{ChatColor.GOLD+"Level:16","+4 Attack","-1 Prayer Point Per 2 Secconds"},false,0,0),
	Prayer_UnrelentingForce(Material.BOW,ChatColor.GREEN+"Unrelenting Force",new String[]{ChatColor.GOLD+"Level:26","+4% Range","-1 Prayer Point Per 2 Secconds"},false,0,0),
	Prayer_SuperCharge(Material.BLAZE_ROD,ChatColor.GREEN+"Super Charge",new String[]{ChatColor.GOLD+"Level:27","+4% Magic","-1 Prayer Point Per 2 Secconds"},false,0,0),
	
	Prayer_SteelSkin(Material.IRON_CHESTPLATE,ChatColor.GREEN+"Steel Skin",new String[]{ChatColor.GOLD+"Level:28","+6% Defence","-1 Prayer Point Per 1 Secconds"},false,0,0),
	Prayer_IncredibleReflexes(Material.GOLD_SWORD,ChatColor.GREEN+"Incredible Reflexes",new String[]{ChatColor.GOLD+"Level:34","+6% Attack","-1 Prayer Point Per 1 Secconds"},false,0,0),
	Prayer_ProtectfromMagic(Material.CHAINMAIL_CHESTPLATE,ChatColor.GREEN+"Protect from Magic",new String[]{ChatColor.GOLD+"Level:37","-50% Melee Magic on you","-1 Prayer Point Per 0.5 Secconds"},false,0,0),
	Prayer_ProtectfromRange(Material.CHAINMAIL_CHESTPLATE,ChatColor.GREEN+"Protect from Range",new String[]{ChatColor.GOLD+"Level:40","-50% Melee Range on you","-1 Prayer Point Per 0.5 Secconds"},false,0,0),
	Prayer_ProtectfromMelee(Material.CHAINMAIL_CHESTPLATE,ChatColor.GREEN+"Protect from Melee",new String[]{ChatColor.GOLD+"Level:43","-50% Melee Attacks on you","-1 Prayer Point Per 0.5 Secconds"},false,0,0),
	Prayer_OverpoweringForce(Material.BOW,ChatColor.GREEN+"Overpowering Force",new String[]{ChatColor.GOLD+"Level:44","+6% Range","-1 Prayer Point Per 0.5 Secconds"},false,0,0),
	Prayer_Overcharge(Material.NETHER_STAR,ChatColor.GREEN+"Overcharge",new String[]{ChatColor.GOLD+"Level:45","+6 Magic","-1 Prayer Point Per 0.5 Secconds"},false,0,0),
	
	
	
	
	//furnace Items
	Furnace_BronzeBar(Material.CLAY_BRICK,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Bar",new String[]{ChatColor.GOLD+"Requirments:","1 CopperOre","1 TinOre","XP:7"},false,0,0),
	Furnace_IronBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Bar",new String[]{ChatColor.GOLD+"Requirments:","1 Iron","Level:15","XP:13"},false,0,0),
	Furnace_SilverBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Silver Bar",new String[]{ChatColor.GOLD+"Requirments:","1 SilverOre","Level:20","XP:14"},false,0,0),
	Furnace_SteelBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Bar",new String[]{ChatColor.GOLD+"Requirments:","1 IronOre","2 Coal","Level:30","XP:18"},false,0,0),
	Furnace_GoldBar(Material.GOLD_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Gold Bar",new String[]{ChatColor.GOLD+"Requirments:","1 GoldOre","Level:40","XP:23"},false,0,0),
	Furnace_MithrillBar(Material.NETHER_BRICK_ITEM,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Bar",new String[]{ChatColor.GOLD+"Requirments:","1 MithrillOre","4 Coal","Level:50","XP:30"},false,0,0),
	Furnace_AdamantBar(Material.ACACIA_STAIRS.NETHER_BRICK_ITEM,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamant Bar",new String[]{ChatColor.GOLD+"Requirments:","1 AdamantiteOre","6 Coal","Level:70","XP:38"},false,0,0),
	Furnace_RuneBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Bar",new String[]{ChatColor.GOLD+"Requirments:","1 RuneOre","8 Coal","Level:85","XP:50"},false,0,0),
	
	
	//anvil
	Anvil_BronzeBar(Material.CLAY_BRICK,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Items",new String[]{ChatColor.GOLD+""},false,0,0),
	Anvil_IronBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Items",new String[]{ChatColor.GOLD+""},false,0,0),
	Anvil_SilverBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Silver Items",new String[]{ChatColor.GOLD+""},false,0,0),
	Anvil_SteelBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Items",new String[]{ChatColor.GOLD+""},false,0,0),
	Anvil_GoldBar(Material.GOLD_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Gold Items",new String[]{ChatColor.GOLD+""},false,0,0),
	Anvil_MithrillBar(Material.NETHER_BRICK_ITEM,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Items",new String[]{ChatColor.GOLD+""},false,0,0),
	Anvil_AdamantBar(Material.ACACIA_STAIRS.NETHER_BRICK_ITEM,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamant Items",new String[]{ChatColor.GOLD+""},false,0,0),
	Anvil_RuneBar(Material.IRON_INGOT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Items",new String[]{ChatColor.GOLD+""},false,0,0),
	
	
	Anvil_Back(Material.WEB,ChatColor.GREEN+"Back",new String[]{},false,0,0),

	
	//anvil bronze armour
	Anvil_Arrowhead_Bronze(Material.FLINT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Arrowhead",new String[]{ChatColor.GOLD+"Level: 5","Bars: 1","XP:13"},false,0,0),
	Anvil_Dagger_Bronze(Material.WOOD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Dagger",new String[]{ChatColor.GOLD+"Level: 1","Bars: 1","XP:13"},false,0,0),
	Anvil_Hatchet_Bronze(Material.WOOD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Hatchet",new String[]{ChatColor.GOLD+"Level: 1","Bars: 1","XP:13"},false,0,0),
	Anvil_Pickaxe_Bronze(Material.WOOD_PICKAXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Pickaxe",new String[]{ChatColor.GOLD+"Level: 5","Bars: 2","XP:25"},false,0,0),
	Anvil_Mace_Bronze(Material.WOOD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Mace",new String[]{ChatColor.GOLD+"Level: 2","Bars: 1","XP:13"},false,0,0),
	Anvil_MediumHelmet_Bronze(Material.LEATHER_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze MediumHelmet",new String[]{ChatColor.GOLD+"Level: 1","Bars: 1","XP:13"},false,0,0),
	Anvil_Sword_Bronze(Material.WOOD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Sword",new String[]{ChatColor.GOLD+"Level: 4","Bars: 1","XP:13"},false,0,0),
	Anvil_Scimitar_Bronze(Material.WOOD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Scimitar",new String[]{ChatColor.GOLD+"Level: 5","Bars: 2","XP:25"},false,0,0),
	Anvil_Longsword_Bronze(Material.WOOD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Longsword",new String[]{ChatColor.GOLD+"Level: 6","Bars: 2","XP:25"},false,0,0),
	Anvil_FullHelmet_Bronze(Material.LEATHER_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze FullHelmet",new String[]{ChatColor.GOLD+"Level: 7","Bars: 2","XP:25"},false,0,0),
	Anvil_Warhammer_Bronze(Material.WOOD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Warhammer",new String[]{ChatColor.GOLD+"Level: 9","Bars:3","XP:38"},false,0,0),
	Anvil_Battleaxe_Bronze(Material.WOOD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Battleaxe",new String[]{ChatColor.GOLD+"Level: 10","Bars: 3","XP:38"},false,0,0),
	Anvil_Chainbody_Bronze(Material.LEATHER_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Chainbody",new String[]{ChatColor.GOLD+"Level: 11","Bars: 3","XP:38"},false,0,0),
	Anvil_TwoHandedSword_Bronze(Material.WOOD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 14","Bars: 3","XP:38"},false,0,0),
	Anvil_Platelegs_Bronze(Material.LEATHER_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Platelegs",new String[]{ChatColor.GOLD+"Level: 16","Bars: 3","XP:38"},false,0,0),
	Anvil_Plateskirt_Bronze(Material.LEATHER_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Plateskirt",new String[]{ChatColor.GOLD+"Level: 16","Bars: 3","XP:38"},false,0,0),
	Anvil_Platebody_Bronze(Material.LEATHER_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Bronze Platebody",new String[]{ChatColor.GOLD+"Level: 18","Bars: 5","XP:63"},false,0,0),
	
	
	//anvil Iron armour
	Anvil_Arrowhead_Iron(Material.FLINT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Arrowhead",new String[]{ChatColor.GOLD+"Level: 20","Bars: 1","XP:25"},false,0,0),
	Anvil_Dagger_Iron(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Dagger",new String[]{ChatColor.GOLD+"Level: 15","Bars: 1","XP:25"},false,0,0),
	Anvil_Hatchet_Iron(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Hatchet",new String[]{ChatColor.GOLD+"Level: 16","Bars: 1","XP:25"},false,0,0),
	Anvil_Pickaxe_Iron(Material.IRON_PICKAXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Pickaxe",new String[]{ChatColor.GOLD+"Level: 20","Bars: 2","XP:50"},false,0,0),
	Anvil_Mace_Iron(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Mace",new String[]{ChatColor.GOLD+"Level: 17","Bars: 1","XP:25"},false,0,0),
	Anvil_MediumHelmet_Iron(Material.IRON_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron MediumHelmet",new String[]{ChatColor.GOLD+"Level: 18","Bars: 1","XP:25"},false,0,0),
	Anvil_Sword_Iron(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Sword",new String[]{ChatColor.GOLD+"Level: 19","Bars: 1","XP:25"},false,0,0),
	Anvil_Scimitar_Iron(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Scimitar",new String[]{ChatColor.GOLD+"Level: 20","Bars: 2","XP:50"},false,0,0),
	Anvil_Longsword_Iron(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Longsword",new String[]{ChatColor.GOLD+"Level: 21","Bars: 2","XP:50"},false,0,0),
	Anvil_FullHelmet_Iron(Material.IRON_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron FullHelmet",new String[]{ChatColor.GOLD+"Level: 22","Bars: 2","XP:50"},false,0,0),
	Anvil_Warhammer_Iron(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Warhammer",new String[]{ChatColor.GOLD+"Level: 24","Bars:3","XP:75"},false,0,0),
	Anvil_Battleaxe_Iron(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Battleaxe",new String[]{ChatColor.GOLD+"Level: 25","Bars: 3","XP:75"},false,0,0),
	Anvil_Chainbody_Iron(Material.IRON_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Chainbody",new String[]{ChatColor.GOLD+"Level: 26","Bars: 3","XP:75"},false,0,0),
	Anvil_TwoHandedSword_Iron(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 29","Bars: 3","XP:75"},false,0,0),
	Anvil_Platelegs_Iron(Material.IRON_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Platelegs",new String[]{ChatColor.GOLD+"Level: 31","Bars: 3","XP:75"},false,0,0),
	Anvil_Plateskirt_Iron(Material.IRON_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Plateskirt",new String[]{ChatColor.GOLD+"Level: 31","Bars: 3","XP:75"},false,0,0),
	Anvil_Platebody_Iron(Material.IRON_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Iron Platebody",new String[]{ChatColor.GOLD+"Level: 33","Bars: 5","XP:125"},false,0,0),
	
	
	//anvil Steel armour
	Anvil_Arrowhead_Steel(Material.FLINT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Arrowhead",new String[]{ChatColor.GOLD+"Level: 35","Bars: 1","XP:38"},false,0,0),
	Anvil_Dagger_Steel(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Dagger",new String[]{ChatColor.GOLD+"Level: 30","Bars: 1","XP:38"},false,0,0),
	Anvil_Hatchet_Steel(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Hatchet",new String[]{ChatColor.GOLD+"Level: 31","Bars: 1","XP:38"},false,0,0),
	Anvil_Pickaxe_Steel(Material.IRON_PICKAXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Pickaxe",new String[]{ChatColor.GOLD+"Level: 35","Bars: 2","XP:75"},false,0,0),
	Anvil_Mace_Steel(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Mace",new String[]{ChatColor.GOLD+"Level: 32","Bars: 1","XP:38"},false,0,0),
	Anvil_MediumHelmet_Steel(Material.IRON_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel MediumHelmet",new String[]{ChatColor.GOLD+"Level: 33","Bars: 1","XP:38"},false,0,0),
	Anvil_Sword_Steel(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Sword",new String[]{ChatColor.GOLD+"Level: 34","Bars: 1","XP:38"},false,0,0),
	Anvil_Scimitar_Steel(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Scimitar",new String[]{ChatColor.GOLD+"Level: 35","Bars: 2","XP:75"},false,0,0),
	Anvil_Longsword_Steel(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Longsword",new String[]{ChatColor.GOLD+"Level: 36","Bars: 2","XP:75"},false,0,0),
	Anvil_FullHelmet_Steel(Material.IRON_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel FullHelmet",new String[]{ChatColor.GOLD+"Level: 37","Bars: 2","XP:75"},false,0,0),
	Anvil_Warhammer_Steel(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Warhammer",new String[]{ChatColor.GOLD+"Level: 39","Bars:3","XP:113"},false,0,0),
	Anvil_Battleaxe_Steel(Material.IRON_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Battleaxe",new String[]{ChatColor.GOLD+"Level: 40","Bars: 3","XP:113"},false,0,0),
	Anvil_Chainbody_Steel(Material.IRON_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Chainbody",new String[]{ChatColor.GOLD+"Level: 41","Bars: 3","XP:113"},false,0,0),
	Anvil_TwoHandedSword_Steel(Material.IRON_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 44","Bars: 3","XP:113"},false,0,0),
	Anvil_Platelegs_Steel(Material.IRON_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Platelegs",new String[]{ChatColor.GOLD+"Level: 46","Bars: 3","XP:113"},false,0,0),
	Anvil_Plateskirt_Steel(Material.IRON_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Plateskirt",new String[]{ChatColor.GOLD+"Level: 46","Bars: 3","XP:113"},false,0,0),
	Anvil_Platebody_Steel(Material.IRON_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Steel Platebody",new String[]{ChatColor.GOLD+"Level: 48","Bars: 5","XP:188"},false,0,0),
	
	
	//anvil Mithrill armour
	Anvil_Arrowhead_Mithrill(Material.FLINT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Arrowhead",new String[]{ChatColor.GOLD+"Level: 55","Bars: 1","XP:50"},false,0,0),
	Anvil_Dagger_Mithrill(Material.GOLD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Dagger",new String[]{ChatColor.GOLD+"Level: 50","Bars: 1","XP:50"},false,0,0),
	Anvil_Hatchet_Mithrill(Material.GOLD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Hatchet",new String[]{ChatColor.GOLD+"Level: 51","Bars: 1","XP:50"},false,0,0),
	Anvil_Pickaxe_Mithrill(Material.GOLD_PICKAXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Pickaxe",new String[]{ChatColor.GOLD+"Level: 55","Bars: 2","XP:100"},false,0,0),
	Anvil_Mace_Mithrill(Material.GOLD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Mace",new String[]{ChatColor.GOLD+"Level: 52","Bars: 1","XP:50"},false,0,0),
	Anvil_MediumHelmet_Mithrill(Material.GOLD_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill MediumHelmet",new String[]{ChatColor.GOLD+"Level: 53","Bars: 1","XP:50"},false,0,0),
	Anvil_Sword_Mithrill(Material.GOLD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Sword",new String[]{ChatColor.GOLD+"Level: 54","Bars: 1","XP:50"},false,0,0),
	Anvil_Scimitar_Mithrill(Material.GOLD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Scimitar",new String[]{ChatColor.GOLD+"Level: 55","Bars: 2","XP:100"},false,0,0),
	Anvil_Longsword_Mithrill(Material.GOLD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Longsword",new String[]{ChatColor.GOLD+"Level: 56","Bars: 2","XP:100"},false,0,0),
	Anvil_FullHelmet_Mithrill(Material.GOLD_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill FullHelmet",new String[]{ChatColor.GOLD+"Level: 57","Bars: 2","XP:100"},false,0,0),
	Anvil_Warhammer_Mithrill(Material.GOLD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Warhammer",new String[]{ChatColor.GOLD+"Level: 59","Bars:3","XP:150"},false,0,0),
	Anvil_Battleaxe_Mithrill(Material.GOLD_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Battleaxe",new String[]{ChatColor.GOLD+"Level: 60","Bars: 3","XP:150"},false,0,0),
	Anvil_Chainbody_Mithrill(Material.GOLD_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Chainbody",new String[]{ChatColor.GOLD+"Level: 61","Bars: 3","XP:150"},false,0,0),
	Anvil_TwoHandedSword_Mithrill(Material.GOLD_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 64","Bars: 3","XP:150"},false,0,0),
	Anvil_Platelegs_Mithrill(Material.GOLD_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Platelegs",new String[]{ChatColor.GOLD+"Level: 66","Bars: 3","XP:150"},false,0,0),
	Anvil_Plateskirt_Mithrill(Material.GOLD_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Plateskirt",new String[]{ChatColor.GOLD+"Level: 66","Bars: 3","XP:150"},false,0,0),
	Anvil_Platebody_Mithrill(Material.GOLD_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Mithrill Platebody",new String[]{ChatColor.GOLD+"Level: 68","Bars: 5","XP:250"},false,0,0),
	
	
	//anvil Adamantite armour
	Anvil_Arrowhead_Adamantite(Material.FLINT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Arrowhead",new String[]{ChatColor.GOLD+"Level: 75","Bars: 1","XP:63"},false,0,0),
	Anvil_Dagger_Adamantite(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Dagger",new String[]{ChatColor.GOLD+"Level: 70","Bars: 1","XP:63"},false,0,0),
	Anvil_Hatchet_Adamantite(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Hatchet",new String[]{ChatColor.GOLD+"Level: 71","Bars: 1","XP:63"},false,0,0),
	Anvil_Pickaxe_Adamantite(Material.DIAMOND_PICKAXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Pickaxe",new String[]{ChatColor.GOLD+"Level: 75","Bars: 2","XP:125"},false,0,0),
	Anvil_Mace_Adamantite(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Mace",new String[]{ChatColor.GOLD+"Level: 72","Bars: 1","XP:63"},false,0,0),
	Anvil_MediumHelmet_Adamantite(Material.DIAMOND_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite MediumHelmet",new String[]{ChatColor.GOLD+"Level: 71","Bars: 1","XP:63"},false,0,0),
	Anvil_Sword_Adamantite(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Sword",new String[]{ChatColor.GOLD+"Level: 74","Bars: 1","XP:63"},false,0,0),
	Anvil_Scimitar_Adamantite(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Scimitar",new String[]{ChatColor.GOLD+"Level: 75","Bars: 2","XP:125"},false,0,0),
	Anvil_Longsword_Adamantite(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Longsword",new String[]{ChatColor.GOLD+"Level: 76","Bars: 2","XP:125"},false,0,0),
	Anvil_FullHelmet_Adamantite(Material.DIAMOND_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite FullHelmet",new String[]{ChatColor.GOLD+"Level: 77","Bars: 2","XP:125"},false,0,0),
	Anvil_Warhammer_Adamantite(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Warhammer",new String[]{ChatColor.GOLD+"Level: 79","Bars:3","XP:188"},false,0,0),
	Anvil_Battleaxe_Adamantite(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Battleaxe",new String[]{ChatColor.GOLD+"Level: 80","Bars: 3","XP:188"},false,0,0),
	Anvil_Chainbody_Adamantite(Material.DIAMOND_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Chainbody",new String[]{ChatColor.GOLD+"Level: 81","Bars: 3","XP:188"},false,0,0),
	Anvil_TwoHandedSword_Adamantite(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 84","Bars: 3","XP:188"},false,0,0),
	Anvil_Platelegs_Adamantite(Material.DIAMOND_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Platelegs",new String[]{ChatColor.GOLD+"Level: 86","Bars: 3","XP:188"},false,0,0),
	Anvil_Plateskirt_Adamantite(Material.DIAMOND_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Plateskirt",new String[]{ChatColor.GOLD+"Level: 86","Bars: 3","XP:188"},false,0,0),
	Anvil_Platebody_Adamantite(Material.DIAMOND_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Adamantite Platebody",new String[]{ChatColor.GOLD+"Level: 88","Bars: 5","XP:313"},false,0,0),
	
	
	//anvil Runite armour
	Anvil_Arrowhead_Rune(Material.FLINT,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Arrowhead",new String[]{ChatColor.GOLD+"Level: 90","Bars: 1","XP:75"},false,0,0),
	Anvil_Dagger_Rune(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Dagger",new String[]{ChatColor.GOLD+"Level: 85","Bars: 1","XP:75"},false,0,0),
	Anvil_Hatchet_Rune(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Hatchet",new String[]{ChatColor.GOLD+"Level: 86","Bars: 1","XP:75"},false,0,0),
	Anvil_Pickaxe_Rune(Material.DIAMOND_PICKAXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Pickaxe",new String[]{ChatColor.GOLD+"Level: 90","Bars: 2","XP:150"},false,0,0),
	Anvil_Mace_Rune(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Mace",new String[]{ChatColor.GOLD+"Level: 87","Bars: 1","XP:75"},false,0,0),
	Anvil_MediumHelmet_Rune(Material.DIAMOND_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune MediumHelmet",new String[]{ChatColor.GOLD+"Level: 88","Bars: 1","XP:75"},false,0,0),
	Anvil_Sword_Rune(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Sword",new String[]{ChatColor.GOLD+"Level: 89","Bars: 1","XP:75"},false,0,0),
	Anvil_Scimitar_Rune(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Scimitar",new String[]{ChatColor.GOLD+"Level: 90","Bars: 2","XP:150"},false,0,0),
	Anvil_Longsword_Rune(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Longsword",new String[]{ChatColor.GOLD+"Level: 91","Bars: 2","XP:150"},false,0,0),
	Anvil_FullHelmet_Rune(Material.DIAMOND_HELMET,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune FullHelmet",new String[]{ChatColor.GOLD+"Level: 92","Bars: 2","XP:150"},false,0,0),
	Anvil_Warhammer_Rune(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Warhammer",new String[]{ChatColor.GOLD+"Level: 94","Bars:3","XP:225"},false,0,0),
	Anvil_Battleaxe_Rune(Material.DIAMOND_AXE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Battleaxe",new String[]{ChatColor.GOLD+"Level: 95","Bars: 3","XP:225"},false,0,0),
	Anvil_Chainbody_Rune(Material.DIAMOND_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Chainbody",new String[]{ChatColor.GOLD+"Level: 96","Bars: 3","XP:225"},false,0,0),
	Anvil_TwoHandedSword_Rune(Material.DIAMOND_SWORD,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 99","Bars: 3","XP:225"},false,0,0),
	Anvil_Platelegs_Rune(Material.DIAMOND_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Platelegs",new String[]{ChatColor.GOLD+"Level: 99","Bars: 3","XP:225"},false,0,0),
	Anvil_Plateskirt_Rune(Material.DIAMOND_LEGGINGS,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Plateskirt",new String[]{ChatColor.GOLD+"Level: 99","Bars: 3","XP:225"},false,0,0),
	Anvil_Platebody_Rune(Material.DIAMOND_CHESTPLATE,ChatColor.LIGHT_PURPLE+"Smithing:"+ChatColor.GREEN+"Rune Platebody",new String[]{ChatColor.GOLD+"Level: 99","Bars: 5","XP:375"},false,0,0),
	
	
	
	
	
	
	
	// bronze armour
	Arrowhead_Bronze(Material.FLINT,ChatColor.GREEN+"Bronze Arrowhead",new String[]{ChatColor.GOLD+"Type:Fleching"},true,0,0),
	Dagger_Bronze(Material.WOOD_SWORD,ChatColor.GREEN+"Bronze Dagger",new String[]{ChatColor.GOLD+"Level: 1","Damage:1"},false,14,0),
	Mace_Bronze(Material.WOOD_AXE,ChatColor.GREEN+"Bronze Mace",new String[]{ChatColor.GOLD+"Level: 1","Damage:2"},false,20,0),
	MediumHelmet_Bronze(Material.LEATHER_HELMET,ChatColor.GREEN+"Bronze MediumHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,25,0),
	Sword_Bronze(Material.WOOD_SWORD,ChatColor.GREEN+"Bronze Sword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,26,0),
	Scimitar_Bronze(Material.WOOD_SWORD,ChatColor.GREEN+"Bronze Scimitar",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,27,0),
	Longsword_Bronze(Material.WOOD_SWORD,ChatColor.GREEN+"Bronze Longsword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,28,0),
	FullHelmet_Bronze(Material.LEATHER_HELMET,ChatColor.GREEN+"Bronze FullHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,23,0),
	Warhammer_Bronze(Material.WOOD_AXE,ChatColor.GREEN+"Bronze Warhammer",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,26,0),
	Battleaxe_Bronze(Material.WOOD_AXE,ChatColor.GREEN+"Bronze Battleaxe",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,26,0),
	Chainbody_Bronze(Material.LEATHER_CHESTPLATE,ChatColor.GREEN+"Bronze Chainbody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,27,0),
	TwoHandedSword_Bronze(Material.WOOD_SWORD,ChatColor.GREEN+"Bronze TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,30,0),
	Platelegs_Bronze(Material.LEATHER_LEGGINGS,ChatColor.GREEN+"Bronze Platelegs",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,45,0),
	Plateskirt_Bronze(Material.LEATHER_LEGGINGS,ChatColor.GREEN+"Bronze Plateskirt",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,34,0),
	Platebody_Bronze(Material.LEATHER_CHESTPLATE,ChatColor.GREEN+"Bronze Platebody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,54,0),
	
	
	// Iron armour
	Arrowhead_Iron(Material.FLINT,ChatColor.GREEN+"Iron Arrowhead",new String[]{ChatColor.GOLD+"Type:Fleching"},true,0,0),
	Dagger_Iron(Material.IRON_SWORD,ChatColor.GREEN+"Iron Dagger",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,35,0),
	Mace_Iron(Material.IRON_AXE,ChatColor.GREEN+"Iron Mace",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	MediumHelmet_Iron(Material.IRON_HELMET,ChatColor.GREEN+"Iron MediumHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Sword_Iron(Material.IRON_SWORD,ChatColor.GREEN+"Iron Sword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,91,0),
	Scimitar_Iron(Material.IRON_SWORD,ChatColor.GREEN+"Iron Scimitar",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,112,0),
	Longsword_Iron(Material.IRON_SWORD,ChatColor.GREEN+"Iron Longsword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,140,0),
	FullHelmet_Iron(Material.IRON_HELMET,ChatColor.GREEN+"Iron FullHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Warhammer_Iron(Material.IRON_AXE,ChatColor.GREEN+"Iron Warhammer",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Battleaxe_Iron(Material.IRON_AXE,ChatColor.GREEN+"Iron Battleaxe",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Chainbody_Iron(Material.IRON_CHESTPLATE,ChatColor.GREEN+"Iron Chainbody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	TwoHandedSword_Iron(Material.IRON_SWORD,ChatColor.GREEN+"Iron TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Platelegs_Iron(Material.IRON_LEGGINGS,ChatColor.GREEN+"Iron Platelegs",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Plateskirt_Iron(Material.IRON_LEGGINGS,ChatColor.GREEN+"Iron Plateskirt",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Platebody_Iron(Material.IRON_CHESTPLATE,ChatColor.GREEN+"Iron Platebody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	
	
	// Steel armour
	Arrowhead_Steel(Material.FLINT,ChatColor.GREEN+"Steel Arrowhead",new String[]{ChatColor.GOLD+"Type:Fleching"},true,0,0),
	Dagger_Steel(Material.IRON_SWORD,ChatColor.GREEN+"Steel Dagger",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,125,0),
	Mace_Steel(Material.IRON_AXE,ChatColor.GREEN+"Steel Mace",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	MediumHelmet_Steel(Material.IRON_HELMET,ChatColor.GREEN+"Steel MediumHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Sword_Steel(Material.IRON_SWORD,ChatColor.GREEN+"Steel Sword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,325,0),
	Scimitar_Steel(Material.IRON_SWORD,ChatColor.GREEN+"Steel Scimitar",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,400,0),
	Longsword_Steel(Material.IRON_SWORD,ChatColor.GREEN+"Steel Longsword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,500,0),
	FullHelmet_Steel(Material.IRON_HELMET,ChatColor.GREEN+"Steel FullHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Warhammer_Steel(Material.IRON_AXE,ChatColor.GREEN+"Steel Warhammer",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Battleaxe_Steel(Material.IRON_AXE,ChatColor.GREEN+"Steel Battleaxe",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Chainbody_Steel(Material.IRON_CHESTPLATE,ChatColor.GREEN+"Steel Chainbody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	TwoHandedSword_Steel(Material.IRON_SWORD,ChatColor.GREEN+"Steel TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Platelegs_Steel(Material.IRON_LEGGINGS,ChatColor.GREEN+"Steel Platelegs",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Plateskirt_Steel(Material.IRON_LEGGINGS,ChatColor.GREEN+"Steel Plateskirt",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Platebody_Steel(Material.IRON_CHESTPLATE,ChatColor.GREEN+"Steel Platebody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	
	
	// Mithrill armour
	Arrowhead_Mithrill(Material.FLINT,ChatColor.GREEN+"Mithrill Arrowhead",new String[]{ChatColor.GOLD+"Type:Fleching"},true,0,0),
	Dagger_Mithrill(Material.GOLD_SWORD,ChatColor.GREEN+"Mithrill Dagger",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,325,0),
	Mace_Mithrill(Material.GOLD_AXE,ChatColor.GREEN+"Mithrill Mace",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	MediumHelmet_Mithrill(Material.GOLD_HELMET,ChatColor.GREEN+"Mithrill MediumHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Sword_Mithrill(Material.GOLD_SWORD,ChatColor.GREEN+"Mithrill Sword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,845,0),
	Scimitar_Mithrill(Material.GOLD_SWORD,ChatColor.GREEN+"Mithrill Scimitar",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,1060,0),
	Longsword_Mithrill(Material.GOLD_SWORD,ChatColor.GREEN+"Mithrill Longsword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,1300,0),
	FullHelmet_Mithrill(Material.GOLD_HELMET,ChatColor.GREEN+"Mithrill FullHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Warhammer_Mithrill(Material.GOLD_AXE,ChatColor.GREEN+"Mithrill Warhammer",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Battleaxe_Mithrill(Material.GOLD_AXE,ChatColor.GREEN+"Mithrill Battleaxe",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Chainbody_Mithrill(Material.GOLD_CHESTPLATE,ChatColor.GREEN+"Mithrill Chainbody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	TwoHandedSword_Mithrill(Material.GOLD_SWORD,ChatColor.GREEN+"Mithrill TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Platelegs_Mithrill(Material.GOLD_LEGGINGS,ChatColor.GREEN+"Mithrill Platelegs",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Plateskirt_Mithrill(Material.GOLD_LEGGINGS,ChatColor.GREEN+"Mithrill Plateskirt",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Platebody_Mithrill(Material.GOLD_CHESTPLATE,ChatColor.GREEN+"Mithrill Platebody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	
	
	// Adamantite armour
	Arrowhead_Adamantite(Material.FLINT,ChatColor.GREEN+"Adamantite Arrowhead",new String[]{ChatColor.GOLD+"Type:Fleching"},true,0,0),
	Dagger_Adamantite(Material.DIAMOND_SWORD,ChatColor.GREEN+"Adamantite Dagger",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,800,0),
	Mace_Adamantite(Material.DIAMOND_AXE,ChatColor.GREEN+"Adamantite Mace",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	MediumHelmet_Adamantite(Material.DIAMOND_HELMET,ChatColor.GREEN+"Adamantite MediumHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Sword_Adamantite(Material.DIAMOND_SWORD,ChatColor.GREEN+"Adamantite Sword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,2080,0),
	Scimitar_Adamantite(Material.DIAMOND_SWORD,ChatColor.GREEN+"Adamantite Scimitar",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Longsword_Adamantite(Material.DIAMOND_SWORD,ChatColor.GREEN+"Adamantite Longsword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,3200,0),
	FullHelmet_Adamantite(Material.DIAMOND_HELMET,ChatColor.GREEN+"Adamantite FullHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Warhammer_Adamantite(Material.DIAMOND_AXE,ChatColor.GREEN+"Adamantite Warhammer",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Battleaxe_Adamantite(Material.DIAMOND_AXE,ChatColor.GREEN+"Adamantite Battleaxe",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Chainbody_Adamantite(Material.DIAMOND_CHESTPLATE,ChatColor.GREEN+"Adamantite Chainbody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	TwoHandedSword_Adamantite(Material.DIAMOND_SWORD,ChatColor.GREEN+"Adamantite TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Platelegs_Adamantite(Material.DIAMOND_LEGGINGS,ChatColor.GREEN+"Adamantite Platelegs",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Plateskirt_Adamantite(Material.DIAMOND_LEGGINGS,ChatColor.GREEN+"Adamantite Plateskirt",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Platebody_Adamantite(Material.DIAMOND_CHESTPLATE,ChatColor.GREEN+"Adamantite Platebody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	
	
	// Runite armour
	Arrowhead_Rune(Material.FLINT,ChatColor.GREEN+"Rune Arrowhead",new String[]{ChatColor.GOLD+"Type:Fleching"},true,0,0),
	Dagger_Rune(Material.DIAMOND_SWORD,ChatColor.GREEN+"Rune Dagger",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Mace_Rune(Material.DIAMOND_AXE,ChatColor.GREEN+"Rune Mace",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	MediumHelmet_Rune(Material.DIAMOND_HELMET,ChatColor.GREEN+"Rune MediumHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Sword_Rune(Material.DIAMOND_SWORD,ChatColor.GREEN+"Rune Sword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Scimitar_Rune(Material.DIAMOND_SWORD,ChatColor.GREEN+"Rune Scimitar",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Longsword_Rune(Material.DIAMOND_SWORD,ChatColor.GREEN+"Rune Longsword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	FullHelmet_Rune(Material.DIAMOND_HELMET,ChatColor.GREEN+"Rune FullHelmet",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Warhammer_Rune(Material.DIAMOND_AXE,ChatColor.GREEN+"Rune Warhammer",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Battleaxe_Rune(Material.DIAMOND_AXE,ChatColor.GREEN+"Rune Battleaxe",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Chainbody_Rune(Material.DIAMOND_CHESTPLATE,ChatColor.GREEN+"Rune Chainbody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	TwoHandedSword_Rune(Material.DIAMOND_SWORD,ChatColor.GREEN+"Rune TwoHandedSword",new String[]{ChatColor.GOLD+"Level: 1","Damage:"},false,0,0),
	Platelegs_Rune(Material.DIAMOND_LEGGINGS,ChatColor.GREEN+"Rune Platelegs",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Plateskirt_Rune(Material.DIAMOND_LEGGINGS,ChatColor.GREEN+"Rune Plateskirt",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	Platebody_Rune(Material.DIAMOND_CHESTPLATE,ChatColor.GREEN+"Rune Platebody",new String[]{ChatColor.GOLD+"Level: 1","Defence:"},false,0,0),
	
	
	//bones and drops
	Bone(Material.BONE,ChatColor.GREEN+"Bone",new String[]{ChatColor.GOLD+"Type:Prayer"},false,0,0),
	CowHide(Material.LEATHER,ChatColor.GREEN+"CowHide",new String[]{ChatColor.GOLD+"Type:Crafting"},false,0,0),
	RawBeef(Material.RAW_BEEF,ChatColor.GREEN+"Raw Beef",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,0),
	Feather(Material.FEATHER,ChatColor.GREEN+"Feather",new String[]{ChatColor.GOLD+"Type:Crafting,Fleching"},true,0,0),
	RawChicken(Material.RAW_CHICKEN,ChatColor.GREEN+"Chicken Beef",new String[]{ChatColor.GOLD+"Type:Cooking"},false,0,0),
	GoblinMail(Material.CHAINMAIL_CHESTPLATE,ChatColor.GREEN+"Goblin Mail",new String[]{ChatColor.LIGHT_PURPLE+"Type:Misc"},false,0,0),
	
	
	//smithing
	BronzeBar(Material.CLAY_BRICK,ChatColor.GREEN+"Bronze Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	IronBar(Material.IRON_INGOT,ChatColor.GREEN+"Iron Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	SilverBar(Material.IRON_INGOT,ChatColor.GREEN+"Silver Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	SteelBar(Material.IRON_INGOT,ChatColor.GREEN+"Steel Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	GoldBar(Material.GOLD_INGOT,ChatColor.GREEN+"Gold Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	MithrillBar(Material.NETHER_BRICK_ITEM,ChatColor.GREEN+"Mithrill Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	AdamantBar(Material.ACACIA_STAIRS.NETHER_BRICK_ITEM,ChatColor.GREEN+"Adamant Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	RuneBar(Material.IRON_INGOT,ChatColor.GREEN+"Rune Bar",new String[]{ChatColor.GOLD+"Type:Smithing"},false,0,0),
	
	
	//money
	GoldCoin(Material.GOLD_NUGGET,ChatColor.GREEN+"Gold Coin",new String[]{ChatColor.GOLD+"1 Gold"},true,1,0),
	SmallGoldPile(Material.GOLD_INGOT,ChatColor.GREEN+"Small Gold Pile",new String[]{ChatColor.GOLD+"100 Gold"},true,100,0),
	LargeGoldPile(Material.GOLD_BLOCK,ChatColor.GREEN+"Large Gold Pile",new String[]{ChatColor.GOLD+"1k Gold"},true,1000,0),
	
	
	//axe
	Bronze_Hatchet(Material.WOOD_AXE,ChatColor.GREEN+"Bronze Hatchet",new String[]{ChatColor.LIGHT_PURPLE+"level:1",ChatColor.LIGHT_PURPLE+"Type:Woodcutting"},false,16,0),
	Iron_Hatchet(Material.WOOD_AXE,ChatColor.GREEN+"Iron Hatchet",new String[]{ChatColor.LIGHT_PURPLE+"level:1",ChatColor.LIGHT_PURPLE+"Type:Woodcutting"},false,56,0),
	Steel_Hatchet(Material.IRON_AXE,ChatColor.GREEN+"Steel Hatchet",new String[]{ChatColor.LIGHT_PURPLE+"level:6",ChatColor.LIGHT_PURPLE+"Type:Woodcutting"},false,200,0),
	Mithrill_Hatchet(Material.GOLD_AXE,ChatColor.GREEN+"Mithrill Hatchet",new String[]{ChatColor.LIGHT_PURPLE+"level:21",ChatColor.LIGHT_PURPLE+"Type:Woodcutting"},false,0,0),
	Adamant_Hatchet(Material.GOLD_AXE,ChatColor.GREEN+"Adamant Hatchet",new String[]{ChatColor.LIGHT_PURPLE+"level:31",ChatColor.LIGHT_PURPLE+"Type:Woodcutting"},false,0,0),
	Rune_Hatchet(Material.DIAMOND_AXE,ChatColor.GREEN+"Rune Hatchet",new String[]{ChatColor.LIGHT_PURPLE+"level:41",ChatColor.LIGHT_PURPLE+"Type:Woodcutting"},false,0,0),
	Dragon_Hatchet(Material.DIAMOND_AXE,ChatColor.GREEN+"Dragon Hatchet",new String[]{ChatColor.LIGHT_PURPLE+"level:61",ChatColor.LIGHT_PURPLE+"Type:Woodcutting"},false,0,0),
	
	
	//pickaxe
	Bronze_Pickaxe(Material.WOOD_PICKAXE,ChatColor.GREEN+"Bronze Pickaxe",new String[]{ChatColor.LIGHT_PURPLE+"level:1",ChatColor.LIGHT_PURPLE+"Type:Mining"},false,1,0),
	Iron_Pickaxe(Material.WOOD_PICKAXE,ChatColor.GREEN+"Iron Pickaxe",new String[]{ChatColor.LIGHT_PURPLE+"level:1",ChatColor.LIGHT_PURPLE+"Type:Mining"},false,140,0),
	Steel_Pickaxe(Material.IRON_PICKAXE,ChatColor.GREEN+"Steel Pickaxe",new String[]{ChatColor.LIGHT_PURPLE+"level:6",ChatColor.LIGHT_PURPLE+"Type:Mining"},false,500,0),
	Mithrill_Pickaxe(Material.GOLD_PICKAXE,ChatColor.GREEN+"Mithrill Pickaxe",new String[]{ChatColor.LIGHT_PURPLE+"level:21",ChatColor.LIGHT_PURPLE+"Type:Mining"},false,1300,0),
	Adamant_Pickaxe(Material.GOLD_PICKAXE,ChatColor.GREEN+"Adamant Pickaxe",new String[]{ChatColor.LIGHT_PURPLE+"level:31",ChatColor.LIGHT_PURPLE+"Type:Mining"},false,3200,0),
	Rune_Pickaxe(Material.DIAMOND_PICKAXE,ChatColor.GREEN+"Rune Pickaxe",new String[]{ChatColor.LIGHT_PURPLE+"level:41",ChatColor.LIGHT_PURPLE+"Type:Mining"},false,32000,0),
	Dragon_Pickaxe(Material.DIAMOND_PICKAXE,ChatColor.GREEN+"Dragon Pickaxe",new String[]{ChatColor.LIGHT_PURPLE+"level:61",ChatColor.LIGHT_PURPLE+"Type:Mining"},false,0,0),
	
	
	//logs
	Log(Material.LOG,ChatColor.GREEN+"Log",new String[]{ChatColor.LIGHT_PURPLE+"Type:Crafting ,Firemaking ,Fleching"},false,0,0),
	Oak_Log(Material.LOG,ChatColor.GREEN+"Oak Log",new String[]{ChatColor.LIGHT_PURPLE+"Type:Crafting ,Firemaking ,Fleching"},false,0,0),
	Willow_Log(Material.LOG,ChatColor.GREEN+"Willow Log",new String[]{ChatColor.LIGHT_PURPLE+"Type:Crafting ,Firemaking ,Fleching"},false,0,0),
	Yew_Log(Material.LOG,ChatColor.GREEN+"Yew Log",new String[]{ChatColor.LIGHT_PURPLE+"Type:Crafting ,Firemaking ,Fleching"},false,0,0),
	
	
	//ores
	Copper_Ore(Material.LAPIS_ORE,ChatColor.GREEN+"Copper Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Tin_Ore(Material.QUARTZ_ORE,ChatColor.GREEN+"Tin Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Iron_Ore(Material.IRON_ORE,ChatColor.GREEN+"Iron Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Silver_Ore(Material.IRON_BLOCK,ChatColor.GREEN+"Silver Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Coal(Material.COAL_ORE,ChatColor.GREEN+"Coal",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Gold_Ore(Material.GOLD_ORE,ChatColor.GREEN+"Gold Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Mithrill_Ore(Material.EMERALD_ORE,ChatColor.GREEN+"Mithrill Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Adamantite_Ore(Material.EMERALD_BLOCK,ChatColor.GREEN+"Adamantite Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	Runite_Ore(Material.DIAMOND_ORE,ChatColor.GREEN+"Runite Ore",new String[]{ChatColor.LIGHT_PURPLE+"Type:Smithing"},false,0,0),
	
	
	//short bows
	ShortBow(Material.BOW,ChatColor.GREEN+"ShortBow",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 1"},false,50,0),
	Oak_ShortBow(Material.BOW,ChatColor.GREEN+"Oak ShortBow",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 10"},false,100,0),
	Willow_ShortBow(Material.BOW,ChatColor.GREEN+"Willow ShortBow",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 20"},false,200,0),
	Yew_ShortBow(Material.BOW,ChatColor.GREEN+"Yew ShortBow",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 40"},false,0,0),
	
	//arrows
	Bronze_Arrows(Material.ARROW,ChatColor.GREEN+"Bronze Arrows",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 1","Damage:4"},true,7,0),
	Iron_Arrows(Material.ARROW,ChatColor.GREEN+"Iron Arrows",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 10","Damage:9"},true,20,0),
	Steel_Arrows(Material.ARROW,ChatColor.GREEN+"Steel Arrows",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 20","Damage:15"},true,46,0),
	Mithril_Arrows(Material.ARROW,ChatColor.GREEN+"Mithril Arrows",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 30","Damage:24"},true,76,0),
	Adamantite_Arrows(Material.ARROW,ChatColor.GREEN+"Adamantite Arrows",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 40","Damage:38"},true,172,0),
	Rune_Arrows(Material.ARROW,ChatColor.GREEN+"Rune Arrows",new String[]{ChatColor.LIGHT_PURPLE+"Type:Range","Level: 50","Damage:"},true,510,0),
	
	
	//firemaking
	TinderBox(Material.FLINT_AND_STEEL,ChatColor.GREEN+"TinderBox",new String[]{ChatColor.LIGHT_PURPLE+"Type:Firemaking"},false,1,0);
	
	private Material m;
	private String name;
	private String[] lore;
	private boolean stack;
	private int shopPrice;
	private int metadata;
	Items(Material m,String name,String[] lore,boolean stack,int shopPrice,int meta){
		this.m = m;
		this.name = name;
		this.lore = lore;
		this.stack = stack;
		this.shopPrice = shopPrice;
		this.metadata = meta;
	}
	public static Items getByName(String name){
		for(Items item:Items.values()){
			String name1 = ChatColor.stripColor(name);
			if(ChatColor.stripColor(item.name).equals(name1)){
				return item;
			}
		}
		/*switch(name1){
		//fishing equip
		case "Bait":
			return Items.Bait;
		case "Net":
			return Items.Net;
		case "Big Net":
			return Items.BigNet;
		case "Fishing Rod":
			return Items.FishingRod;
		//fish
		case "Shrimp":
			return Items.Shrimp;
		case "Herring":
			return Items.Herring;
		case "Trout":
			return Items.Trout;
		case "Tuna":
			return Items.Tuna;
		case "Lobster":
			return Items.Lobster;
		case "Swordfish":
			return Items.Swordfish;
		case "Monkfish":
			return Items.Monkfish;
		case "Shark":
			return Items.Shark;
		//party hats
		case "Red partyhat":
			return Items.PartyHat_RED;
		case "White partyhat":
			return Items.PartyHat_WHITE;
		case "Blue partyhat":
			return Items.PartyHat_BLUE;
		case "Green partyhat":
			return Items.PartyHat_GREEN;
		case "Yellow partyhat":
			return Items.PartyHat_YELLOW;
		case "Purple partyhat":
			return Items.PartyHat_PURPLE;
			
		
		
		//arrows
		case "Bronze Arrowhead":
			return Items.Arrowhead_Bronze;
		case "Iron Arrowshead":
			return Items.Arrowhead_Iron;
		case "Steel Arrowshead":
			return Items.Arrowhead_Steel;
		case "Mithril Arrowshead":
			return Items.Arrowhead_Mithrill;
		case "Adamantite Arrowshead":
			return Items.Arrowhead_Adamantite;
		case "Rune Arrowshead":
			return Items.Arrowhead_Rune;
		
		
		case "Bronze Arrows":
			return Items.Bronze_Arrows;
		case "Iron Arrows":
			return Items.Iron_Arrows;
		case "Steel Arrows":
			return Items.Steel_Arrows;
		case "Mithril Arrows":
			return Items.Mithril_Arrows;
		case "Adamantite Arrows":
			return Items.Adamantite_Arrows;
		case "Rune Arrows":
			return Items.Rune_Arrows;
		//short bow
		case "ShortBow":
			return Items.ShortBow;
		case "Oak ShortBow":
			return Items.Oak_ShortBow;
		case "Willow ShortBow":
			return Items.Willow_ShortBow;
		case "Yew ShortBow":
			return Items.Yew_ShortBow;
		//bronze wepons
		case "Bronze Dagger":
			return Items.Dagger_Bronze;
		case "Bronze Mace":
			return Items.Mace_Bronze;
		case "Bronze MediumHelmet":
			return Items.MediumHelmet_Bronze;
		case "Bronze Sword":
			return Items.Sword_Bronze;
		case "Bronze Scimitar":
			return Items.Scimitar_Bronze;
		case "Bronze Longsword":
			return Items.Longsword_Bronze;
		case "Bronze FullHelmet":
			return Items.FullHelmet_Bronze;
		case "Bronze Warhammer":
			return Items.Warhammer_Bronze;
		case "Bronze Battleaxe":
			return Items.Battleaxe_Bronze;
		case "Bronze Chainbody":
			return Items.Chainbody_Bronze;
		case "Bronze TwoHandedSword":
			return Items.TwoHandedSword_Bronze;
		case "Bronze Platelegs":
			return Items.Platelegs_Bronze;
		case "Bronze Plateskirt":
			return Items.Plateskirt_Bronze;
		case "Bronze Platebody":
			return Items.Platebody_Bronze;
			
			//Iron wepons
			case "Iron Dagger":
				return Items.Dagger_Iron;
			case "Iron Mace":
				return Items.Mace_Iron;
			case "Iron MediumHelmet":
				return Items.MediumHelmet_Iron;
			case "Iron Sword":
				return Items.Sword_Iron;
			case "Iron Scimitar":
				return Items.Scimitar_Iron;
			case "Iron Longsword":
				return Items.Longsword_Iron;
			case "Iron FullHelmet":
				return Items.FullHelmet_Iron;
			case "Iron Warhammer":
				return Items.Warhammer_Iron;
			case "Iron Battleaxe":
				return Items.Battleaxe_Iron;
			case "Iron Chainbody":
				return Items.Chainbody_Iron;
			case "Iron TwoHandedSword":
				return Items.TwoHandedSword_Iron;
			case "Iron Platelegs":
				return Items.Platelegs_Iron;
			case "Iron Plateskirt":
				return Items.Plateskirt_Iron;
			case "Iron Platebody":
				return Items.Platebody_Iron;
		
				//Steel wepons
			case "Steel Dagger":
				return Items.Dagger_Steel;
			case "Steel Mace":
				return Items.Mace_Steel;
			case "Steel MediumHelmet":
				return Items.MediumHelmet_Steel;
			case "Steel Sword":
				return Items.Sword_Steel;
			case "Steel Scimitar":
				return Items.Scimitar_Steel;
			case "Steel Longsword":
				return Items.Longsword_Steel;
			case "Steel FullHelmet":
				return Items.FullHelmet_Steel;
			case "Steel Warhammer":
				return Items.Warhammer_Steel;
			case "Steel Battleaxe":
				return Items.Battleaxe_Steel;
			case "Steel Chainbody":
				return Items.Chainbody_Steel;
			case "Steel TwoHandedSword":
				return Items.TwoHandedSword_Steel;
			case "Steel Platelegs":
				return Items.Platelegs_Steel;
			case "Steel Plateskirt":
				return Items.Plateskirt_Steel;
			case "Steel Platebody":
				return Items.Platebody_Steel;
		
				//Mithrill wepons
			case "Mithrill Dagger":
				return Items.Dagger_Mithrill;
			case "Mithrill Mace":
				return Items.Mace_Mithrill;
			case "Mithrill MediumHelmet":
				return Items.MediumHelmet_Mithrill;
			case "Mithrill Sword":
				return Items.Sword_Mithrill;
			case "Mithrill Scimitar":
				return Items.Scimitar_Mithrill;
			case "Mithrill Longsword":
				return Items.Longsword_Mithrill;
			case "Mithrill FullHelmet":
				return Items.FullHelmet_Mithrill;
			case "Mithrill Warhammer":
				return Items.Warhammer_Mithrill;
			case "Mithrill Battleaxe":
				return Items.Battleaxe_Mithrill;
			case "Mithrill Chainbody":
				return Items.Chainbody_Mithrill;
			case "Mithrill TwoHandedSword":
				return Items.TwoHandedSword_Mithrill;
			case "Mithrill Platelegs":
				return Items.Platelegs_Mithrill;
			case "Mithrill Plateskirt":
				return Items.Plateskirt_Mithrill;
			case "Mithrill Platebody":
				return Items.Platebody_Mithrill;
		
				//Adamantite wepons
			case "Adamantite Dagger":
				return Items.Dagger_Adamantite;
			case "Adamantite Mace":
				return Items.Mace_Adamantite;
			case "Adamantite MediumHelmet":
				return Items.MediumHelmet_Adamantite;
			case "Adamantite Sword":
				return Items.Sword_Adamantite;
			case "Adamantite Scimitar":
				return Items.Scimitar_Adamantite;
			case "Adamantite Longsword":
				return Items.Longsword_Adamantite;
			case "Adamantite FullHelmet":
				return Items.FullHelmet_Adamantite;
			case "Adamantite Warhammer":
				return Items.Warhammer_Adamantite;
			case "Adamantite Battleaxe":
				return Items.Battleaxe_Adamantite;
			case "Adamantite Chainbody":
				return Items.Chainbody_Adamantite;
			case "Adamantite TwoHandedSword":
				return Items.TwoHandedSword_Adamantite;
			case "Adamantite Platelegs":
				return Items.Platelegs_Adamantite;
			case "Adamantite Plateskirt":
				return Items.Plateskirt_Adamantite;
			case "Adamantite Platebody":
				return Items.Platebody_Adamantite;
				
				//Rune wepons
			case "Rune Dagger":
				return Items.Dagger_Rune;
			case "Rune Mace":
				return Items.Mace_Rune;
			case "Rune MediumHelmet":
				return Items.MediumHelmet_Rune;
			case "Rune Sword":
				return Items.Sword_Rune;
			case "Rune Scimitar":
				return Items.Scimitar_Rune;
			case "Rune Longsword":
				return Items.Longsword_Rune;
			case "Rune FullHelmet":
				return Items.FullHelmet_Rune;
			case "Rune Warhammer":
				return Items.Warhammer_Rune;
			case "Rune Battleaxe":
				return Items.Battleaxe_Rune;
			case "Rune Chainbody":
				return Items.Chainbody_Rune;
			case "Rune TwoHandedSword":
				return Items.TwoHandedSword_Rune;
			case "Rune Platelegs":
				return Items.Platelegs_Rune;
			case "Rune Plateskirt":
				return Items.Plateskirt_Rune;
			case "Rune Platebody":
				return Items.Platebody_Rune;
				
				
				
		//smithing
		case "Bronze Bar":
			return Items.BronzeBar;
		case "Iron Bar":
			return Items.IronBar;
		case "Silver Bar":
			return Items.SilverBar;
		case "Steel Bar":
			return Items.SteelBar;
		case "Gold Bar":
			return Items.GoldBar;
		case "Mithrill Bar":
			return Items.MithrillBar;
		case "Adamant Bar":
			return Items.AdamantBar;
		case "Rune Bar":
			return Items.RuneBar;
		//bone
		case "Bone":
			return Items.Bone;
		//eco
		case "Gold Coin":
			return Items.GoldCoin;
		case "Small Gold Pile":
			return Items.SmallGoldPile;
		case "Large Gold Pile":
			return Items.LargeGoldPile;
		//woodcutting
		case "Bronze Hatchet":
			return Items.Bronze_Hatchet;
		case "Iron Hatchet":
			return Items.Iron_Hatchet;
		case "Steel Hatchet":
			return Items.Steel_Hatchet;
		case "Mithrill Hatchet":
			return Items.Mithrill_Hatchet;
		case "Adamant Hatchet":
			return Items.Adamant_Hatchet;
		case "Rune Hatchet":
			return Items.Rune_Hatchet;
		case "Dragon Hatchet":
			return Items.Dragon_Hatchet;
			//pickaxes
		case "Bronze Pickaxe":
			return Items.Bronze_Pickaxe;
		case "Iron Pickaxe":
			return Items.Iron_Pickaxe;
		case "Steel Pickaxe":
			return Items.Steel_Pickaxe;
		case "Mithrill Pickaxe":
			return Items.Mithrill_Pickaxe;
		case "Adamant Pickaxe":
			return Items.Adamant_Pickaxe;
		case "Rune Pickaxe":
			return Items.Rune_Pickaxe;
		case "Dragon Pickaxe":
			return Items.Dragon_Pickaxe;
			//logs
		case "Log":
			return Items.Log;
		case "Oak Log":
			return Items.Oak_Log;
		case "Willow Log":
			return Items.Willow_Log;
		case "Yew Log":
			return Items.Yew_Log;
			//ores
		case "Copper Ore":
			return Items.Copper_Ore;
		case "Tin Ore":
			return Items.Tin_Ore;
		case "Iron Ore":
			return Items.Iron_Ore;
		case "Silver Ore":
			return Items.Silver_Ore;
		case "Coal":
			return Items.Coal;
		case "Gold Ore":
			return Items.Gold_Ore;
		case "Mithrill Ore":
			return Items.Mithrill_Ore;
		case "Adamantite Ore":
			return Items.Adamantite_Ore;
		case "Runite Ore":
			return Items.Runite_Ore;
			//firemaking
		case "TinderBox":
			return Items.TinderBox;
		}*/
		return null;
	}
	public ItemStack generateItem(){
		ItemStack item = new ItemStack(m,1,(byte)metadata);
		ItemMeta im = item.getItemMeta();
		if(metadata!=0&&m==Material.LEATHER_BOOTS||
				metadata!=0&&m==Material.LEATHER_CHESTPLATE||
				metadata!=0&&m==Material.LEATHER_LEGGINGS||
				metadata!=0&&m==Material.LEATHER_HELMET){
			LeatherArmorMeta meta = (LeatherArmorMeta) im;
			switch(metadata){
				case 1:
					meta.setColor(Color.RED);
					break;
				case 2:
					meta.setColor(Color.BLUE);
					break;
				case 3:
					meta.setColor(Color.WHITE);
					break;
				case 4:
					meta.setColor(Color.GREEN);
					break;
				case 5:
					meta.setColor(Color.YELLOW);
					break;
				case 6:
					meta.setColor(Color.PURPLE);
					break;
			}
			im = meta;;
		}
		im.setDisplayName(name);
		List<String> lo = new ArrayList();
		for(String s: lore){
			lo.add(s);
		}
		if(stack==false){
			lo.add(ChatColor.BLACK+"ID:"+genRandom());
		}
		im.setLore(lo);
		item.setItemMeta(im);
		return item;
	}
	public static ItemStack generateItem(List<String> lore,String name,Material m){
		ItemStack item = new ItemStack(m);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		im.setLore(lore);
		item.setItemMeta(im);
		return item;
	}
	public ItemStack generateShopItem(){
		ItemStack item = new ItemStack(m,1,(byte)metadata);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		List<String> lo = new ArrayList();
		for(String s: lore){
			lo.add(s);
		}
		lo.add(ChatColor.GOLD+"Price:"+shopPrice);
		im.setLore(lo);
		item.setItemMeta(im);
		return item;
	}
	public String getName(){
		return name;
	}
	public int getCost(){
		return shopPrice;
	}
	public static int genRandom(){
		return new Random().nextInt(10000);
	}
}
