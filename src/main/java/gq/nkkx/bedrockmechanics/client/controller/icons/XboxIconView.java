package gq.nkkx.bedrockmechanics.client.controller.icons;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.glfw.GLFW.*;

@AllArgsConstructor
public class XboxIconView implements InterfacedIconView {

    private static final Map<Integer, ControllerIcon> ICONS = new HashMap<>();

    static {
        ICONS.put(GLFW_GAMEPAD_BUTTON_A, new ControllerIcon("icons/images/xbox-a.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_B, new ControllerIcon("icons/images/xbox-b.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_X, new ControllerIcon("icons/images/xbox-x.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_Y, new ControllerIcon("icons/images/xbox-y.png"));
        ICONS.put(GLFW_GAMEPAD_AXIS_LEFT_TRIGGER, new ControllerIcon("icons/images/xbox-lt.png"));
        ICONS.put(GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER, new ControllerIcon("icons/images/xbox-rt.png"));
    }

    private final InterfacedIconView fallbackIconView;

    @Override
    public ControllerIcon getIconFromButton(int button) {
        return getControllerIcon(button, ICONS, fallbackIconView);
    }

}
