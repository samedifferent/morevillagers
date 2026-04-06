package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.platform.PlatformHooks;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.villager.VillagerProfession;

public class MVProfessions {
    public static final ResourceKey<VillagerProfession> OCEANOGRAPHER = createKey("oceanographer");
    public static final ResourceKey<VillagerProfession> NETHERIAN = createKey("netherian");
    public static final ResourceKey<VillagerProfession> WOODWORKER = createKey("woodworker");
    public static final ResourceKey<VillagerProfession> ENDERIAN = createKey("enderian");
    public static final ResourceKey<VillagerProfession> ENGINEER = createKey("engineer");
    public static final ResourceKey<VillagerProfession> FLORIST = createKey("florist");
    public static final ResourceKey<VillagerProfession> HUNTER = createKey("hunter");
    public static final ResourceKey<VillagerProfession> MINER = createKey("miner");

    public static void init() {
        PlatformHooks.PLATFORM_HELPER.registerProfession(
            OCEANOGRAPHER,
            MVPoiTypes.OCEANOGRAPHER_POI,
            SoundEvents.VILLAGER_WORK_CARTOGRAPHER,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.OCEANOGRAPHER_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.OCEANOGRAPHER_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.OCEANOGRAPHER_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.OCEANOGRAPHER_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.OCEANOGRAPHER_LEVEL_5)
            )
        );

        PlatformHooks.PLATFORM_HELPER.registerProfession(
            NETHERIAN,
            MVPoiTypes.NETHERIAN_POI,
            SoundEvents.VILLAGER_WORK_BUTCHER,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.NETHERIAN_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.NETHERIAN_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.NETHERIAN_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.NETHERIAN_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.NETHERIAN_LEVEL_5)
            )
        );

        PlatformHooks.PLATFORM_HELPER.registerProfession(
            WOODWORKER,
            MVPoiTypes.WOODWORKER_POI,
            SoundEvents.VILLAGER_WORK_LEATHERWORKER,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.WOODWORKER_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.WOODWORKER_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.WOODWORKER_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.WOODWORKER_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.WOODWORKER_LEVEL_5)
            )
        );

        PlatformHooks.PLATFORM_HELPER.registerProfession(
            ENDERIAN,
            MVPoiTypes.ENDERIAN_POI,
            SoundEvents.VILLAGER_WORK_BUTCHER,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.ENDERIAN_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.ENDERIAN_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.ENDERIAN_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.ENDERIAN_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.ENDERIAN_LEVEL_5)
            )
        );

        PlatformHooks.PLATFORM_HELPER.registerProfession(
            ENGINEER,
            MVPoiTypes.ENGINEER_POI,
            SoundEvents.VILLAGER_WORK_TOOLSMITH,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.ENGINEER_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.ENGINEER_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.ENGINEER_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.ENGINEER_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.ENGINEER_LEVEL_5)
            )
        );

        PlatformHooks.PLATFORM_HELPER.registerProfession(
            FLORIST,
            MVPoiTypes.FLORIST_POI,
            SoundEvents.VILLAGER_WORK_FARMER,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.FLORIST_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.FLORIST_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.FLORIST_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.FLORIST_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.FLORIST_LEVEL_5)
            )
        );

        PlatformHooks.PLATFORM_HELPER.registerProfession(
            HUNTER,
            MVPoiTypes.HUNTER_POI,
            SoundEvents.VILLAGER_WORK_FLETCHER,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.HUNTER_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.HUNTER_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.HUNTER_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.HUNTER_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.HUNTER_LEVEL_5)
            )
        );

        PlatformHooks.PLATFORM_HELPER.registerProfession(
            MINER,
            MVPoiTypes.MINER_POI,
            SoundEvents.VILLAGER_WORK_ARMORER,
            Int2ObjectMap.ofEntries(
                Int2ObjectMap.entry(1, MVTradeSets.MINER_LEVEL_1),
                Int2ObjectMap.entry(2, MVTradeSets.MINER_LEVEL_2),
                Int2ObjectMap.entry(3, MVTradeSets.MINER_LEVEL_3),
                Int2ObjectMap.entry(4, MVTradeSets.MINER_LEVEL_4),
                Int2ObjectMap.entry(5, MVTradeSets.MINER_LEVEL_5)
            )
        );
    }

    private static ResourceKey<VillagerProfession> createKey(String string) {
        return ResourceKey.create(Registries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(MoreVillagers.MOD_ID, string));
    }
}