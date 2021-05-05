package gq.nkkx.bedrockmechanics.mixin.client.gui.screen;

import gq.nkkx.bedrockmechanics.client.screens.BedrockTitleScreen;
import gq.nkkx.bedrockmechanics.client.screens.ScreenInitializer;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    private static final ScreenInitializer BEDROCK_TITLE_SCREEN = new BedrockTitleScreen();

    @Inject(
        method = "init",
        at = @At(value = "RETURN")
    )
    private void bedrock_mechanics$init(CallbackInfo callbackInfo) {
        BEDROCK_TITLE_SCREEN.init((TitleScreen) (Object) this, callbackInfo);
    }

}
