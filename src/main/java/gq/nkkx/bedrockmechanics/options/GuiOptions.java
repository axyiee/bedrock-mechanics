package gq.nkkx.bedrockmechanics.options;

import lombok.Getter;
import lombok.Setter;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Getter
@Setter
@Config(name = "gui-options")
public class GuiOptions implements ConfigData {

    private boolean isEnabled = true;

    private boolean isPaperDollEnabled = true;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 1000)
    @ConfigEntry.Gui.TransitiveObject
    private int guiPositionY = 20;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 1000)
    @ConfigEntry.Gui.TransitiveObject
    private int guiPositionX = 20;

}
