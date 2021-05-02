package gq.nkkx.bedrockmechanics.controller.input.handlers;

import gq.nkkx.bedrockmechanics.controller.input.ControllerButtonState;

public interface IControllerInputHandler {

    void handleInput(int value, ControllerButtonState buttonState);

}
