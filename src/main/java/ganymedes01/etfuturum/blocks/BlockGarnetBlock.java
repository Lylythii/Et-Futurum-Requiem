package ganymedes01.etfuturum.blocks;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.client.sound.ModSounds;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import ganymedes01.etfuturum.configuration.configs.ConfigSounds;
import ganymedes01.etfuturum.core.utils.Utils;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public class BlockGarnetBlock extends Block implements IConfigurable {
	
	public BlockGarnetBlock() {
		this(Material.rock);
	}
	public BlockGarnetBlock(Material material) {
		super(material);
		setHardness(1.5F);
		setResistance(1.5F);
		setStepSound(ConfigSounds.newBlockSounds ? ModSounds.soundGemstoneBlock : soundTypeGlass);
		setBlockTextureName("garnet_block");
		setBlockName(Utils.getUnlocalisedName("Garnet_block"));
		setCreativeTab(isEnabled() ? EtFuturum.creativeTabBlocks : null);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity ent)
	{
		if (!world.isRemote && ent instanceof IProjectile) {
			 ent.playSound(Reference.MCAssetVer + ":block.gemstone_block.hit", 1.0F, 0.5F + world.rand.nextFloat() * 1.2F);
			 ent.playSound(Reference.MCAssetVer + ":block.gemstone_block.chime", 1.0F, 0.5F + world.rand.nextFloat() * 1.2F);
		}
	}

	@Override
	public boolean isEnabled() {
		return ConfigBlocksItems.enableGemstone;
	}
}
