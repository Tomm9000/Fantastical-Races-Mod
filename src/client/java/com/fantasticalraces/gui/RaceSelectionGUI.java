package com.fantasticalraces.gui;

import com.fantasticalraces.packet.RaceSelectionPacket;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import com.fantasticalraces.raceframework.Race;
import com.fantasticalraces.raceframework.RaceManager;


public class RaceSelectionGUI extends LightweightGuiDescription {
    private static ServerPlayerEntity player;
    private final WGridPanel contentPanel;

    public RaceSelectionGUI(ServerPlayerEntity player){
        RaceSelectionGUI.player = player;

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(200, 150); // Set the size of the menu

        // Create the main content panel for buttons
        contentPanel = new WGridPanel();
        root.add(contentPanel, 0, 6, 9, 2); // Position and size of the button panel

        // Create buttons for each raceName
        createRaceButton("Human", 4, -5, 5, 1, player);
        createRaceButton("Deathless One", 4, -3, 5, 1, player);
    }

    private void createRaceButton(String race, int x, int y, int width, int height, ServerPlayerEntity player) {
        WButton raceButton = new WButton();
        raceButton.setLabel(Text.of("Select " + race + " Race"));
        raceButton.setOnClick(() -> onRaceButtonClicked(race, player));

        contentPanel.add(raceButton, x, y, width, height);
    }

    private void onRaceButtonClicked(String raceName, ServerPlayerEntity player) {
        System.out.println("Race selected: " + raceName);

        PacketByteBuf buf = PacketByteBufs.create();
        RaceSelectionPacket.toBuffer(new RaceSelectionPacket(raceName), buf);

        RaceSelectionPacket.sendToServer(player, raceName);

        MinecraftClient.getInstance().setScreen(null);

    }
}
