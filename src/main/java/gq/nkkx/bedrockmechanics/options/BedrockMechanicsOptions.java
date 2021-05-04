package gq.nkkx.bedrockmechanics.options;

import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.client.gui.provider.ControllerGuiProvider;
import lombok.Getter;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

@Getter
@Config(name = "bedrock-mechanics")
public class BedrockMechanicsOptions extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("controller-options")
    @ConfigEntry.Gui.TransitiveObject
    private final ControllerOptions controllerOptions = new ControllerOptions();

    @ConfigEntry.Category("mechanics-options")
    @ConfigEntry.Gui.TransitiveObject
    private final MechanicsOptions mechanicsOptions = new MechanicsOptions();

    public static void init() {
        AutoConfig.register(BedrockMechanicsOptions.class, PartitioningSerializer.wrap(Toml4jConfigSerializer::new));
        AutoConfig.getGuiRegistry(BedrockMechanicsOptions.class).registerTypeProvider(new ControllerGuiProvider(), Controller.class);
    }

}
