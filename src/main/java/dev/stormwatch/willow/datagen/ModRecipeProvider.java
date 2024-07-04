package dev.stormwatch.willow.datagen;

import dev.stormwatch.willow.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider
{

	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
	{
		super(output, registriesFuture);
	}

	@Override
	public void generate(RecipeExporter exporter)
	{
		// Tools
		ModRecipes.TOOL_HANDLE.offerTo(exporter);
		ModRecipes.FLINT_AXE_HEAD.offerTo(exporter);
		ModRecipes.FLINT_PICKAXE_HEAD.offerTo(exporter);
		ModRecipes.FLINT_SHOVEL_HEAD.offerTo(exporter);
		ModRecipes.FLINT_HOE_HEAD.offerTo(exporter);
		ModRecipes.FLINT_BLADE.offerTo(exporter);
		ModRecipes.FLINT_AXE.offerTo(exporter);
		ModRecipes.FLINT_PICKAXE.offerTo(exporter);
		ModRecipes.FLINT_SHOVEL.offerTo(exporter);
		ModRecipes.FLINT_HOE.offerTo(exporter);
		ModRecipes.FLINT_KNIFE.offerTo(exporter);

		// Fuel
		ModRecipes.KINDLING.offerTo(exporter);
	}

	private static class ModRecipes
	{
		private static final ShapedRecipeJsonBuilder TOOL_HANDLE = ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_HANDLE)
				.input('s', Items.STICK)
				.pattern(" s ")
				.pattern(" s ")
				.criterion(FabricRecipeProvider.hasItem(Items.STICK), FabricRecipeProvider.conditionsFromItem(Items.STICK));

		private static final ShapedRecipeJsonBuilder FLINT_AXE_HEAD = ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_AXE_HEAD)
				.input('f', Items.FLINT)
				.pattern("ff")
				.pattern("f ")
				.criterion(FabricRecipeProvider.hasItem(Items.FLINT), FabricRecipeProvider.conditionsFromItem(Items.FLINT));

		private static final ShapedRecipeJsonBuilder FLINT_PICKAXE_HEAD = ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_PICKAXE_HEAD)
				.input('f', Items.FLINT)
				.pattern("ff")
				.criterion(FabricRecipeProvider.hasItem(Items.FLINT), FabricRecipeProvider.conditionsFromItem(Items.FLINT));

		private static final ShapedRecipeJsonBuilder FLINT_HOE_HEAD = ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_HOE_HEAD)
				.input('f', Items.FLINT)
				.pattern("f")
				.criterion(FabricRecipeProvider.hasItem(Items.FLINT), FabricRecipeProvider.conditionsFromItem(Items.FLINT));

		private static final ShapedRecipeJsonBuilder FLINT_BLADE = ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_BLADE)
				.input('f', Items.FLINT)
				.pattern("f")
				.pattern("f")
				.criterion(FabricRecipeProvider.hasItem(Items.FLINT), FabricRecipeProvider.conditionsFromItem(Items.FLINT));

		private static final ShapedRecipeJsonBuilder FLINT_SHOVEL_HEAD = ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_SHOVEL_HEAD)
				.input('f', Items.FLINT)
				.pattern("ff")
				.pattern("ff")
				.criterion(FabricRecipeProvider.hasItem(Items.FLINT), FabricRecipeProvider.conditionsFromItem(Items.FLINT));

		private static final ShapelessRecipeJsonBuilder FLINT_AXE = ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_AXE)
				.input(ModItems.FLINT_AXE_HEAD)
				.input(ModItems.TOOL_HANDLE)
				.criterion(FabricRecipeProvider.hasItem(ModItems.FLINT_AXE_HEAD), FabricRecipeProvider.conditionsFromItem(ModItems.FLINT_AXE_HEAD));

		private static final ShapelessRecipeJsonBuilder FLINT_PICKAXE = ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_PICKAXE)
				.input(ModItems.FLINT_PICKAXE_HEAD)
				.input(ModItems.TOOL_HANDLE)
				.criterion(FabricRecipeProvider.hasItem(ModItems.FLINT_PICKAXE_HEAD), FabricRecipeProvider.conditionsFromItem(ModItems.FLINT_PICKAXE_HEAD));

		private static final ShapelessRecipeJsonBuilder FLINT_HOE = ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_HOE)
				.input(ModItems.FLINT_HOE_HEAD)
				.input(ModItems.TOOL_HANDLE)
				.criterion(FabricRecipeProvider.hasItem(ModItems.FLINT_HOE_HEAD), FabricRecipeProvider.conditionsFromItem(ModItems.FLINT_HOE_HEAD));

		private static final ShapelessRecipeJsonBuilder FLINT_KNIFE = ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_SWORD)
				.input(ModItems.FLINT_BLADE)
				.input(ModItems.TOOL_HANDLE)
				.criterion(FabricRecipeProvider.hasItem(ModItems.FLINT_BLADE), FabricRecipeProvider.conditionsFromItem(ModItems.FLINT_BLADE));

		private static final ShapelessRecipeJsonBuilder FLINT_SHOVEL = ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_SHOVEL)
				.input(ModItems.FLINT_SHOVEL_HEAD)
				.input(ModItems.TOOL_HANDLE)
				.criterion(FabricRecipeProvider.hasItem(ModItems.FLINT_SHOVEL_HEAD), FabricRecipeProvider.conditionsFromItem(ModItems.FLINT_SHOVEL_HEAD));

		private static final ShapelessRecipeJsonBuilder KINDLING = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KINDLING)
				.input(Items.STICK, 9)
				.criterion(FabricRecipeProvider.hasItem(Items.STICK), FabricRecipeProvider.conditionsFromItem(Items.STICK));
	}
}
