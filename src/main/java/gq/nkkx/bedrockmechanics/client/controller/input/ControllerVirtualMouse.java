package gq.nkkx.bedrockmechanics.client.controller.input;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.client.accessor.IHandledScreen;
import gq.nkkx.bedrockmechanics.client.accessor.IMouse;
import gq.nkkx.bedrockmechanics.client.controller.Controller;
import lombok.Getter;
import lombok.Setter;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;
import static gq.nkkx.bedrockmechanics.client.controller.input.ControllerAxisState.toButton;
import static org.lwjgl.glfw.GLFW.GLFW_GAMEPAD_AXIS_LEFT_X;
import static org.lwjgl.glfw.GLFW.GLFW_GAMEPAD_AXIS_LEFT_Y;

@Getter
@Setter
public class ControllerVirtualMouse {

    private static Identifier CROSSHAIR = BedrockMechanics.locate("textures/crosshair.png");

    private int prevTargetMouseX = 0;
    private int prevTargetMouseY = 0;
    private int targetMouseX = 0;
    private int targetMouseY = 0;

    public ControllerVirtualMouse() {
        ClientTickEvents.END_CLIENT_TICK.register(unused -> tick());
    }

    private void tick() {
        Controller controller = options().getControllerOptions().getSelectedController();
        if (controller == null || !controller.isConnected()) {
            return;
        }
        this.prevTargetMouseX = this.targetMouseX;
        this.prevTargetMouseY = this.targetMouseY;
    }

    private int computeCrosshairX() {
        MinecraftClient client = MinecraftClient.getInstance();
        return (int) (client.mouse.getX() * ((double) client.getWindow().getScaledWidth() / (double) client.getWindow().getWidth()));
    }

    private int computeCrosshairY() {
        MinecraftClient client = MinecraftClient.getInstance();
        return (int) (client.mouse.getY() * ((double) client.getWindow().getScaledHeight() / (double) client.getWindow().getHeight()));
    }

    public void resetMousePosition() {
        MinecraftClient client = MinecraftClient.getInstance();
        targetMouseX = (int) (client.getWindow().getScaledWidth() / 2F);
        targetMouseY = (int) (client.getWindow().getScaledHeight() / 2F);
    }

    public void resetMouseTarget() {
        MinecraftClient client = MinecraftClient.getInstance();
        this.prevTargetMouseX = this.targetMouseX = (int) client.mouse.getX();
        this.prevTargetMouseY = this.targetMouseY = (int) client.mouse.getY();
    }

    // Values taken from LambdaControls.
    private void renderCrosshair(MatrixStack matrices, HandledScreen screen) {
        boolean hoverSlot = false;
        IHandledScreen iHandledScreen = (IHandledScreen) screen;
        Slot slot = iHandledScreen.bedrock_mechanics$getCurrentSlot();
        int x = computeCrosshairX();
        int y = computeCrosshairY();
        if (slot != null) {
            x = iHandledScreen.bedrock_mechanics$getX() + slot.x;
            y = iHandledScreen.bedrock_mechanics$getY() + slot.y;
            hoverSlot = true;
        }
        MinecraftClient.getInstance().getTextureManager().bindTexture(CROSSHAIR);
        DrawableHelper.drawTexture(matrices, x, y, hoverSlot ? 16 : 0, 0, 0, 16, 16, 16, 16);
    }

    public void onRender() {
        Controller controller = options().getControllerOptions().getSelectedController();
        if (controller == null || !controller.isConnected() || !(MinecraftClient.getInstance().currentScreen instanceof HandledScreen)) {
            return;
        }
        MinecraftClient client = MinecraftClient.getInstance();
        int speed = BedrockMechanics.options().getControllerOptions().getVirtualMouseSpeed();
        if (ControllerInputManager.getState(toButton(GLFW_GAMEPAD_AXIS_LEFT_X, true)).isPressed()
            || ControllerInputManager.getState(toButton(GLFW_GAMEPAD_AXIS_LEFT_X, false)).isPressed()) {
            targetMouseX += controller.getGamepadState().axes(GLFW_GAMEPAD_AXIS_LEFT_X) * speed;
        }
        if (ControllerInputManager.getState(toButton(GLFW_GAMEPAD_AXIS_LEFT_Y, true)).isPressed()
            || ControllerInputManager.getState(toButton(GLFW_GAMEPAD_AXIS_LEFT_Y, false)).isPressed()) {
            targetMouseY += controller.getGamepadState().axes(GLFW_GAMEPAD_AXIS_LEFT_Y) * speed;
        }
        if (this.prevTargetMouseX != this.targetMouseX || this.prevTargetMouseY != this.targetMouseY) {
            double mouseX = this.prevTargetMouseX + (this.targetMouseX - this.prevTargetMouseX) * client.getTickDelta() + 0.5;
            double mouseY = this.prevTargetMouseY + (this.targetMouseY - this.prevTargetMouseY) * client.getTickDelta() + 0.5;
            ((IMouse) client.mouse).bedrock_mechanics$onCursorPos(client.getWindow().getHandle(), mouseX, mouseY);
        }
        renderCrosshair(new MatrixStack(), (HandledScreen) MinecraftClient.getInstance().currentScreen);
    }

}
