package com.fantasticalraces.raceframework.races;

import com.fantasticalraces.raceframework.Race;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class HumanRace extends Race {
    public HumanRace(){
        super("HumanRace", new Identifier("fantasticalraces", "human"), new ArrayList<>());
    }

}

