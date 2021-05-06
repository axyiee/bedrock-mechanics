package gq.nkkx.bedrockmechanics.client.controller.icons;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.glfw.GLFW.*;

public class GenericIconView implements InterfacedIconView {

    private static final Map<Integer, ControllerIcon> ICONS = new HashMap<>();

    static {
        ICONS.put(GLFW_GAMEPAD_BUTTON_A, new ControllerIcon("icons/images/rift-a.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_B, new ControllerIcon("icons/images/rift-b.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_X, new ControllerIcon("icons/images/rift-x.png"));
        ICONS.put(GLFW_GAMEPAD_BUTTON_Y, new ControllerIcon("icons/images/rift-y.png"));
    }

    @Override
    public @Nullable ControllerIcon getIconFromButton(int button) {
        return ICONS.get(button);
    }

}
