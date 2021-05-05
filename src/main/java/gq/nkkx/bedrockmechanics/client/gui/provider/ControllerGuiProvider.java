package gq.nkkx.bedrockmechanics.client.gui.provider;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.registry.ControllerRegistry;
import me.shedaniel.autoconfig.gui.registry.api.GuiProvider;
import me.shedaniel.autoconfig.gui.registry.api.GuiRegistryAccess;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class ControllerGuiProvider implements GuiProvider {

    @Override
    public List<AbstractConfigListEntry> get(String s, Field field, Object o, Object o1, GuiRegistryAccess guiRegistryAccess) {
        Controller selectedController = BedrockMechanics.options().getControllerOptions().getSelectedController();
        return Collections.singletonList(
            ConfigEntryBuilder.create().startDropdownMenu(
                new TranslatableText(s),
                selectedController,
                name -> ControllerRegistry.getInstance().getControllers()
                    .stream()
                    .filter(controller -> controller.getName().equals(name))
                    .findFirst()
                    .orElse(null),
                controller -> Text.of(controller.getName())
            ).setSelections(ControllerRegistry.getInstance().getControllers()).setDefaultValue(selectedController).build()
        );
    }
}
