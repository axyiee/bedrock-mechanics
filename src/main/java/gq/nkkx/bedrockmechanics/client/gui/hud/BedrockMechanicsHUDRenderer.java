package gq.nkkx.bedrockmechanics.client.gui.hud;

import gq.nkkx.bedrockmechanics.client.accessor.IMinecraftClient;
import gq.nkkx.bedrockmechanics.client.gui.IRenderer;
import gq.nkkx.bedrockmechanics.client.gui.paperdoll.PaperDoll;
import gq.nkkx.bedrockmechanics.options.GuiOptions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

public class BedrockMechanicsHUDRenderer implements IRenderer {

    private static final TranslatableText POSITION_TEXT = new TranslatableText("bedrock-mechanics.hud.position");
    private static final TranslatableText FPS_TEXT = new TranslatableText("bedrock-mechanics.hud.fps");

    @Override
    public void render(MatrixStack matrices) {
        if (!BedrockMechanicsHUD.isEnabled()) {
            return;
        }
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null) {
            GuiOptions options = options().getGuiOptions();

            int basePosY = options.getGuiPositionY() + options.getScreenSafeArea() + (PaperDoll.isEnabled() ? 50 : 0);
            int posX = options.getGuiPositionX() + options.getScreenSafeArea();

            boolean shouldShowPosition = BedrockMechanicsHUD.shouldShowPosition();
            if (shouldShowPosition) {
                BlockPos blockPos = client.player.getBlockPos();
                String position = String.format("%d, %d, %d", blockPos.getX(), blockPos.getY(), blockPos.getZ());
                Text text = POSITION_TEXT.append(position);
                client.textRenderer.drawWithShadow(matrices, text, posX, basePosY, options.getTextColor());
            }

            if (BedrockMechanicsHUD.shouldShowFPS()) {
                int fps = ((IMinecraftClient) client).getCurrentFPS();
                int posY = shouldShowPosition ? basePosY : basePosY + 10;
                Text text = FPS_TEXT.append(String.valueOf(fps));
                client.textRenderer.drawWithShadow(matrices, text, posX, posY, options.getTextColor());
            }
        }
    }

}
