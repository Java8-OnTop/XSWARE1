package me.xss6.xsware.module.modules.movement;

import me.xss6.xsware.module.Module;

@Module.Registration(name = "Slippers", description = "Oh no I hope I don't fall", category = Module.Category.MOVEMENT, isListening = false)
public class Slippers extends Module{
    @Override
    public void onTick() {
        mc.player.onGround = false;
    }
}
