package gq.nkkx.bedrockmechanics.client.gui.hud;

import com.google.common.collect.ImmutableList;
import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.client.controller.icons.ControllerIcon;
import gq.nkkx.bedrockmechanics.client.controller.icons.IconView;
import gq.nkkx.bedrockmechanics.client.controller.icons.InterfacedIconView;
import gq.nkkx.bedrockmechanics.client.controller.input.ControllerButtonBinding;
import gq.nkkx.bedrockmechanics.client.gui.IRenderer;
import gq.nkkx.bedrockmechanics.client.gui.ScreenSafeArea;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.List;

import static gq.nkkx.bedrockmechanics.BedrockMechanics.options;

public class ControllerHUDRenderer implements IRenderer {

    private static final int ICON_SIZE = 56;
    private static final float SCALED_ICON_SIZE = 0.36f;

    private static final ImmutableList<ControllerButtonBinding> leftBindings = ImmutableList.<ControllerButtonBinding>builder()
        .add(ControllerButtonBinding.JUMP)
        .add(ControllerButtonBinding.OPEN_INVENTORY)
        .build();

    private static final ImmutableList<ControllerButtonBinding> inventoryLeftBindings = ImmutableList.<ControllerButtonBinding>builder()
        .add(ControllerButtonBinding.QUICK_MOVE)
        .add(ControllerButtonBinding.INVENTORY_PLACE_HALF)
        .add(ControllerButtonBinding.EXIT)
        .add(ControllerButtonBinding.INVENTORY_PICKUP)
        .build();

    @Override
    public void render(MatrixStack matrices) {
        if (!options().getControllerOptions().isEnableControllerHUD()) {
            return;
        }
        Controller controller = options().getControllerOptions().getSelectedController();
        if (controller == null || !controller.isConnected()) {
            return;
        }

        InterfacedIconView view = IconView.byType(options().getControllerOptions().getIconViewType());
        if (MinecraftClient.getInstance().currentScreen == null) {
            drawBindings(matrices, 0, view, leftBindings);
        } else if (MinecraftClient.getInstance().currentScreen instanceof InventoryScreen) {
            drawBindings(matrices, 0, view, inventoryLeftBindings);
        }
    }

    private void drawBindings(MatrixStack matrices, int x, InterfacedIconView view, List<ControllerButtonBinding> bindings) {
        int y = MinecraftClient.getInstance().getWindow().getScaledHeight() - 22;
        MinecraftClient client = MinecraftClient.getInstance();
        for (ControllerButtonBinding binding : bindings) {
            ControllerIcon icon = view.getIconFromButton(binding.getButton());
            if (icon == null) {
                continue;
            }

            matrices.push();
            matrices.translate(2.0 + options().getHudOptions().getScreenSafeArea(), y, 0.0);
            matrices.scale(SCALED_ICON_SIZE, SCALED_ICON_SIZE, SCALED_ICON_SIZE);
            client.getTextureManager().bindTexture(icon.getIdentifier());
            Text text = new TranslatableText("bedrock-mechanics.bindings." + binding.getIdentifier());

            ScreenSafeArea.drawPositiveNegativeTexture(matrices, x, 0, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);
            matrices.pop();
            int textY = options().getHudOptions().getScreenSafeArea() > 0 ? y + options().getHudOptions().getScreenSafeArea() + 2 : y + 5;
            ScreenSafeArea.drawPositiveNegativeShadowedText(matrices, text, x + 30, textY, options().getHudOptions().getTextColor());

            y -= 25;
        }
    }

}
