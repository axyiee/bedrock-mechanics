package gq.nkkx.bedrockmechanics.client.options;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MechanicsOptions {

    @SerializedName("allow_fast_block_placement")
    private boolean allowFastBlockPlacement;

    @SerializedName("key_binding_look_speed")
    private float keyBindingLookSpeed;

}
