package gq.nkkx.bedrockmechanics.client.gui.paperdoll;

import gq.nkkx.bedrockmechanics.options.GuiOptions;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

/**
 * A utility class for getting the state and options for the paper doll feature.
 */
public class PaperDoll {

    private static final PaperDollRenderer RENDERER = new PaperDollRenderer();

    public static boolean isEnabled() {
        GuiOptions options = options().getGuiOptions();
        return options.isEnabled() && options.isPaperDollEnabled();
    }

    public static PaperDollRenderer getRenderer() {
        return RENDERER;
    }

}
