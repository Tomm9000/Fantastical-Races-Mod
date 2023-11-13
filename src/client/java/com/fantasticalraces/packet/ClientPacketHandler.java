package com.fantasticalraces.packet;

import com.fantasticalraces.raceframework.races.DeathlessOneRace;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

public class ClientPacketHandler {

    public static void init(ServerPlayerEntity player){
        System.out.println("Client-side packet handler registered for race selection.");
        ClientPlayNetworking.registerGlobalReceiver(CustomPackets.RACE_SELECTION, (client, handler, buf, responseSender) -> {
           RaceSelectionPacket packet = RaceSelectionPacket.fromBuffer(buf);
           String selectedRace = packet.getSelectedRace();
           System.out.println("Selected Race on Client: " + selectedRace);
        });
    }
}
