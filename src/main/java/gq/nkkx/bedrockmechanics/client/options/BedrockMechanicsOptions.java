package gq.nkkx.bedrockmechanics.client.options;

import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.client.gui.provider.ControllerGuiProvider;
import lombok.Data;
import lombok.Getter;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Data
@Getter
@Config(name = "bedrock-mechanics")
public class BedrockMechanicsOptions implements ConfigData {

    @ConfigEntry.Category("controller-options")
    @ConfigEntry.Gui.TransitiveObject
    private final ControllerOptions controllerOptions = new ControllerOptions();

    @ConfigEntry.Category("mechanics-options")
    @ConfigEntry.Gui.TransitiveObject
    private final MechanicsOptions mechanicsOptions = new MechanicsOptions();

    @ConfigEntry.Category("hud-options")
    @ConfigEntry.Gui.TransitiveObject
    private final HudOptions hudOptions = new HudOptions();

    @ConfigEntry.Category("animations-options")
    @ConfigEntry.Gui.TransitiveObject
    private final AnimationsOptions animationsOptions = new AnimationsOptions();

    public static void init() {
        AutoConfig.register(BedrockMechanicsOptions.class, GsonConfigSerializer::new);
        AutoConfig.getGuiRegistry(BedrockMechanicsOptions.class).registerTypeProvider(new ControllerGuiProvider(), Controller.class);
    }

}
