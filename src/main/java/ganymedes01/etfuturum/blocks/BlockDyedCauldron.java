package ganymedes01.etfuturum.blocks;

import java.awt.Color;

import org.apache.commons.lang3.ArrayUtils;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.ModBlocks.ISubBlocksBlock;
import ganymedes01.etfuturum.recipes.ModRecipes;
import ganymedes01.etfuturum.tileentities.TileEntityCauldronDyed;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDyedCauldron extends BlockCauldronTileEntity implements IConfigurable, ISubBlocksBlock {

	protected BlockDyedCauldron() {
		super(Material.iron);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		
		final ItemStack stack = entityPlayer.getHeldItem();
		if(stack != null) {
			final TileEntityCauldronDyed dyedCauldron = (TileEntityCauldronDyed) world.getTileEntity(x, y, z);
			for(final String oreString : EtFuturum.getOreStrings(stack)) {
				if(oreString.contains("dye")) {
					final int index = ArrayUtils.indexOf(ModRecipes.ore_dyes, oreString);
					if(index < 0 || index > 15) {
						return false;
					}
					final float[] rgb = EntitySheep.fleeceColorTable[index];
					dyedCauldron.dyeColor = (int)(rgb[0] * 255) << 16 | (int)(rgb[1] * 255) << 8 | (int)(rgb[2] * 255);
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityCauldronDyed();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return null;
	}

}
