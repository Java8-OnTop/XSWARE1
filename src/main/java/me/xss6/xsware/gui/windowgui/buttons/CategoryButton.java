package me.xss6.xsware.gui.windowgui.buttons;

import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.util.Globals;

import java.util.ArrayList;

/**
 * @author XSS6
 * @since 06/07/2021
 */

public class CategoryButton implements Globals {
    public ArrayList<Component> components;
    public Module.Category category;


    public CategoryButton(Module.Category category){
        this.category = category;
        this.components = new ArrayList<>();
    }
}
