package dev.stormwatch.willow.events;

import dev.stormwatch.willow.registry.ModTags;
import dev.stormwatch.willow.state.ModStateManager;
import dev.stormwatch.willow.state.player.PlayerProfessionState;
import dev.stormwatch.willow.util.Profession;
import dev.stormwatch.willow.util.ProfessionXPValues;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ProfessionEvents
{
    public static void registerEventHandlers()
    {
        PlayerBlockBreakEvents.AFTER.register(ProfessionEvents::blockBreakXPEventHandler);
    }

    public static void blockBreakXPEventHandler(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity entity)
    {
        if (world.isClient()) return;
        // TODO: check if ores were silk touched
        if (state.isIn(ModTags.BlockTags.GIVES_WOODCUTTING_XP))
        {
            TagKey<Block> tier = ProfessionXPValues.getProfessionTierForState(state, Profession.WOODCUTTING);
            int xp = ProfessionXPValues.getXPValueForTier(tier, Profession.WOODCUTTING);
            ModStateManager stateManager = ModStateManager.getState(world.getServer());
            PlayerProfessionState professionState = stateManager.getOrCreatePlayerState((ServerPlayerEntity) player).getProfessionState();
            professionState.increaseProfessionXP(Profession.WOODCUTTING, xp);
        }
    }

}
