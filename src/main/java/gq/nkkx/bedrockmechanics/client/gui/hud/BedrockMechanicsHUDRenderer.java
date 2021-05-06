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
            if (shouldShowPosition) {
                int posY = options.getPositionY() + (PaperDoll.isEnabled() ? 50 : 0);
                Vec3d pos = client.player.getPos();
                String position = String.format("%.0f, %.0f, %.0f", pos.getX(), pos.getY(), pos.getZ());
                Text text = new TranslatableText("bedrock-mechanics.hud.position").append(position);
                drawShadowedText(matrices, text, options.getPositionX(), posY, options.getTextColor());
            }

            if (BedrockMechanicsHUD.shouldShowFPS()) {
                int fps = ((IMinecraftClient) client).getCurrentFPS();
                int basePosY = options.getPositionY() + (PaperDoll.isEnabled() ? 50 : 0);
                int posY = shouldShowPosition ? basePosY + 10 : basePosY;
                Text text = new TranslatableText("bedrock-mechanics.hud.fps").append(String.valueOf(fps));
                drawShadowedText(matrices, text, options.getPositionX(), posY, options.getTextColor());
            }
            matrices.pop();
        }
    }

}
