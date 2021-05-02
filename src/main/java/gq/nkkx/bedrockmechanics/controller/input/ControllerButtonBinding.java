package gq.nkkx.bedrockmechanics.controller.input;

import net.minecraft.client.options.KeyBinding;

import java.util.Objects;
import java.util.Optional;

import static org.lwjgl.glfw.GLFW.GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER;
import static org.lwjgl.glfw.GLFW.GLFW_GAMEPAD_BUTTON_A;

public class ControllerButtonBinding {

    public static final Category MOVEMENT_CATEGORY = new Category("movement");
    public static final Category INVENTORY_CATEGORY = new Category("inventory");
    public static final Category GAMEPLAY_CATEGORY = new Category("gameplay");

    public static final ControllerButtonBinding ATTACK = new Builder("attack", GAMEPLAY_CATEGORY)
        .axis(GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER, true)
        .onlyInGame()
        .build();

    public static final ControllerButtonBinding JUMP = new Builder("jump", MOVEMENT_CATEGORY)
        .button(GLFW_GAMEPAD_BUTTON_A)
        .onlyInGame()
        .build();
    private final String name;
    private final Category category;
    private final boolean accessOnlyInGame;
    private int button;

    public ControllerButtonBinding(int button, String name, Category category, boolean accessOnlyInGame) {
        this.category = category;
        this.name = name;
        this.accessOnlyInGame = accessOnlyInGame;
        setButton(button);
    }

    public boolean isOnlyInGame() {
        return accessOnlyInGame;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public Optional<KeyBinding> asKeyBinding() {
        return ControllerInputManager.getKeybinding(this);
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
        return Objects.equals(name, that.name) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    public static class Category {

        public final String name;

        public Category(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

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

    private static class Builder {

        private final String name;
        private final Category category;
        private boolean accessOnlyInGame;
        private int button;

        public Builder(String name, Category category) {
            this.category = category;
            this.name = name;
            this.accessOnlyInGame = false;
        }

        public Builder button(int button) {
            this.button = button;
            return this;
        }

        public Builder onlyInGame() {
            this.accessOnlyInGame = true;
            return this;
        }

        public Builder axis(int axis, boolean positive) {
            return button(positive ? 100 + axis : 200 + axis);
        }

        public ControllerButtonBinding build() {
            ControllerButtonBinding binding = new ControllerButtonBinding(button, name, category, accessOnlyInGame);
            ControllerInputManager.registerBinding(binding);
            return binding;
        }

    }

}
