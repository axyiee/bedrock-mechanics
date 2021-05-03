package gq.nkkx.bedrockmechanics.controller.input;

import lombok.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

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
        .supply(options -> options.keyDrop)
        .build()
        .add();

    public static final ControllerButtonBinding JUMP = builder()
        .identifier("jump")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_A)
        .supply(options -> options.keyJump)
        .build()
        .add();

    public static final ControllerButtonBinding ATTACK = builder()
        .identifier("attack")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER)
        .supply(options -> options.keyAttack)
        .isAxis(true)
        .isAxisPositive(true)
        .build()
        .add();

    public static final ControllerButtonBinding USE = builder()
        .identifier("use")
        .category(GAMEPLAY_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_LEFT_TRIGGER)
        .supply(options -> options.keyUse)
        .isAxis(true)
        .isAxisPositive(true)
        .build()
        .add();

    public static final ControllerButtonBinding MOVE_FORWARD = builder()
        .identifier("move_forward")
        .category(MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_AXIS_LEFT_Y)
        .isAxisPositive(false)
        .isAxis(true)
        .supply(options -> options.keyForward)
        .build()
        .add();

    private final String identifier;
    private final Category category;

    private final boolean isAxis;
    private final boolean isAxisPositive;

    @Builder.Default
    private final AccessibleEnvironment environment = AccessibleEnvironment.IN_GAME;
    @Getter(AccessLevel.NONE)
    private final Function<GameOptions, KeyBinding> supply;
    @Setter
    private int button;

    public Optional<KeyBinding> asKeyBinding() {
        return Optional.ofNullable(supply.apply(MinecraftClient.getInstance().options));
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
