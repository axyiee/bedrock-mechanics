package gq.nkkx.bedrockmechanics.client.controller.input;

import gq.nkkx.bedrockmechanics.client.accessor.IHandledScreen;
import gq.nkkx.bedrockmechanics.client.accessor.IKeyBinding;
import gq.nkkx.bedrockmechanics.client.keybindings.LookKeyBindingView;
import lombok.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.options.StickyKeyBinding;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

import java.util.Objects;
import java.util.function.BiConsumer;

import static org.lwjgl.glfw.GLFW.*;

@Getter
@Builder
@AllArgsConstructor
public class ControllerButtonBinding {

    public static final Category MOVEMENT_CATEGORY = new Category("movement");
    public static final Category INVENTORY_CATEGORY = new Category("inventory");
    public static final Category GAMEPLAY_CATEGORY = new Category("gameplay");

    public static final ControllerButtonBinding DROP_ITEM = builder()
        .identifier("drop_item")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_B)
        .execute((options, pressed) -> useKeybind(options.keyDrop, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding JUMP = builder()
        .identifier("jump")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_A)
        .execute((options, pressed) -> useKeybind(options.keyJump, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding ATTACK = builder()
        .identifier("attack")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER)
        .execute((options, pressed) -> useKeybind(options.keyAttack, pressed))
        .isAxis(true)
        .isAxisPositive(true)
        .build()
        .add();

    public static final ControllerButtonBinding USE = builder()
        .identifier("use")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_LEFT_TRIGGER)
        .execute((options, pressed) -> useKeybind(options.keyUse, pressed))
        .isAxis(true)
        .isAxisPositive(true)
        .build()
        .add();

    public static final ControllerButtonBinding MOVE_FORWARD = builder()
        .identifier("move_forward")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_LEFT_Y)
        .isAxis(true)
        .isAxisPositive(false)
        .execute((options, pressed) -> useKeybind(options.keyForward, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding LOOK_UP = builder()
        .identifier("look_up")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_RIGHT_Y)
        .isAxis(true)
        .isAxisPositive(false)
        .execute((options, pressed) -> useKeybind(LookKeyBindingView.LOOK_UP.getKeyBinding(), pressed))
        .build()
        .add();

    public static final ControllerButtonBinding MOVE_BACKWARDS = builder()
        .identifier("move_backwards")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_LEFT_Y)
        .isAxis(true)
        .isAxisPositive(true)
        .execute((options, pressed) -> useKeybind(options.keyBack, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding MOVE_RIGHT = builder()
        .identifier("right")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_LEFT_X)
        .isAxis(true)
        .isAxisPositive(true)
        .execute((options, pressed) -> useKeybind(options.keyRight, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding MOVE_LEFT = builder()
        .identifier("move_left")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_LEFT_X)
        .isAxis(true)
        .isAxisPositive(false)
        .execute((options, pressed) -> useKeybind(options.keyLeft, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding LOOK_DOWN = builder()
        .identifier("look_down")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_RIGHT_Y)
        .isAxis(true)
        .isAxisPositive(true)
        .execute((options, pressed) -> useKeybind(LookKeyBindingView.LOOK_DOWN.getKeyBinding(), pressed))
        .build()
        .add();

    public static final ControllerButtonBinding LOOK_RIGHT = builder()
        .identifier("look_right")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_RIGHT_X)
        .isAxis(true)
        .isAxisPositive(true)
        .execute((options, pressed) -> useKeybind(LookKeyBindingView.LOOK_RIGHT.getKeyBinding(), pressed))
        .build()
        .add();

    public static final ControllerButtonBinding LOOK_LEFT = builder()
        .identifier("look_left")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_RIGHT_X)
        .isAxis(true)
        .isAxisPositive(false)
        .execute((options, pressed) -> useKeybind(LookKeyBindingView.LOOK_LEFT.getKeyBinding(), pressed))
        .build()
        .add();

    public static final ControllerButtonBinding OPEN_INVENTORY = builder()
        .identifier("open_inventory")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_Y)
        .execute((options, pressed) -> useKeybind(options.keyInventory, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding PAUSE_GAME = builder()
        .identifier("pause_game")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_START)
        .execute((options, pressed) -> MinecraftClient.getInstance().openPauseMenu(pressed))
        .build()
        .add();

    public static final ControllerButtonBinding SNEAK = builder()
        .identifier("sneak")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_RIGHT_THUMB)
        .execute((options, pressed) -> useKeybind(options.keySneak, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding SPRINT = builder()
        .identifier("sprint")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_LEFT_THUMB)
        .execute((options, pressed) -> useKeybind(options.keySprint, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding TOGGLE_PERSPECTIVE = builder()
        .identifier("toggle_perspective")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_X)
        .execute((options, pressed) -> useKeybind(options.keyTogglePerspective, pressed))
        .build()
        .add();

    public static final ControllerButtonBinding EXIT = builder()
        .identifier("exit")
        .category(INVENTORY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_B)
        .execute((options, pressed) -> {
            IHandledScreen screen = getIHandledScreen(pressed);
            if (screen != null) {
                screen.bedrock_mechanics$onClose();
            }
        })
        .environment(AccessibleEnvironment.INVENTORY)
        .build()
        .add();

    public static final ControllerButtonBinding QUICK_MOVE = builder()
        .identifier("quick_move")
        .category(INVENTORY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_Y)
        .execute((options, pressed) -> onHandledScreenMouseClick(pressed, GLFW_MOUSE_BUTTON_1, SlotActionType.QUICK_MOVE))
        .environment(AccessibleEnvironment.INVENTORY)
        .build()
        .add();

    public static final ControllerButtonBinding INVENTORY_PICKUP = builder()
        .identifier("inventory_pickup")
        .category(INVENTORY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_A)
        .execute((options, pressed) -> onHandledScreenMouseClick(pressed, GLFW_MOUSE_BUTTON_1, SlotActionType.PICKUP))
        .environment(AccessibleEnvironment.INVENTORY)
        .build()
        .add();

    public static final ControllerButtonBinding INVENTORY_PLACE_HALF = builder()
        .identifier("inventory_place_half")
        .category(INVENTORY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_X)
        .execute((options, pressed) -> onHandledScreenMouseClick(pressed, GLFW_MOUSE_BUTTON_2, SlotActionType.PICKUP))
        .environment(AccessibleEnvironment.INVENTORY)
        .build()
        .add();

    private final String identifier;
    private final Category category;
    private final boolean isAxis;
    private final boolean isAxisPositive;

    @Builder.Default
    private final AccessibleEnvironment environment = AccessibleEnvironment.IN_GAME;

    @Getter(AccessLevel.NONE)
    private final BiConsumer<GameOptions, Boolean> execute;

    @Setter
    private int button;

    private static IHandledScreen getIHandledScreen(boolean pressed) {
        Screen currentScreen = MinecraftClient.getInstance().currentScreen;
        if (pressed && currentScreen instanceof HandledScreen) {
            return (IHandledScreen) currentScreen;
        }
        return null;
    }

    private static void onHandledScreenMouseClick(boolean pressed, int button, SlotActionType action) {
        IHandledScreen screen = getIHandledScreen(pressed);
        if (pressed && screen != null) {
            Slot slot = screen.bedrock_mechanics$getCurrentSlot();
            if (slot != null) {
                screen.bedrock_mechanics$onMouseClick(slot, slot.id, button, action);
            }
        }
    }

    private static void useKeybind(KeyBinding keyBinding, boolean pressed) {
        if (keyBinding instanceof StickyKeyBinding) {
            keyBinding.setPressed(pressed);
        } else {
            ((IKeyBinding) keyBinding).changeNonStickyPressState(pressed);
        }
    }

    public void execute(boolean pressed) {
        execute.accept(MinecraftClient.getInstance().options, pressed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ControllerButtonBinding that = (ControllerButtonBinding) o;
        return Objects.equals(identifier, that.identifier) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, category);
    }

    private ControllerButtonBinding add() {
        ControllerInputManager.registerBinding(this);
        return this;
    }

    public enum AccessibleEnvironment {
        OTHER_MENUS,
        INVENTORY,
        IN_GAME
    }

    @Getter
    @AllArgsConstructor
    public static class Category {

        public final String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Category category = (Category) o;
            return Objects.equals(name, category.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

    }

}
