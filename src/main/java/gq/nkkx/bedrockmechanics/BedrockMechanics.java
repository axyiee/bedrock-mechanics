package gq.nkkx.bedrockmechanics;

import gq.nkkx.bedrockmechanics.client.keybindings.LookKeyBindingView;
import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BedrockMechanics implements ModInitializer {

    public static final String MOD_ID = "bedrock-mechanics";
    private static final BedrockMechanicsOptions options = new BedrockMechanicsOptions();

    public static BedrockMechanicsOptions options() {
        return options;
    }

    public static Identifier locate(String value) {
        return new Identifier(MOD_ID, value);
    }

    public static Logger getLogger() {
        return LogManager.getLogger("gq.nkkx.bedrockmechanics.BedrockMechanics");
    }

    public static void render(MinecraftClient client) {
        LookKeyBindingView.render(client);
    }

    @Override
    public void onInitialize() {
        // no-op
    }

}
