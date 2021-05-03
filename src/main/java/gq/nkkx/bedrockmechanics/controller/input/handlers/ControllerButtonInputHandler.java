package gq.nkkx.bedrockmechanics.controller.input.handlers;

import gq.nkkx.bedrockmechanics.controller.input.ControllerButtonState;
import gq.nkkx.bedrockmechanics.controller.input.ControllerInputManager;
import net.minecraft.client.MinecraftClient;

public class ControllerButtonInputHandler extends EnvironmentMatcher {

    public void handleInput(int button, ControllerButtonState buttonState) {
        ControllerInputManager.getBindings()
            .stream()
            .filter(binding -> !binding.isAxis() && binding.getButton() == button)
            .findFirst()
            .ifPresent(binding -> {
                if (matches(MinecraftClient.getInstance(), binding.getEnvironment())) {
                    System.out.println("hello!");
                    binding.asKeyBinding().ifPresent(keyBinding -> keyBinding.setPressed(buttonState.isPressed()));
                }
            });
    }

}
