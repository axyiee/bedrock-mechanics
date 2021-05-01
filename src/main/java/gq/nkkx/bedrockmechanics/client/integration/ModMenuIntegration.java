package gq.nkkx.bedrockmechanics.client.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import gq.nkkx.bedrockmechanics.options.BedrockMechanicsOptions;
import me.shedaniel.autoconfig.AutoConfig;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(BedrockMechanicsOptions.class, parent).get();
    }
}
