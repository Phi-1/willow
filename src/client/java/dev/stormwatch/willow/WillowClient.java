package dev.stormwatch.willow;

import dev.stormwatch.willow.state.synced.SyncedPlayerState;
import net.fabricmc.api.ClientModInitializer;

public class WillowClient implements ClientModInitializer
{
	@Override
	public void onInitializeClient()
	{
		registerNetworkHandlers();
	}

	private void registerNetworkHandlers()
	{
		SyncedPlayerState.registerNetworkHandlers();
	}
}