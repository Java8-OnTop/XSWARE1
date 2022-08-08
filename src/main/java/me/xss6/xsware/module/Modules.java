package me.xss6.xsware.module;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.event.events.Render3DEvent;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.util.Globals;
import me.xss6.xsware.util.ReflectionUtil;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Modules implements Globals {

    private final List<Module> modules = new ArrayList<>();
    private final List<Module> drawnModules = new ArrayList<>();

    public Modules() {

        try {
            ArrayList<Class<?>> modClasses = ReflectionUtil.getClassesForPackage("me.xss6.xsware.module.modules");
            modClasses.spliterator().forEachRemaining(aClass -> {
                if(Module.class.isAssignableFrom(aClass)) {
                    try {
                        Module module = (Module) aClass.getConstructor().newInstance();
                        modules.add(module);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            modules.sort(Comparator.comparing(Module::getPriority));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final List<Module> getHacks() {
        return this.modules;
    }

    public final List<Module> getDrawnHacks() {
        return this.drawnModules;
    }

    public final boolean isDrawHack(Module module) {
        return this.drawnModules.contains(module);
    }

    public final void addDrawHack(Module module) {
        this.drawnModules.add(module);
    }

    public final void removeDrawnHack(Module module) {
        if (!isDrawHack(module)) return;
        this.drawnModules.remove(module);
    }

    public final Module getHackByName(String name) {
        for (Module module : this.modules) {
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }

    public final void enablehack(String name) {
        this.getHackByName(name).enable();
    }

    public final void disablehack(String name) {
        this.getHackByName(name).disable();
    }

    public final boolean ishackEnabled(String name) {
        try {
            return this.getHackByName(name).isEnabled();
        } catch (NullPointerException error) {
            return false;
        }
    }

    public final void onUpdate() {
        this.modules.stream().filter(Module::isEnabled).spliterator().forEachRemaining(Module::onUpdate);
        if (mc.currentScreen == null) {
            for (Module module : modules) {
                if (module.isHold() && module.getBind() >= 0) {
                    if (Keyboard.isKeyDown(module.getBind())) {
                        if (!module.isEnabled()) {
                            module.enable();
                        }
                    } else {
                        if (module.isEnabled()) {
                            module.disable();
                        }
                    }
                }
            }
        }
    }


    public final void onTick() {
        this.modules.stream().filter(Module::isEnabled).spliterator().forEachRemaining(Module::onTick);
    }

    public final void onRender2D(Render2DEvent event) {
        this.modules.stream().filter(Module::isEnabled).spliterator().forEachRemaining(hack -> hack.onRender2D(event));
    }

    public final void onRender3D(Render3DEvent event) {
        this.modules.stream().filter(Module::isEnabled).spliterator().forEachRemaining(hack -> hack.onRender3D(event));
    }

    public final void onLogout() {
        this.modules.spliterator().forEachRemaining(Module::onLogout);
    }

    public final void onLogin() {
        this.modules.spliterator().forEachRemaining(Module::onLogin);
    }

    public final void onUnload() {
        this.modules.forEach(MinecraftForge.EVENT_BUS::unregister);
        this.modules.forEach(XSWARE.EVENT_PROCESSOR::removeEventListener);
        this.modules.forEach(Module::onUnload);
    }

    public final void unloadAll() {
        for (Module module : this.modules) {
            module.disable();
        }
    }

    public final void onKeyDown(int key) {
        if (key <= 0 || mc.currentScreen instanceof XswareGuiNew) {
            return;
        }
        for (Module module : this.modules) {
            if (module.isHold()) continue;
            if (module.getBind() == key) {
                module.toggle();
            }
        }
    }

    public final List<Module.Category> getCategories() {
        List<Module.Category> cats = new ArrayList<>();
        for (Module.Category category : Module.Category.values()) {
            if (category.getName().equalsIgnoreCase("hidden") || category.getName().equalsIgnoreCase("hud")) continue;
            cats.add(category);
        }
        return cats;
    }

    public final List<Module> getHacksByCategory(Module.Category cat) {
        List<Module> modules = new ArrayList<>();
        for (Module module : this.modules) {
            if (module.getCategory() == cat) {
                modules.add(module);
            }
        }
        modules.sort(Comparator.comparing(Module::getName));
        return modules;
    }

    public final List<Module> getEnabledHacks() {
        List<Module> modules = new ArrayList<>();
        for (Module module : this.modules) {
            if (module.isEnabled()) {
                modules.add(module);
            }
        }
        return modules;
    }

    public final List<Module> getHacksAlp() {
        List<Module> sortedModules = new ArrayList<>(this.modules);
        sortedModules.sort(Comparator.comparing(Module::getName));
        return sortedModules;
    }

    public final List<Module> getSortedHacks(boolean reverse, boolean customFont) {
        if (customFont) {
            if (reverse) {
                List<Module> list = this.getEnabledHacks().stream().sorted(Comparator.comparing(hack ->
                        XSWARE.GUI_FONT_MANAGER.getTextWidth(hack.getFullArrayString()))).collect(Collectors.toList());
                Collections.reverse(list);
                return list;
            }  else {
                return this.getEnabledHacks().stream().sorted(Comparator.comparing(hack ->
                        XSWARE.GUI_FONT_MANAGER.getTextWidth(hack.getFullArrayString()))).collect(Collectors.toList());
            }
        } else {
            if (reverse) {
                List<Module> list = this.getEnabledHacks().stream().sorted(Comparator.comparing(hack ->
                        mc.fontRenderer.getStringWidth(hack.getFullArrayString()))).collect(Collectors.toList());
                Collections.reverse(list);
                return list;
            }  else {
                return this.getEnabledHacks().stream().sorted(Comparator.comparing(hack ->
                        mc.fontRenderer.getStringWidth(hack.getFullArrayString()))).collect(Collectors.toList());
            }
        }
    }
}
