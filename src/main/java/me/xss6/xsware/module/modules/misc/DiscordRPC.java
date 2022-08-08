package me.xss6.xsware.module.modules.misc;

import me.xss6.xsware.RPC;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.module.ModulePriority;


@Module.Registration(name = "Discord RPC", description = "It is discordrpc !", category = Module.Category.MISC, priority = ModulePriority.Lowest)
public class DiscordRPC extends Module {


    public void onEnable() {
        RPC.startRPC();
    }

    public void onDisable() {
        RPC.stopRPC();
    }
}
