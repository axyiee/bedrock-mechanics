package gq.nkkx.bedrockmechanics.controller.input;

public enum ControllerAxisState {

    NONE,
    POSITIVE,
    NEGATIVE;

    public static int toButton(int axis, boolean positive) {
        return positive ? 300 + axis : 400 + axis;
    }

}
