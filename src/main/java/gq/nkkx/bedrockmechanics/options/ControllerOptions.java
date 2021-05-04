package gq.nkkx.bedrockmechanics.options;

import gq.nkkx.bedrockmechanics.client.controller.Controller;
import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Getter
@Setter
@Config(name = "controller-options")
public class ControllerOptions implements ConfigData {

    private boolean enabled = true;

    private Controller selectedController = null;

    private float deadZone = 0.25f;

}
