package gq.nkkx.bedrockmechanics.client.gui.hud;

import gq.nkkx.bedrockmechanics.client.accessor.IMinecraftClient;
import gq.nkkx.bedrockmechanics.client.gui.IRenderer;
import gq.nkkx.bedrockmechanics.client.gui.paperdoll.PaperDoll;
import gq.nkkx.bedrockmechanics.client.options.HudOptions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Vec3d;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;
import static gq.nkkx.bedrockmechanics.client.gui.ScreenSafeArea.drawShadowedText;
import static gq.nkkx.bedrockmechanics.client.gui.ScreenSafeArea.fill;

public class BedrockMechanicsHUDRenderer implements IRenderer {

    @Override
    public void render(MatrixStack matrices) {
        if (!BedrockMechanicsHUD.isEnabled()) {
            return;
        }
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null) {
            HudOptions options = options().getHudOptions();
            boolean shouldShowPosition = BedrockMechanicsHUD.shouldShowPosition();
            matrices.push();

            int basePosY = options.getPositionY() + (PaperDoll.isEnabled() ? 50 : 0);

            if (shouldShowPosition) {
                int posX = options.getPositionX();
                Vec3d pos = client.player.getPos();
                String position = String.format("%.0f, %.0f, %.0f", pos.getX(), pos.getY(), pos.getZ());
                Text text = new TranslatableText("bedrock-mechanics.hud.position").append(position);
                int positionWidth = client.textRenderer.getWidth(text);
                fill(matrices, posX - 5, basePosY - 1, posX + positionWidth + 5, basePosY + 9, client.options.getTextBackgroundColor(0.5F));
                drawShadowedText(matrices, text, posX, basePosY, options.getTextColor());
            }

            if (BedrockMechanicsHUD.shouldShowFPS()) {
                int fps = ((IMinecraftClient) client).getCurrentFPS();
                int posY = shouldShowPosition ? basePosY + 10 : basePosY;
                int posX = options.getPositionX();
                Text text = new TranslatableText("bedrock-mechanics.hud.fps").append(String.valueOf(fps));
                int fpsWidth = client.textRenderer.getWidth(text);
                fill(matrices, posX - 5, posY - 1, posX + fpsWidth + 5, posY + 9, client.options.getTextBackgroundColor(0.5F));
                drawShadowedText(matrices, text, posX, posY, options.getTextColor());
            }
            matrices.pop();
        }
    }

}
