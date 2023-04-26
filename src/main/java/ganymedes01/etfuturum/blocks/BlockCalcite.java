package ganymedes01.etfuturum.blocks;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.client.sound.ModSounds;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import ganymedes01.etfuturum.configuration.configs.ConfigSounds;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCalcite extends Block implements IConfigurable {

	public BlockCalcite() {
		super(Material.rock);
		setHardness(0.75F);
		setResistance(0.75F);
		setStepSound(ConfigSounds.newBlockSounds ? ModSounds.soundCalcite : soundTypePiston);
		setBlockTextureName("calcite");
		setBlockName(Utils.getUnlocalisedName("calcite"));
		setCreativeTab(isEnabled() ? EtFuturum.creativeTabBlocks : null);
	}

	@Override
	public boolean isEnabled() {
		return ConfigBlocksItems.enableGemstone;
	}
}
