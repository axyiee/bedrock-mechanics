package gq.nkkx.bedrockmechanics.client.animations;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.item.ItemStack;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

public class ItemPickupAnimation implements IAnimation.Empty {

    private float timeLeft = 0.0f;

    public void registerTimeLeft(ItemStack itemStack, float tickDelta) {
        timeLeft = itemStack.getCooldown() - tickDelta;
    }

    public void play(float x, float y, float z) {
        if (options().getVisualsOptions().isEnablePickupAnimation() && timeLeft > 0.0f) {
            float value = 1.0f + timeLeft / 10.0f;
            RenderSystem.scalef(value, value, 1.0f);
            return;
        }
        RenderSystem.scalef(x, y, z);
    }

}
