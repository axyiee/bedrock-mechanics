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

    private void safePress$press() {
        pressed = true;
        ++this.timesPressed;
    }

    private void safePress$unpress() {
        pressed = false;
    }

    @Override
    public void changeNonStickyPressState(boolean pressed) {
        if (pressed) {
            safePress$press();
        } else {
            safePress$unpress();
        }
    }

}
