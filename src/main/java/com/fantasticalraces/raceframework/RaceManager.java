package com.fantasticalraces.raceframework;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    private static final List<Race> races = new ArrayList<>();

    public static void registerRace(Race race){ races.add(race); }

    public List<Race> getRaces(){ return races; }
}
