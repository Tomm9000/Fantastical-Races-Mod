package com.fantasticalraces.raceframework.races;

import com.fantasticalraces.raceframework.Race;
import com.fantasticalraces.raceframework.customraceattributes.RaceHealthHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class DeathlessOneRace extends Race{

    public DeathlessOneRace() {
        super("The Deathless Ones", new Identifier("fantasticalraces", "deathless_ones"), new ArrayList<>());
    }

    public static void changeHealth(ServerPlayerEntity player){
        float deathlessHealthModifier = -4;
        RaceHealthHandler.setCustomBaseHealth(player, deathlessHealthModifier);
    }
}
