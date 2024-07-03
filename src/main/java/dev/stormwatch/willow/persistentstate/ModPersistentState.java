package dev.stormwatch.willow.persistentstate;

import dev.stormwatch.willow.persistentstate.player.PlayerStateHolder;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.PersistentState;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModPersistentState extends PersistentState
{

    private final Map<UUID, PlayerStateHolder> PLAYER_STATES = new HashMap<>();

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        return null;
    }
}
