package dev.stormwatch.willow.persistentstate;

import net.minecraft.nbt.NbtCompound;

public interface NBTSerializable
{
	public NbtCompound writeNBT(NbtCompound nbt);
	public NBTSerializable readNBT(NbtCompound nbt);
}
