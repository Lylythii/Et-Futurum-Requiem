package ganymedes01.etfuturum.items;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.blocks.IConfigurable;
import ganymedes01.etfuturum.configuration.configs.ConfigBlocksItems;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.item.Item;

public class ItemRubyShard extends Item implements IConfigurable {

	public ItemRubyShard() {
		setTextureName("ruby_shard");
		setUnlocalizedName(Utils.getUnlocalisedName("ruby_shard"));
		setCreativeTab(isEnabled() ? EtFuturum.creativeTabItems : null);
	}
	
	@Override
	public boolean isEnabled() {
		return ConfigBlocksItems.enableGemstone;
	}

}
