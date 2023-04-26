package ganymedes01.etfuturum.client.sound;

import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;

public class ModSounds {
	
	public static final SoundType soundSlime = new CustomSound("minecraft:mob.slime.big") {
		@Override
		public String getBreakSound() {
			return soundName;
		}

		@Override
		public String getStepResourcePath() {
			return "minecraft:mob.slime.small";
		}
	};
	public static final SoundType soundLantern = new CustomSound("lantern", true);
	public static final SoundType soundWartBlock = new CustomSound("wart_block");
	public static final SoundType soundSoulSand = new CustomSound("soul_sand");
	public static final SoundType soundNetherBricks = new CustomSound("nether_bricks");
	public static final SoundType soundBoneBlock = new CustomSound("bone_block");
	public static final SoundType soundNetherrack = new CustomSound("netherrack");
	public static final SoundType soundNetherOre = new CustomSound("nether_ore");
	public static final SoundType soundAncientDebris = new CustomSound("ancient_debris");
	public static final SoundType soundBasalt = new CustomSound("basalt");
	public static final SoundType soundNetherite = new CustomSound("netherite_block");
	public static final SoundType soundCrops = new CustomSound("crop") {
		@Override
		public String getStepResourcePath() {
			return Block.soundTypeGrass.getStepResourcePath();
		}

		@Override
		public String func_150496_b()
		{
			return Reference.MCAssetVer + ":item." + soundName + ".plant";
		}
	};
	public static final SoundType soundCropWarts = new CustomSound("nether_wart") {
		@Override
		public String getStepResourcePath() {
			return Reference.MCAssetVer + ":block.fungus.step";
		}

		@Override
		public String func_150496_b()
		{
			return Reference.MCAssetVer + ":item." + soundName + ".plant";
		}
	};
	public static final SoundType soundCopper = new CustomSound("copper");
	public static final SoundType soundBerryBush = new CustomSound("sweet_berry_bush", true) {
		@Override
		public String getStepResourcePath() {
			return Block.soundTypeGrass.getStepResourcePath();
		}
	};
	public static final SoundType soundDeepslate = new CustomSound("deepslate", true);
	public static final SoundType soundDeepslateBricks = new CustomSound("deepslate_bricks");
	public static final SoundType soundDeepslateTiles = new CustomSound("deepslate_tiles");
	public static final SoundType soundTuff = new CustomSound("tuff");
	public static final SoundType soundSculk = new CustomSound("sculk");
	public static final SoundType soundSculkCatalyst = new CustomSound("sculk_catalyst");
	public static final SoundType soundVines = new CustomSound("vine");
	public static final SoundType soundCalcite = new CustomSound("calcite", true);
	public static final SoundType soundGemstoneBlock = new CustomSound("gemstone_block", true);
	public static final SoundType soundGemstoneBudSmall = new CustomSound("small_gemstone_bud", true) {
		@Override
		public String getStepResourcePath() {
			return soundGemstoneCluster.getStepResourcePath();
		}
	};
	public static final SoundType soundGemstoneBudMed = new CustomSound("medium_gemstone_bud", true) {
		@Override
		public String getStepResourcePath() {
			return soundGemstoneCluster.getStepResourcePath();
		}
	};
	public static final SoundType soundGemstoneBudLrg = new CustomSound("large_gemstone_bud", true) {
		@Override
		public String getStepResourcePath() {
			return soundGemstoneCluster.getStepResourcePath();
		}
	};
	public static final SoundType soundGemstoneCluster = new CustomSound("gemstone_cluster", true);
	public static final SoundType soundLodestone = new CustomSound("lodestone", true);
	public static final SoundType soundDripstoneBlock = new CustomSound("dripstone_block");
	public static final SoundType soundPointedDripstone = new CustomSound("pointed_dripstone");
	public static final SoundType soundWetGrass = new CustomSound("wet_grass", true);
//  public static final SoundType soundNylium = new CustomSound("nylium");
//  public static final SoundType soundHoneyBlock = new CustomSound("honey_block");
//  public static final SoundType soundFungus = new CustomSound("fungus");
//  public static final SoundType soundShroomlight = new CustomSound("shroomlight");

	//Currently prep for Alterius Futurum
	public static final SoundType soundAzaleaSapling = new CustomSound("azalea");
	public static final SoundType soundAzaleaLeaves = new CustomSound("azalea_leaves");
	public static final SoundType soundHangingRoots = new CustomSound("hanging_roots");
	public static final SoundType soundRootedDirt = new CustomSound("rooted_dirt");
	public static final SoundType soundMossBlock = new CustomSound("moss");
	public static final SoundType soundMossCarpet = new CustomSound("moss_carpet");
	public static final SoundType soundStem = new CustomSound("stem");

	public static class CustomSound extends SoundType {

		private final boolean placeSound;

		public CustomSound(String name, boolean placeSound) {
			this(name, 1, 1, placeSound);
		}
		
		public CustomSound(String name, float volume, float pitch, boolean placeSound) {
			super(name, volume, pitch);
			this.placeSound = placeSound;
		}
		
		public CustomSound(String name, float volume, float pitch) {
			this(name, volume, pitch, false);
		}
		
		public CustomSound(String name) {
			this(name, 1, 1, false);
		}

		@Override
		public String getBreakSound() {
			return Reference.MCAssetVer + ":block." + soundName + ".break";
		}

		@Override
		public String getStepResourcePath() {
			return Reference.MCAssetVer + ":block." + soundName + ".step";
		}

		@Override
		public String func_150496_b()
		{
			return placeSound ? Reference.MCAssetVer + ":block." + soundName + ".place" : this.getBreakSound();
		}
	}
}