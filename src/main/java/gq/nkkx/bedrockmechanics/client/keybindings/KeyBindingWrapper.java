package gq.nkkx.bedrockmechanics.client.keybindings;

import lombok.Builder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;

import java.util.function.Consumer;

public class KeyBindingWrapper {

    private final String name;
    private final String category;
    private final int key;
    private final Consumer<MinecraftClient> execute;
    private KeyBinding value;

    @Builder
    public KeyBindingWrapper(String name, String category, int key, Consumer<MinecraftClient> execute) {
        this.name = name;
        this.category = category;
        this.key = key;
        this.execute = execute;
    }

    public KeyBinding getKeyBinding() {
        if (value == null) {
            value = new KeyBinding(
                "bedrock-mechanics.bindings." + name, key, "bedrock-mechanics.category." + category
            );
        }
        return value;
    }

    public void execute(MinecraftClient client) {
        if (execute != null) {
            execute.accept(client);
        }
    }

}
