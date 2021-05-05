package gq.nkkx.bedrockmechanics.client.gui.paperdoll;

import gq.nkkx.bedrockmechanics.client.options.HudOptions;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

/**
 * A utility class for getting the state and options for the paper doll feature.
 */
public class PaperDoll {

    public static final PaperDollRenderer RENDERER = new PaperDollRenderer();

    private PaperDoll() {
    }

    public static boolean isEnabled() {
        HudOptions options = options().getHudOptions();
        return options.isEnabled() && options.isPaperDollEnabled();
    }

}
