package dev.stormwatch.willow.state.player;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerStateHolder
{
    private final PlayerProfessionState playerProfessionState;
    private final ServerPlayerEntity player;

    public PlayerStateHolder(ServerPlayerEntity player)
    {
        this(player, new PlayerProfessionState(player));
    }

    public PlayerStateHolder(ServerPlayerEntity player, PlayerProfessionState playerProfessionState)
    {
        this.playerProfessionState = playerProfessionState;
        this.player = player;
    }

    public PlayerProfessionState getProfessionState()
    {
        return this.playerProfessionState;
    }

    public NbtCompound serialize()
    {
        NbtCompound nbt = new NbtCompound();
        // TODO
        return nbt;
    }
}