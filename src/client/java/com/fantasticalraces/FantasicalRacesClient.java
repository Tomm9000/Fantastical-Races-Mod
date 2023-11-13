package com.fantasticalraces;

import com.fantasticalraces.Data.PlayerData;
import com.fantasticalraces.packet.ClientPacketHandler;
import com.fantasticalraces.packet.RaceSelectionPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.server.network.ServerPlayerEntity;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;

public class FantasicalRacesClient implements ClientModInitializer {
	public static KeyBinding keyBinding;



	@Override
	public void onInitializeClient() {



		PlayerJoinEventListener.init();
		ClientPacketHandler.init(RaceSelectionPacket.getPlayer());


		keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Open Race Menu",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_G,
				"Fantastical Races"
		));
	}




}