package me.xss6.xsware.util;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.module.Module;

public class HackUtil implements Globals {

    public static boolean shouldPause(Module module) {
        if (XSWARE.Modules.ishackEnabled("Surround") && !module.getName().equalsIgnoreCase("Surround")) {
            return true;
        }
        return false;
    }

}
