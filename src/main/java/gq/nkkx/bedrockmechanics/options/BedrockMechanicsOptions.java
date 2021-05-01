package gq.nkkx.bedrockmechanics.options;

import gq.nkkx.bedrockmechanics.controller.Controller;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

import java.util.Optional;

@Config(name = "bedrock-mechanics")
public class BedrockMechanicsOptions implements ConfigData {

    private Controller selectedController;

    public Optional<Controller> getSelectedController() {
        return Optional.ofNullable(selectedController);
    }

    public void setSelectedController(Controller controller) {
        selectedController = controller;
    }

}
