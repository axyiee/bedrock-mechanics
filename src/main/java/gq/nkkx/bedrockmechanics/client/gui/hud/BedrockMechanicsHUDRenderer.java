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

public class BedrockMechanicsHUDRenderer implements IRenderer {

    @Override
    public void render(MatrixStack matrices) {
        if (!BedrockMechanicsHUD.isEnabled()) {
            return;
        }
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null) {
            HudOptions options = options().getHudOptions();

            int basePosY = options.getPositionY() + options.getScreenSafeArea() + (PaperDoll.isEnabled() ? 50 : 0);
            int posX = options.getPositionX() + options.getScreenSafeArea();

            boolean shouldShowPosition = BedrockMechanicsHUD.shouldShowPosition();
            matrices.push();
            if (shouldShowPosition) {
                Vec3d pos = client.player.getPos();
                String position = String.format("%.0f, %.0f, %.0f", pos.getX(), pos.getY(), pos.getZ());
                Text text = new TranslatableText("bedrock-mechanics.hud.position").append(position);
                client.textRenderer.drawWithShadow(matrices, text, posX, basePosY, 0xffffff);
            }

            if (BedrockMechanicsHUD.shouldShowFPS()) {
                int fps = ((IMinecraftClient) client).getCurrentFPS();
                int posY = shouldShowPosition ? basePosY + 10 : basePosY;
                Text text = new TranslatableText("bedrock-mechanics.hud.fps").append(String.valueOf(fps));
                client.textRenderer.drawWithShadow(matrices, text, posX, posY, 0xffffff);
            }
            matrices.pop();
        }
    }

}
