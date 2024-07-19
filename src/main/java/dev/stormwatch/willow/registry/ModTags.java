package dev.stormwatch.willow.registry;

import dev.stormwatch.willow.Willow;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags
{
    public static class BlockTags
    {
        public static final TagKey<Block> GIVES_WOODCUTTING_XP = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Willow.MOD_ID, "profession/woodcutting/gives_woodcutting_xp"));
        public static final TagKey<Block> WOODCUTTING_TIER_0 = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Willow.MOD_ID, "profession/woodcutting/woodcutting_tier_0"));
        public static final TagKey<Block> WOODCUTTING_TIER_1 = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Willow.MOD_ID, "profession/woodcutting/woodcutting_tier_1"));
        public static final TagKey<Block> WOODCUTTING_TIER_2 = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Willow.MOD_ID, "profession/woodcutting/woodcutting_tier_2"));
        public static final TagKey<Block> WOODCUTTING_TIER_3 = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Willow.MOD_ID, "profession/woodcutting/woodcutting_tier_3"));
        public static final TagKey<Block> WOODCUTTING_TIER_4 = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Willow.MOD_ID, "profession/woodcutting/woodcutting_tier_4"));
    }
}
