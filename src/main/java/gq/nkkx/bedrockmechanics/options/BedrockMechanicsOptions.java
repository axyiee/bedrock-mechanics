package gq.nkkx.bedrockmechanics.options;

import gq.nkkx.bedrockmechanics.controller.Controller;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

import java.util.Optional;

@Config(name = "bedrock-mechanics")
public class BedrockMechanicsOptions implements ConfigData {

    private double controllerDeadZone = 0.20;
    private Controller selectedController;

    public Optional<Controller> getSelectedController() {
        return Optional.ofNullable(selectedController);
    }

    public double getControllerDeadZone() {
        return controllerDeadZone;
    }

    public void setControllerDeadZone(double controllerDeadZone) {
        this.controllerDeadZone = controllerDeadZone;
    }

    public void setSelectedController(Controller controller) {
        selectedController = controller;
    }

}
