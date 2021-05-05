package gq.nkkx.bedrockmechanics.client.controller.input.handlers;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.client.controller.input.ControllerAxisState;
import gq.nkkx.bedrockmechanics.client.controller.input.ControllerButtonState;
import gq.nkkx.bedrockmechanics.client.controller.input.ControllerInputManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFWGamepadState;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import static gq.nkkx.bedrockmechanics.client.controller.input.ControllerAxisState.toButton;

public class ControllerInputHandler {

    private static final ControllerButtonInputHandler BUTTON_INPUT_HANDLER = new ControllerButtonInputHandler();
    private static final ControllerAxisInputHandler AXIS_INPUT_HANDLER = new ControllerAxisInputHandler();
    private static final ControllerInputHandler INSTANCE = new ControllerInputHandler();

    private ControllerInputHandler() {
    }

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(INSTANCE::onTick);
    }

    private void onTick(MinecraftClient minecraftClient) {
        Controller controller = BedrockMechanics.options().getControllerOptions().getSelectedController();
        if (controller != null && BedrockMechanics.options().getControllerOptions().isEnabled() && controller.isConnected()) {
            GLFWGamepadState state = controller.getGamepadState();
            fetchGamepadButtonsInput(state);
            fetchGamepadAxesInput(state);
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

    private void fetchGamepadAxesInput(GLFWGamepadState state) {
        FloatBuffer buffer = state.axes();
        for (int axis = 0; axis < buffer.limit(); axis++) {
            float value = buffer.get();
            float deadZone = BedrockMechanics.options().getControllerOptions().getDeadZone();

            boolean isAxisPositive = value > deadZone;
            boolean isAxisNegative = value < -deadZone;

            ControllerButtonState previousPositiveState = ControllerInputManager.getState(toButton(axis, true));
            ControllerButtonState previousNegativeState = ControllerInputManager.getState(toButton(axis, false));

            if (isAxisPositive != previousPositiveState.isPressed()) {
                ControllerButtonState buttonState = isAxisPositive ? ControllerButtonState.PRESS : ControllerButtonState.RELEASE;
                ControllerInputManager.setState(toButton(axis, true), buttonState);
                AXIS_INPUT_HANDLER.handleInput(axis, buttonState, ControllerAxisState.POSITIVE);
                continue;
            }

            if (isAxisNegative != previousNegativeState.isPressed()) {
                ControllerButtonState buttonState = isAxisNegative ? ControllerButtonState.PRESS : ControllerButtonState.RELEASE;
                ControllerInputManager.setState(toButton(axis, false), buttonState);
                AXIS_INPUT_HANDLER.handleInput(axis, buttonState, ControllerAxisState.NEGATIVE);
            }
        }
    }

}
