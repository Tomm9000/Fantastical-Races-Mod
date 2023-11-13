package com.fantasticalraces;

import com.fantasticalraces.packet.CustomPackets;
import com.fantasticalraces.packet.RaceSelectionPacket;
import com.fantasticalraces.raceframework.Race;
import com.fantasticalraces.raceframework.RaceManager;
import com.fantasticalraces.raceframework.races.DeathlessOneRace;
import com.fantasticalraces.raceframework.races.HumanRace;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.fabricmc.api.ModInitializer;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class FantasicalRaces implements ModInitializer {
	public static final String MOD_ID = "fantasticalraces";
	private float baseHealthModifier;

    public static final Logger LOGGER = LoggerFactory.getLogger("fantasical-races");

	@Override
	// basically start
	public void onInitialize() {
		CustomPackets.register();

		HumanRace humanRace = new HumanRace();
		RaceManager.registerRace(humanRace);

		DeathlessOneRace deathlessOneRace = new DeathlessOneRace();
		RaceManager.registerRace(deathlessOneRace);
	}
}