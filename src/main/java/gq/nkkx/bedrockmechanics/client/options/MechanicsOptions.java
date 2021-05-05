package gq.nkkx.bedrockmechanics.client.options;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Data
@Getter
@Setter
@Config(name = "mechanics-options")
public class MechanicsOptions implements ConfigData {

    private boolean allowFastBlockPlacement = true;

    private boolean sneakingActivatesShield = true;

    @ConfigEntry.BoundedDiscrete(min = 10, max = 1500)
    private int keyBindingLookSpeed = 1000;

}
