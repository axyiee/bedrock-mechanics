package gq.nkkx.bedrockmechanics.client.gui.provider;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.controller.Controller;
import gq.nkkx.bedrockmechanics.registry.ControllerRegistry;
import me.shedaniel.autoconfig.gui.registry.api.GuiProvider;
import me.shedaniel.autoconfig.gui.registry.api.GuiRegistryAccess;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.TranslatableText;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ControllerGuiProvider implements GuiProvider {

    @Override
    public List<AbstractConfigListEntry> get(String s, Field field, Object o, Object o1, GuiRegistryAccess guiRegistryAccess) {
        Controller selectedController = BedrockMechanics.options().getSelectedController().orElse(null);
        String defaultControllerName = selectedController != null ? selectedController.getName() : "";
        return Collections.singletonList(
            ConfigEntryBuilder.create()
                .startStringDropdownMenu(new TranslatableText(s), defaultControllerName)
                .setSelections(ControllerRegistry.getInstance().getControllers().stream().map(c -> c.getName()).collect(Collectors.toList()))
                .setDefaultValue(defaultControllerName)
                .setSaveConsumer((consumer) -> {
                    Optional<Controller> controller = ControllerRegistry.getInstance().getControllers()
                        .stream()
                        .filter(c -> c.getName().equals(consumer))
                        .findFirst();
                    if (controller.isPresent()) {
                        Controller c = controller.get();
                        BedrockMechanics.getLogger().info("Setting current controller to " + c.getId());
                        BedrockMechanics.options().setSelectedController(c);
                    } else {
                        BedrockMechanics.getLogger().error("Couldn't find the controller named " + consumer);
                    }
                })
                .setSuggestionMode(true)
                .build()
        );
    }


}
