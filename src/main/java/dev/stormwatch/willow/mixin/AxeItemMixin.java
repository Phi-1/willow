package dev.stormwatch.willow.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxeItem.class)
public class AxeItemMixin
{
    @Inject(at = @At("HEAD"), cancellable = true, method = "useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;")
    private void useOnBlockRequiresProfessionLevel(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir)
    {
        // TODO: cancelling needs to happen on client as well, so xp data should be synced
        World world = context.getWorld();
        if (!world.isClient())
        {
            BlockPos pos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            MinecraftServer server = world.getServer();
            System.out.println("no");
            cir.setReturnValue(ActionResult.FAIL);
        }
    }
}
