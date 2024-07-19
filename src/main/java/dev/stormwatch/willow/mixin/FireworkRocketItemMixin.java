package dev.stormwatch.willow.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireworkRocketItem.class)
public class FireworkRocketItemMixin
{
    @Inject(at = @At("HEAD"), cancellable = true, method = "use(Lnet/minecraft/world/World;Lnet/minecraft/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;")
    private void disableRocketPoweredElytraFlight(World world, PlayerEntity player, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir)
    {
        if (player.isFallFlying())
        {
            cir.setReturnValue(TypedActionResult.pass(player.getStackInHand(hand)));
        }
    }
}
