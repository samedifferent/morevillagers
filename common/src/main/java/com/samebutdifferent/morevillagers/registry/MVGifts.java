package com.samebutdifferent.morevillagers.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Map;

public class MVGifts {
    public static final Map<ResourceKey<VillagerProfession>, ResourceKey<LootTable>> TABLES = Map.ofEntries(
        gift(MVProfessions.OCEANOGRAPHER),
        gift(MVProfessions.NETHERIAN),
        gift(MVProfessions.WOODWORKER),
        gift(MVProfessions.ENDERIAN),
        gift(MVProfessions.ENGINEER),
        gift(MVProfessions.FLORIST),
        gift(MVProfessions.HUNTER),
        gift(MVProfessions.MINER)
    );

    private static Map.Entry<ResourceKey<VillagerProfession>, ResourceKey<LootTable>> gift(ResourceKey<VillagerProfession> profession) {
        return Map.entry(profession, ResourceKey.create(Registries.LOOT_TABLE,
            profession.identifier().withPath(path -> "gameplay/hero_of_the_village/" + path + "_gift")));
    }
}
