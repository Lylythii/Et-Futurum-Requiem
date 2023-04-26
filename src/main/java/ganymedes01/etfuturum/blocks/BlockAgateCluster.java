package ganymedes01.etfuturum.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.ModBlocks.ISubBlocksBlock;
import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.client.sound.ModSounds;
import ganymedes01.etfuturum.configuration.configs.ConfigSounds;
import ganymedes01.etfuturum.core.utils.Utils;
import ganymedes01.etfuturum.items.block.ItemAgateCluster;
import ganymedes01.etfuturum.lib.RenderIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAgateCluster extends BlockAgateBlock implements ISubBlocksBlock, IMultiStepSound {
	
	private final int type;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockAgateCluster(int type) {
		super(Material.glass);
		setHardness(1.5F);
		setResistance(1.5F);
		setStepSound(ConfigSounds.newBlockSounds ? ModSounds.soundGemstoneCluster : soundTypeGlass);
		setBlockTextureName("agate_cluster");
		setBlockName(Utils.getUnlocalisedName("agate_cluster_" + (type + 1)));
		setCreativeTab(isEnabled() ? EtFuturum.creativeTabBlocks : null);
		setHarvestLevel("pickaxe", 0);
		this.lightValue = 1;
		this.type = type;
	}
	
	public int getMobilityFlag()
	{
		return 1;
	}
	
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		return getLightValue() + (type * 3) + (meta / 6);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return ModItems.agate_shard;
	}
	
	protected ItemStack createStackedBlock(int p_149644_1_)
	{
		int j = 0;
		Item item = Item.getItemFromBlock(this);

		if (item != null && item.getHasSubtypes())
		{
			j = p_149644_1_ < 6 ? 0 : 6;
		}

		return new ItemStack(item, 1, j);
	}
	
	protected boolean canSilkHarvest()
	{
		return true;
	}

	public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
	{
		return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) < 6 ? 0 : 6;
	}
	
	public int quantityDropped(int meta, int fortune, Random random)
	{
		if(this == ModBlocks.agate_cluster_2 && meta >= 6) {
			int drop = quantityDropped(random);
			if(fortune > 0 && harvestingWithPickaxe() && random.nextInt(2 + fortune) == 0) {
				drop += 4 * fortune;
			}
			return drop;
		}
		return 0;
	}

	public int quantityDropped(Random p_149745_1_)
	{
		if(harvestingWithPickaxe()) {
			return 4;
		}
		return 2;
	}
	
	private boolean harvestingWithPickaxe() {
		return harvesters.get() != null && harvesters.get().getCurrentEquippedItem() != null && harvesters.get().getCurrentEquippedItem().getItem().getToolClasses(harvesters.get().getCurrentEquippedItem()).contains("pickaxe");
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		return side + meta;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);

		float height = (meta < 6 ? 0.125F : 0.1875F) + (type == 1 ? 0.1875F : 0.0625F);
		float xzOffset = meta < 6 && type == 0 ? .25F : .1875F;
		if(meta >= 6 && type == 1) {
			height += .0625F;
		}

		switch (meta % 6) {
		case 0:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y+1 - height, z+xzOffset, x+1 - xzOffset, y+1.0F, z+1 - xzOffset);
		case 1:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y, z+xzOffset, x+1 - xzOffset, y+height, z+1 - xzOffset);
		case 2:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y+xzOffset, z+1 - height, x+1 - xzOffset, y+1 - xzOffset, z+1.0F);
		case 3:
			return AxisAlignedBB.getBoundingBox(x+xzOffset, y+xzOffset, z, x+1 - xzOffset, y+1 - xzOffset, z+height);
		case 4:
			return AxisAlignedBB.getBoundingBox(x+1 - height, y+xzOffset, z+xzOffset, x+1.0F, y+1 - xzOffset, z+1 - xzOffset);
		case 5:
			return AxisAlignedBB.getBoundingBox(x, y+xzOffset, z+xzOffset, x+height, y+1 - xzOffset, z+1 - xzOffset);
		}
		return null;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
		int meta = access.getBlockMetadata(x, y, z);

		float height = (meta < 6 ? 0.125F : 0.1875F) + (type == 1 ? 0.1875F : 0.0625F);
		float xzOffset = meta < 6 && type == 0 ? .25F : .1875F;
		if(meta >= 6 && type == 1) {
			height += .0625F;
		}

		switch (meta % 6) {
		case 0:
			this.setBlockBounds(xzOffset, 1 - height, xzOffset, 1 - xzOffset, 1.0F, 1 - xzOffset);
			break;
		case 1:
			this.setBlockBounds(xzOffset, 0.0F, xzOffset, 1 - xzOffset, height, 1 - xzOffset);
			break;
		case 2:
			this.setBlockBounds(xzOffset, xzOffset, 1 - height, 1 - xzOffset, 1 - xzOffset, 1.0F);
			break;
		case 3:
			this.setBlockBounds(xzOffset, xzOffset, 0.0F, 1 - xzOffset, 1 - xzOffset, height);
			break;
		case 4:
			this.setBlockBounds(1 - height, xzOffset, xzOffset, 1.0F, 1 - xzOffset, 1 - xzOffset);
			break;
		case 5:
			this.setBlockBounds(0.0F, xzOffset, xzOffset, height, 1 - xzOffset, 1 - xzOffset);
			break;
		}
	}

	protected void checkAndDropBlock(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_)
	{
		if (!this.canBlockStay(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_))
		{
			this.dropBlockAsItem(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_, p_149855_1_.getBlockMetadata(p_149855_2_, p_149855_3_, p_149855_4_), 0);
			p_149855_1_.setBlockToAir(p_149855_2_, p_149855_3_, p_149855_4_);
		}
	}

	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	{
		super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
		this.checkAndDropBlock(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return this.canPlaceBlockOnSide(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
	
	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
	{
		EnumFacing facing = EnumFacing.getFront(side);
		return world.getBlock(x - facing.getFrontOffsetX(), y - facing.getFrontOffsetY(), z - facing.getFrontOffsetZ()).isOpaqueCube();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return this.icons[p_149691_2_ < 6 ? 0 : 1];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		icons = new IIcon[2];
		if(type == 0) {
			icons[0] = p_149651_1_.registerIcon("small_agate_bud");
			icons[1] = p_149651_1_.registerIcon("medium_agate_bud");
		}
		if(type == 1) {
			icons[0] = p_149651_1_.registerIcon("large_agate_bud");
			icons[1] = p_149651_1_.registerIcon(getTextureName());
		}
		super.registerBlockIcons(p_149651_1_);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 6));
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIDs.AGATE_CLUSTER;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemAgateCluster.class;
	}

	private static final SoundType[] STEPSOUNDS = new SoundType[] {ModSounds.soundGemstoneBudSmall, ModSounds.soundGemstoneBudMed, ModSounds.soundGemstoneBudLrg, null};
	@Override
	public SoundType getStepSound(IBlockAccess world, int x, int y, int z, int meta) {
		return STEPSOUNDS[(meta < 6 ? 0 : 1) + (type == 0 ? 0 : 2)];
	}

	@Override
	public boolean requiresNewBlockSounds() {
		return true;
	}
}
