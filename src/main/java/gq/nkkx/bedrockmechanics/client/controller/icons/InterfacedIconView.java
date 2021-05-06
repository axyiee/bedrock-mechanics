package gq.nkkx.bedrockmechanics.client.controller.icons;

import java.util.Map;

public interface InterfacedIconView {

    static ControllerIcon getControllerIcon(int button, Map<Integer, ControllerIcon> icons, InterfacedIconView fallbackIconView) {
        ControllerIcon icon = icons.get(button);
        return icon == null ? fallbackIconView.getIconFromButton(button) : icon;
    }

    ControllerIcon getIconFromButton(int button);

}
