package gq.nkkx.bedrockmechanics.client.controller.input.handlers;

import gq.nkkx.bedrockmechanics.client.controller.input.ControllerAxisState;
import gq.nkkx.bedrockmechanics.client.controller.input.ControllerButtonState;
import gq.nkkx.bedrockmechanics.client.controller.input.ControllerInputManager;
import net.minecraft.client.MinecraftClient;

public class ControllerAxisInputHandler extends EnvironmentMatcher {

    public void handleInput(int axis, ControllerButtonState buttonState, ControllerAxisState axisState) {
        ControllerInputManager.getBindings()
            .stream()
            .filter(binding -> binding.isAxis() && binding.getButton() == axis)
            .forEach(binding -> {
                if (matches(MinecraftClient.getInstance(), binding.getEnvironment())) {
                    if ((axisState == ControllerAxisState.POSITIVE && binding.isAxisPositive())
                        || (axisState == ControllerAxisState.NEGATIVE && !binding.isAxisPositive())) {
                        binding.execute(buttonState.isPressed());
                    }
                }
            });
    }

}
