package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.util.ClientMessage;

public class DrawnCommand extends Command {

    public DrawnCommand() {
        super("Drawn");
    }

    @Override
    public void execute(String[] message) {
        Module module = XSWARE.Modules.getHackByName(message[0].replaceAll("_", " "));
        if (module == null) {
            ClientMessage.sendErrorMessage("Cannot find module by name " + ChatFormatting.BOLD + message[0]);
            return;
        }
        if (XSWARE.Modules.isDrawHack(module)) {
            XSWARE.Modules.removeDrawnHack(module);
            ClientMessage.sendMessage("Removed " + ChatFormatting.BOLD + module.getName() + ChatFormatting.RESET + " from drawn list");
        } else {
            XSWARE.Modules.addDrawHack(module);
            ClientMessage.sendMessage("Added " + ChatFormatting.BOLD + module.getName() + ChatFormatting.RESET + " to drawn list");
        }
    }
}
