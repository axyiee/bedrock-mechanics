package gq.nkkx.bedrockmechanics.client;

import gq.nkkx.bedrockmechanics.client.gui.provider.ControllerGuiProvider;
import gq.nkkx.bedrockmechanics.controller.Controller;
import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BedrockMechanicsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AutoConfig.register(BedrockMechanicsOptions.class, GsonConfigSerializer::new);
        AutoConfig.getGuiRegistry(BedrockMechanicsOptions.class).registerTypeProvider(new ControllerGuiProvider(), Controller.class);
    }

}
