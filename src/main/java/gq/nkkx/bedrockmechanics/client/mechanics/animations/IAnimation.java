package gq.nkkx.bedrockmechanics.client.mechanics.animations;

import gq.nkkx.bedrockmechanics.client.mechanics.IMechanic;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;

public interface IAnimation extends IMechanic {

    void play(LivingEntity entity, float tickDelta, PlayerEntityModel model);

}
