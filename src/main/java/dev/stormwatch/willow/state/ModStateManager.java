package dev.stormwatch.willow.state;

import dev.stormwatch.willow.Willow;
import dev.stormwatch.willow.state.player.PlayerStateHolder;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModStateManager extends PersistentState
{
    private static final Type<ModStateManager> TYPE = new Type<>(ModStateManager::new, ModStateManager::createFromNBT, null);
    private final Map<UUID, PlayerStateHolder> playerStateMap = new HashMap<>();

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        this.serializePlayerState(nbt);
        return nbt;
    }

    public static ModStateManager createFromNBT(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        ModStateManager stateManager = new ModStateManager();
        // TODO: read all state
        return stateManager;
    }

    public static ModStateManager getState(MinecraftServer server)
    {
        PersistentStateManager persistentStateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        ModStateManager modStateManager = persistentStateManager.getOrCreate(TYPE, Willow.MOD_ID);
        modStateManager.markDirty();
        return modStateManager;
    }

    public PlayerStateHolder getOrCreatePlayerState(ServerPlayerEntity player)
    {
        PlayerStateHolder playerState = this.playerStateMap.getOrDefault(player.getUuid(), new PlayerStateHolder(player));
        if (!this.playerStateMap.containsKey(player.getUuid()))
        {
            this.playerStateMap.put(player.getUuid(), playerState);
        }
        return playerState;
    }

    private void serializePlayerState(NbtCompound nbt)
    {
        for (Map.Entry<UUID, PlayerStateHolder> playerStateEntry : this.playerStateMap.entrySet())
        {
            NbtCompound playerStateNBT = playerStateEntry.getValue().serialize();
            nbt.put(playerStateEntry.getKey().toString(), playerStateNBT);
        }
    }
}
