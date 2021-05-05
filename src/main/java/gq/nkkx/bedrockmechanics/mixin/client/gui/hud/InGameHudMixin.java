package gq.nkkx.bedrockmechanics.mixin.client.gui.hud;

import gq.nkkx.bedrockmechanics.client.gui.GuiRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At(value = "RETURN"))
    private void bedrock_mechanics$render(MatrixStack matrices, float tickDelta, CallbackInfo callbackInfo) {
        GuiRenderer.render(matrices, tickDelta);
    }

}
