package com.samebutdifferent.morevillagers.mixin;

import com.google.common.collect.ImmutableMap;
import com.samebutdifferent.morevillagers.registry.MVGifts;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(GiveGiftToHero.class)
public class GiveGiftToHeroMixin {
    @Shadow
    @Final
    @Mutable
    private static Map<ResourceKey<VillagerProfession>, ResourceKey<LootTable>> GIFTS;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void morevillagers$addGifts(CallbackInfo ci) {
        GIFTS = ImmutableMap.<ResourceKey<VillagerProfession>, ResourceKey<LootTable>>builder()
            .putAll(GIFTS).putAll(MVGifts.TABLES).build();
    }
}
