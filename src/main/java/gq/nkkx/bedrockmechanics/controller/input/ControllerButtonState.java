package gq.nkkx.bedrockmechanics.controller.input;

public enum ControllerButtonState {

    NONE(0),
    PRESS(1),
    RELEASE(2);

    public final int id;

    ControllerButtonState(int id) {
        this.id = id;
    }

    public boolean isPressed() {
        return this == PRESS;
    }

    public boolean isUnpressed() {
        return this == RELEASE || this == NONE;
    }

}
