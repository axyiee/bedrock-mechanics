package gq.nkkx.bedrockmechanics;

import gq.nkkx.bedrockmechanics.client.BedrockMechanicsClient;
import gq.nkkx.bedrockmechanics.client.options.BedrockMechanicsOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BedrockMechanics {

    public static BedrockMechanicsOptions options() {
        return BedrockMechanicsClient.options();
    }

    public static Logger getLogger() {
        return LogManager.getLogger("gq.nkkx.bedrockmechanics.BedrockMechanics");
    }

}
