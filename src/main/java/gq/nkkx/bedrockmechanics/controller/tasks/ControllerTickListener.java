package gq.nkkx.bedrockmechanics.controller.tasks;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.controller.Controller;
import gq.nkkx.bedrockmechanics.controller.input.ControllerButtonState;
import gq.nkkx.bedrockmechanics.controller.input.ControllerInputManager;
import gq.nkkx.bedrockmechanics.controller.input.handlers.ControllerButtonInputHandler;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFWGamepadState;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Optional;

public class ControllerTickListener {

    private static final ControllerButtonInputHandler BUTTON_INPUT_HANDLER = new ControllerButtonInputHandler();

    public ControllerTickListener() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
    }

    private void onTick(MinecraftClient minecraftClient) {
        Optional<Controller> selected = BedrockMechanics.options().getSelectedController();
        if (selected.isPresent()) {
            Controller controller = selected.get();
            if (controller.isConnected()) {
                GLFWGamepadState state = controller.getGamepadState();
                fetchGamepadButtonsInput(state);
                //fetchGamepadAxesInput(state);
            }
        }
    }

    private void fetchGamepadButtonsInput(GLFWGamepadState state) {
        ByteBuffer buffer = state.buttons();
        for (int button = 0; button < buffer.limit(); button++) {
            ControllerButtonState previousState = ControllerInputManager.getState(button);
            boolean isPressed = buffer.get() == (byte) 1;
            if (isPressed != previousState.isPressed()) {
                ControllerButtonState buttonState = isPressed ? ControllerButtonState.PRESS : ControllerButtonState.RELEASE;
                ControllerInputManager.setState(button, buttonState);
                BUTTON_INPUT_HANDLER.handleInput(button, buttonState);
            }
        }
    }

    // todo
    private void fetchGamepadAxesInput(GLFWGamepadState state) {
        FloatBuffer buffer = state.axes();
        for (int axis = 0; axis < buffer.limit(); axis++) {
            float value = buffer.get();
        }
    }

}
