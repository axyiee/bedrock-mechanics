package gq.nkkx.bedrockmechanics.client.keybindings;

import net.minecraft.client.options.KeyBinding;

public class KeyBindingHelper {

    public static KeyBindingWrapper create(String name, String category, int key) {
        KeyBindingWrapper keyBinding = new KeyBindingWrapper(new KeyBinding(
            "bedrock-mechanics.bindings." + name,
            key,
            "bedrock-mechanics.category." + category
        ));
        KeyBindingHandler.listenTo(keyBinding);
        return keyBinding;
    }

}
