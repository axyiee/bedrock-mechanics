package gq.nkkx.bedrockmechanics.client.controller;

import gq.nkkx.bedrockmechanics.client.controller.input.ControllerVirtualMouse;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWGamepadState;

import java.util.Objects;

/**
 * A class that represents a controller.
 */
public class Controller {

    public static final ControllerVirtualMouse VIRTUAL_MOUSE = new ControllerVirtualMouse();

    private final int id;
    private String cachedName;

    public Controller(int id) {
        this.id = id;
    }

    /**
     * This method is used internally only.
     * Check whether the controller is connected, if `false` an exception would be thrown.
     */
    private void checkIfIsConnected() throws IllegalStateException {
        if (!isConnected()) {
            throw new IllegalStateException("The controller is not connected.");
        }
    }

    /**
     * Get the identifier for this controller.
     *
     * @return The identifier for this controller.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the controller's global unique identifier.
     *
     * @return The GUID for this controller.
     * @throws IllegalStateException If the controller is not connected.
     */
    public String getGUID() {
        checkIfIsConnected();
        String guid = GLFW.glfwGetJoystickGUID(id);
        if (guid == null) {
            throw new UnknownError("An error occurred while attempting to get the controller GUID.");
        }
        return guid;
    }

    /**
     * Get the name for this controller.
     *
     * @return The name for this controller.
     */
    public String getName() {
        if (isConnected() && isGamepad()) {
            cachedName = GLFW.glfwGetGamepadName(getId());
            return cachedName;
        }
        return cachedName == null ? "" : cachedName;
    }

    /**
     * Creates a GLFW Gamepad state for the controller.
     *
     * @return The instance of the created gamepad state.
     * @throws IllegalStateException If the controller is not connected.
     */
    public GLFWGamepadState getGamepadState() {
        checkIfIsConnected();
        GLFWGamepadState state = GLFWGamepadState.create();
        if (this.isGamepad()) {
            GLFW.glfwGetGamepadState(id, state);
        }
        return state;
    }

    /**
     * Check whether this controller is connected.
     *
     * @return Whether this controller is connected.
     */
    public boolean isConnected() {
        return GLFW.glfwJoystickPresent(id);
    }

    /**
     * Check whether this controller is a gamepad.
     *
     * @return Whether this controller is a gamepad.
     * @throws IllegalStateException If the controller is not connected.
     */
    public boolean isGamepad() {
        checkIfIsConnected();
        return GLFW.glfwJoystickIsGamepad(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Controller)) {
            return false;
        }
        return ((Controller) object).id == id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
