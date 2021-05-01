package gq.nkkx.bedrockmechanics.controller.tasks;

import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.registry.ControllerRegistry;
import net.minecraft.client.MinecraftClient;

public class ControllerUpdateThread extends Thread {

    private final long INTERVAL = 10_000;

    @Override
    public void run() {
        BedrockMechanics.getLogger().info("Starting controller update thread...");
        ControllersSetup controllersSetup = new ControllersSetup();
        while (MinecraftClient.getInstance().isRunning()) {
            ControllerRegistry.getInstance().cleanup();
            controllersSetup.run();
            try {
                sleep(INTERVAL);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

}
