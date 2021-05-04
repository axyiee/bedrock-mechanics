package gq.nkkx.bedrockmechanics.client;

import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.client.controller.input.handlers.ControllerInputHandler;
import gq.nkkx.bedrockmechanics.client.gui.provider.ControllerGuiProvider;
import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BedrockMechanicsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AutoConfig.register(BedrockMechanicsOptions.class, PartitioningSerializer.wrap(Toml4jConfigSerializer::new));
        AutoConfig.getGuiRegistry(BedrockMechanicsOptions.class).registerTypeProvider(new ControllerGuiProvider(), Controller.class);
        new ControllerInputHandler();
    }

}
