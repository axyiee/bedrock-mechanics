package gq.nkkx.bedrockmechanics.controller.input.handlers;

import gq.nkkx.bedrockmechanics.controller.input.ControllerButtonBinding;
import gq.nkkx.bedrockmechanics.controller.input.ControllerButtonState;
import gq.nkkx.bedrockmechanics.controller.input.ControllerInputManager;
import net.minecraft.client.options.KeyBinding;

import java.util.Optional;

public class ControllerButtonInputHandler implements IControllerInputHandler {

    public void handleInput(int button, ControllerButtonState buttonState) {
        for (ControllerButtonBinding binding : ControllerInputManager.getBindings()) {
            if (binding.getButton() == button) {
                Optional<KeyBinding> keyBinding = binding.asKeyBinding();
                keyBinding.ifPresent(value -> value.setPressed(buttonState.isPressed()));
                break;
            }
        }
    }

}
