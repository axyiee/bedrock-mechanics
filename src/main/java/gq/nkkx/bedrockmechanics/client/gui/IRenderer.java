package gq.nkkx.bedrockmechanics.client.gui;

import net.minecraft.client.util.math.MatrixStack;

public interface IRenderer {

    interface Empty {
    }

    void render(MatrixStack matrices);

}
