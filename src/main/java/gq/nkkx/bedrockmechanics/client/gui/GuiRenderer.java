package gq.nkkx.bedrockmechanics.client.gui;

import gq.nkkx.bedrockmechanics.client.gui.paperdoll.PaperDoll;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class GuiRenderer {

    private GuiRenderer() {
    }

    public static void render(MatrixStack matrices, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options.debugEnabled || client.options.hudHidden) {
            return;
        }
        PaperDoll.getRenderer().render(matrices);
    }

}
