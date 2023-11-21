package com.fantasticalraces.packet;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;
import java.util.function.Consumer;

public class RaceSelectionPacket {
    private final String _selectedRace;
    private static String selectedRace;
    private static ServerPlayerEntity serverPlayer;

    {
        serverPlayer = serverPlayerMap.get(this);
    }

    private static final HashMap<ServerPlayerEntity, RaceSelectionPacket> playerRaceMap = new HashMap<>();
    private static final HashMap<RaceSelectionPacket, ServerPlayerEntity> serverPlayerMap = new HashMap<>();

    public RaceSelectionPacket(String _selectedRaceName) {
        this._selectedRace = _selectedRaceName;
        System.out.println(_selectedRace);

    }
    public static void sendToServer(ServerPlayerEntity player, String selectedRace){
        RaceSelectionPacket.selectedRace = selectedRace;
        RaceSelectionPacket packet = new RaceSelectionPacket(selectedRace);
        PacketByteBuf buf = PacketByteBufs.create();
        packet.toBuffer(packet, buf);
        ServerPlayNetworking.send(player, CustomPackets.RACE_SELECTION, buf);
        playerRaceMap.put(player, packet);
        serverPlayerMap.put(packet, player);

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
        buf.writeString(packet._selectedRace);
    }

    public static String getSelectedRace(){
        return selectedRace;
    }

    public static ServerPlayerEntity getPlayer(){
        return serverPlayer;
    }
}
