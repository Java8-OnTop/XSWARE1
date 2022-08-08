package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;

@Module.Registration(name = "Shulker Preview", description = "lets u see shulker contents", category = Module.Category.RENDER, isListening = false)
public class ShulkerPreview extends Module {

    public static ShulkerPreview INSTACE;

    public ShulkerPreview() {
        INSTACE = this;
    }

}
