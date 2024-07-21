package dev.stormwatch.willow.util;

import com.google.common.collect.ImmutableMap;
import dev.stormwatch.willow.registry.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.TagKey;

import java.util.Optional;

public class ProfessionXPValues
{

    // TODO: values
    private static final ImmutableMap<TagKey<Block>, Integer> WOODCUTTING_XP_VALUES = ImmutableMap.<TagKey<Block>, Integer>builder()
            .put(ModTags.BlockTags.WOODCUTTING_TIER_0, 1)
            .put(ModTags.BlockTags.WOODCUTTING_TIER_1, 1)
            .put(ModTags.BlockTags.WOODCUTTING_TIER_2, 1)
            .put(ModTags.BlockTags.WOODCUTTING_TIER_3, 1)
            .put(ModTags.BlockTags.WOODCUTTING_TIER_4, 1)
            .build();

    public static int getXPValueForTier(TagKey<Block> blockTier, Profession profession)
    {
        return switch (profession)
        {
            // TODO
            case WOODCUTTING -> WOODCUTTING_XP_VALUES.getOrDefault(blockTier, 0);
            case MINING -> 0;
            case EXCAVATING -> 0;
            case FARMING -> 0;
            case FIGHTING -> 0;
        };
    }

    public static TagKey<Block> getProfessionTierForState(BlockState state, Profession profession)
    {
        return switch (profession)
        {
            case WOODCUTTING -> getWoodCuttingTier(state).get();
            case MINING -> null;
            case EXCAVATING -> null;
            case FARMING -> null;
            case FIGHTING -> null;
        };
    }

    private static Optional<TagKey<Block>> getWoodCuttingTier(BlockState state)
    {
        if      (state.isIn(ModTags.BlockTags.WOODCUTTING_TIER_0)) return Optional.of(ModTags.BlockTags.WOODCUTTING_TIER_0);
        else if (state.isIn(ModTags.BlockTags.WOODCUTTING_TIER_1)) return Optional.of(ModTags.BlockTags.WOODCUTTING_TIER_1);
        else if (state.isIn(ModTags.BlockTags.WOODCUTTING_TIER_2)) return Optional.of(ModTags.BlockTags.WOODCUTTING_TIER_2);
        else if (state.isIn(ModTags.BlockTags.WOODCUTTING_TIER_3)) return Optional.of(ModTags.BlockTags.WOODCUTTING_TIER_3);
        else if (state.isIn(ModTags.BlockTags.WOODCUTTING_TIER_4)) return Optional.of(ModTags.BlockTags.WOODCUTTING_TIER_4);
        else return Optional.empty();
    }

}
