package ganymedes01.etfuturum.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import cpw.mods.fml.common.Loader;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class Utils {

	public static String getUnlocalisedName(String name) {
		return Reference.MOD_ID + "." + name;
	}

	public static String getBlockTexture(String name) {
		return Reference.ITEM_BLOCK_TEXTURE_PATH + name;
	}

	public static String getItemTexture(String name) {
		return Reference.ITEM_BLOCK_TEXTURE_PATH + name;
	}

	public static ResourceLocation getResource(String path) {
		return new ResourceLocation(path);
	}

	public static String getConainerName(String name) {
		return "container." + Reference.MOD_ID + "." + name;
	}

	public static String getModContainer() {
		return Loader.instance().activeModContainer().getName();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getTileEntity(IBlockAccess world, int x, int y, int z, Class<T> cls) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (!cls.isInstance(tile))
			return null;
		return (T) tile;
	}

	public static List<String> getOreNames(ItemStack stack) {
		List<String> list = new ArrayList<String>();
		for (int id : OreDictionary.getOreIDs(stack))
			list.add(OreDictionary.getOreName(id));

		return list;
	}

	public static void loadItemStacksFromNBT(NBTTagList tag, ItemStack[] stacks) {
		for (int i = 0; i < tag.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = tag.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < stacks.length) {
				stacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	public static NBTTagList writeItemStacksToNBT(ItemStack[] stacks) {
		NBTTagList list = new NBTTagList();

		for (int i = 0; i < stacks.length; ++i) {
			if (stacks[i] != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stacks[i].writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		return list;
	}

	public static NBTTagCompound createUUIDTag(UUID uuid) {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setLong("M", uuid.getMostSignificantBits());
		nbttagcompound.setLong("L", uuid.getLeastSignificantBits());
		return nbttagcompound;
	}

	public static UUID getUUIDFromTag(NBTTagCompound tag) {
		return new UUID(tag.getLong("M"), tag.getLong("L"));
	}

	// Copied from 1.9 ProjectileHelper.class
	public static MovingObjectPosition forwardsRaycast(Entity p_188802_0_, boolean p_188802_1_, boolean p_188802_2_,
			Entity p_188802_3_) {
		double d0 = p_188802_0_.posX;
		double d1 = p_188802_0_.posY;
		double d2 = p_188802_0_.posZ;
		double d3 = p_188802_0_.motionX;
		double d4 = p_188802_0_.motionY;
		double d5 = p_188802_0_.motionZ;
		World world = p_188802_0_.worldObj;
		Vec3 vec3d = Vec3.createVectorHelper(d0, d1, d2);
		Vec3 vec3d1 = Vec3.createVectorHelper(d0 + d3, d1 + d4, d2 + d5);
		MovingObjectPosition raytraceresult = world.func_147447_a(vec3d, vec3d1, false, true, false);

		if (p_188802_1_) {
			if (raytraceresult != null) {
				vec3d1 = Vec3.createVectorHelper(raytraceresult.hitVec.xCoord, raytraceresult.hitVec.yCoord,
						raytraceresult.hitVec.zCoord);
			}

			Entity entity = null;
			List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(p_188802_0_,
					p_188802_0_.boundingBox.addCoord(d3, d4, d5).expand(1, 1, 1));
			double d6 = 0.0D;

			for (int i = 0; i < list.size(); ++i) {
				Entity entity1 = (Entity) list.get(i);

				if (entity1.canBeCollidedWith() && (p_188802_2_ || !entity1.isEntityEqual(p_188802_3_))
						&& !entity1.noClip) {
					AxisAlignedBB axisalignedbb = entity1.boundingBox.expand(0.30000001192092896D, 0.30000001192092896D,
							0.30000001192092896D);
					MovingObjectPosition raytraceresult1 = axisalignedbb.calculateIntercept(vec3d, vec3d1);

					if (raytraceresult1 != null) {
						double d7 = vec3d.squareDistanceTo(raytraceresult1.hitVec);

						if (d7 < d6 || d6 == 0.0D) {
							entity = entity1;
							d6 = d7;
						}
					}
				}
			}

			if (entity != null) {
				raytraceresult = new MovingObjectPosition(entity);
			}
		}

		return raytraceresult;
	}

	public static final void rotateTowardsMovement(Entity p_188803_0_, float p_188803_1_) {
		double d0 = p_188803_0_.motionX;
		double d1 = p_188803_0_.motionY;
		double d2 = p_188803_0_.motionZ;
		float f = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
		p_188803_0_.rotationYaw = (float) (atan2(d2, d0) * (180D / Math.PI)) + 90.0F;

		for (p_188803_0_.rotationPitch = (float) (atan2((double) f, d1) * (180D / Math.PI))
				- 90.0F; p_188803_0_.rotationPitch
						- p_188803_0_.prevRotationPitch < -180.0F; p_188803_0_.prevRotationPitch -= 360.0F) {
			;
		}

		while (p_188803_0_.rotationPitch - p_188803_0_.prevRotationPitch >= 180.0F) {
			p_188803_0_.prevRotationPitch += 360.0F;
		}

		while (p_188803_0_.rotationYaw - p_188803_0_.prevRotationYaw < -180.0F) {
			p_188803_0_.prevRotationYaw -= 360.0F;
		}

		while (p_188803_0_.rotationYaw - p_188803_0_.prevRotationYaw >= 180.0F) {
			p_188803_0_.prevRotationYaw += 360.0F;
		}

		p_188803_0_.rotationPitch = p_188803_0_.prevRotationPitch
				+ (p_188803_0_.rotationPitch - p_188803_0_.prevRotationPitch) * p_188803_1_;
		p_188803_0_.rotationYaw = p_188803_0_.prevRotationYaw
				+ (p_188803_0_.rotationYaw - p_188803_0_.prevRotationYaw) * p_188803_1_;
	}

	// Copied from 1.9 MathHelper
	public static double atan2(double p_181159_0_, double p_181159_2_) {

		final double FRAC_BIAS = Double.longBitsToDouble(4805340802404319232L);
		final double[] ASINE_TAB;
		final double[] COS_TAB;
		ASINE_TAB = new double[257];
		COS_TAB = new double[257];

		for (int j = 0; j < 257; ++j) {
			double d0 = (double) j / 256.0D;
			double d1 = Math.asin(d0);
			COS_TAB[j] = Math.cos(d1);
			ASINE_TAB[j] = d1;
		}

		double d0 = p_181159_2_ * p_181159_2_ + p_181159_0_ * p_181159_0_;

		if (Double.isNaN(d0)) {
			return Double.NaN;
		}

		boolean flag = p_181159_0_ < 0.0D;

		if (flag) {
			p_181159_0_ = -p_181159_0_;
		}

		boolean flag1 = p_181159_2_ < 0.0D;

		if (flag1) {
			p_181159_2_ = -p_181159_2_;
		}

		boolean flag2 = p_181159_0_ > p_181159_2_;

		if (flag2) {
			double d1 = p_181159_2_;
			p_181159_2_ = p_181159_0_;
			p_181159_0_ = d1;
		}

		double d9 = fastInvSqrt(d0);
		p_181159_2_ = p_181159_2_ * d9;
		p_181159_0_ = p_181159_0_ * d9;
		double d2 = FRAC_BIAS + p_181159_0_;
		int i = (int) Double.doubleToRawLongBits(d2);
		double d3 = ASINE_TAB[i];
		double d4 = COS_TAB[i];
		double d5 = d2 - FRAC_BIAS;
		double d6 = p_181159_0_ * d4 - p_181159_2_ * d5;
		double d7 = (6.0D + d6 * d6) * d6 * 0.16666666666666666D;
		double d8 = d3 + d7;

		if (flag2) {
			d8 = (Math.PI / 2D) - d8;
		}

		if (flag1) {
			d8 = Math.PI - d8;
		}

		if (flag) {
			d8 = -d8;
		}

		return d8;
	}

	public static double fastInvSqrt(double p_181161_0_) {
		double d0 = 0.5D * p_181161_0_;
		long i = Double.doubleToRawLongBits(p_181161_0_);
		i = 6910469410427058090L - (i >> 1);
		p_181161_0_ = Double.longBitsToDouble(i);
		p_181161_0_ = p_181161_0_ * (1.5D - d0 * p_181161_0_ * p_181161_0_);
		return p_181161_0_;
	}

	public static double perlinFade(double value) {
		return value * value * value * (value * (value * 6.0D - 15.0D) + 10.0D);
	}

	public static double perlinFadeDerivative(double value) {
		return 30.0D * value * value * (value - 1.0D) * (value - 1.0D);
	}

	public static float lerp(float delta, float start, float end) {
		return start + delta * (end - start);
	}

	public static double lerp(double delta, double start, double end) {
		return start + delta * (end - start);
	}

	/**
	 * A two-dimensional lerp between values on the 4 corners of the unit square.
	 * Arbitrary values are specified for the corners and the output is interpolated
	 * between them.
	 * 
	 * @param deltaX the x-coordinate on the unit square
	 * @param deltaY the y-coordinate on the unit square
	 * @param x0y0   the output if {@code deltaX} is 0 and {@code deltaY} is 0
	 * @param x1y0   the output if {@code deltaX} is 1 and {@code deltaY} is 0
	 * @param x0y1   the output if {@code deltaX} is 0 and {@code deltaY} is 1
	 * @param x1y1   the output if {@code deltaX} is 1 and {@code deltaY} is 1
	 */
	public static double lerp2(double deltaX, double deltaY, double x0y0, double x1y0, double x0y1, double x1y1) {
		return lerp(deltaY, lerp(deltaX, x0y0, x1y0), lerp(deltaX, x0y1, x1y1));
	}

	/**
	 * A three-dimensional lerp between values on the 8 corners of the unit cube.
	 * Arbitrary values are specified for the corners and the output is interpolated
	 * between them.
	 * 
	 * @param deltaX the x-coordinate on the unit cube
	 * @param deltaY the y-coordinate on the unit cube
	 * @param deltaZ the z-coordinate on the unit cube
	 * @param x0y0z0 the output if {@code deltaX} is 0, {@code deltaY} is 0 and
	 *               {@code deltaZ} is 0
	 * @param x1y0z0 the output if {@code deltaX} is 1, {@code deltaY} is 0 and
	 *               {@code deltaZ} is 0
	 * @param x0y1z0 the output if {@code deltaX} is 0, {@code deltaY} is 1 and
	 *               {@code deltaZ} is 0
	 * @param x1y1z0 the output if {@code deltaX} is 1, {@code deltaY} is 1 and
	 *               {@code deltaZ} is 0
	 * @param x0y0z1 the output if {@code deltaX} is 0, {@code deltaY} is 0 and
	 *               {@code deltaZ} is 1
	 * @param x1y0z1 the output if {@code deltaX} is 1, {@code deltaY} is 0 and
	 *               {@code deltaZ} is 1
	 * @param x0y1z1 the output if {@code deltaX} is 0, {@code deltaY} is 1 and
	 *               {@code deltaZ} is 1
	 * @param x1y1z1 the output if {@code deltaX} is 1, {@code deltaY} is 1 and
	 *               {@code deltaZ} is 1
	 */

	public static double lerp3(double deltaX, double deltaY, double deltaZ, double x0y0z0, double x1y0z0, double x0y1z0,
			double x1y1z0, double x0y0z1, double x1y0z1, double x0y1z1, double x1y1z1) {
		return lerp(deltaZ, lerp2(deltaX, deltaY, x0y0z0, x1y0z0, x0y1z0, x1y1z0),
				lerp2(deltaX, deltaY, x0y0z1, x1y0z1, x0y1z1, x1y1z1));
	}

	public static long lfloor(double value) {
		long l = (long) value;
		return value < (double) l ? l - 1L : l;
	}

	public static float fastInverseSqrt(float x) {
		float f = 0.5F * x;
		int i = Float.floatToIntBits(x);
		i = 1597463007 - (i >> 1);
		x = Float.intBitsToFloat(i);
		x *= 1.5F - f * x * x;
		return x;
	}

	public static double fastInverseSqrt(double x) {
		double d = 0.5D * x;
		long l = Double.doubleToRawLongBits(x);
		l = 6910469410427058090L - (l >> 1);
		x = Double.longBitsToDouble(l);
		x *= 1.5D - d * x * x;
		return x;
	}
	
	public static <T> T getRandom(List<T> list, Random rand) {
		return list.get(rand.nextInt(list.size()));
	}
}