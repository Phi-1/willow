package dev.stormwatch.willow.persistentstate.player;

import dev.stormwatch.willow.persistentstate.NBTSerializable;
import net.minecraft.nbt.NbtCompound;

import java.util.UUID;

public class PlayerStateHolder implements NBTSerializable
{
	private final UUID playerUUID;
	private final PlayerSkillLevelState playerSkillLevelState;
	// all the other player related state

	private PlayerStateHolder(UUID playerUUID, PlayerSkillLevelState playerSkillLevelState)
	{
		this.playerUUID = playerUUID;
		this.playerSkillLevelState = playerSkillLevelState;
	}

	@Override
	public NbtCompound writeNBT(NbtCompound nbt)
	{
		return null;
	}

	@Override
	public NBTSerializable readNBT(NbtCompound nbt)
	{
		return null;
	}
}