package com.fantasticalraces.raceframework;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;

import java.rmi.registry.Registry;

public class ModAttributes {
    public static final EntityAttribute CUSTOM_MAX_HEALTH = new ClampedEntityAttribute("mod:custom_max_health", 10.0D, 0.0D, 1024.0D).setTracked(true);

    public static void registerCustomAttributes() {
        // Register your custom attributes
        EntityAttributes.put(CUSTOM_MAX_HEALTH);
    }
}
