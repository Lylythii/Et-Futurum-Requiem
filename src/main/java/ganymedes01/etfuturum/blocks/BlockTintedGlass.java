package ganymedes01.etfuturum.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import java.util.Random;

public class BlockTintedGlass extends BlockGlass implements IConfigurable {
	public BlockTintedGlass() {
		super(Material.glass, false);
		setHardness(0.3f);
		setResistance(0.3f);
		setLightOpacity(255);
		setBlockName(Utils.getUnlocalisedName("tinted_glass"));
		setCreativeTab(EtFuturum.creativeTabBlocks);
		setStepSound(Block.soundTypeGlass);
	}

	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 1;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return ConfigBlocksItems.enableGemstone;
	}

	@Override
	protected boolean canSilkHarvest() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg)
	{
		this.blockIcon = reg.registerIcon("tinted_glass");
	}
}
