package gq.nkkx.bedrockmechanics.client.gui.hud;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

/**
 * A utility class for getting the state and options for the paper doll feature.
 */
public class BedrockMechanicsHUD {

    public static BedrockMechanicsHUDRenderer RENDERER = new BedrockMechanicsHUDRenderer();

    private BedrockMechanicsHUD() {
    }

    public static boolean isEnabled() {
        return options().getHudOptions().isEnabled();
    }

    public static boolean shouldShowFPS() {
        return isEnabled() && options().getHudOptions().isShowFPS();
    }

    public static boolean shouldShowPosition() {
        return isEnabled() && options().getHudOptions().isShowPosition();
    }

}
