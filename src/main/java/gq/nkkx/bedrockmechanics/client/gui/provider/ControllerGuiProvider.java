package gq.nkkx.bedrockmechanics.client.gui.provider;
import gq.nkkx.bedrockmechanics.client.controller.Controller;
import gq.nkkx.bedrockmechanics.registry.ControllerRegistry;

public class ControllerGuiProvider implements IGuiProvider<Controller> {

    @Override
    public Iterable<Controller> index() {
        return ControllerRegistry.getInstance().getControllers();
    }

    @Override
    public String toString(Controller value) {
        return value != null ? value.getName() : "";
    }

    @Override
    public Controller fromId(int id) {
        return ControllerRegistry.getInstance().withId(id).orElse(null);
    }

}
