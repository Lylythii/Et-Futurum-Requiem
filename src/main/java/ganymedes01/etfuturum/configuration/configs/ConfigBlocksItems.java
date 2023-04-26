package ganymedes01.etfuturum.configuration.configs;

import java.io.File;

import ganymedes01.etfuturum.EtFuturum;
import org.apache.commons.lang3.ArrayUtils;

import cpw.mods.fml.common.Loader;
import ganymedes01.etfuturum.configuration.ConfigBase;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigBlocksItems extends ConfigBase {
	
	public static boolean enableArmourStand;
	public static int netheriteToolDurability;
	public static int netheriteEnchantability;
	public static int netheriteHarvestLevel;
	public static float netheriteSpeed;
	public static float netheriteDamageBase;
	public static int netheriteArmourDurabilityFactor;
	public static int netheritePickaxeDurability;
	public static int netheriteSwordDurability;
	public static int netheriteHoeDurability;
	public static int netheriteAxeDurability;
	public static int netheriteSpadeDurability;
	public static int netheriteHelmetDurability;
	public static int netheriteChestplateDurability;
	public static int netheriteLeggingsDurability;
	public static int netheriteBootsDurability;
	public static int netheriteHelmetProtection;
	public static int netheriteChestplateProtection;
	public static int netheriteLeggingsProtection;
	public static int netheriteBootsProtection;
	
	public static boolean enableBanners;
	public static boolean enableBarkLogs;
	public static boolean enableStones;
	public static boolean enableIronTrapdoor;
	public static boolean enableMutton;
	public static boolean enableSponge;
	public static boolean enablePrismarine;
	public static boolean enableDoors;
	public static boolean enableDoorRecipeBuffs;
	public static boolean enableTrapdoors;
	public static boolean enableInvertedDaylightSensor;
	public static boolean enableOldBaseDaylightSensor;
	public static boolean enableCoarseDirt;
	public static boolean enableRedSandstone;
	public static boolean enableFences;
	public static boolean enableSlimeBlock;
	public static boolean enableBeetroot;
	public static boolean enableChorusFruit;
	public static boolean enableGrassPath;
	public static boolean enableTippedArrows;
	public static boolean enableLingeringPotions;
	public static boolean enableCryingObsidian;
	public static boolean enableBrewingStands;
	public static boolean enableColourfulBeacons;
	public static boolean enableBarrel;
	public static boolean enableLantern;
	public static boolean enableSmoker;
	public static boolean enableBlastFurnace;
	public static boolean enableBarrier;
	public static boolean enableNetherGold;
	public static boolean enableSigns;
	public static boolean enableSmoothStone;
	public static boolean enableSmoothSandstone;
	public static boolean enableSmoothQuartz;
	public static boolean enableQuartzBricks;
	public static boolean enableExtraVanillaSlabs;
	public static boolean enableExtraVanillaStairs;
	public static boolean enableExtraVanillaWalls;
	public static boolean enableLilyOfTheValley;
	public static boolean enableCornflower;
	public static boolean enableWitherRose;
	public static boolean enableSweetBerryBushes;
	public static boolean enableLavaCauldrons;
	public static boolean enableNewNetherBricks;
	public static boolean enableNetherwartBlock;
	public static boolean enableMagmaBlock;
	public static boolean enableNetherite;
	public static boolean enableBoneBlock;
	public static boolean enableConcrete;
	public static boolean enableTotemUndying;
	public static boolean enableRawOres;
	public static boolean enableNewDyes;
	public static boolean enableWoodRedstone;
	public static boolean enableStrippedLogs;
	public static boolean enableBlueIce;
	public static boolean enableCopper;
	public static boolean enableCopperSubItems;
	public static boolean enableDeepslate;
	public static boolean enableDeepslateOres;
	public static boolean enableTuff;
	public static boolean enableNewTileEntities;
	public static boolean enableSuspiciousStew;
	public static boolean enableGlazedTerracotta;
	public static boolean enableIronNugget;
	public static boolean enablePigstep;
	public static boolean enableOtherside;
	public static boolean enableEnchantingTable;
	public static boolean enableAnvil;
	public static boolean enableComposter;
	public static boolean enableSmithingTable;
	public static boolean enableStonecutter;
	public static boolean enableFletchingTable;
	public static boolean enableCartographyTable;
	public static boolean enableLoom;
	public static boolean enableGemstone;
	public static boolean enableDyedBeds;
	public static boolean enableTarget;
	public static boolean enableSculk;
	//Nether Update temp disabled
	public static boolean enableCrimsonBlocks = false;
	public static boolean enableWarpedBlocks = false;
	
	public static boolean enableShulkerBoxes;
	public static boolean enableDyedShulkerBoxes = true;
	public static boolean enableShulkerBoxesIronChest;
	public static boolean enablePotionCauldron;
	public static boolean enableNewBoats;
	public static boolean newBoatPassengerSeat;
	public static float newBoatMaxLandSpeed;
	public static float newBoatSpeed;
	public static boolean replaceOldBoats;
	public static String[] newBoatEntityBlacklist;
	public static boolean newBoatEntityBlacklistAsWhitelist;
	
	public static int endGatewaySpawnColor = 2;
	public static int endGatewayEntryColor = 2;

	public static final String catBlockNatural = "natural blocks";
	public static final String catBlockFunc = "function blocks";
	public static final String catBlockMisc = "misc blocks";
	public static final String catItemEquipment = "equipment";
	public static final String catItemEntity = "entity items";
	public static final String catItemMisc = "misc items";
	
	public static final String PATH = configDir + File.separator + "blocksitems.cfg";
	public static final ConfigBlocksItems configInstance = new ConfigBlocksItems(new File(Launch.minecraftHome, PATH));
	
	public ConfigBlocksItems(File file) {
		super(file);
		setCategoryComment(catBlockNatural, "Blocks that can generate naturally in your world. Check world.cfg for generation values.");
		setCategoryComment(catBlockFunc, "Blocks that have a specific function, whether right clicked or otherwise.");
		setCategoryComment(catBlockMisc, "Blocks that don't fit in any other category.");
		setCategoryComment(catItemEquipment, "Tools, armor, and other equipment items.");
		setCategoryComment(catItemEntity, "Entity items. (Armor stand, boat, etc)");
		setCategoryComment(catItemMisc, "Items that don't fit in any other category.");
		
		configCats.add(getCategory(catBlockNatural));
		configCats.add(getCategory(catBlockFunc));
		configCats.add(getCategory(catBlockMisc));
		configCats.add(getCategory(catItemEquipment));
		configCats.add(getCategory(catItemEntity));
		configCats.add(getCategory(catItemMisc));
	}

	@Override
	protected void syncConfigOptions() {
		Configuration cfg = configInstance;

		//Natural Blocks
		enableStones = cfg.getBoolean("enableStones", catBlockNatural, true, "Enable Granite/Andesite/Diorite");
		enableNetherGold = cfg.getBoolean("enableNetherGold", catBlockNatural, true, "");
		enablePrismarine = cfg.getBoolean("enablePrismarine", catBlockNatural, true, "");
		enableCoarseDirt = cfg.getBoolean("enableCoarseDirt", catBlockNatural, true, "");
		enableRedSandstone = cfg.getBoolean("enableRedSandstone", catBlockNatural, true, "");
		enableChorusFruit = cfg.getBoolean("enableChorusBlocks", catBlockNatural, true, "Enables chorus plants and purpur blocks");
		enableGrassPath = cfg.getBoolean("enableGrassPath", catBlockNatural, true, "");
		enableCryingObsidian = cfg.getBoolean("enableCryingObsidian", catBlockNatural, true, "");
		enableNewNetherBricks = cfg.getBoolean("enableRedNetherBricks", catBlockMisc, true, "Note: Also enables cracked and chiseled nether bricks as they use this ID too");
		enableNetherwartBlock = cfg.getBoolean("enableNetherwartBlock", catBlockNatural, true, "");
		enableNetherite = cfg.getBoolean("enableNetherite", catBlockNatural, true, "");
		enableMagmaBlock = cfg.getBoolean("enableMagmaBlock", catBlockNatural, true, "");
		enableBoneBlock = cfg.getBoolean("enableBoneBlock", catBlockNatural, true, "");
		enableBlueIce = cfg.getBoolean("enableBlueIce", catBlockNatural, true, "");
		enableLilyOfTheValley = cfg.getBoolean("enableLilyOfTheValley", catBlockNatural, true, "");
		enableCornflower = cfg.getBoolean("enableCornflower", catBlockNatural, true, "");
		enableWitherRose = cfg.getBoolean("enableWitherRose", catBlockNatural, true, "");
		enableCopper = cfg.getBoolean("enableCopper", catBlockNatural, true, "Copper ore and copper blocks, variants, and waxed variants. (Slime balls are used if no mod introduces wax)");
		enableSweetBerryBushes = cfg.getBoolean("enableSweetBerryBushes", catBlockNatural, true, "");
		enableDeepslate = cfg.getBoolean("enableDeepslate", catBlockNatural, true, "");
		enableTuff = cfg.getBoolean("enableTuff", catBlockNatural, true, "");
		enableDeepslateOres = cfg.getBoolean("enableDeepslateOres", catBlockNatural, true, "Enable deepslate ores for copper ore and vanilla ores when deepslate generates over them.");
		enableGemstone = cfg.getBoolean("enableGemstone", catBlockNatural, true, "Enables tinted glass, gemstone blocks, budding gemstone and gemstone crystals. Also enables the item too. Smooth basalt can be disabled by changing the world.cfg option for the basalt layer to something else.");

//      enableSculk = cfg.getBoolean("enableSculk", catBlockNatural, true, "Enables sculk-related blocks.");

		//Function Blocks
		enableIronTrapdoor = cfg.getBoolean("enableIronTrapdoor", catBlockFunc, true, "");
		enableSponge = cfg.getBoolean("enableSponge", catBlockFunc, true, "");
		enableDoors = cfg.getBoolean("enableDoors", catBlockFunc, true, "Enables wood variant doors");
		enableDoorRecipeBuffs = cfg.getBoolean("enableDoorRecipeBuffs", catBlockFunc, true, "Backports recipe buffs to doors (from 1 to 3)");
		enableTrapdoors = cfg.getBoolean("enableTrapdoors", catBlockFunc, true, "Enables wood variant trapdoors");
		enableSlimeBlock = cfg.getBoolean("enableSlimeBlock", catBlockFunc, true, "Just bouncy, does not pull blocks.");
		enableWoodRedstone = cfg.getBoolean("enableWoodRedstone", catBlockFunc, true, "Enables wood variant buttons and pressure plates");
		enableBarrel = cfg.getBoolean("enableBarrel", catBlockFunc, true, "");
		enableSmoker = cfg.getBoolean("enableSmoker", catBlockFunc, true, "Will attempt to seek and auto-add recipes to itself. Look at ConfigFunctions.cfg \"autoAddSmoker\" for more info.\nCompatible with CraftTweaker. In the same way that you'd use furnace.addRecipe or furnace.remove, you can use \"mods.etfuturum.smoker\" instead of \"furnace\".");
		enableBlastFurnace = cfg.getBoolean("enableBlastFurnace", catBlockFunc, true, "Will attempt to seek and auto-add recipes to itself. Look at ConfigFunctions.cfg \"autoAddBlastFurance\" for more info.\nCompatible with CraftTweaker. In the same way that you'd use furnace.addRecipe or furnace.remove, you can use \"mods.etfuturum.blastFurnace\" instead of \"furnace\".");
		enableSigns = cfg.getBoolean("enableSigns", catBlockFunc, true, "");
		enableLavaCauldrons = cfg.getBoolean("enableLavaCauldrons", catBlockFunc, true, "Allow lava buckets to fill cauldrons");
		enableShulkerBoxes = cfg.getBoolean("enableShulkerBoxes", catBlockFunc, true, "If Shulkers are disabled, a custom recipe will be required to obtain Shulker shells.");
		enableShulkerBoxesIronChest = cfg.getBoolean("enableShulkerBoxesIronChest", catBlockFunc, true, "If Iron Chests is installed, allow Iron Shulker boxes to be crafted having all the same tiers as Iron Chests. This option does nothing if Iron Chests is not installed.");
		enablePotionCauldron = cfg.getBoolean("enablePotionCauldron", catBlockFunc, true, "A port of potion cauldrons from Bedrock Edition. Used to make tipped arrows and store potions.");
		//Note the above option has an extra check in preInit to ensure Iron Chests is loaded. We can't do this here because Loader doesn't even exist yet since we initialize these configs while Mixins and ASM are being applied.
		enableStonecutter = cfg.getBoolean("enableStonecutter", catBlockFunc, true, "Currently DOES NOT HAVE ANY FUNCTIONALITY. Decoration ONLY!");
		enableSmithingTable = cfg.getBoolean("enableSmithingTable", catBlockFunc, true, "If this is disabled, netherite items will not be craftable unless added by CraftTweaker. This introduces the smithing GUI from versions prior to 1.20. It is compatible with CraftTweaker." +
				"\nThe mod prefix is \"mods.etfuturum.smithingTable\", and the functions are \"addRecipe\" or \"addRecipeNoNBT\". \"addRecipe\" will copy all NBT data from the first slot to the output. (and damage if the first slot and output are damageable items) You can remove recipes using the \"remove\" function and an ItemStack." +
				"\nCurrently CraftTweaker support is limited, so some features from CraftTweaker may not work. .noReturn() and .anyDamage().onlyDamaged() are known to not work." +
				"\nExamples:" +
				"\nmods.etfuturum.smithingTable.addRecipe(<IC2:itemToolBronzeSword>, <minecraft:iron_sword>, <ore:ingotBronze>); //(Use \"ingotBronze\" on iron sword to convert it toa bronze sword)" +
				"\nmods.etfuturum.smithingTable.addRecipeNoNBT(<etfuturum:sponge:1>, <minecraft:sponge>, <minecraft:water_bucket>); //Take a vanilla sponge and a water bucket, you will get an Et Futurum Requiem wet sponge.");
		enableFletchingTable = cfg.getBoolean("enableFletchingTable", catBlockFunc, true, "Currently DOES NOT HAVE ANY FUNCTIONALITY. Decoration ONLY!");
		enableComposter = cfg.getBoolean("enableComposter", catBlockFunc, true, "Allows certain items to be composted, which has a chance of adding a layer to the compost bin. Once full, bone meal may be harvested. It is compatible with CraftTweaker." +
				"\nA value greater than 100 can add more than one layer to the composter. (The composter has 6 layers so max value is 600) EG 150 = 1 layer guaranteed and a 50% chance to fill another layer. And 600 = instantly fill the whole composter, or any remaining layers." +
				"\nThe mod prefix is \"mods.etfuturum.composting\", and the function is \"addCompostable\" and an ItemStack or OreDictionary tag, then an integer for how likely the item is to add a compost layer. 100 = 100%, or guaranteed. You can remove compostables using the \"remove\" function and an ItemStack or an OreDictionary tag." +
				"\nYou can use the \"removeAll\" function to remove all composting recipes, if you wanted to overhaul the composter's useage." +
				"\nExamples:" +
				"\nmods.etfuturum.composting.addCompostable(<minecraft:planks:*>, 100); //(Makes all planks have a 100% chance to fill one layer.)" +
				"\nmods.etfuturum.composting.addCompostable(<minecraft:bedrock>, 150); //(Makes bedrock fill one layer and have a 50% chance to fill another layer.)" +
				"\nmods.etfuturum.composting.remove(<minecraft:leaves:*>); //(Removes all leaves as a compostable item)" +
				"\n\nAdditionally the bone meal drop when harvesting a full composting bin can be changed. It drops one item from the \"composting\" loot table, and can be modified with CraftTweaker's \"addChestLoot\" function." +
				"\nBy default bone meal is the only item in this loot table, with a weight of 10. You can learn more about CraftTweaker loot table modification here: https://www.mcdrama.net/archiveformal/MineTweaker3/wiki/tutorials/1710/loot_and_seeds.html"
		);
		enableCartographyTable = cfg.getBoolean("enableCartographyTable", catBlockFunc, true, "Currently DOES NOT HAVE ANY FUNCTIONALITY. Decoration ONLY!");
		enableLoom = cfg.getBoolean("enableLoom", catBlockFunc, true, "Currently DOES NOT HAVE ANY FUNCTIONALITY. Decoration ONLY!");
		enableDyedBeds = cfg.getBoolean("enableDyedBeds", catBlockFunc, true, "Ability to craft differently colored beds out of wool. Mixed wool colors = red bed");

		enableEnchantingTable = cfg.getBoolean("enableNewEnchantingTable", catBlockFunc, true, "Uses lapis as payment and has enchant previews and adjusted level costs. Requires tile entity replacement to be enabled in \"function.cfg\". It is compatible with CraftTweaker for adding and removing fuels." +
				"\nThe mod prefix is \"mods.etfuturum.enchantingFuel\", and the function is \"addFuel\" and an ItemStack or OreDictionary tag. You can remove fuels using the \"remove\" function and an ItemStack or an OreDictionary tag." +
				"\nExamples:" +
				"\nmods.etfuturum.enchantingFuel.addFuel(<etfuturum:amethyst_shard>); //(Adds amethyst shards as an enchanting fuel)" +
				"\nmods.etfuturum.enchantingFuel.remove(<minecraft:dye:4>); //(Removes lapis lazuli as an enchanting fuel)");
		enableAnvil = cfg.getBoolean("enableNewAnvil", catBlockFunc, true, "Enables new anvil behavior, such as less expensive item renaming");
		enableBrewingStands = cfg.getBoolean("enableNewBrewingStand", catBlockFunc, true, "Makes the brewing stand have a fuel slot like in 1.9+. The fuel slot is compatible with CraftTweaker and takes blaze powder by default. Blaze powder can brew 30 potion cycles." +
				"\nThe mod prefix is \"mods.etfuturum.brewingFuel\", and the function is \"addFuel\" and an ItemStack or OreDictionary tag, then an integer for how many brew cycles. (Any brewing, regardless of if 1 or all 3 slots are filled, is still one \"cycle\") You can remove fuels using the \"remove\" function and an ItemStack or an OreDictionary tag." +
				"\nExamples:" +
				"\nmods.etfuturum.brewingFuel.addFuel(<minecraft:gunpowder>, 10); //(Makes gunpowder have 10 brewing cycles)" +
				"\nmods.etfuturum.brewingFuel.remove(<minecraft:blaze_powder>); //(Removes blaze powder as a brewing fuel)");
		enableColourfulBeacons = cfg.getBoolean("enableNewBeacon", catBlockFunc, true, "Beacon beam can be colored using stained glass");
		enableInvertedDaylightSensor = cfg.getBoolean("enableInvertedSensor", catBlockFunc, true, "Inverted Daylight Sensor");
		enableOldBaseDaylightSensor = cfg.getBoolean("enableOldBaseDaylightSensor", catBlockFunc, false, "Enable the old Et Futurum daylight sensor block. Should be enabled if you still have the old Et Futurum copy of the non-inverted daylight detector that need to be converted.");

		enableTarget = cfg.getBoolean("enableTarget", catBlockFunc, true, "Enables target block from 1.16");
		
		//Misc Blocks
		enableFences = cfg.getBoolean("enableFences", catBlockMisc, true, "Enables wood variant fences and gates");
		enableBanners = cfg.getBoolean("enableBanners", catBlockMisc, true, "");
		enableConcrete = cfg.getBoolean("enableConcrete", catBlockMisc, true, "");
		enableStrippedLogs = cfg.getBoolean("enableStrippedLogs", catBlockMisc, true, "Enables stripped log blocks");
		enableBarkLogs = cfg.getBoolean("enableBarkLogs", catBlockMisc, true, "Enables log blocks with bark on all sides");
		enableLantern = cfg.getBoolean("enableLantern", catBlockMisc, true, "");
		enableSmoothStone = cfg.getBoolean("enableSmoothStone", catBlockMisc, true, "");
		enableSmoothSandstone = cfg.getBoolean("enableSmoothSandStone", catBlockMisc, true, "");
		enableSmoothQuartz = cfg.getBoolean("enableSmoothQuartz", catBlockMisc, true, "");
		enableQuartzBricks = cfg.getBoolean("enableQuartzBricks", catBlockMisc, true, "");
		enableExtraVanillaSlabs = cfg.getBoolean("enableExtraVanillaSlabs", catBlockMisc, true, "Slabs for vanilla blocks: stone, mossy stone brick, mossy cobble, cut sandstone");
		enableExtraVanillaStairs = cfg.getBoolean("enableExtraVanillaStairs", catBlockMisc, true, "Stairs for vanilla blocks: stone, mossy stone brick, mossy cobble");
		enableExtraVanillaWalls = cfg.getBoolean("enableExtraVanillaWalls", catBlockMisc, true, "Stairs for vanilla blocks: stone brick, mossy stone brick, sandstone, brick, nether brick");
		enableCopperSubItems = cfg.getBoolean("enableCopperSubItems", catBlockMisc, true, "Copper sub-blocks and items. Disable copper but keep this on if you want the new copper items and blocks made of it, without the main ingot, ore or copper block itself.");
		enableGlazedTerracotta = cfg.getBoolean("enableGlazedTerracotta", catBlockMisc, true, "");
		enableBarrier = cfg.getBoolean("enableBarrier", catBlockMisc, true, "");
		
		//Misc Items
		enableMutton = cfg.getBoolean("enableMutton", catItemMisc, true, "");
		enableBeetroot = cfg.getBoolean("enableBeetroot", catItemMisc, true, "");
		enableIronNugget = cfg.getBoolean("enableIronNugget", catItemMisc, true, "");
		enableTippedArrows = cfg.getBoolean("enableTippedArrows", catItemMisc, true, "");
		enableLingeringPotions = cfg.getBoolean("enableLingeringPotions", catItemMisc, true, "");
		enableRawOres = cfg.getBoolean("enableRawOres", catItemMisc, true, "If true, vanilla and Et Futurum copper ores will drop raw ore items.");
		
		enableTotemUndying = cfg.getBoolean("enableTotemUndying", catItemMisc, true, "");
		enableSuspiciousStew = cfg.getBoolean("enableSuspiciousStew", catItemMisc, true, "");
		enableNewDyes = cfg.getBoolean("enableNewDyes", catItemMisc, true, "");
		
		enablePigstep = cfg.getBoolean("enablePigstep", catItemMisc, true, "Appears in Nether fortress chest loot.");
		enableOtherside = cfg.getBoolean("enableOtherside", catItemMisc, true, "Appears in stronghold corridor and dungeon chests.");
		
		//Equipment Items
		netheriteToolDurability = cfg.getInt("netheriteToolDurability", catItemEquipment, 2031, 1, Integer.MAX_VALUE, "");
		netheriteEnchantability = cfg.getInt("netheriteEnchantability", catItemEquipment, 15, 1, Integer.MAX_VALUE, "");
		netheriteHarvestLevel = cfg.getInt("netheriteHarvestLevel", catItemEquipment, 4, 0, Integer.MAX_VALUE, "Netherite harvest level, Diamond is 3");
		netheriteSpeed = cfg.getFloat("netheriteSpeed", catItemEquipment, 9.0f, 0.1f, Float.MAX_VALUE, "Netherite mining speed, Diamond is 8.0");
		netheriteDamageBase  = cfg.getFloat("netheriteDamageBase", catItemEquipment, 4.0f, 0.0f, Float.MAX_VALUE, "Neterite base damage, Diamond is 3.0");
		netheriteArmourDurabilityFactor = cfg.getInt("netheriteArmourDurabilityFactor", catItemEquipment, 37, 1, Integer.MAX_VALUE, "");
		netheritePickaxeDurability = cfg.getInt("netheritePickaxeDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Pickaxe Durability, -1 to disable");
		netheriteSwordDurability = cfg.getInt("netheriteSwordDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Sword Durability, -1 to disable");
		netheriteHoeDurability = cfg.getInt("netheriteHoeDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Hoe Durability, -1 to disable");
		netheriteAxeDurability = cfg.getInt("netheriteAxeDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Axe Durability, -1 to disable");
		netheriteSpadeDurability = cfg.getInt("netheriteSpadeDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Shovel Durability, -1 to disable");
		netheriteHelmetDurability = cfg.getInt("netheriteHelmetDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Helmet Durability, -1 to disable");
		netheriteChestplateDurability = cfg.getInt("netheriteChestplateDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Chestplate Durability, -1 for no override");
		netheriteLeggingsDurability = cfg.getInt("netheriteLeggingsDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Leggings Durability, -1 for no override");
		netheriteBootsDurability = cfg.getInt("netheriteBootsDurability", catItemEquipment, -1, -1, Integer.MAX_VALUE, "Override Netherite Boots Durability, -1 for no override");
		netheriteHelmetProtection = cfg.getInt("netheriteHelmetProtection", catItemEquipment, 3, 1, Integer.MAX_VALUE, "Netherite Helmet Protection");
		netheriteChestplateProtection = cfg.getInt("netheriteChestplateProtection", catItemEquipment, 8, 1, Integer.MAX_VALUE, "Netherite Chestplate Protection");
		netheriteLeggingsProtection = cfg.getInt("netheriteLeggingsProtection", catItemEquipment, 6, 1, Integer.MAX_VALUE, "Netherite Leggings Protection");
		netheriteBootsProtection = cfg.getInt("netheriteBootsProtection", catItemEquipment, 3, 1, Integer.MAX_VALUE, "Netherite Boots Protection");

		//Entity Items
		enableArmourStand = cfg.getBoolean("enableArmorStand", catItemEntity, true, "");
		enableNewBoats = cfg.getBoolean("enableNewBoats", catItemEntity, true, "New boats from 1.9+, including the new rowing sounds. All vanilla wood variants included.");
		
		replaceOldBoats = cfg.getBoolean("replaceOldBoats", catItemEntity, true, "If true, old boats will be replaced with the new oak boat and the item sprite will also be changned. False means the new and old boat and item for it exists separately, and the new boats will use a wooden shovel in their crafting recipe. If this is enabled, a boat that has an entity in it will not be replaced until the entity gets out.\nTHIS WILL NOT WORK PROPERLY WITH BETTER BOATS INSTALLED");
		newBoatMaxLandSpeed = cfg.getFloat("newBoatMaxLandSpeed", catItemEntity, 0.986F, 0.1F, 1, "The maximum speed a boat can travel by while on land. This option exists because boats are very very fast when travelling on slippery blocks. Land speed = cfg.0.6, Regular/Packed Ice Speed = cfg.0.98, Packed Ice Speed = cfg.0.986. Anything smaller than 0.6 is really, REALLY slow on land.\nThe speed values are just block slipperiness values, and are averaged by the slippery blocks around the bottom of the boat. This option does nothing to old boats.");
		newBoatSpeed = cfg.getFloat("newBoatSpeed", catItemEntity, 1F, 0.1F, 2, "The speed multiplier for boats while in water. Use this if you want to make the boats faster or slower. 1 = no speed change");
		newBoatPassengerSeat = cfg.getBoolean("newBoatPassengerSeat", catItemEntity, true, "If disabled, only one person can sit in the new boat at a time. The new seat is actually an invisible entity that follows new boats.");
		Property newBoatEntityBlacklistProp = cfg.get(catItemEntity, "newBoatEntityBlacklist", new String[] {});
		newBoatEntityBlacklistProp.comment = "What entities shouldn't be able to sit in the boat? You can either provide an entity ID (modid.entityid, for vanilla entities type just entity ID), or search for a string in the classpath (classpath:stringtofind).\nSeparate entries in the list by a new line. Note that players can always sit even if blacklisted, and some entities, like horses, water mobs or nonliving entities, will never be allowed to sit in boats.\nIt's a little hard to explain, a more detailed explanation and list of examples can be found here: https://pastebin.com/XNZ7VWKh";
		newBoatEntityBlacklist = newBoatEntityBlacklistProp.getStringList();
		newBoatEntityBlacklistAsWhitelist = cfg.getBoolean("newBoatEntityBlacklistAsWhitelist", catItemEntity, false, "Treat the entity blacklist as a whitelist, ONLY entities matching that criteria will be allowed.");
		
		//      endGatewaySpawnColor = cfg.getInt("endGatewaySpawnColor", catAbandoned, 2, 0, 15, "The color of the end gateway beam when the gateway first appears.");
//      endGatewayEntryColor = cfg.getInt("endGatewayEntryColor", catAbandoned, 2, 0, 15, "The color of the end gateway beam when an entity enters it. Originally, this value was 4 (yellow) before version 1.11.");
	}
}
