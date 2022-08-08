package me.xss6.xsware.module.modules.player;

import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.BooleanSetting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemExpBottle;

@Module.Registration(name = "AutoRespawn", description = "Respawns you automatically on death", category = Module.Category.PLAYER)
public class AutoRespawn extends Module {
    @Override
    public void onTick() {
        if(mc.player.isDead)
        {
            mc.player.respawnPlayer();
        }

    }
}
