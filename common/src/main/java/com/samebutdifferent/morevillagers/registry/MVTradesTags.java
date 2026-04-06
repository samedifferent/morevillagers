package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.VillagerTrade;

public class MVTradesTags {

    public static final TagKey<VillagerTrade> OCEANOGRAPHER_LEVEL_1 = create("oceanographer/level_1");
    public static final TagKey<VillagerTrade> OCEANOGRAPHER_LEVEL_2 = create("oceanographer/level_2");
    public static final TagKey<VillagerTrade> OCEANOGRAPHER_LEVEL_3 = create("oceanographer/level_3");
    public static final TagKey<VillagerTrade> OCEANOGRAPHER_LEVEL_4 = create("oceanographer/level_4");
    public static final TagKey<VillagerTrade> OCEANOGRAPHER_LEVEL_5 = create("oceanographer/level_5");

    public static final TagKey<VillagerTrade> NETHERIAN_LEVEL_1 = create("netherian/level_1");
    public static final TagKey<VillagerTrade> NETHERIAN_LEVEL_2 = create("netherian/level_2");
    public static final TagKey<VillagerTrade> NETHERIAN_LEVEL_3 = create("netherian/level_3");
    public static final TagKey<VillagerTrade> NETHERIAN_LEVEL_4 = create("netherian/level_4");
    public static final TagKey<VillagerTrade> NETHERIAN_LEVEL_5 = create("netherian/level_5");

    public static final TagKey<VillagerTrade> WOODWORKER_LEVEL_1 = create("woodworker/level_1");
    public static final TagKey<VillagerTrade> WOODWORKER_LEVEL_2 = create("woodworker/level_2");
    public static final TagKey<VillagerTrade> WOODWORKER_LEVEL_3 = create("woodworker/level_3");
    public static final TagKey<VillagerTrade> WOODWORKER_LEVEL_4 = create("woodworker/level_4");
    public static final TagKey<VillagerTrade> WOODWORKER_LEVEL_5 = create("woodworker/level_5");

    public static final TagKey<VillagerTrade> ENDERIAN_LEVEL_1 = create("enderian/level_1");
    public static final TagKey<VillagerTrade> ENDERIAN_LEVEL_2 = create("enderian/level_2");
    public static final TagKey<VillagerTrade> ENDERIAN_LEVEL_3 = create("enderian/level_3");
    public static final TagKey<VillagerTrade> ENDERIAN_LEVEL_4 = create("enderian/level_4");
    public static final TagKey<VillagerTrade> ENDERIAN_LEVEL_5 = create("enderian/level_5");

    public static final TagKey<VillagerTrade> ENGINEER_LEVEL_1 = create("engineer/level_1");
    public static final TagKey<VillagerTrade> ENGINEER_LEVEL_2 = create("engineer/level_2");
    public static final TagKey<VillagerTrade> ENGINEER_LEVEL_3 = create("engineer/level_3");
    public static final TagKey<VillagerTrade> ENGINEER_LEVEL_4 = create("engineer/level_4");
    public static final TagKey<VillagerTrade> ENGINEER_LEVEL_5 = create("engineer/level_5");

    public static final TagKey<VillagerTrade> FLORIST_LEVEL_1 = create("florist/level_1");
    public static final TagKey<VillagerTrade> FLORIST_LEVEL_2 = create("florist/level_2");
    public static final TagKey<VillagerTrade> FLORIST_LEVEL_3 = create("florist/level_3");
    public static final TagKey<VillagerTrade> FLORIST_LEVEL_4 = create("florist/level_4");
    public static final TagKey<VillagerTrade> FLORIST_LEVEL_5 = create("florist/level_5");

    public static final TagKey<VillagerTrade> HUNTER_LEVEL_1 = create("hunter/level_1");
    public static final TagKey<VillagerTrade> HUNTER_LEVEL_2 = create("hunter/level_2");
    public static final TagKey<VillagerTrade> HUNTER_LEVEL_3 = create("hunter/level_3");
    public static final TagKey<VillagerTrade> HUNTER_LEVEL_4 = create("hunter/level_4");
    public static final TagKey<VillagerTrade> HUNTER_LEVEL_5 = create("hunter/level_5");

    public static final TagKey<VillagerTrade> MINER_LEVEL_1 = create("miner/level_1");
    public static final TagKey<VillagerTrade> MINER_LEVEL_2 = create("miner/level_2");
    public static final TagKey<VillagerTrade> MINER_LEVEL_3 = create("miner/level_3");
    public static final TagKey<VillagerTrade> MINER_LEVEL_4 = create("miner/level_4");
    public static final TagKey<VillagerTrade> MINER_LEVEL_5 = create("miner/level_5");

    private static TagKey<VillagerTrade> create(final String name) {
        return TagKey.create(Registries.VILLAGER_TRADE, MoreVillagers.id(name));
    }
}
