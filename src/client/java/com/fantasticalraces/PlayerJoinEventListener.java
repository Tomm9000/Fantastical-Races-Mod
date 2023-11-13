package com.fantasticalraces;
import com.fantasticalraces.Data.PlayerData;
import com.fantasticalraces.gui.RaceSelectionGUI;
import com.fantasticalraces.gui.RaceSelectionScreen;
import com.fantasticalraces.packet.RaceSelectionPacket;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerJoinEventListener{
    private static final Set<ServerPlayerEntity> joinedPlayers = ConcurrentHashMap.newKeySet();

    private static final HashMap<ServerPlayerEntity, PlayerData> playerDataMap = new HashMap<>();
    private static boolean screenSet = false;
    public static void init(){
        ServerPlayConnectionEvents.INIT.register((handler, server) -> {
            ServerPlayerEntity player = handler.player;
            if (!joinedPlayers.contains(player)){
                handlePlayerJoin(player);
                joinedPlayers.add(player);
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
        PlayerData playerData = new PlayerData();
        playerDataMap.put(player, playerData);
    }
}
