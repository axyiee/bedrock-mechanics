package gq.nkkx.bedrockmechanics.client.screens;

import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface ScreenInitializer {

    void init(Screen screen, CallbackInfo callbackInfo);

}
