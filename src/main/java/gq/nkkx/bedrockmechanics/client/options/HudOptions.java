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
@Config(name = "hud-options")
public class HudOptions implements ConfigData {

    private boolean isEnabled = true;

    private boolean isPaperDollEnabled = true;

    private boolean showPosition = true;

    private boolean showFPS = true;

    private boolean bedrockChatStyle = true;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 360)
    private int paperDollRotation = 20;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    private int paperDollScale = 20;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    private int positionY = 5;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    private int positionX = 5;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
    private int screenSafeArea = 0;

    @ConfigEntry.ColorPicker
    private int textColor = 0xffffff;

}
