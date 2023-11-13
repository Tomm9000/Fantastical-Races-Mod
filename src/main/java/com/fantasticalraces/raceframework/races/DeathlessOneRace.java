package com.fantasticalraces.raceframework.races;

import com.fantasticalraces.packet.RaceSelectionPacket;
import com.fantasticalraces.raceframework.Race;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.*;

public class DeathlessOneRace extends Race {
    private static float deathlessHealthModifier = -4;

    public DeathlessOneRace() {
        super("The Deathless Ones", new Identifier("fantasticalraces", "deathless_ones"), new ArrayList<>());
    }

    public static void changeHealth(){
        System.out.println("Cyum");
        CustomBaseHealth(deathlessHealthModifier);
    }
}
