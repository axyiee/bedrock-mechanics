package gq.nkkx.bedrockmechanics.mixin.client.gui.screen.ingame;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.client.accessor.IHandledScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin extends DrawableHelper implements IHandledScreen {

    private static final int OUTLINE = -1;

    // color taken from bedrockify, since hexadecimal colors does not work here.
    // https://github.com/juancarloscp52/BedrockIfy/blob/7cbdf41cf5eb24967d0c64110b3a6a7f2101148a/src/main/java/me/juancarloscp52/bedrockify/BedrockifySettings.java#L22
    private static final int COLOR = 64 + (170 << 8) + (109 << 16) + (255 << 24);

    @Shadow
    protected Slot focusedSlot;

    @Shadow
    protected abstract void drawSlot(MatrixStack matrices, Slot slot);

    @Shadow
    protected abstract Slot getSlotAt(double xPosition, double yPosition);

    @Invoker("onMouseClick")
    public abstract void bedrock_mechanics$onMouseClick(Slot slot, int invSlot, int clickData, SlotActionType actionType);

    @Invoker("onClose")
    public abstract void bedrock_mechanics$onClose();

    @Override
    public Slot bedrock_mechanics$getCurrentSlot() {
        MinecraftClient client = MinecraftClient.getInstance();
        double x = client.mouse.getX() * client.getWindow().getScaledWidth() / client.getWindow().getWidth();
        double y = client.mouse.getY() * client.getWindow().getScaledHeight() / client.getWindow().getHeight();
        return getSlotAt(x, y);
    }

    @Redirect(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screen/ingame/HandledScreen;fillGradient(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"
        )
    )
    private void bedrock_mechanics$render$fillGradient(
        HandledScreen handledScreen, MatrixStack matrices, int xStart, int yStart, int xEnd, int yEnd, int colorStart, int colorEnd
    ) {
        if (BedrockMechanics.options().getVisualsOptions().isEnableInventorySlotHighlighting()) {
            this.fillGradient(matrices, xStart - 1, yStart - 1, xEnd + 1, yEnd + 1, OUTLINE, OUTLINE);
            this.fillGradient(matrices, xStart, yStart, xEnd, yEnd, COLOR, COLOR);
            drawSlot(matrices, focusedSlot);
            return;
        }
        fillGradient(matrices, xStart, yStart, xEnd, yEnd, colorStart, colorEnd);
    }


}
