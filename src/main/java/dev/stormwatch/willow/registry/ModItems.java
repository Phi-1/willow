package dev.stormwatch.willow.registry;

import dev.stormwatch.willow.Willow;
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

	/**
	 * Dummy method, needs to be called to make Java aware of this class
	 */
	public static void register() {}

}
