package me.xss6.xsware.module.modules.player;

import me.xss6.xsware.module.Module;

@Module.Registration(name = "Multi Task", description = "eat n shit", category = Module.Category.PLAYER, isListening = false)
public class MultiTask extends Module {

    public static MultiTask INSTANCE;

    public MultiTask() {
        INSTANCE = this;
    }

}
