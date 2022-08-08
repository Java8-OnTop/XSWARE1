package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.IntSetting;

@Module.Registration(name = "Fov", description = "tabbott mode", category = Module.Category.RENDER, isListening = false)
public class Fov extends Module {

    IntSetting fov = new IntSetting("Fov", 130, 90, 179, this);

    float fovOld;

    @Override
    public void onEnable(){
        fovOld = mc.gameSettings.fovSetting;
    }

    @Override
    public void onUpdate() {
        mc.gameSettings.fovSetting = (float) fov.getValue();
    }

    @Override
    public void onDisable(){
        mc.gameSettings.fovSetting = fovOld;
    }
}
