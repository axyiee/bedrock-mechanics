package gq.nkkx.bedrockmechanics;

import gq.nkkx.bedrockmechanics.client.options.BedrockMechanicsOptions;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BedrockMechanics {

    public static BedrockMechanicsOptions options() {
        return AutoConfig.getConfigHolder(BedrockMechanicsOptions.class).getConfig();
    }

    public static Identifier locate(String name) {
        return new Identifier("bedrock-mechanics", name);
    }

    public static Logger getLogger() {
        return LogManager.getLogger("gq.nkkx.bedrockmechanics.BedrockMechanics");
    }

}
