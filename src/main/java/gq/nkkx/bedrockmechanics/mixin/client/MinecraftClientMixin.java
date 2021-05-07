package gq.nkkx.bedrockmechanics.mixin.client;

import gq.nkkx.bedrockmechanics.client.BedrockMechanicsClient;
import gq.nkkx.bedrockmechanics.client.accessor.IMinecraftClient;
import gq.nkkx.bedrockmechanics.client.controller.input.ControllerInputManager;
import gq.nkkx.bedrockmechanics.client.controller.tasks.ControllerUpdateThread;
import gq.nkkx.bedrockmechanics.client.controller.tasks.ControllersMappingsSetup;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin implements IMinecraftClient {

    @Override
    @Accessor("currentFps")
    public abstract int getCurrentFPS();

    @Inject(method = "<init>", at = @At("RETURN"))
    private void bedrock_mechanics$init(CallbackInfo callbackInfo) {
        new ControllersMappingsSetup().run();
        ControllerInputManager.init(((MinecraftClient) (Object) this).options);
        Thread thread = new ControllerUpdateThread();
        thread.setName("Controller Update");
        thread.setDaemon(true);
        thread.start();
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void bedrock_mechanics$render(CallbackInfo callbackInfo) {
        BedrockMechanicsClient.render((MinecraftClient) (Object) this);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;render(FJZ)V", shift = At.Shift.AFTER))
    private void bedrock_mechanics$render$afterGameRenderer(CallbackInfo callbackInfo) {
        BedrockMechanicsClient.render$afterGameRenderer((MinecraftClient) (Object) this);
    }

}
