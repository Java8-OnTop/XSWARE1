package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;

@Hack.Registration(name = "FullBright", description = "Increases Brightnesss", category = Hack.Category.RENDER, isListening = false)
public class FullBright extends Module {



    private float previousValue = 0;
    @Override
    public void onDisable(){
        mc.getMinecraft().gameSettings.gammaSetting = previousValue;
    }
    @Override
    public void onEnable(){
        previousValue = mc.getMinecraft().gameSettings.gammaSetting;
        mc.getMinecraft().gameSettings.gammaSetting = 16;
    }
}
