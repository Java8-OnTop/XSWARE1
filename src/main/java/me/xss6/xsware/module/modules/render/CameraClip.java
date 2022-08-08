package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.DoubleSetting;

@Module.Registration(name = "Camera Clip", description = "f5 mode", category = Module.Category.RENDER, isListening = false)
public class CameraClip extends Module {

    public static CameraClip INSTANCE;

    public CameraClip() {
        INSTANCE = this;
    }

    public DoubleSetting distance = new DoubleSetting("Distance", 10.0, -10.0, 50.0, this);

}
