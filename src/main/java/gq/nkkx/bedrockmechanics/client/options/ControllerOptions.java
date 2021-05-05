package gq.nkkx.bedrockmechanics.client.options;

import gq.nkkx.bedrockmechanics.client.controller.Controller;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Data
@Getter
@Setter
@Config(name = "controller-options")
public class ControllerOptions implements ConfigData {

    private Controller selectedController = null;

    private boolean isEnabled = true;

    private float deadZone = 0.25f;

}
