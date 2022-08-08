package me.xss6.xsware.module.modules.chat;

import me.xss6.xsware.module.Module;

@Module.Registration(name = "Clear Chatbox", description = "makes the chatbox clear", category = Module.Category.CHAT, isListening = false)
public class ClearChatbox extends Module {

    public static ClearChatbox INSTANCE;

    public ClearChatbox() {
        INSTANCE = this;
    }

}
