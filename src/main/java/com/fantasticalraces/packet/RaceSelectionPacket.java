package com.fantasticalraces.packet;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class RaceSelectionPacket {
    private final String selectedRace;
    //public static final Identifier PACKET_ID = new Identifier("fantasticalraces", "race_selection");

    public RaceSelectionPacket(String selectedRace) {
        this.selectedRace = selectedRace;
    }
    public static void sendToServer(ServerPlayerEntity player, String selectedRace){
        RaceSelectionPacket packet = new RaceSelectionPacket(selectedRace);
        PacketByteBuf buf = PacketByteBufs.create();
        packet.toBuffer(packet, buf);
        ServerPlayNetworking.send(player, CustomPackets.RACE_SELECTION, buf);
    }

    public static RaceSelectionPacket fromBuffer(PacketByteBuf buf){
        try {
            String selectedRace = buf.readString(32767);
            System.out.println("Received Selected Race: " + selectedRace);
            return new RaceSelectionPacket(selectedRace);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return new RaceSelectionPacket("Invalid Race Data");
        }

    }

    public static void toBuffer(RaceSelectionPacket packet, PacketByteBuf buf){
        buf.writeString(packet.selectedRace);
    }

    public String getSelectedRace(){
        return selectedRace;
    }
}
