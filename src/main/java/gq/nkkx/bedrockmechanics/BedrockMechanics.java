package gq.nkkx.bedrockmechanics;

import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BedrockMechanics {

    private static BedrockMechanicsOptions OPTIONS;

    public static BedrockMechanicsOptions options() {
        if (OPTIONS == null) {
            OPTIONS = new BedrockMechanicsOptions();
        }
        return OPTIONS;
    }

    public static Logger getLogger() {
        return LogManager.getLogger("gq.nkkx.bedrockmechanics.BedrockMechanics");
    }

}
