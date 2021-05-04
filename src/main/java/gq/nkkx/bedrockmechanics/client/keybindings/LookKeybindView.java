package gq.nkkx.bedrockmechanics.client.keybindings;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.lwjgl.glfw.GLFW;

/**
 * A utility class that adds key bindings to look in 4 directions in order to provide a easier way to make
 * the controller support easier.
 */
public class LookKeybindView implements IKeyBindingView {

    public static KeyBindingWrapper LOOK_UP = KeyBindingWrapper.builder()
        .name("look_up")
        .key(GLFW.GLFW_KEY_UP)
        .category("gameplay")
        .build();

    public static KeyBindingWrapper LOOK_DOWN = KeyBindingWrapper.builder()
        .name("look_down")
        .key(GLFW.GLFW_KEY_DOWN)
        .category("gameplay")
        .build();

    public static KeyBindingWrapper LOOK_LEFT = KeyBindingWrapper.builder()
        .name("look_left")
        .key(GLFW.GLFW_KEY_LEFT)
        .category("gameplay")
        .build();

    public static KeyBindingWrapper LOOK_RIGHT = KeyBindingWrapper.builder()
        .name("look_right")
        .key(GLFW.GLFW_KEY_RIGHT)
        .category("gameplay")
        .build();

    public static void init() {
        registerKeyBinding(LOOK_UP);
        registerKeyBinding(LOOK_DOWN);
        registerKeyBinding(LOOK_LEFT);
        registerKeyBinding(LOOK_RIGHT);
    }

    public static void registerKeyBinding(KeyBindingWrapper wrapper) {
        KeyBindingHelper.registerKeyBinding(wrapper.getKeyBinding());
        KeyBindingHandler.listenTo(wrapper);
    }

}
