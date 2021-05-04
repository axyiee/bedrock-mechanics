package gq.nkkx.bedrockmechanics.client.keybindings;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.HashSet;
import java.util.Set;

public class KeyBindingHandler {

    private static final Set<KeyBindingWrapper> KEY_BINDINGS = new HashSet<>();

    public static void listenTo(KeyBindingWrapper keyBinding) {
        KEY_BINDINGS.add(keyBinding);
    }

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            LookKeybindView.clear();
            KEY_BINDINGS.forEach((keyBindingWrapper) -> {
                if (keyBindingWrapper.getKeyBinding().isPressed()) {
                    keyBindingWrapper.execute(client);
                }
            });
        });
    }

}
