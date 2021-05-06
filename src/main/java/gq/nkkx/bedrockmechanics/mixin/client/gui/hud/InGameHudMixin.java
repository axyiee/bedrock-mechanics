package gq.nkkx.bedrockmechanics.mixin.client.gui.hud;

import gq.nkkx.bedrockmechanics.client.animations.ItemPickupAnimation;
import gq.nkkx.bedrockmechanics.client.gui.GuiRenderer;
import gq.nkkx.bedrockmechanics.client.gui.ScreenSafeArea;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    private static final ItemPickupAnimation ITEM_PICKUP_ANIMATION = new ItemPickupAnimation();

    @Shadow
    protected abstract void renderHotbarItem(int a, int b, float c, PlayerEntity player, ItemStack item);

    @Inject(method = "renderHotbarItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getCooldown()I"))
    private void bedrock_mechanics$renderHotbarItem$getCooldown(int x, int y, float tickDelta, PlayerEntity player, ItemStack stack, CallbackInfo callbackInfo) {
        ITEM_PICKUP_ANIMATION.registerTimeLeft(stack, tickDelta);
    }

    @Redirect(method = "renderHotbarItem", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;scalef(FFF)V"))
    private void bedrock_mechanics$renderHotbarItem$scalef(float x, float y, float z) {
        ITEM_PICKUP_ANIMATION.play(x, y, z);
    }

    @Inject(method = "render", at = @At(value = "RETURN"))
    private void bedrock_mechanics$render(MatrixStack matrices, float tickDelta, CallbackInfo callbackInfo) {
        GuiRenderer.render(matrices, tickDelta);
    }

    @Redirect(method = "renderHeldItemTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;drawWithShadow(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/text/Text;FFI)I"))
    private int bedrock_mechanics$renderHeldItemTooltip(TextRenderer textRenderer, MatrixStack matrices, Text text, float x, float y, int color) {
        return ScreenSafeArea.drawNegativeShadowedText(textRenderer, matrices, text, x, y, color);
    }

    @Redirect(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderHotbarTextures(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        ScreenSafeArea.drawNegativeTexture(inGameHud, matrices, x, y, u, v, width, width == 24 ? height + 2 : height);
    }

    @Redirect(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHotbarItem(IIFLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;)V"))
    private void bedrock_mechanics$renderHotbarItem(InGameHud inGameHud, int i, int j, float f, PlayerEntity playerEntity, ItemStack itemStack) {
        renderHotbarItem(i, j - options().getHudOptions().getScreenSafeArea(), f, playerEntity, itemStack);
    }

    @Redirect(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderExpBarTexture(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        ScreenSafeArea.drawNegativeTexture(inGameHud, matrices, x, y, u, v, width, height);
    }

    @Redirect(method = "renderExperienceBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;draw(Lnet/minecraft/client/util/math/MatrixStack;Ljava/lang/String;FFI)I"))
    private int bedrock_mechanics$renderExperienceBar(TextRenderer textRenderer, MatrixStack matrices, String text, float x, float y, int color) {
        return ScreenSafeArea.drawNegativeText(textRenderer, matrices, text, x, y, color);
    }

    @Redirect(method = "renderMountJumpBar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderMountJumpBar(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        ScreenSafeArea.drawNegativeTexture(inGameHud, matrices, x, y, u, v, width, height);
    }

    @Redirect(method = "renderMountHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderMountHealth(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        ScreenSafeArea.drawNegativeTexture(inGameHud, matrices, x, y, u, v, width, height);
    }

    @Redirect(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"))
    private void bedrock_mechanics$renderStatusBars(InGameHud inGameHud, MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        ScreenSafeArea.drawNegativeTexture(inGameHud, matrices, x, y, u, v, width, height);
    }

    // Titles and subtitles taken from BedrockIfy.
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;draw(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/text/Text;FFI)I", ordinal = 0))
    public int bedrock_mechanics$render$draw(TextRenderer textRenderer, MatrixStack matrices, Text text, float x, float y, int color) {
        return textRenderer.draw(matrices, text, x, y - options().getHudOptions().getScreenSafeArea(), color);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;drawWithShadow(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/text/Text;FFI)I", ordinal = 0))
    public int bedrock_mechanics$render$drawWithShadow(TextRenderer textRenderer, MatrixStack matrices, Text text, float x, float y, int color) {
        return textRenderer.drawWithShadow(matrices, text, x, y - (options().getHudOptions().getScreenSafeArea() / 4.0f), color);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;drawWithShadow(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/text/Text;FFI)I", ordinal = 1))
    public int bedrock_mechanics$render$drawWithShadow$ordinal_1(TextRenderer textRenderer, MatrixStack matrices, Text text, float x, float y, int color) {
        return textRenderer.drawWithShadow(matrices, text, x, y - (options().getHudOptions().getScreenSafeArea() / 2.0f), color);
    }

}
