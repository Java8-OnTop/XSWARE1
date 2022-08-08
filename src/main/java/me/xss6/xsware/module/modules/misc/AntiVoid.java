package me.xss6.xsware.module.modules.misc;

import io.netty.util.internal.ConcurrentSet;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.module.ModulePriority;
import me.xss6.xsware.util.PlayerUtil;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

import java.util.List;

import static me.xss6.xsware.util.PlayerUtil.getPlayerPos;

/**
 * @author XSS6
 * @since 28/04/2021
 *  - not china code i promise!
 */
@Module.Registration(name = "Anti Void", description = "stops dumb ppl (you) falling into the void", category = Module.Category.MISC, priority = ModulePriority.High)
public class AntiVoid extends Module {

    private ConcurrentSet<BlockPos> voidHoles;

    public void onUpdate(){
        if(nullCheck())return;
        if (mc.player.getPosition().getY() > 1) {
            return;
        }
        if (voidHoles == null) {
            voidHoles = new ConcurrentSet<>();
        }
        else {
            voidHoles.clear();
        }

        List<BlockPos> blockPosList = PlayerUtil.getSphere(PlayerUtil.getPlayerPos(), 10, 6, false, true, 0);

        for (BlockPos blockPos : blockPosList) {
            if (mc.world.getBlockState(blockPos).getBlock().equals(Blocks.BEDROCK) || mc.world.getBlockState(blockPos).getBlock().equals(Blocks.OBSIDIAN)) {
                continue;
            }
            if (isAnyBedrock(blockPos, Offsets.center)) {
                continue;
            }
            voidHoles.add(blockPos);
        }


        if(voidHoles.contains(new BlockPos(PlayerUtil.getPlayerPos().getX(), PlayerUtil.getPlayerPos().getY() - 2, PlayerUtil.getPlayerPos().getZ()))){
            mc.player.motionY = 0.1;
        }
    }

    private boolean isAnyBedrock(BlockPos origin, BlockPos[] offset) {
        for (BlockPos pos : offset) {
            if (mc.world.getBlockState(origin.add(pos)).getBlock().equals(Blocks.BEDROCK) || mc.world.getBlockState(origin.add(pos)).getBlock().equals(Blocks.OBSIDIAN)) {
                return true;
            }
        } return false;
    }

    private static class Offsets {
        static final BlockPos[] center = {
                new BlockPos(0, 0, 0),
                new BlockPos(0, 1, 0),
                new BlockPos(0, 2, 0)
        };
    }
}
