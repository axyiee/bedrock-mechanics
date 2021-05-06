package gq.nkkx.bedrockmechanics.client.controller.icons;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import lombok.Getter;
import net.minecraft.util.Identifier;

@Getter
public class ControllerIcon {

    private final Identifier identifier;

    public ControllerIcon(String path) {
        identifier = BedrockMechanics.locate(path);
    }

}
