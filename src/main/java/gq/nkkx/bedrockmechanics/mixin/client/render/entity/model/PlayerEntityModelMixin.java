package gq.nkkx.bedrockmechanics.mixin.client.render.entity.model;

import gq.nkkx.bedrockmechanics.client.mechanics.animations.EatingAnimation;
import gq.nkkx.bedrockmechanics.client.mechanics.animations.IAnimation;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public class PlayerEntityModelMixin<T extends LivingEntity> {

    private static final IAnimation eatingAnimation = new EatingAnimation();

    @Inject(method = "setAngles", at = @At("TAIL"))
    private void bedrock_mechanics$setAngles(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo callbackInfo) {
        PlayerEntityModel model = (PlayerEntityModel) (Object) this;
        eatingAnimation.play(livingEntity, h, model);
    }

}
