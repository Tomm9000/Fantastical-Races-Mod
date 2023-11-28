package com.fantasticalraces.gui;

import com.fantasticalraces.packet.RaceSelectionPacket;
import com.fantasticalraces.raceframework.races.DeathlessOneRace;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;


public class RaceSelectionGUI extends LightweightGuiDescription {
    public RaceSelectionGUI(ServerPlayerEntity player){
        System.out.println("test");

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(200, 150);

        WButton humanButton = createRaceButton("Human", 4, -5, 5, 1, player);
        root.add(humanButton, 1, 1);


        WButton deathlessOneButton = createRaceButton("Deathless One", 4, -3, 5, 1, player);
        root.add(deathlessOneButton, 1, 3);

    }

    private @NotNull WButton createRaceButton(String race, int x, int y, int width, int height, ServerPlayerEntity player) {
        WButton raceButton = new WButton();
        raceButton.setLabel(Text.of("Select " + race + " Race"));
        raceButton.setOnClick(() -> onRaceButtonClicked(race, player));

        return raceButton;
    }

    private void SendMessageInChat(PlayerEntity player, String race){
        player.sendMessage(Text.of("I chose " + race));

        MinecraftClient.getInstance().setScreen(null);
    }

    private void onRaceButtonClicked(String raceName, ServerPlayerEntity player) {
        System.out.println("Race selected: " + raceName);
        SendMessageInChat(player, raceName);
        PacketByteBuf buf = PacketByteBufs.create();
        RaceSelectionPacket.toBuffer(new RaceSelectionPacket(raceName), buf);

        RaceSelectionPacket.sendToServer(player, raceName);
        getRaceAttributes(raceName, player);

        MinecraftClient.getInstance().setScreen(null);
    }

    private void getRaceAttributes(String raceName, ServerPlayerEntity player){
        switch (raceName){
            case "Deathless One":
                DeathlessOneRace.changeHealth(player);
                player.sendMessage(Text.of("Health should change"));
                break;
            default:
                break;
        }
    }
}
