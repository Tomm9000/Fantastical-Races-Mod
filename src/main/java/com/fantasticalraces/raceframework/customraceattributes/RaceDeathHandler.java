package com.fantasticalraces.raceframework.customraceattributes;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public class RaceDeathHandler{
    public static void InitDeathEvent(ServerPlayerEntity player){
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            if(entity == player){
                player.sendMessage(Text.literal("Balls"));
                return ActionResult.CONSUME.shouldSwingHand();
            }
            return ActionResult.PASS.isAccepted();
        });
    }
}
