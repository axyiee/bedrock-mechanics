package gq.nkkx.bedrockmechanics.client.options;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Data
@Setter
@Getter
@Config(name = "visuals-options")
public class VisualsOptions implements ConfigData {

    private boolean enableEatingAnimation = true;

    private boolean enableIdleHandAnimation = true;

}
