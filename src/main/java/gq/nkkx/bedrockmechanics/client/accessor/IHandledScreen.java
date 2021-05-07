package gq.nkkx.bedrockmechanics.client.accessor;

import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public interface IHandledScreen {

    void bedrock_mechanics$onMouseClick(Slot slot, int invSlot, int clickData, SlotActionType actionType);

    Slot bedrock_mechanics$getCurrentSlot();

    void bedrock_mechanics$onClose();

}
