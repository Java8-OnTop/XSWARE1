package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.util.ClientMessage;

public class ToggleCommand extends Command {

    public ToggleCommand() {
        super("Toggle", "T");
    }

    @Override
    public void execute(String[] message) {
        String name = message[0].replaceAll("_", " ");
        Module module = XSWARE.Modules.getHackByName(name);
        if (module != null) {
            module.toggle();
        } else {
            ClientMessage.sendErrorMessage("Cannot find module by name " + ChatFormatting.BOLD + name);
        }
    }
}
