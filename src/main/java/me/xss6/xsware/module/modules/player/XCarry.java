package me.xss6.xsware.module.modules.player;

import me.xss6.xsware.event.events.PacketEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.event.processor.EventPriority;
import me.xss6.xsware.module.Module;
import net.minecraft.network.play.client.CPacketCloseWindow;

@Module.Registration(name = "XCarry", description = "carrys stuff", category = Module.Category.PLAYER)
public class XCarry extends Module {

    @CommitEvent(priority = EventPriority.LOW)
    public void onCloseGuiScreen(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketCloseWindow) {
            CPacketCloseWindow packet = event.getPacket();
            if (packet.windowId == XCarry.mc.player.inventoryContainer.windowId) {
                event.setCancelled(true);
            }
        }
    }

}
