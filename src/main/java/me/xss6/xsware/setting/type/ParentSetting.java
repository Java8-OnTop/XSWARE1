package me.xss6.xsware.setting.type;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.Setting;

public class ParentSetting extends Setting<Boolean> {

    public ParentSetting(String name, Module parent) {
        super(name, false, parent);
    }

    public void toggle() {
        value = !value;
    }

    public boolean isShown(){
        return true;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String getType() {
        return "boolean";
    }
}
