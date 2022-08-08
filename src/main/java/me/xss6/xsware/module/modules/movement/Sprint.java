package me.xss6.xsware.module.modules.movement;

import me.xss6.xsware.event.events.MoveEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.EnumSetting;

import java.util.Arrays;

@Module.Registration(name = "Sprint", description = "sprints automatically", category = Module.Category.MOVEMENT)
public class Sprint extends Module {

    public EnumSetting mode = new EnumSetting("Mode", "Legit", Arrays.asList("legit", "Rage"), this);

    @CommitEvent
    public void onMove(MoveEvent event) {
        if (event.getStage() == 1 && this.mode.is("Rage") && (mc.player.movementInput.moveForward != 0f ||
                mc.player.moveStrafing != 0f)) {
            event.setCancelled(true);
        }
    }

    @Override
    public void onUpdate() {
        if(nullCheck())return;
        if (mode.is("Legit")) {
            if (mc.gameSettings.keyBindForward.isKeyDown()) {
                mc.player.setSprinting(true);
            }
        } else {
            mc.player.setSprinting(true);
        }
    }

    @Override
    public String getDisplayInfo() {
        return mode.getValue();
    }
}
