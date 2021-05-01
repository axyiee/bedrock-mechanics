package gq.nkkx.bedrockmechanics;

import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BedrockMechanics implements ModInitializer {

    public static final String MOD_ID = "bedrock-mechanics";
    private static final BedrockMechanicsOptions options = new BedrockMechanicsOptions();

    public static BedrockMechanicsOptions options() {
        return options;
    }

    public static Logger getLogger() {
        return LogManager.getLogger("gq.nkkx.bedrockmechanics.BedrockMechanics");
    }

    @Override
    public void onInitialize() {
        // no-op
    }

}
