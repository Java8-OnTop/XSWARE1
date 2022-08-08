package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.DoubleSetting;

/**
 * @author XSS6
 * @since 03/05/2021
 */
@Module.Registration(name = "Item Physics", description = "Apply physics to items", category = Module.Category.RENDER, isListening = false)
public class ItemPhysics extends Module {
    public static ItemPhysics INSTANCE;

    public ItemPhysics(){
        INSTANCE = this;
    }

    public DoubleSetting Scaling = new DoubleSetting("Scaling", 0.5, 0.0, 10.0, this);
}
