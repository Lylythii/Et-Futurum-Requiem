package ganymedes01.etfuturum.lib;

public class Reference {

	public static final String MOD_ID = "etfuturum";
	public static final String MOD_NAME = "Et Futurum Requiem";
	public static final String MOD_URL = "@URL@";
	public static final String DEPENDENCIES = "required-after:Forge@[10.13.4.1558,);after:Thaumcraft@[4.2.3.5,);after:TwilightForest;after:HardcoreEnderExpansion;after:bluepower;after:MineTweaker3;";
	public static final String VERSION_NUMBER = "@VERSION@";
	public static String BUILD_VERSION;
	public static final String CREDITS = "@CREDITS@";
	public static final String[] AUTHOR_LIST = {"@AUTHORLIST@"};
	public static final String DESCRIPTION = "@DESCRIPTION@";
	public static final String LOGO_FILE = "@LOGOFILE@";
	public static final String VERSION_URL = System.getProperty("etfuturum.versionUrl", "https://raw.githubusercontent.com/Roadhog360/Et-Futurum-Requiem/master/LATEST_VERSION");
	public static final String MODRINTH_URL = "https://modrinth.com/mod/etfuturum";
	public static final String CURSEFORGE_URL = "https://www.curseforge.com/minecraft/mc-mods/et-futurum-requiem";
	public static final String GITHUB_URL = "https://github.com/Roadhog360/Et-Futurum-Requiem";

	public static final String MCAssetVer = "minecraft_1.19.3";
	
	public static final String ITEM_BLOCK_TEXTURE_PATH = MOD_ID + ":";
	public static final String ARMOUR_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/models/armor/";
	public static final String ENTITY_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/entities/";

}
