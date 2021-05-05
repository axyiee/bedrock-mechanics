package gq.nkkx.bedrockmechanics.client.options;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GuiOptions {

    @SerializedName("is_enabled")
    private boolean isEnabled;

    @SerializedName("is_paper_doll_enabled")
    private boolean isPaperDollEnabled;

    @SerializedName("show_position")
    private boolean showPosition;

    @SerializedName("show_fps")
    private boolean showFPS;

    @SerializedName("paper_doll_rotation")
    private int paperDollRotation;

    @SerializedName("paper_doll_scale")
    private int paperDollScale;

    @SerializedName("position_y")
    private int guiPositionY;

    @SerializedName("position_x")
    private int guiPositionX;

    @SerializedName("screen_safe_area")
    private int screenSafeArea;

}
