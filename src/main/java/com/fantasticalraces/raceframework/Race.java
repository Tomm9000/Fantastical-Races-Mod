package com.fantasticalraces.raceframework;

import com.fantasticalraces.packet.RaceSelectionPacket;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.List;

public abstract class Race {
    private String name;
    private Identifier id;
    private List<EntityAttributeModifier> customAttributes;

    public Race(String name, Identifier id, List<EntityAttributeModifier> attributeModifiers){
        this.name = name;
        this.id = id;
        this.customAttributes = attributeModifiers;
    }

    public String getName(){
        return name;
    }
    public Identifier getId(){
        return id;
    }

    public List<EntityAttributeModifier> getAttributeModifiers(){
        return customAttributes;
    }
}


