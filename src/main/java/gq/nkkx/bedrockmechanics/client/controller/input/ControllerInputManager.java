package gq.nkkx.bedrockmechanics.client.controller.input;

import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ControllerInputManager {

    private static final List<ControllerButtonBinding> BINDINGS = new ArrayList<>();
    private static final Map<ControllerButtonBinding, KeyBinding> MINECRAFT_MAPPINGS = new HashMap<>();
    private static final Map<Integer, ControllerButtonState> STATES = new HashMap<>();

    public static boolean isBindingRegistered(ControllerButtonBinding binding) {
        return BINDINGS.contains(binding);
    }

    public static void registerBinding(ControllerButtonBinding binding) {
        BINDINGS.add(binding);
    }

    public static List<ControllerButtonBinding> getBindings() {
        return BINDINGS;
    }

    public static Optional<KeyBinding> getKeybinding(ControllerButtonBinding binding) {
        return Optional.ofNullable(MINECRAFT_MAPPINGS.get(binding));
    }

    public static void setState(int button, ControllerButtonState state) {
        STATES.put(button, state);
    }

    public static @NotNull ControllerButtonState getState(int button) {
        ControllerButtonState state = STATES.get(button);
        return state == null ? ControllerButtonState.NONE : state;
    }

    public static void init(GameOptions options) {
        MINECRAFT_MAPPINGS.put(ControllerButtonBinding.ATTACK, options.keyAttack);
        MINECRAFT_MAPPINGS.put(ControllerButtonBinding.JUMP, options.keyJump);
    }

}
