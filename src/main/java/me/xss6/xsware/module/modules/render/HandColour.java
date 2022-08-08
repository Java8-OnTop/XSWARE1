package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.ColourSetting;
import me.xss6.xsware.util.elements.Colour;

@Module.Registration(name = "Hand Colour", description = "colours hands", category = Module.Category.RENDER, isListening = false)
public class HandColour extends Module {

    public static HandColour INSTANCE;

    public HandColour() {
        INSTANCE = this;
    }

    public ColourSetting colour = new ColourSetting("Colour", new Colour(255, 255, 255, 150), this);

}
