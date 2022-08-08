package me.xss6.xsware.module.modules.chat;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.module.ModulePriority;
import me.xss6.xsware.setting.type.BooleanSetting;

@Module.Registration(name = "Toggle Msgs", description = "Says in chat when you toggle something", category = Module.Category.CHAT, priority = ModulePriority.Lowest)
public class ToggleMessages extends Module {

    public static ToggleMessages INSTANCE;

    public ToggleMessages() {
        INSTANCE = this;
    }

    public BooleanSetting compact = new BooleanSetting("Compact", true, this);
}
