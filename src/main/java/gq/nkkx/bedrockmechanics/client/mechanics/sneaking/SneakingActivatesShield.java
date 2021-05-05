package gq.nkkx.bedrockmechanics.client.mechanics.sneaking;

import gq.nkkx.bedrockmechanics.client.mechanics.IMechanic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Hand;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

public class SneakingActivatesShield implements IMechanic {

    public void execute(PlayerEntity player) {
        if (!player.isSneaking() || !options().getMechanicsOptions().isSneakingActivatesShield()) {
            return;
        }
        ItemStack mainItem = player.getStackInHand(Hand.MAIN_HAND);
        if (mainItem.getItem() instanceof ShieldItem) {
            mainItem.use(player.world, player, Hand.MAIN_HAND);
            return;
        }
        ItemStack offItem = player.getStackInHand(Hand.OFF_HAND);
        if (offItem.getItem() instanceof ShieldItem) {
            offItem.use(player.world, player, Hand.OFF_HAND);
        }
    }

}
