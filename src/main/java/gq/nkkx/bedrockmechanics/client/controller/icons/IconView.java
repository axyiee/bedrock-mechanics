package gq.nkkx.bedrockmechanics.client.controller.icons;

public class IconView {

    public static InterfacedIconView GENERIC_VIEW = new GenericIconView();
    public static InterfacedIconView PLAYSTATION_VIEW = new PlayStationIconView(GENERIC_VIEW);
    public static InterfacedIconView XBOX_VIEW = new XboxIconView(GENERIC_VIEW);

    public static InterfacedIconView byType(Type type) {
        switch (type) {
            case XBOX:
                return XBOX_VIEW;
            case PLAYSTATION:
                return PLAYSTATION_VIEW;
            default:
                return GENERIC_VIEW;
        }
    }

    public enum Type {
        GENERIC,
        PLAYSTATION,
        XBOX
    }

}
