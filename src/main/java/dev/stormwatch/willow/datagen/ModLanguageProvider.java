package dev.stormwatch.willow.datagen;

import dev.stormwatch.willow.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider
{
    public ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder)
    {
        addItemTranslations(translationBuilder);
    }

    public void addItemTranslations(TranslationBuilder builder)
    {
        // Tools
        builder.add(ModItems.TOOL_HANDLE, "Tool Handle");
        builder.add(ModItems.FLINT_AXE_HEAD, "Flint Axe Head");
        builder.add(ModItems.FLINT_PICKAXE_HEAD, "Flint Pickaxe Head");
        builder.add(ModItems.FLINT_SHOVEL_HEAD, "Flint Shovel Head");
        builder.add(ModItems.FLINT_HOE_HEAD, "Flint Hoe Head");
        builder.add(ModItems.FLINT_BLADE, "Flint Blade");

        // Fuel
        builder.add(ModItems.KINDLING, "Kindling");
    }
}
