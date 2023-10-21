package com.fantasticalraces.raceframework;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private static final List<Race> races = new ArrayList<>();

    public static void registerRace(Race race){ races.add(race); }

    public List<Race> getRaces(){ return races; }

    public Race getRaceId(Identifier id){
        return  races.stream()
                .filter(race -> race.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void applyRaceAttributes(PlayerEntity player, Race race) {
        for (EntityAttributeModifier modifier : race.getAttributeModifiers()) {
            player.getAttributeInstance(EntityAttribute.CUSTOM_MAX_HEALTH).
        }
    }

    public static Race getRaceByName(String name) {
        for (Race race : races) {
            if (race.getName().equals(name)) {
                return race;
            }
        }
        return null; // Race not found
    }
}
