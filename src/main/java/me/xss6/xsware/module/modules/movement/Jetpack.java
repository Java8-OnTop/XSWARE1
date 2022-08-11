package me.xss6.xsware.module.modules.movement;

import me.xss6.xsware.module.Module;

@Hack.Registration(name = "Jetpack", description = "weeee", category = Module.Category.MOVEMENT, isListening = false)
public class Jetpack extends Module{
    @Override
    public void onTick() {
        if(mc.getMinecraft().gameSettings.keyBindJump.pressed)
        {
            mc.getMinecraft().player.jump();
        }
    }
}
