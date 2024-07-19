package dev.stormwatch.willow.state.synced;

import dev.stormwatch.willow.state.player.PlayerProfessionState;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.text.Text;

public class SyncedPlayerState
{
    public static PlayerProfessionState professionState = null;

    public static void registerNetworkHandlers()
    {
        ClientPlayNetworking.registerGlobalReceiver(PlayerProfessionState.ProfessionStatePayload.ID, (payload, context) ->
        {
            context.client().execute(() ->
            {
                // TODO
            });
        });
    }
}
