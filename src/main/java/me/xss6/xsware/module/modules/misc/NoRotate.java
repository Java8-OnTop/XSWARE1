package me.xss6.xsware.module.modules.misc;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.module.ModulePriority;

@Module.Registration(name = "NoRotate", description = "Could cause desync", category = Module.Category.MISC, priority = ModulePriority.Lowest)
public class NoRotate extends Module {
    public static NoRotate INSTANCE;

    public NoRotate(){
        INSTANCE = this;
    }
}
