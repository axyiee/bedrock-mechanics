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

    private boolean showPosition = true;

    private boolean showFPS = false;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 180)
    private int paperDollRotation = 20;

    @ConfigEntry.BoundedDiscrete(min = 10, max = 50)
    private int paperDollScale = 20;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 500)
    private int guiPositionY = 50;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 500)
    private int guiPositionX = 30;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    private int screenSafeArea = 0;

    @ConfigEntry.ColorPicker
    private int textColor = 0xffffff;

}
