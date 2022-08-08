package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.util.ClientMessage;

public class panic extends Command {

    public panic() {
        super("Panic", "P");
    }

    @Override
    public void execute(String[] message) {
        try {
            for(Module h : XSWARE.HACKS.getModules()) {
                if(h == null)
                {
                    continue;
                }
                if(h.isEnabled()) {
                    h.toggle();
                }

            }
        }catch (Exception ex){}

    }
}
