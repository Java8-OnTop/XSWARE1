package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.BooleanSetting;
import me.xss6.xsware.setting.type.EnumSetting;
import net.minecraft.util.ResourceLocation;
import java.util.Arrays;


import java.util.Locale;

@Module.Registration(name = "Shaders", description = "huge module", category = Module.Category.RENDER)
public class Shaders extends Module {
    //testeststests
    public EnumSetting type = new EnumSetting("Mode", "Flip", Arrays.asList("AntiAlias", "Art", "Bits", "Blobs", "Blobs2", "Blur", "Bumpy", "Color_Convolve", "Creeper", "Deconverge", "Desaturate", "flip", "fxaa", "Green", "Invert", "Notch", "ntsc", "Outline", "Pencil", "Phosphor", "Scan_Pincushion", "Sobel", "Spider", "Wobble"), this);
    public BooleanSetting onlyInGui = new BooleanSetting("OnlyInGui", false, this);
    private boolean loaded = false;

    @Override
    public void onUpdate() {
        if (onlyInGui.getValue()) {
            if (mc.currentScreen != null && !loaded) {
                mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/" + (type.getValue().toLowerCase(Locale.ROOT) + ".json")));
                loaded = true;
            } else if (mc.entityRenderer.isShaderActive() && mc.currentScreen == null) {
                loaded = false;
                mc.entityRenderer.getShaderGroup().deleteShaderGroup();
            }
        } else if (!mc.entityRenderer.isShaderActive()){
            mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/" + (type.getValue().toLowerCase(Locale.ROOT) + ".json")));
        }
    }



    @Override
    public void onSettingChange() {
        if (mc.entityRenderer.isShaderActive())
            mc.entityRenderer.getShaderGroup().deleteShaderGroup();
        mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/" + (type.getValue().toLowerCase(Locale.ROOT) + ".json")));
    }

    @Override
    public void onDisable() {
        if (mc.entityRenderer.isShaderActive()) {
            mc.entityRenderer.getShaderGroup().deleteShaderGroup();
        }
    }
}
