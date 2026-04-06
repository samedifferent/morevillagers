package com.samebutdifferent.morevillagers.datagen;

import com.samebutdifferent.morevillagers.registry.MVTrades;
import com.samebutdifferent.morevillagers.registry.MVTradesTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.concurrent.CompletableFuture;

public class MVTradesTagsProvider extends KeyTagProvider<VillagerTrade> {
    public MVTradesTagsProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.VILLAGER_TRADE, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(MVTradesTags.OCEANOGRAPHER_LEVEL_1).add(
            MVTrades.OCEANOGRAPHER_1_PRISMARINE,
            MVTrades.OCEANOGRAPHER_1_SEA_LANTERN
        );
        tag(MVTradesTags.OCEANOGRAPHER_LEVEL_2).add(
            MVTrades.OCEANOGRAPHER_2_PRISMARINE_BRICKS,
            MVTrades.OCEANOGRAPHER_2_SPONGE
        );
        tag(MVTradesTags.OCEANOGRAPHER_LEVEL_3).add(
            MVTrades.OCEANOGRAPHER_3_DARK_PRISMARINE,
            MVTrades.OCEANOGRAPHER_3_MAP
        );
        tag(MVTradesTags.OCEANOGRAPHER_LEVEL_4).add(
            MVTrades.OCEANOGRAPHER_4_NAUTILUS,
            MVTrades.OCEANOGRAPHER_4_HEART
        );
        tag(MVTradesTags.OCEANOGRAPHER_LEVEL_5).add(
            MVTrades.OCEANOGRAPHER_5_TRIDENT
        );

        tag(MVTradesTags.NETHERIAN_LEVEL_1).add(
            MVTrades.NETHERIAN_1_BASALT,
            MVTrades.NETHERIAN_1_BRICK
        );
        tag(MVTradesTags.NETHERIAN_LEVEL_2).add(
            MVTrades.NETHERIAN_2_BLACKSTONE,
            MVTrades.NETHERIAN_2_QUARTZ
        );
        tag(MVTradesTags.NETHERIAN_LEVEL_3).add(
            MVTrades.NETHERIAN_3_OBSIDIAN,
            MVTrades.NETHERIAN_3_MAP
        );
        tag(MVTradesTags.NETHERIAN_LEVEL_4).add(
            MVTrades.NETHERIAN_4_GOLD,
            MVTrades.NETHERIAN_4_BASTION
        );
        tag(MVTradesTags.NETHERIAN_LEVEL_5).add(
            MVTrades.NETHERIAN_5_PIGSTEP
        );

        tag(MVTradesTags.WOODWORKER_LEVEL_1).add(
            MVTrades.WOODWORKER_1_OAK_SAPLING,
            MVTrades.WOODWORKER_1_OAK_LOG,
            MVTrades.WOODWORKER_1_BIRCH_SAPLING,
            MVTrades.WOODWORKER_1_BIRCH_LOG
        );
        tag(MVTradesTags.WOODWORKER_LEVEL_2).add(
            MVTrades.WOODWORKER_2_SPRUCE_SAPLING,
            MVTrades.WOODWORKER_2_SPRUCE_LOG,
            MVTrades.WOODWORKER_2_DARK_OAK_SAPLING,
            MVTrades.WOODWORKER_2_DARK_OAK_LOG
        );
        tag(MVTradesTags.WOODWORKER_LEVEL_3).add(
            MVTrades.WOODWORKER_3_ACACIA_SAPLING,
            MVTrades.WOODWORKER_3_ACACIA_LOG,
            MVTrades.WOODWORKER_3_JUNGLE_SAPLING,
            MVTrades.WOODWORKER_3_JUNGLE_LOG
        );
        tag(MVTradesTags.WOODWORKER_LEVEL_4).add(
            MVTrades.WOODWORKER_4_WARPED_STEM,
            MVTrades.WOODWORKER_4_CRIMSON_STEM
        );
        tag(MVTradesTags.WOODWORKER_LEVEL_5).add(
            MVTrades.WOODWORKER_5_AXE,
            MVTrades.WOODWORKER_5_HOE
        );

