package gq.nkkx.bedrockmechanics.client.animations;

import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

/**
 * Credits to BedrockIfy.
 */
public class EatingAnimation implements IAnimation {

    private float currentPitch = 0.0f;

    private boolean isEating(PlayerEntity player, Hand hand, ItemStack item) {
        return player.getItemUseTimeLeft() > 0 && player.getActiveHand() == hand &&
            (item.getUseAction() == UseAction.EAT || item.getUseAction() == UseAction.DRINK);
    }

    @Override
    public void play(LivingEntity entity, float tickDelta, PlayerEntityModel model) {
        if (!(entity instanceof PlayerEntity) || !options().getVisualsOptions().isEnableEatingAnimation()) {
            return;
        }
        PlayerEntity player = (PlayerEntity) entity;
        if (isEating(player, Hand.MAIN_HAND, player.getMainHandStack())) {
            if (entity.getItemUseTime() == 1) {
                currentPitch = 0.0f;
            }
            currentPitch = MathHelper.lerp(0.15f, currentPitch, 1.50f);
            model.rightArm.pitch = -currentPitch + (MathHelper.cos(tickDelta * 1.50f) * 0.15f);
            model.rightArm.yaw = 0.25f;
            model.rightArm.roll = 0.32f;
            model.rightSleeve.copyPositionAndRotation(model.rightArm);
        }
        if (isEating(player, Hand.OFF_HAND, player.getOffHandStack())) {
            if (entity.getItemUseTime() == 1) {
                currentPitch = 0.0f;
            }
            currentPitch = MathHelper.lerp(0.15f, currentPitch, 1.50f);
            model.leftArm.pitch = currentPitch + (MathHelper.cos(tickDelta * 1.50f) * 0.15f);
            model.leftArm.yaw = 0.25f;
            model.leftArm.roll = 0.32f;
            model.leftSleeve.copyPositionAndRotation(model.leftArm);
        }
    }
}
