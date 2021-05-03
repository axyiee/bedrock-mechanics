package gq.nkkx.bedrockmechanics.options;

import lombok.Getter;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Getter
@Config(name = "bedrock-mechanics")
public class BedrockMechanicsOptions extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("controller-options")
    @ConfigEntry.Gui.TransitiveObject
    private final ControllerOptions controllerOptions = new ControllerOptions();

    @ConfigEntry.Category("mechanics-options")
    @ConfigEntry.Gui.TransitiveObject
    private final MechanicsOptions mechanicsOptions = new MechanicsOptions();

}
