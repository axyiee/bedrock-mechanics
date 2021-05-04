package gq.nkkx.bedrockmechanics.client.keybindings;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

/**
 * A utility class that adds key bindings to look in 4 directions in order to provide a easier way to make
 * the controller support easier.
 */
public class LookKeybindView implements IKeyBindingView {

    private static double PITCH;
    public static KeyBindingWrapper LOOK_UP = KeyBindingWrapper.builder()
        .name("look_up")
        .key(GLFW.GLFW_KEY_UP)
        .category("gameplay")
        .execute(client -> {
            if (client.player != null) {
                PITCH = -getValue();
            }
        })
        .build();
    public static KeyBindingWrapper LOOK_DOWN = KeyBindingWrapper.builder()
        .name("look_down")
        .key(GLFW.GLFW_KEY_DOWN)
        .category("gameplay")
        .execute(client -> {
            if (client.player != null) {
                PITCH = getValue();
            }
        })
        .build();
    private static double YAW;
    public static KeyBindingWrapper LOOK_LEFT = KeyBindingWrapper.builder()
        .name("look_left")
        .key(GLFW.GLFW_KEY_LEFT)
        .category("gameplay")
        .execute(client -> {
            if (client.player != null) {
                YAW = -getValue();
            }
        })
        .build();

    public static KeyBindingWrapper LOOK_RIGHT = KeyBindingWrapper.builder()
        .name("look_right")
        .key(GLFW.GLFW_KEY_RIGHT)
        .category("gameplay")
        .execute(client -> {
            if (client.player != null) {
                YAW = getValue();
            }
        })
        .build();

    public static void render(MinecraftClient client) {
        if (client.player == null) {
            return;
        }
        if (YAW != 0.0f || PITCH != 0.0f) {
            float yaw = (float) (client.player.prevYaw + (YAW / 10f) * client.getTickDelta());
            float pitch = (float) (client.player.prevPitch + (PITCH / 10f) * client.getTickDelta());
            client.player.yaw = yaw;
            client.player.pitch = MathHelper.clamp(pitch, -90f, 90f);
            if (client.player.isRiding()) {
                client.player.getVehicle().onPassengerLookAround(client.player);
            }
            client.getTutorialManager().onUpdateMouse(YAW, PITCH);
        }
    }

    public static void clear() {
        PITCH = 0.0f;
        YAW = 0.0f;
    }

    private static double getValue() {
        return (options().getMechanicsOptions().getKeyBindingLookSpeed() * 0.64f) * 0.10D;
    }

    public static void init() {
        registerKeyBinding(LOOK_UP);
        registerKeyBinding(LOOK_DOWN);
        registerKeyBinding(LOOK_LEFT);
        registerKeyBinding(LOOK_RIGHT);
    }

    public static void registerKeyBinding(KeyBindingWrapper wrapper) {
        KeyBindingHelper.registerKeyBinding(wrapper.getKeyBinding());
        KeyBindingHandler.listenTo(wrapper);
    }

}
