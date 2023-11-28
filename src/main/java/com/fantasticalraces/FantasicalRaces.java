package com.fantasticalraces;

import com.fantasticalraces.packet.CustomPackets;
import com.fantasticalraces.packet.RaceSelectionPacket;
import com.fantasticalraces.raceframework.RaceManager;
import com.fantasticalraces.raceframework.customraceattributes.RaceDeathHandler;
import com.fantasticalraces.raceframework.races.DeathlessOneRace;
import com.fantasticalraces.raceframework.races.HumanRace;
import net.fabricmc.api.ModInitializer;

public class FantasicalRaces implements ModInitializer {

	//!TODO for easier readability maybe change all instances of the mod ID with this variable
	public static final String MOD_ID = "fantasticalraces";
	@Override
	// basically start
	public void onInitialize() {
		CustomPackets.register();

		HumanRace humanRace = new HumanRace();
		RaceManager.registerRace(humanRace);

		DeathlessOneRace deathlessOneRace = new DeathlessOneRace();
		RaceManager.registerRace(deathlessOneRace);

		RaceDeathHandler.InitDeathEvent(RaceSelectionPacket.getPlayer());
	}
}