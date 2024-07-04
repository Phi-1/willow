package dev.stormwatch.willow.registry;

import dev.stormwatch.willow.Willow;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
	// Tools
	public static final Item TOOL_HANDLE = Registry.register(
			Registries.ITEM,
			Identifier.of(Willow.MOD_ID, "tool_handle"),
			new Item(new Item.Settings()));
	public static final Item FLINT_BLADE = Registry.register(
			Registries.ITEM,
			Identifier.of(Willow.MOD_ID, "flint_blade"),
			new Item(new Item.Settings()));
	public static final Item FLINT_AXE_HEAD = Registry.register(
			Registries.ITEM,
			Identifier.of(Willow.MOD_ID, "flint_axe_head"),
			new Item(new Item.Settings()));
	public static final Item FLINT_PICKAXE_HEAD = Registry.register(
			Registries.ITEM,
			Identifier.of(Willow.MOD_ID, "flint_pickaxe_head"),
			new Item(new Item.Settings()));
	public static final Item FLINT_SHOVEL_HEAD = Registry.register(
			Registries.ITEM,
			Identifier.of(Willow.MOD_ID, "flint_shovel_head"),
			new Item(new Item.Settings()));
	public static final Item FLINT_HOE_HEAD = Registry.register(
			Registries.ITEM,
			Identifier.of(Willow.MOD_ID, "flint_hoe_head"),
			new Item(new Item.Settings()));

	// Fuel Items
	public static final Item KINDLING = Registry.register(
			Registries.ITEM,
			Identifier.of(Willow.MOD_ID, "kindling"),
			new Item(new Item.Settings()));


	public static void register()
	{
	}

	private static void registerFuelItems()
	{
		// Burning time in ticks is number of items it can burn times 200
		FuelRegistry.INSTANCE.add(KINDLING, 6 * 200);
	}
}
