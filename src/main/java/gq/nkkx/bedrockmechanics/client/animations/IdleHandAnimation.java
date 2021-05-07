package gq.nkkx.bedrockmechanics.client.animations;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

public class IdleHandAnimation implements IAnimation {

    private float breath;

    @Override
    public void playStack(MatrixStack matrices, Arm arm, float equipProgress, CallbackInfo callbackInfo) {
        if (!options().getVisualsOptions().isEnableIdleHandAnimation()) {
            return;
        }
        int side = arm == Arm.RIGHT ? 1 : -1;
        double breath = Math.sin(this.breath) * 0.01D;
        matrices.translate(side * 0.5f, (-0.5f + equipProgress * -0.5f) + breath, -0.7D);
        this.breath += (MinecraftClient.getInstance().getTickDelta() * 0.02D) + 0.000001D;
        callbackInfo.cancel();
    }

}
