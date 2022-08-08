package me.xss6.xsware.module.modules.render;

import me.xss6.xsware.event.events.PerspectiveEvent;
import me.xss6.xsware.event.processor.CommitEvent;
import me.xss6.xsware.event.processor.EventPriority;
import me.xss6.xsware.module.Module;
import me.xss6.xsware.setting.type.DoubleSetting;

/**
 * @author SankuGG
 * @since 01/05/2021
 *  -> src from prism
 */

@Module.Registration(name = "Aspect", description = "Does aspect shit", category = Module.Category.RENDER, isListening = false)
public class Aspect extends Module {
    DoubleSetting aspect = new DoubleSetting("Aspect",  mc.displayWidth / mc.displayHeight + 0.0, 0.0 ,3.0, this);

    @CommitEvent(priority = EventPriority.LOW)
    public void onPerspectiveEvent(PerspectiveEvent event){
        event.setAspect(aspect.getValue().floatValue());
    }
}
