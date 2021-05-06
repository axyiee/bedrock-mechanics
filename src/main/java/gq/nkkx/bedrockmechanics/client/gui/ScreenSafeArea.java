package gq.nkkx.bedrockmechanics.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

public class ScreenSafeArea implements IRenderer.Empty {

    public static void fill(MatrixStack matrices, int x1, int y1, int x2, int y2, int color) {
        DrawableHelper.fill(
            matrices,
            x1 + options().getHudOptions().getScreenSafeArea(),
            y1 + options().getHudOptions().getScreenSafeArea(),
            x2 + options().getHudOptions().getScreenSafeArea(),
            y2 + options().getHudOptions().getScreenSafeArea(),
            color
        );
    }

    public static void negativeFill(MatrixStack matrices, int x1, int y1, int x2, int y2, int color) {
        DrawableHelper.fill(
            matrices,
            x1 - options().getHudOptions().getScreenSafeArea(),
            y1 - options().getHudOptions().getScreenSafeArea(),
            x2 - options().getHudOptions().getScreenSafeArea(),
            y2 - options().getHudOptions().getScreenSafeArea(),
            color
        );
    }

    public static void drawShadowedText(MatrixStack matrices, Text text, float x, float y, int color) {
        MinecraftClient.getInstance().textRenderer.drawWithShadow(
            matrices, text, x + options().getHudOptions().getScreenSafeArea(), y + options().getHudOptions().getScreenSafeArea(), color
        );
    }

    public static int drawNegativeText(TextRenderer textRenderer, MatrixStack matrices, String text, float x, float y, int color) {
        return textRenderer.draw(matrices, text, x, y - options().getHudOptions().getScreenSafeArea(), color);
    }

    public static int drawNegativeShadowedText(TextRenderer textRenderer, MatrixStack matrices, Text text, float x, float y, int color) {
        return textRenderer.drawWithShadow(matrices, text, x, y - options().getHudOptions().getScreenSafeArea(), color);
    }

    public static void drawNegativeTexture(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        inGameHud.drawTexture(matrices, x, y - options().getHudOptions().getScreenSafeArea(), u, v, width, height);
    }

}
