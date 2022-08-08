package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.util.ClientMessage;

public class ListCommand extends Command {

    public ListCommand() {
        super("List", "L");
    }

    @Override
    public void execute(String[] message) {
        ClientMessage.sendMessage(ChatFormatting.BOLD + "Hack list");
        String cat = "";
        if (message.length >= 1) {
            cat = message[0];
        }
        for (Module.Category category : Module.Category.values()) {
            if (!cat.equalsIgnoreCase("") && !cat.equalsIgnoreCase(category.getName())) continue;
            ClientMessage.sendMessage(ChatFormatting.BOLD + category.getName());
            for (Module module : XSWARE.Modules.getHacksByCategory(category)) {
                ClientMessage.sendMessage(module.getName() + " : " + module.getDescription());
            }
        }
    }
}
