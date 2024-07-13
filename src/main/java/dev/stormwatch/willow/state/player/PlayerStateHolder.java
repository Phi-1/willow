package dev.stormwatch.willow.state.player;

import net.minecraft.nbt.NbtCompound;

public class PlayerStateHolder
{
    private final PlayerSkillLevelState playerSkillLevelState;

    public PlayerStateHolder()
    {
        this(new PlayerSkillLevelState());
    }

    public PlayerStateHolder(PlayerSkillLevelState playerSkillLevelState)
    {
        this.playerSkillLevelState = playerSkillLevelState;
    }

    public NbtCompound serialize()
    {
        NbtCompound nbt = new NbtCompound();
        // TODO
        return nbt;
    }
}