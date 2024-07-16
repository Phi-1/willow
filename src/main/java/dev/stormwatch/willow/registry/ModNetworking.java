package dev.stormwatch.willow.registry;

import dev.stormwatch.willow.state.player.PlayerProfessionState;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ModNetworking
{

    public static void registerCustomPayloadTypes()
    {
        PayloadTypeRegistry.playS2C().register(PlayerProfessionState.ProfessionStatePayload.ID, PlayerProfessionState.ProfessionStatePayload.CODEC);
    }

}
