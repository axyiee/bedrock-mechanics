package gq.nkkx.bedrockmechanics.client;

import gq.nkkx.bedrockmechanics.client.controller.input.handlers.ControllerInputHandler;
import gq.nkkx.bedrockmechanics.client.keybindings.LookKeybindView;
import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BedrockMechanicsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LookKeybindView.init();
        BedrockMechanicsOptions.init();
        ControllerInputHandler.init();
    }

}
