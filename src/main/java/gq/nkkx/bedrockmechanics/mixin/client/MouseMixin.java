package gq.nkkx.bedrockmechanics.mixin.client;

import gq.nkkx.bedrockmechanics.client.accessor.IMouse;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Mouse.class)
public abstract class MouseMixin implements IMouse {

    @Invoker("onCursorPos")
    public abstract void bedrock_mechanics$onCursorPos(long window, double x, double y);

}
