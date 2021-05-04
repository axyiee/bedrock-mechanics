package gq.nkkx.bedrockmechanics.mixin;

import gq.nkkx.bedrockmechanics.client.controller.input.ControllerInputManager;
import gq.nkkx.bedrockmechanics.client.controller.tasks.ControllerUpdateThread;
import gq.nkkx.bedrockmechanics.client.controller.tasks.ControllersMappingsSetup;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void bedrock_mechanics$init(CallbackInfo callbackInfo) {
        new ControllersMappingsSetup().run();
        ControllerInputManager.init(MinecraftClient.getInstance().options);
        Thread thread = new ControllerUpdateThread();
        thread.setName("Controller Update");
        thread.setDaemon(true);
        thread.start();
    }

}
