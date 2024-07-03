package dev.stormwatch.willow.datagen;

import dev.stormwatch.willow.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.TOOL_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLINT_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLINT_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLINT_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLINT_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLINT_BLADE, Models.GENERATED);
    }
}
