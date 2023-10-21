package com.fantasticalraces.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ClientPacketHandler {
    //public static final Identifier PACKET_ID = new Identifier("fantasticalraces", "race_selection");

    public static void init(){
        System.out.println("Client-side packet handler registered for race selection.");
        ClientPlayNetworking.registerGlobalReceiver(CustomPackets.RACE_SELECTION, (client, handler, buf, responseSender) -> {
           RaceSelectionPacket packet = RaceSelectionPacket.fromBuffer(buf);
           String selectedRace = packet.getSelectedRace();
           System.out.println("Selected Race on Client: " + selectedRace);
        });
    }
}
