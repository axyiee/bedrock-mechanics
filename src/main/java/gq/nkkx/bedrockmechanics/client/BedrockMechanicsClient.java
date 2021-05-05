package gq.nkkx.bedrockmechanics.client;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.client.controller.input.handlers.ControllerInputHandler;
import gq.nkkx.bedrockmechanics.client.keybindings.KeyBindingHandler;
import gq.nkkx.bedrockmechanics.client.keybindings.LookKeyBindingView;
import gq.nkkx.bedrockmechanics.client.options.BedrockMechanicsOptions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

import java.io.IOException;

@Environment(EnvType.CLIENT)
public class BedrockMechanicsClient implements ClientModInitializer {

    private static BedrockMechanicsOptions OPTIONS;

    public static BedrockMechanicsOptions options() {
        return OPTIONS;
    }

    public static void render(MinecraftClient client) {
        LookKeyBindingView.render(client);
    }

    @Override
    public void onInitializeClient() {
        try {
            BedrockMechanicsOptions options = BedrockMechanicsOptions.init();
            System.out.println((OPTIONS = options).toString());
        } catch (IOException exception) {
            BedrockMechanics.getLogger().error("Could not initialize the configuration.");
            exception.printStackTrace();
        }
        ControllerInputHandler.init();
        LookKeyBindingView.init();
        KeyBindingHandler.init();
    }

}
