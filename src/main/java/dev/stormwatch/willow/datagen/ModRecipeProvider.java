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
		ModRecipes.TOOL_HANDLE.offerTo(exporter);
		ModRecipes.FLINT_AXE_HEAD.offerTo(exporter);
		ModRecipes.FLINT_AXE.offerTo(exporter);
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
				.pattern("ff ")
				.pattern("f  ")
				.criterion(FabricRecipeProvider.hasItem(Items.FLINT), FabricRecipeProvider.conditionsFromItem(Items.FLINT));

		private static final ShapelessRecipeJsonBuilder FLINT_AXE = ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_AXE)
				.input(ModItems.FLINT_AXE_HEAD)
				.input(ModItems.TOOL_HANDLE)
				.criterion(FabricRecipeProvider.hasItem(ModItems.FLINT_AXE_HEAD), FabricRecipeProvider.conditionsFromItem(ModItems.FLINT_AXE_HEAD));
	}
}
