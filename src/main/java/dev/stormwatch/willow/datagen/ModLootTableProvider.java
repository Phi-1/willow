package dev.stormwatch.willow.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider
{
	public static class Block extends FabricBlockLootTableProvider
	{

		public Block(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
		{
			super(dataOutput, registryLookup);
		}

		@Override
		public void generate()
		{
			addStickDropToAllLeaves();
		}

		private void addStickDropToAllLeaves()
		{
			addStickDropToLeafType(Blocks.ACACIA_LEAVES);
			addStickDropToLeafType(Blocks.DARK_OAK_LEAVES);
			addStickDropToLeafType(Blocks.OAK_LEAVES);
			addStickDropToLeafType(Blocks.BIRCH_LEAVES);
			addStickDropToLeafType(Blocks.JUNGLE_LEAVES);
			addStickDropToLeafType(Blocks.SPRUCE_LEAVES);
			addStickDropToLeafType(Blocks.CHERRY_LEAVES);
			addStickDropToLeafType(Blocks.MANGROVE_LEAVES);
			addStickDropToLeafType(Blocks.AZALEA_LEAVES);
			addStickDropToLeafType(Blocks.FLOWERING_AZALEA_LEAVES);
		}

		private void addStickDropToLeafType(net.minecraft.block.Block leaf)
		{
			// TODO: chances and amounts
			addDrop(leaf, );
		}
	}
}
