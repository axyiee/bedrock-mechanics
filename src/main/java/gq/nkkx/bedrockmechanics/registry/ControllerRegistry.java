package gq.nkkx.bedrockmechanics.registry;

import gq.nkkx.bedrockmechanics.controller.Controller;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class ControllerRegistry {

    private static final ControllerRegistry INSTANCE = new ControllerRegistry();
    private final Set<Controller> controllers;

    private ControllerRegistry() {
        controllers = new LinkedHashSet<>();
    }

    public static ControllerRegistry getInstance() {
        return INSTANCE;
    }

    public Optional<Controller> withId(int id) {
        return getControllers()
            .stream()
            .filter((controller) -> controller.getId() == id)
            .findFirst();
    }

    public Set<Controller> getControllers() {
        return controllers;
    }

    public boolean register(Controller controller) {
        return this.controllers.add(controller);
    }

    public void unregister(Controller controller) {
        this.controllers.remove(controller);
    }

    public void cleanup() {
        controllers.removeIf((controller) -> !controller.isConnected());
    }

}
