package gq.nkkx.bedrockmechanics.client.mechanics.animations;

import gq.nkkx.bedrockmechanics.client.mechanics.IMechanic;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface IAnimation extends IMechanic {

    default void play(LivingEntity entity, float tickDelta, PlayerEntityModel model) {
    }

    default void playStack(MatrixStack matrices, Arm arm, float equipProgress, CallbackInfo callbackInfo) {
    }

}
