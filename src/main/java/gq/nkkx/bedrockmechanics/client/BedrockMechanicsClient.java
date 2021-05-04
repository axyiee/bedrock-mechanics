package gq.nkkx.bedrockmechanics.client;

import gq.nkkx.bedrockmechanics.client.controller.input.handlers.ControllerInputHandler;
import gq.nkkx.bedrockmechanics.client.keybindings.KeyBindingHandler;
import gq.nkkx.bedrockmechanics.client.keybindings.LookKeyBindingView;
import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BedrockMechanicsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LookKeyBindingView.init();
        KeyBindingHandler.init();
        BedrockMechanicsOptions.init();
        ControllerInputHandler.init();
    }

}
