package ganymedes01.etfuturum.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/** ContainerChest modified to use a custom row size. */
public class ContainerChestGeneric extends Container
{
	private IInventory chestInventory;
	private int rowSize;

	public ContainerChestGeneric(IInventory p_i1806_1_, IInventory p_i1806_2_) {
		this(p_i1806_1_, p_i1806_2_, 9, false);
	}
	
	public ContainerChestGeneric(IInventory p_i1806_1_, IInventory p_i1806_2_, int rowSize, boolean slim)
	{
		this.chestInventory = p_i1806_2_;
		this.rowSize = rowSize = Math.min(rowSize, p_i1806_2_.getSizeInventory());
		if(p_i1806_2_.getSizeInventory() % rowSize != 0) {
			throw new IllegalArgumentException("Non-rectangular inventory. " + p_i1806_2_.getSizeInventory() + " slots, " + rowSize + " columns.");
		}
		
		int numRows = (int)Math.ceil(p_i1806_2_.getSizeInventory() / (float)rowSize);
		p_i1806_2_.openInventory();
		int i = (numRows - 4) * 18;
		int j;
		int k;
		
		int padL = slim ? 12 : 8; // padding on left and right
		int padT = slim ? 8 : 18; // padding on top
		int sep1H = slim ? 4 : 13; // height of separator
		int sep2H = slim ? 4 : 4; // height of separator
		
		int width = rowSize * 18 + 2 * padL;
		
		int slotStartXOff = 0;
		
		for (j = 0; j < numRows; ++j)
		{
			for (k = 0; k < rowSize; ++k)
			{
				if(k + j * rowSize < chestInventory.getSizeInventory()) {
					this.addSlotToContainer(constructSlot(p_i1806_2_, k + j * rowSize, slotStartXOff + padL + k * 18, padT + j * 18));
				}
			}
		}
		
		int invSlotStartXOff = (rowSize * 18 - 9 * 18) / 2;

		for (j = 0; j < 3; ++j)
		{
			for (k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new Slot(p_i1806_1_, k + j * 9 + 9, invSlotStartXOff + padL + k * 18, padT + numRows * 18 + sep1H + j * 18));
			}
		}

		for (j = 0; j < 9; ++j)
		{
			this.addSlotToContainer(new Slot(p_i1806_1_, j, invSlotStartXOff + padL + j * 18, padT + numRows * 18 + sep1H + 3 * 18 + sep2H));
		}
	}
	
	protected Slot constructSlot(IInventory inventory, int slotIndex, int displayX, int displayY) {
		return new SlotCustom(inventory, slotIndex, displayX, displayY);
	}

	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return this.chestInventory.isUseableByPlayer(p_75145_1_);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (p_82846_2_ < this.chestInventory.getSizeInventory())
			{
				if (!this.mergeItemStack(itemstack1, this.chestInventory.getSizeInventory(), this.inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 0, this.chestInventory.getSizeInventory(), false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}
	
	@Override
	protected boolean mergeItemStack(ItemStack p_75135_1_, int p_75135_2_, int p_75135_3_, boolean p_75135_4_)
	{
		int k = p_75135_2_;

		if (p_75135_4_)
		{
			k = p_75135_3_ - 1;
		}
		
		while (!p_75135_4_ && k < p_75135_3_ || p_75135_4_ && k >= p_75135_2_)
		{
			Slot slot = (Slot)this.inventorySlots.get(k);
			
			if(slot instanceof SlotCustom && !slot.isItemValid(p_75135_1_)) {
				return false;
			}

			if (p_75135_4_)
			{
				--k;
			}
			else
			{
				++k;
			}
		}

		return super.mergeItemStack(p_75135_1_, p_75135_2_, p_75135_3_, p_75135_4_);
	}

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer p_75134_1_)
	{
		super.onContainerClosed(p_75134_1_);
		this.chestInventory.closeInventory();
	}

	/**
	 * Return this chest container's <s>lower</s> UPPER chest inventory.
	 */
	public IInventory getLowerChestInventory()
	{
		return this.chestInventory;
	}
	
	public int getRowSize() {
		return this.rowSize;
	}
	
	public static class SlotCustom extends Slot {
		
		public SlotCustom(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
			super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
		}
		
		@Override
		public boolean isItemValid(ItemStack stack) {
			return inventory.isItemValidForSlot(this.getSlotIndex(), stack);
		}
		
	}
}