package gq.nkkx.bedrockmechanics.mixin.client.gui.hud;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.SubtitlesHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;
import static gq.nkkx.bedrockmechanics.client.gui.ScreenSafeArea.negativeFill;

@Mixin(SubtitlesHud.class)
public class SubtitlesHudMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;draw(Lnet/minecraft/client/util/math/MatrixStack;Ljava/lang/String;FFI)I"))
    private int bedrock_mechanics$render$draw(TextRenderer textRenderer, MatrixStack matrices, String text, float x, float y, int color) {
        int area = options().getHudOptions().getScreenSafeArea();
        return textRenderer.draw(matrices, text, x - area, y - area, color);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;draw(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/text/Text;FFI)I"))
    private int bedrock_mechanics$render$draw(TextRenderer textRenderer, MatrixStack matrices, Text text, float x, float y, int color) {
        int area = options().getHudOptions().getScreenSafeArea();
        return textRenderer.draw(matrices, text, x - area, y - area, color);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/SubtitlesHud;fill(Lnet/minecraft/client/util/math/MatrixStack;IIIII)V"))
    private void bedrock_mechanics$render$fill(MatrixStack matrices, int x1, int y1, int x2, int y2, int color) {
        negativeFill(matrices, x1, y1, x2, y2, color);
    }

}
