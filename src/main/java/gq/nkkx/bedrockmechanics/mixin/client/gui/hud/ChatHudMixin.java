package gq.nkkx.bedrockmechanics.mixin.client.gui.hud;

import gq.nkkx.bedrockmechanics.client.accessor.IChatHud;
import gq.nkkx.bedrockmechanics.client.gui.IRenderer;
import gq.nkkx.bedrockmechanics.client.gui.hud.BedrockStyleChatRenderer;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.text.OrderedText;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(ChatHud.class)
public abstract class ChatHudMixin implements IChatHud {

    private final IRenderer bedrockStyleChatRenderer = new BedrockStyleChatRenderer((ChatHud) (Object) this);
    @Shadow
    @Final
    private List<ChatHudLine<OrderedText>> visibleMessages;

    @Override
    public int getMessageCount() {
        return visibleMessages.size();
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;translatef(FFF)V", ordinal = 0))
    private void bedrock_mechanics$render(float unusedX, float unusedY, float unusedZ) {
        bedrockStyleChatRenderer.render(null);
    }

}
