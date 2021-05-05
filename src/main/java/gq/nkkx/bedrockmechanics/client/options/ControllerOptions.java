package gq.nkkx.bedrockmechanics.client.options;

import com.google.gson.annotations.SerializedName;
import gq.nkkx.bedrockmechanics.BedrockMechanics;
import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.registry.ControllerRegistry;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ControllerOptions {

    @SerializedName("selected_controller")
    private int selectedControllerId;

    @SerializedName("is_enabled")
    private boolean isEnabled;

    @SerializedName("dead_zone")
    private float deadZone;

    public Controller getSelectedController() {
        if (selectedControllerId == -1) {
            return null;
        }
        return ControllerRegistry.getInstance().withId(selectedControllerId).orElse(null);
    }

    public void setSelectedController(Controller controller) {
        BedrockMechanics.getLogger().info("Setting current controller to " + controller.getId());
        setSelectedControllerId(controller.getId());
    }

}