        tag(MVTradesTags.ENDERIAN_LEVEL_1).add(
            MVTrades.ENDERIAN_1_END_STONE,
            MVTrades.ENDERIAN_1_END_ROD
        );
        tag(MVTradesTags.ENDERIAN_LEVEL_2).add(
            MVTrades.ENDERIAN_2_CHORUS,
            MVTrades.ENDERIAN_2_MEMBRANE
        );
        tag(MVTradesTags.ENDERIAN_LEVEL_3).add(
            MVTrades.ENDERIAN_3_PEARL,
            MVTrades.ENDERIAN_3_FIREWORK
        );
        tag(MVTradesTags.ENDERIAN_LEVEL_4).add(
            MVTrades.ENDERIAN_4_BREATH,
            MVTrades.ENDERIAN_4_MAP
        );
        tag(MVTradesTags.ENDERIAN_LEVEL_5).add(
            MVTrades.ENDERIAN_5_SHULKER,
            MVTrades.ENDERIAN_5_HEAD
        );

        tag(MVTradesTags.ENGINEER_LEVEL_1).add(
            MVTrades.ENGINEER_1_REDSTONE,
            MVTrades.ENGINEER_1_REPEATER
        );
        tag(MVTradesTags.ENGINEER_LEVEL_2).add(
            MVTrades.ENGINEER_2_TORCH,
            MVTrades.ENGINEER_2_DROPPER,
            MVTrades.ENGINEER_2_DISPENSER
        );
        tag(MVTradesTags.ENGINEER_LEVEL_3).add(
            MVTrades.ENGINEER_3_LAMP,
            MVTrades.ENGINEER_3_OBSERVER,
            MVTrades.ENGINEER_3_COMPARATOR
        );
        tag(MVTradesTags.ENGINEER_LEVEL_4).add(
            MVTrades.ENGINEER_4_PISTON,
            MVTrades.ENGINEER_4_STICKY
        );
        tag(MVTradesTags.ENGINEER_LEVEL_5).add(
            MVTrades.ENGINEER_5_DAYLIGHT,
            MVTrades.ENGINEER_5_HOPPER
        );

        tag(MVTradesTags.FLORIST_LEVEL_1).add(
            MVTrades.FLORIST_1_POT,
            MVTrades.FLORIST_1_HONEYCOMB
        );
        tag(MVTradesTags.FLORIST_LEVEL_2).add(
            MVTrades.FLORIST_2_VINE,
            MVTrades.FLORIST_2_BERRIES
        );
        tag(MVTradesTags.FLORIST_LEVEL_3).add(
            MVTrades.FLORIST_3_DRIPLEAF,
            MVTrades.FLORIST_3_BOTTLE
        );
        tag(MVTradesTags.FLORIST_LEVEL_4).add(
            MVTrades.FLORIST_4_MOSS,
            MVTrades.FLORIST_4_MAP
        );
        tag(MVTradesTags.FLORIST_LEVEL_5).add(
            MVTrades.FLORIST_5_NEST,
            MVTrades.FLORIST_5_JUNGLE
        );

        tag(MVTradesTags.HUNTER_LEVEL_1).add(
            MVTrades.HUNTER_1_BONE,
            MVTrades.HUNTER_1_SLIME
        );
        tag(MVTradesTags.HUNTER_LEVEL_2).add(
            MVTrades.HUNTER_2_EYE,
            MVTrades.HUNTER_2_FERMENTED
        );
        tag(MVTradesTags.HUNTER_LEVEL_3).add(
            MVTrades.HUNTER_3_GUNPOWDER,
            MVTrades.HUNTER_3_MAGMA
        );
        tag(MVTradesTags.HUNTER_LEVEL_4).add(
            MVTrades.HUNTER_4_BLAZE,
            MVTrades.HUNTER_4_MAP
        );
        tag(MVTradesTags.HUNTER_LEVEL_5).add(
            MVTrades.HUNTER_5_GHAST,
            MVTrades.HUNTER_5_RABBIT
        );

        tag(MVTradesTags.MINER_LEVEL_1).add(
            MVTrades.MINER_1_DEEPSLATE,
            MVTrades.MINER_1_CALCITE
        );
        tag(MVTradesTags.MINER_LEVEL_2).add(
            MVTrades.MINER_2_COPPER,
            MVTrades.MINER_2_IRON
        );
        tag(MVTradesTags.MINER_LEVEL_3).add(
            MVTrades.MINER_3_GOLD,
            MVTrades.MINER_3_AMETHYST
        );
        tag(MVTradesTags.MINER_LEVEL_4).add(
            MVTrades.MINER_4_TORCH,
            MVTrades.MINER_4_MAP
        );
        tag(MVTradesTags.MINER_LEVEL_5).add(
            MVTrades.MINER_5_PICKAXE,
            MVTrades.MINER_5_CITY
        );
    }
}
