package com.samebutdifferent.morevillagers.datagen;

import com.samebutdifferent.morevillagers.registry.MVTrades;
import com.samebutdifferent.morevillagers.registry.MVTradesTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.VillagerTrade;

public final class MVTradesTagEntries {
    private MVTradesTagEntries() {
    }

    public static void addTo(TagEntries entries) {
        entries.add(MVTradesTags.OCEANOGRAPHER_LEVEL_1,
            MVTrades.OCEANOGRAPHER_1_PRISMARINE,
            MVTrades.OCEANOGRAPHER_1_SEA_LANTERN
        );
        entries.add(MVTradesTags.OCEANOGRAPHER_LEVEL_2,
            MVTrades.OCEANOGRAPHER_2_PRISMARINE_BRICKS,
            MVTrades.OCEANOGRAPHER_2_SPONGE
        );
        entries.add(MVTradesTags.OCEANOGRAPHER_LEVEL_3,
            MVTrades.OCEANOGRAPHER_3_DARK_PRISMARINE,
            MVTrades.OCEANOGRAPHER_3_MAP
        );
        entries.add(MVTradesTags.OCEANOGRAPHER_LEVEL_4,
            MVTrades.OCEANOGRAPHER_4_NAUTILUS,
            MVTrades.OCEANOGRAPHER_4_HEART
        );
        entries.add(MVTradesTags.OCEANOGRAPHER_LEVEL_5,
            MVTrades.OCEANOGRAPHER_5_TRIDENT
        );

        entries.add(MVTradesTags.NETHERIAN_LEVEL_1,
            MVTrades.NETHERIAN_1_BASALT,
            MVTrades.NETHERIAN_1_BRICK
        );
        entries.add(MVTradesTags.NETHERIAN_LEVEL_2,
            MVTrades.NETHERIAN_2_BLACKSTONE,
            MVTrades.NETHERIAN_2_QUARTZ
        );
        entries.add(MVTradesTags.NETHERIAN_LEVEL_3,
            MVTrades.NETHERIAN_3_OBSIDIAN,
            MVTrades.NETHERIAN_3_MAP
        );
        entries.add(MVTradesTags.NETHERIAN_LEVEL_4,
            MVTrades.NETHERIAN_4_GOLD,
            MVTrades.NETHERIAN_4_BASTION
        );
        entries.add(MVTradesTags.NETHERIAN_LEVEL_5,
            MVTrades.NETHERIAN_5_PIGSTEP
        );

        entries.add(MVTradesTags.WOODWORKER_LEVEL_1,
            MVTrades.WOODWORKER_1_OAK_SAPLING,
            MVTrades.WOODWORKER_1_OAK_LOG,
            MVTrades.WOODWORKER_1_BIRCH_SAPLING,
            MVTrades.WOODWORKER_1_BIRCH_LOG
        );
        entries.add(MVTradesTags.WOODWORKER_LEVEL_2,
            MVTrades.WOODWORKER_2_SPRUCE_SAPLING,
            MVTrades.WOODWORKER_2_SPRUCE_LOG,
            MVTrades.WOODWORKER_2_DARK_OAK_SAPLING,
            MVTrades.WOODWORKER_2_DARK_OAK_LOG
        );
        entries.add(MVTradesTags.WOODWORKER_LEVEL_3,
            MVTrades.WOODWORKER_3_ACACIA_SAPLING,
            MVTrades.WOODWORKER_3_ACACIA_LOG,
            MVTrades.WOODWORKER_3_JUNGLE_SAPLING,
            MVTrades.WOODWORKER_3_JUNGLE_LOG
        );
        entries.add(MVTradesTags.WOODWORKER_LEVEL_4,
            MVTrades.WOODWORKER_4_WARPED_STEM,
            MVTrades.WOODWORKER_4_CRIMSON_STEM
        );
        entries.add(MVTradesTags.WOODWORKER_LEVEL_5,
            MVTrades.WOODWORKER_5_AXE,
            MVTrades.WOODWORKER_5_HOE
        );

        entries.add(MVTradesTags.ENDERIAN_LEVEL_1,
            MVTrades.ENDERIAN_1_END_STONE,
            MVTrades.ENDERIAN_1_END_ROD
        );
        entries.add(MVTradesTags.ENDERIAN_LEVEL_2,
            MVTrades.ENDERIAN_2_CHORUS,
            MVTrades.ENDERIAN_2_MEMBRANE
        );
        entries.add(MVTradesTags.ENDERIAN_LEVEL_3,
            MVTrades.ENDERIAN_3_PEARL,
            MVTrades.ENDERIAN_3_FIREWORK
        );
        entries.add(MVTradesTags.ENDERIAN_LEVEL_4,
            MVTrades.ENDERIAN_4_BREATH,
            MVTrades.ENDERIAN_4_MAP
        );
        entries.add(MVTradesTags.ENDERIAN_LEVEL_5,
            MVTrades.ENDERIAN_5_SHULKER,
            MVTrades.ENDERIAN_5_HEAD
        );

        entries.add(MVTradesTags.ENGINEER_LEVEL_1,
            MVTrades.ENGINEER_1_REDSTONE,
            MVTrades.ENGINEER_1_REPEATER
        );
        entries.add(MVTradesTags.ENGINEER_LEVEL_2,
            MVTrades.ENGINEER_2_TORCH,
            MVTrades.ENGINEER_2_DROPPER,
            MVTrades.ENGINEER_2_DISPENSER
        );
        entries.add(MVTradesTags.ENGINEER_LEVEL_3,
            MVTrades.ENGINEER_3_LAMP,
            MVTrades.ENGINEER_3_OBSERVER,
            MVTrades.ENGINEER_3_COMPARATOR
        );
        entries.add(MVTradesTags.ENGINEER_LEVEL_4,
            MVTrades.ENGINEER_4_PISTON,
            MVTrades.ENGINEER_4_STICKY
        );
        entries.add(MVTradesTags.ENGINEER_LEVEL_5,
            MVTrades.ENGINEER_5_DAYLIGHT,
            MVTrades.ENGINEER_5_HOPPER
        );

        entries.add(MVTradesTags.FLORIST_LEVEL_1,
            MVTrades.FLORIST_1_POT,
            MVTrades.FLORIST_1_HONEYCOMB
        );
        entries.add(MVTradesTags.FLORIST_LEVEL_2,
            MVTrades.FLORIST_2_VINE,
            MVTrades.FLORIST_2_BERRIES
        );
        entries.add(MVTradesTags.FLORIST_LEVEL_3,
            MVTrades.FLORIST_3_DRIPLEAF,
            MVTrades.FLORIST_3_BOTTLE
        );
        entries.add(MVTradesTags.FLORIST_LEVEL_4,
            MVTrades.FLORIST_4_MOSS,
            MVTrades.FLORIST_4_MAP
        );
        entries.add(MVTradesTags.FLORIST_LEVEL_5,
            MVTrades.FLORIST_5_NEST,
            MVTrades.FLORIST_5_JUNGLE
        );

        entries.add(MVTradesTags.HUNTER_LEVEL_1,
            MVTrades.HUNTER_1_BONE,
            MVTrades.HUNTER_1_SLIME
        );
        entries.add(MVTradesTags.HUNTER_LEVEL_2,
            MVTrades.HUNTER_2_EYE,
            MVTrades.HUNTER_2_FERMENTED
        );
        entries.add(MVTradesTags.HUNTER_LEVEL_3,
            MVTrades.HUNTER_3_GUNPOWDER,
            MVTrades.HUNTER_3_MAGMA
        );
        entries.add(MVTradesTags.HUNTER_LEVEL_4,
            MVTrades.HUNTER_4_BLAZE,
            MVTrades.HUNTER_4_MAP
        );
        entries.add(MVTradesTags.HUNTER_LEVEL_5,
            MVTrades.HUNTER_5_GHAST,
            MVTrades.HUNTER_5_RABBIT
        );

        entries.add(MVTradesTags.MINER_LEVEL_1,
            MVTrades.MINER_1_DEEPSLATE,
            MVTrades.MINER_1_CALCITE
        );
        entries.add(MVTradesTags.MINER_LEVEL_2,
            MVTrades.MINER_2_COPPER,
            MVTrades.MINER_2_IRON
        );
        entries.add(MVTradesTags.MINER_LEVEL_3,
            MVTrades.MINER_3_GOLD,
            MVTrades.MINER_3_AMETHYST
        );
        entries.add(MVTradesTags.MINER_LEVEL_4,
            MVTrades.MINER_4_TORCH,
            MVTrades.MINER_4_MAP
        );
        entries.add(MVTradesTags.MINER_LEVEL_5,
            MVTrades.MINER_5_PICKAXE,
            MVTrades.MINER_5_CITY
        );
    }

    @FunctionalInterface
    public interface TagEntries {
        @SuppressWarnings("unchecked")
        void add(TagKey<VillagerTrade> tag, ResourceKey<VillagerTrade>... trades);
    }
}
