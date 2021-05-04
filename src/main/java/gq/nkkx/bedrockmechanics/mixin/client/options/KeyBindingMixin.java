package gq.nkkx.bedrockmechanics.mixin.client.options;

import gq.nkkx.bedrockmechanics.client.accessor.IKeyBinding;
import net.minecraft.client.options.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(KeyBinding.class)
public abstract class KeyBindingMixin implements IKeyBinding {

    @Shadow
    private int timesPressed;

    @Shadow
    private boolean pressed;

    @Shadow
    public abstract void setPressed(boolean pressed);

    private void safePress$press() {
        this.pressed = true;
        ++this.timesPressed;
    }

    private void safePress$unpress() {
        pressed = false;
    }

    @Override
    public void safePress(boolean pressed) {
        if (pressed) {
            safePress$press();
        } else {
            safePress$unpress();
        }
    }

}
