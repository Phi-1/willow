package dev.stormwatch.willow;

import dev.stormwatch.willow.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// TODO: lock tool tiers behind skill levels
// TODO: lock more materials behind tool tier, like ores. Iron axe for dark oak kinda stuff.
// TODO: ^ add to block tag needs_***_tool, and set block to needs correct tool for drops, logs dont need that by default
// TODO: maybe add way to get wooden axe without breaking trees, oak logs take basic axe
// TODO: use #minecraft:acacia_logs instead of direct item, it contains variants

// TODO: make leaves drop sticks sometimes, and make mining leaves give woodcutting xp
// TODO: warped fungus should also give (more?) xp

public class Willow implements ModInitializer
{
	public static final String MOD_ID = "willow";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.register();
	}
}