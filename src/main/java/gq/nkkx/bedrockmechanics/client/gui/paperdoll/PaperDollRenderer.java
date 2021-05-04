package gq.nkkx.bedrockmechanics.client.gui.paperdoll;

import gq.nkkx.bedrockmechanics.client.gui.IRenderer;
import gq.nkkx.bedrockmechanics.options.GuiOptions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;
import static net.minecraft.entity.EntityPose.SWIMMING;

public class PaperDollRenderer implements IRenderer {

    private long lastTimeShown;

    @Override
    public void render(MatrixStack matrices) {
        if (!PaperDoll.isEnabled()) {
            return;
        }
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null) {
            ClientPlayerEntity player = client.player;
            if (player.isSneaking() || player.isSprinting() || player.getPose() == SWIMMING || player.isUsingItem()) {
                lastTimeShown = System.currentTimeMillis();
            }
            if (player.isRiding() || player.isSleeping() || (System.currentTimeMillis() - lastTimeShown) > 2000) {
                return;
            }

            GuiOptions options = options().getGuiOptions();

            int basePosY = options.getGuiPositionY(), paperDollScale = options.getPaperDollScale();
            int posX = options.getGuiPositionX() + options.getScreenSafeArea();
            int posY = (player.isFallFlying()
                ? (int) (basePosY - Math.ceil(paperDollScale * 2 * ((90 + player.pitch) / 180)))
                : (player.isSwimming() ? basePosY - paperDollScale : basePosY)) + options.getScreenSafeArea();

            InventoryScreen.drawEntity(posX, posY, paperDollScale, (float) options.getPaperDollRotation(), 0, player);
        }
    }

}
