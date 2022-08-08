package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.util.ClientMessage;
import org.lwjgl.input.Keyboard;

public class BindCommand extends Command {

    public BindCommand() {
        super("Bind");
    }

    @Override
    public void execute(String[] message) {
        if (message.length != 2) {
            ClientMessage.sendErrorMessage("Invalid format");
            return;
        }
        String name = message[0].replaceAll("_", " ");
        Module module = XSWARE.Modules.getHackByName(name);
        if (module == null) {
            ClientMessage.sendErrorMessage("Cannot find module " + ChatFormatting.BOLD + name);
            return;
        }
        String bindName = message[1];
        if (bindName.equalsIgnoreCase("none")) {
            ClientMessage.sendMessage("Removed bind for " + module.getName());
            module.setBind(-1);
            return;
        }
        int key = Keyboard.getKeyIndex(bindName.toUpperCase());
        if (key == 0) {
            ClientMessage.sendErrorMessage("Unknown key");
        } else {
            module.setBind(key);
            ClientMessage.sendMessage(module.getName() + " set bind to " + module.getBindName());
        }
    }
}
