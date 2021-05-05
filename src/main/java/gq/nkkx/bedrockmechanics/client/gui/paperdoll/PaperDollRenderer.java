package gq.nkkx.bedrockmechanics.client.gui.paperdoll;

import gq.nkkx.bedrockmechanics.client.gui.IRenderer;
import gq.nkkx.bedrockmechanics.client.options.HudOptions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;
import static net.minecraft.entity.EntityPose.SWIMMING;

public class PaperDollRenderer implements IRenderer {

    private static final int PADDING_X = 20;
    private static final int PADDING_Y = 45;
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

            HudOptions options = options().getHudOptions();

            int basePosY = options.getPositionY() + PADDING_Y, paperDollScale = options.getPaperDollScale();
            int posX = options.getPositionX() + options.getScreenSafeArea() + PADDING_X;

            int posY = (player.isFallFlying()
                ? (int) (basePosY - Math.ceil(paperDollScale * 2 * ((90 + player.pitch) / 180)))
                : (player.isSwimming() ? basePosY - paperDollScale : basePosY)) + options.getScreenSafeArea();

            InventoryScreen.drawEntity(posX, posY, paperDollScale, (float) options.getPaperDollRotation(), 0, player);
        }
    }

}
