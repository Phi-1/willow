package dev.stormwatch.willow;

import dev.stormwatch.willow.events.ProfessionEvents;
import dev.stormwatch.willow.registry.ModItems;
import dev.stormwatch.willow.registry.ModNetworking;
import dev.stormwatch.willow.state.ModStateManager;
import dev.stormwatch.willow.state.player.PlayerProfessionState;
import dev.stormwatch.willow.state.player.PlayerStateHolder;
import dev.stormwatch.willow.util.Profession;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// TODO: lock tool tiers behind skill levels
// TODO: lock more materials behind tool tier, like ores. Iron axe for dark oak kinda stuff.
// TODO: ^ add to block tag needs_***_tool, and set block to needs correct tool for drops, logs dont need that by default
// TODO: maybe add way to get wooden axe without breaking trees, oak logs take basic axe
// TODO: use #minecraft:acacia_logs instead of direct item, it contains variants

// TODO: make leaves drop sticks sometimes, and make mining leaves give woodcutting xp
// TODO: warped fungus should also give (more?) xp
// TODO: mushroom stems give woodcutting

public class Willow implements ModInitializer
{
	public static final String MOD_ID = "willow";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.register();
		ModNetworking.registerCustomPayloadTypes();

		registerEventHandlers();
		testProfessionSyncing();
	}

	private void registerEventHandlers()
	{
		ProfessionEvents.registerEventHandlers();
	}

	private void testProfessionSyncing()
	{
		PlayerBlockBreakEvents.AFTER.register(((world, player, pos, state, blockEntity) ->
		{
			if (world.isClient()) return;
			MinecraftServer server = world.getServer();
			ModStateManager serverState = ModStateManager.getState(server);
			PlayerProfessionState professionState = serverState.getOrCreatePlayerState((ServerPlayerEntity) player).getProfessionState();
			professionState.increaseProfessionXP(Profession.FARMING, 3);
		}));
	}
}