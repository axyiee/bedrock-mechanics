package gq.nkkx.bedrockmechanics.options;

import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Getter
@Setter
@Config(name = "mechanics-options")
public class MechanicsOptions implements ConfigData {

    private boolean allowFastBlockPlacement = true;

    private float keyBindingLookSpeed = 500.0f;

}
