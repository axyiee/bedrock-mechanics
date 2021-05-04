package gq.nkkx.bedrockmechanics.client.keybindings;

import lombok.Builder;
import net.minecraft.client.options.KeyBinding;

@Builder
public class KeyBindingWrapper {

    private final KeyBinding value;
    private Runnable execute;

    public KeyBindingWrapper(KeyBinding keyBinding) {
        this.value = keyBinding;
    }

    public KeyBinding getKeyBinding() {
        return value;
    }

    public void execute() {
        if (execute != null) {
            execute.run();
        }
    }

}
