package com.fantasticalraces.raceframework.customraceattributes;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class RaceHealthHandler {

    public static void setCustomBaseHealth(ServerPlayerEntity player, float health) {
        player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addPersistentModifier(
                new EntityAttributeModifier("MaxHealth", health, EntityAttributeModifier.Operation.ADDITION)
        );

        saveCustomHealthToPlayerData(player, health);
    }

    private static void saveCustomHealthToPlayerData(ServerPlayerEntity player, float baseHealth) {
        PacketByteBuf customHealthData = PacketByteBufs.create();
        customHealthData.writeFloat(baseHealth);
    }
}
