package gq.nkkx.bedrockmechanics.mixin.client.render.item;

import gq.nkkx.bedrockmechanics.client.animations.IAnimation;
import gq.nkkx.bedrockmechanics.client.animations.IdleHandAnimation;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    private static final IAnimation IDLE_HAND_ANIMATION = new IdleHandAnimation();

    @Inject(method = "applyEquipOffset", at = @At("HEAD"), cancellable = true)
    public void bedrock_mechanics$applyEquipOffset(MatrixStack matrices, Arm arm, float equipProgress, CallbackInfo callbackInfo) {
        IDLE_HAND_ANIMATION.playStack(matrices, arm, equipProgress, callbackInfo);
    }

}
