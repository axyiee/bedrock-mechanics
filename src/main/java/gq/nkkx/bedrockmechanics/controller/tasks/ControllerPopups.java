package gq.nkkx.bedrockmechanics.controller.tasks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.lwjgl.glfw.GLFW;

public class ControllerPopups implements Runnable {

    @Override
    public void run() {
        GLFW.glfwSetJoystickCallback((id, event) -> {
            if (event == GLFW.GLFW_CONNECTED) {
                MinecraftClient.getInstance().getToastManager().add(
                    new SystemToast(
                        SystemToast.Type.TUTORIAL_HINT,
                        new TranslatableText("bedrock-mechanics.controller.connected"),
                        Text.of("ID: " + id)
                    )
                );
            } else if (event == GLFW.GLFW_DISCONNECTED) {
                MinecraftClient.getInstance().getToastManager().add(
                    new SystemToast(
                        SystemToast.Type.TUTORIAL_HINT,
                        new TranslatableText("bedrock-mechanics.controller.disconnected"),
                        Text.of("ID: " + id)
                    )
                );
            }
        });
    }
}
