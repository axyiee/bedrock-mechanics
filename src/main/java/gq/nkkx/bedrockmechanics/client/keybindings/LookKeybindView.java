package gq.nkkx.bedrockmechanics.client.keybindings;

import net.minecraft.client.options.KeyBinding;
import org.lwjgl.glfw.GLFW;

import static net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper.registerKeyBinding;

/**
 * A utility class that adds key bindings to look in 4 directions in order to provide a easier way to make
 * the controller support easier.
 */
public class LookKeybindView implements IKeyBindingView {

    public static KeyBinding LOOK_UP = new KeyBinding(
        "bedrock-mechanics.bindings.look_up",
        GLFW.GLFW_KEY_UP,
        "bedrock-mechanics.category.gameplay"
    );

    public static KeyBinding LOOK_DOWN = new KeyBinding(
        "bedrock-mechanics.bindings.look_down",
        GLFW.GLFW_KEY_DOWN,
        "bedrock-mechanics.category.gameplay"
    );

    public static KeyBinding LOOK_LEFT = new KeyBinding(
        "bedrock-mechanics.bindings.look_left",
        GLFW.GLFW_KEY_LEFT,
        "bedrock-mechanics.category.gameplay"
    );

    public static KeyBinding LOOK_RIGHT = new KeyBinding(
        "bedrock-mechanics.bindings.look_right",
        GLFW.GLFW_KEY_RIGHT,
        "bedrock-mechanics.category.gameplay"
    );

    public static void init() {
        registerKeyBinding(LOOK_UP);
        registerKeyBinding(LOOK_DOWN);
        registerKeyBinding(LOOK_LEFT);
        registerKeyBinding(LOOK_RIGHT);
    }

}
