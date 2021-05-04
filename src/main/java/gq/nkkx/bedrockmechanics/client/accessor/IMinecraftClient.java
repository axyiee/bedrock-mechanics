package gq.nkkx.bedrockmechanics.client.accessor;

import net.minecraft.client.WindowEventHandler;
import net.minecraft.util.snooper.SnooperListener;

public interface IMinecraftClient extends SnooperListener, WindowEventHandler {

    int getCurrentFPS();

}
