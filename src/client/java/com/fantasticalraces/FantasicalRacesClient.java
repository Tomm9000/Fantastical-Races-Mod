package com.fantasticalraces;

import com.fantasticalraces.gui.RaceSelectionGUI;
import com.fantasticalraces.gui.RaceSelectionScreen;
import com.fantasticalraces.packet.ClientPacketHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class FantasicalRacesClient implements ClientModInitializer {
	public static KeyBinding keyBinding;

	@Override
	public void onInitializeClient() {



		PlayerJoinEventListener.init();
		ClientPacketHandler.init();

		keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Open Race Menu",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_G,
				"Fantastical Races"
		));
	}




}