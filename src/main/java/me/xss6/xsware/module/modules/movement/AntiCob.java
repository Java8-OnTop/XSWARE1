package me.xss6.xsware.module.modules.movement;

import me.xss6.xsware.module.Module;

@Module.Registration(name = "AntiCobweb", description = "Cobwebs don't work on me!!", category = Module.Category.MOVEMENT, isListening = false)
public class AntiCob extends Module {
    public void onTick() {
        mc.player.isInWeb = false;
    }
}
