package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;

@Module.Registration(name = "Small Shield", description = "shields block my epic gamer view", category = Module.Category.RENDER, isListening = false)
public class SmallShield extends Module {

    @Override
    public void onUpdate() {
        mc.entityRenderer.itemRenderer.equippedProgressOffHand = -1;
    }

}
