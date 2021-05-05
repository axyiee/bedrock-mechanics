package gq.nkkx.bedrockmechanics.client.controller.tasks;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.registry.ControllerRegistry;
import org.lwjgl.glfw.GLFW;

/**
 * Setup controllers by adding them to the registry when connected and/or detected.
 * The {@code run()} method should be called only when the game is initializing.
 */
public class ControllersSetup implements Runnable {

    @Override
    public void run() {
        ControllerRegistry registry = ControllerRegistry.getInstance();
        for (int id = GLFW.GLFW_JOYSTICK_1; id <= GLFW.GLFW_JOYSTICK_LAST; id++) {
            if (GLFW.glfwJoystickIsGamepad(id)) {
                Controller controller = new Controller(id);
                if (registry.register(controller)) {
                    BedrockMechanics.getLogger().info("Registered controller with ID " + id);
                    if (BedrockMechanics.options().getControllerOptions().getSelectedController() == null) {
                        BedrockMechanics.options().getControllerOptions().setSelectedControllerId(controller.getId());
                        BedrockMechanics.getLogger().info("Set selected controller to controller with ID " + id);
                    }
                }
            }
        }
    }

}
