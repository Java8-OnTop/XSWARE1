package me.xss6.xsware.module.modules.player;



import com.mojang.realmsclient.gui.ChatFormatting;
import io.netty.buffer.Unpooled;
import me.xss6.xsware.event.events.PacketEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.event.processor.EventPriority;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.module.ModulePriority;
import me.xss6.xsware.util.ClientMessage;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

@Module.Registration(name = "Death Coords", description = "Displays coords on death", category = Module.Category.PLAYER, priority = ModulePriority.Low)
public class DeathCoords extends Module {
private float previousX = 0;
private float previousY =0 ;
private float previousZ = 0;
    @Override
    public void onTick() {
        if(mc.player.isDead)
        {
            if(mc.player.getPosition().getX() == previousX && mc.player.getPosition().getY() == previousY && mc.player.getPosition().getZ() == previousZ) {

            }
            else {
                ClientMessage.sendMessage(ChatFormatting.BOLD + "" +  ChatFormatting.RED + " >> You died at " + mc.player.getPosition().getX() + ", " + mc.player.getPosition().getY() + ", " + mc.player.getPosition().getZ() + ".");
                previousX = mc.player.getPosition().getX();
                previousY = mc.player.getPosition().getY();
                previousZ = mc.player.getPosition().getZ();
            }
}
}
}
