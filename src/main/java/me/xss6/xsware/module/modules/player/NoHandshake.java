package me.xss6.xsware.module.modules.player;



import io.netty.buffer.Unpooled;
import me.xss6.xsware.event.events.PacketEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.event.processor.EventPriority;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.module.ModulePriority;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

/**
 * XSS6 moment
 * @author Ronald(K3B)Jones SKIDDED
 * @since 07/05/2005
 */

@Module.Registration(name = "No Handshake", description = "Do not shake hand", category = Module.Category.PLAYER, priority = ModulePriority.Low)
public class NoHandshake extends Module {

    @CommitEvent(priority = EventPriority.LOW)
    public void onPacketSend(PacketEvent.Send event) {
        CPacketCustomPayload packet;
        if (event.getPacket() instanceof FMLProxyPacket && !mc.isSingleplayer()) {
            event.setCancelled(true);
        }
        if (event.getPacket() instanceof CPacketCustomPayload && (packet = (CPacketCustomPayload)event.getPacket()).getChannelName().equals("MC|Brand")) {
            packet.data = new PacketBuffer(Unpooled.buffer()).writeString("vanilla");
        }
    }
}
