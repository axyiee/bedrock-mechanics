package gq.nkkx.bedrockmechanics.controller.tasks;

import com.google.common.io.ByteStreams;
import gq.nkkx.bedrockmechanics.BedrockMechanics;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.MemoryUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * Setup the mappings for the controller.
 */
public class ControllersMappingsSetup implements Runnable {

    @Override
    public void run() {
        try (InputStream inputStream = BedrockMechanics.class.getResourceAsStream("/gamecontrollerdb.txt")) {
            byte[] bytes = ByteStreams.toByteArray(inputStream);
            ByteBuffer buffer = MemoryUtil.memASCIISafe(new String(bytes));
            GLFW.glfwUpdateGamepadMappings(buffer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
