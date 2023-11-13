package com.fantasticalraces.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.core.jmx.Server;

public class CustomPackets {
    public static final Identifier RACE_SELECTION = new Identifier("fantasticalraces", "race_selection");

    public static void register(){
        System.out.println("Server-side packet handler registered for race selection.");
        ServerPlayNetworking.registerGlobalReceiver(RACE_SELECTION, ((server, player, handler, buf, responseSender) -> {

            RaceSelectionPacket packet = RaceSelectionPacket.fromBuffer(buf);
            String selectedRace = packet.getSelectedRace();



            System.out.println("Selected Race: " + selectedRace);

        }));
    }
}
