package gq.nkkx.bedrockmechanics.mixin.client.render;

import gq.nkkx.bedrockmechanics.client.mechanics.sneaking.SneakingActivatesShield;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {

    private static final SneakingActivatesShield SNEAKING_ACTIVATES_SHIELD = new SneakingActivatesShield();

    @Shadow
    private Entity focusedEntity;

    @Inject(method = "updateEyeHeight", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/Camera;cameraY:F", ordinal = 0))
    private void bedrock_mechanics$updateEyeHeight(CallbackInfo callbackInfo) {
        if (focusedEntity instanceof PlayerEntity) {
            SNEAKING_ACTIVATES_SHIELD.execute((PlayerEntity) focusedEntity);
        }
    }

}
