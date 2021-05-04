package gq.nkkx.bedrockmechanics.client.controller.input;

public enum ControllerButtonState {

    NONE,
    PRESS,
    RELEASE;

    public boolean isPressed() {
        return this == PRESS;
    }

    public boolean isUnpressed() {
        return this == RELEASE || this == NONE;
    }

}
