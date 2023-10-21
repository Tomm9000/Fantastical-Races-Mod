package com.fantasticalraces.raceframework.races;

import com.fantasticalraces.raceframework.Race;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.util.Identifier;

import java.util.*;

public class DeathlessOneRace extends Race {
    private static List<PlayerEntity> deathlessPlayers = new ArrayList<>();
    private static Map<PlayerEntity, BlockPos> respawnLocations = new HashMap<>();
    private static final int HEALTH_REGEN_TICKS = 10 * 24000; // 10 Minecraft days
    private static final float MAX_HEALTH_LOSS = 8.0f;

    public DeathlessOneRace() {
        super("The Deathless Ones", new Identifier("fantasticalraces", "deathless_ones"), (List<EntityAttributeModifier>) getAttributeModifier());
    }

    private static DefaultAttributeContainer getAttributeModifier() {
        return DefaultAttributeContainer.builder()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, MAX_HEALTH_LOSS)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1) // Modify movement speed as needed
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0) // Modify attack damage as needed
                // Add other attributes as needed
                .build();
    }

    // ... (other methods and attributes)

    public static void handleRespawn(PlayerEntity player, World world, BlockPos respawnPos) {
        if (player != null && !deathlessPlayers.contains(player)) {
            // Reduce the player's max health
            player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(player.getMaxHealth() - MAX_HEALTH_LOSS);
            player.setHealth(player.getMaxHealth());
            respawnLocations.put(player, respawnPos);
            deathlessPlayers.add(player);
        }
    }

    public static void tickHealthRegen() {
        for (PlayerEntity player : deathlessPlayers) {
            if (player.isAlive()) {
                // Calculate health regen progress
                float regenProgress = (float) player.age / HEALTH_REGEN_TICKS;
                float maxHealth = player.getMaxHealth();
                float regenAmount = regenProgress * MAX_HEALTH_LOSS;

                if (player.getMaxHealth() < maxHealth - regenAmount) {
                    // Increase max health gradually
                    player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(player.getMaxHealth() + regenAmount);
                }
            } else {
                if (respawnLocations.containsKey(player)) {
                    BlockPos respawnPos = respawnLocations.get(player);
                    player.teleport(respawnPos.getX(), respawnPos.getY(), respawnPos.getZ());
                    deathlessPlayers.remove(player);
                }
            }
        }
    }

    private List<EntityAttributeModifier> getCustomAttributes(){
        List<EntityAttributeModifier> modifiers = new ArrayList<>();

        modifiers.add(new EntityAttributeModifier(
                UUID.randomUUID(), "Max Health Modifier", 8.0, Operation.ADDITION));
        return modifiers;
    }

}
