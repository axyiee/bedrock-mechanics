package gq.nkkx.bedrockmechanics.client.options;

import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.client.controller.icons.IconView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Data
@Getter
@Setter
@Config(name = "controller-options")
public class ControllerOptions implements ConfigData {

    private IconView.Type iconViewType = IconView.Type.GENERIC;

    private Controller selectedController = null;

    private boolean isEnabled = true;

    private float deadZone = 0.25f;

    private boolean enableControllerHUD = true;

    @ConfigEntry.BoundedDiscrete(min = 2, max = 10)
    private int virtualMouseSpeed = 2;

}
