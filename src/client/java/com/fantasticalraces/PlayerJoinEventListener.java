package com.fantasticalraces;
import com.fantasticalraces.gui.RaceSelectionGUI;
import com.fantasticalraces.gui.RaceSelectionScreen;
import com.fantasticalraces.packet.RaceSelectionPacket;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerJoinEventListener{
    private static final Set<ServerPlayerEntity> joinedPlayers = ConcurrentHashMap.newKeySet();
    private static boolean screenSet = false;
    public static void init(){
        ServerPlayConnectionEvents.INIT.register((handler, server) -> {
            ServerPlayerEntity player = handler.player;
            if (!joinedPlayers.contains(player)){
                handlePlayerJoin(player);
                joinedPlayers.add(player);
            }
            else if(joinedPlayers.contains(player)){
                player.sendMessage(Text.of("i already chose " + OnPlayerJoinBack()));
            }
        });
    }
    private static void handlePlayerJoin(ServerPlayerEntity player){

        ClientTickCallback.EVENT.register(client -> {
            if (!screenSet && client != null && client.world != null){
                MinecraftClient.getInstance().setScreen(new RaceSelectionScreen(new RaceSelectionGUI(player)));
                System.out.println("Open Menu");
                screenSet = true;
            }
        });
    }
    private static String OnPlayerJoinBack(){
        return RaceSelectionPacket.getSelectedRace();
    }
}
