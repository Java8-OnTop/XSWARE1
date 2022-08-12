package me.xss6.xsware.module.modules.movement;

import me.xss6.xsware.module.Module;
import net.minecraft.client.Minecraft;
@Module.Registration(name = "Spider", description = "Spiderman, Spiderman", category = Module.Category.MOVEMENT, isListening = false)

public class Spider extends Module{

    public void onTick() {
        if(mc.player.collidedHorizontally) {
            Minecraft.getMinecraft().player.motionY = (0.2);
            Minecraft.getMinecraft().player.fallDistance = 0;


            if(Minecraft.getMinecraft().player.motionY < 0.15D) {
                Minecraft.getMinecraft().player.motionY = (-0.15D);
            }

        }
    }
}
