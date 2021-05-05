package gq.nkkx.bedrockmechanics.mixin.client.gui.hud;

import gq.nkkx.bedrockmechanics.client.gui.GuiRenderer;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Shadow
    protected abstract void renderHotbarItem(int a, int b, float c, PlayerEntity player, ItemStack item);

    @Inject(method = "render", at = @At(value = "RETURN"))
    private void bedrock_mechanics$render(MatrixStack matrices, float tickDelta, CallbackInfo callbackInfo) {
        GuiRenderer.render(matrices, tickDelta);
    }

    @Redirect(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderHotbarTextures(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        inGameHud.drawTexture(matrices, x, y - options().getHudOptions().getScreenSafeArea(), u, v, width, width == 24 ? height + 2 : height);
    }

    @Redirect(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHotbarItem(IIFLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;)V"))
    private void bedrock_mechanics$renderHotbar(InGameHud inGameHud, int i, int j, float f, PlayerEntity playerEntity, ItemStack itemStack) {
        renderHotbarItem(i, j - options().getHudOptions().getScreenSafeArea(), f, playerEntity, itemStack);
    }

    @Redirect(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderExpBarTexture(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        inGameHud.drawTexture(matrices, x, y - options().getHudOptions().getScreenSafeArea(), u, v, width, height);
    }

    @Redirect(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;draw(Lnet/minecraft/client/util/math/MatrixStack;Ljava/lang/String;FFI)I"))
    private int bedrock_mechanics$renderExpBar(TextRenderer fontRenderer, MatrixStack matrices, String text, float x, float y, int color) {
        return fontRenderer.draw(matrices, text, x, y - options().getHudOptions().getScreenSafeArea(), color);
    }

    @Redirect(method = "renderMountJumpBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderMountJumpBar(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        inGameHud.drawTexture(matrices, x, y - options().getHudOptions().getScreenSafeArea(), u, v, width, height);
    }

    @Redirect(method = "renderMountHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderMountHealth(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        inGameHud.drawTexture(matrices, x, y - options().getHudOptions().getScreenSafeArea(), u, v, width, height);
    }

    @Redirect(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderStatusBars(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        inGameHud.drawTexture(matrices, x, y - options().getHudOptions().getScreenSafeArea(), u, v, width, height);
    }

}
