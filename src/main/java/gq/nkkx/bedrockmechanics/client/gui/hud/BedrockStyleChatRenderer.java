package gq.nkkx.bedrockmechanics.client.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import gq.nkkx.bedrockmechanics.client.accessor.IChatHud;
import gq.nkkx.bedrockmechanics.client.gui.IRenderer;
import lombok.AllArgsConstructor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.util.math.MatrixStack;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

@AllArgsConstructor
public class BedrockStyleChatRenderer implements IRenderer {

    private static final int PADDING = 50;
    private final ChatHud hud;

    @Override
    public void render(MatrixStack matrices) {
        if (!options().getHudOptions().isBedrockChatStyle()) {
            return;
        }
        int screenSafeArea = options().getHudOptions().getScreenSafeArea();
        IChatHud accessedHud = (IChatHud) hud;

        int posY = PADDING + (BedrockMechanicsHUD.shouldShowPosition() ? 10 : 0)
            + (BedrockMechanicsHUD.shouldShowFPS() ? 10 : 0) + screenSafeArea;

        MinecraftClient client = MinecraftClient.getInstance();
        RenderSystem.translatef(
            screenSafeArea,
            (float) (60 - client.getWindow().getScaledHeight()
                + (accessedHud.getMessageCount()
                * (9D * hud.getChatScale()
                * (client.options.chatLineSpacing + 1D))))
                + posY,
            0f
        );
    }

}
