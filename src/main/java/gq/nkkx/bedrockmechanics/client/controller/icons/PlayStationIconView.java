package gq.nkkx.bedrockmechanics.client.controller.icons;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.glfw.GLFW.*;

@AllArgsConstructor
public class PlayStationIconView implements InterfacedIconView {

    private static final Map<Integer, ControllerIcon> ICONS = new HashMap<>();

    static {
        ICONS.put(GLFW_GAMEPAD_BUTTON_CROSS, new ControllerIcon("icons/images/ps-x.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_CIRCLE, new ControllerIcon("icons/images/ps-o.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_SQUARE, new ControllerIcon("icons/images/ps-square.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_TRIANGLE, new ControllerIcon("icons/images/ps-triangle.png"));
    }

    private final InterfacedIconView fallbackIconView;

    @Override
    public ControllerIcon getIconFromButton(int button) {
        return InterfacedIconView.getControllerIcon(button, ICONS, fallbackIconView);
    }

}
