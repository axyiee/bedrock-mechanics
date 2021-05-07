package gq.nkkx.bedrockmechanics.client;

import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.client.controller.input.handlers.ControllerInputHandler;
import gq.nkkx.bedrockmechanics.client.gui.hud.BedrockMechanicsHUDRenderer;
import gq.nkkx.bedrockmechanics.client.keybindings.KeyBindingHandler;
import gq.nkkx.bedrockmechanics.client.keybindings.LookKeyBindingView;
import gq.nkkx.bedrockmechanics.client.options.BedrockMechanicsOptions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public class BedrockMechanicsClient implements ClientModInitializer {

    public static void render(MinecraftClient client) {
        LookKeyBindingView.render(client);
    }

    public static void render$afterGameRenderer(MinecraftClient client) {
        BedrockMechanicsHUDRenderer.CONTROLLER_HUD_RENDERER.renderInInventory();
        Controller.VIRTUAL_MOUSE.onRender();
    }

    @Override
    public void onInitializeClient() {
        BedrockMechanicsOptions.init();
        ControllerInputHandler.init();
        LookKeyBindingView.init();
        KeyBindingHandler.init();
    }

}
