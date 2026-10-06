package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.Optional;

public class MVTradeSets {
    public static final ResourceKey<TradeSet> OCEANOGRAPHER_LEVEL_1 = resourceKey("oceanographer/level_1");
    public static final ResourceKey<TradeSet> OCEANOGRAPHER_LEVEL_2 = resourceKey("oceanographer/level_2");
    public static final ResourceKey<TradeSet> OCEANOGRAPHER_LEVEL_3 = resourceKey("oceanographer/level_3");
    public static final ResourceKey<TradeSet> OCEANOGRAPHER_LEVEL_4 = resourceKey("oceanographer/level_4");
    public static final ResourceKey<TradeSet> OCEANOGRAPHER_LEVEL_5 = resourceKey("oceanographer/level_5");

    public static final ResourceKey<TradeSet> NETHERIAN_LEVEL_1 = resourceKey("netherian/level_1");
    public static final ResourceKey<TradeSet> NETHERIAN_LEVEL_2 = resourceKey("netherian/level_2");
    public static final ResourceKey<TradeSet> NETHERIAN_LEVEL_3 = resourceKey("netherian/level_3");
    public static final ResourceKey<TradeSet> NETHERIAN_LEVEL_4 = resourceKey("netherian/level_4");
    public static final ResourceKey<TradeSet> NETHERIAN_LEVEL_5 = resourceKey("netherian/level_5");

    public static final ResourceKey<TradeSet> WOODWORKER_LEVEL_1 = resourceKey("woodworker/level_1");
    public static final ResourceKey<TradeSet> WOODWORKER_LEVEL_2 = resourceKey("woodworker/level_2");
    public static final ResourceKey<TradeSet> WOODWORKER_LEVEL_3 = resourceKey("woodworker/level_3");
    public static final ResourceKey<TradeSet> WOODWORKER_LEVEL_4 = resourceKey("woodworker/level_4");
    public static final ResourceKey<TradeSet> WOODWORKER_LEVEL_5 = resourceKey("woodworker/level_5");

    public static final ResourceKey<TradeSet> ENDERIAN_LEVEL_1 = resourceKey("enderian/level_1");
    public static final ResourceKey<TradeSet> ENDERIAN_LEVEL_2 = resourceKey("enderian/level_2");
    public static final ResourceKey<TradeSet> ENDERIAN_LEVEL_3 = resourceKey("enderian/level_3");
    public static final ResourceKey<TradeSet> ENDERIAN_LEVEL_4 = resourceKey("enderian/level_4");
    public static final ResourceKey<TradeSet> ENDERIAN_LEVEL_5 = resourceKey("enderian/level_5");

    public static final ResourceKey<TradeSet> ENGINEER_LEVEL_1 = resourceKey("engineer/level_1");
    public static final ResourceKey<TradeSet> ENGINEER_LEVEL_2 = resourceKey("engineer/level_2");
    public static final ResourceKey<TradeSet> ENGINEER_LEVEL_3 = resourceKey("engineer/level_3");
    public static final ResourceKey<TradeSet> ENGINEER_LEVEL_4 = resourceKey("engineer/level_4");
    public static final ResourceKey<TradeSet> ENGINEER_LEVEL_5 = resourceKey("engineer/level_5");

    public static final ResourceKey<TradeSet> FLORIST_LEVEL_1 = resourceKey("florist/level_1");
    public static final ResourceKey<TradeSet> FLORIST_LEVEL_2 = resourceKey("florist/level_2");
    public static final ResourceKey<TradeSet> FLORIST_LEVEL_3 = resourceKey("florist/level_3");
    public static final ResourceKey<TradeSet> FLORIST_LEVEL_4 = resourceKey("florist/level_4");
    public static final ResourceKey<TradeSet> FLORIST_LEVEL_5 = resourceKey("florist/level_5");

    public static final ResourceKey<TradeSet> HUNTER_LEVEL_1 = resourceKey("hunter/level_1");
    public static final ResourceKey<TradeSet> HUNTER_LEVEL_2 = resourceKey("hunter/level_2");
    public static final ResourceKey<TradeSet> HUNTER_LEVEL_3 = resourceKey("hunter/level_3");
    public static final ResourceKey<TradeSet> HUNTER_LEVEL_4 = resourceKey("hunter/level_4");
    public static final ResourceKey<TradeSet> HUNTER_LEVEL_5 = resourceKey("hunter/level_5");

    public static final ResourceKey<TradeSet> MINER_LEVEL_1 = resourceKey("miner/level_1");
    public static final ResourceKey<TradeSet> MINER_LEVEL_2 = resourceKey("miner/level_2");
    public static final ResourceKey<TradeSet> MINER_LEVEL_3 = resourceKey("miner/level_3");
    public static final ResourceKey<TradeSet> MINER_LEVEL_4 = resourceKey("miner/level_4");
    public static final ResourceKey<TradeSet> MINER_LEVEL_5 = resourceKey("miner/level_5");

    public static Holder<TradeSet> bootstrap(BootstrapContext<TradeSet> context) {

        register(context, OCEANOGRAPHER_LEVEL_1, MVTradesTags.OCEANOGRAPHER_LEVEL_1);
        register(context, OCEANOGRAPHER_LEVEL_2, MVTradesTags.OCEANOGRAPHER_LEVEL_2);
        register(context, OCEANOGRAPHER_LEVEL_3, MVTradesTags.OCEANOGRAPHER_LEVEL_3);
        register(context, OCEANOGRAPHER_LEVEL_4, MVTradesTags.OCEANOGRAPHER_LEVEL_4);
        register(context, OCEANOGRAPHER_LEVEL_5, MVTradesTags.OCEANOGRAPHER_LEVEL_5);

        register(context, NETHERIAN_LEVEL_1, MVTradesTags.NETHERIAN_LEVEL_1);
        register(context, NETHERIAN_LEVEL_2, MVTradesTags.NETHERIAN_LEVEL_2);
        register(context, NETHERIAN_LEVEL_3, MVTradesTags.NETHERIAN_LEVEL_3);
        register(context, NETHERIAN_LEVEL_4, MVTradesTags.NETHERIAN_LEVEL_4);
        register(context, NETHERIAN_LEVEL_5, MVTradesTags.NETHERIAN_LEVEL_5);

        register(context, WOODWORKER_LEVEL_1, MVTradesTags.WOODWORKER_LEVEL_1);
        register(context, WOODWORKER_LEVEL_2, MVTradesTags.WOODWORKER_LEVEL_2);
        register(context, WOODWORKER_LEVEL_3, MVTradesTags.WOODWORKER_LEVEL_3);
        register(context, WOODWORKER_LEVEL_4, MVTradesTags.WOODWORKER_LEVEL_4);
        register(context, WOODWORKER_LEVEL_5, MVTradesTags.WOODWORKER_LEVEL_5);

        register(context, ENDERIAN_LEVEL_1, MVTradesTags.ENDERIAN_LEVEL_1);
        register(context, ENDERIAN_LEVEL_2, MVTradesTags.ENDERIAN_LEVEL_2);
        register(context, ENDERIAN_LEVEL_3, MVTradesTags.ENDERIAN_LEVEL_3);
        register(context, ENDERIAN_LEVEL_4, MVTradesTags.ENDERIAN_LEVEL_4);
        register(context, ENDERIAN_LEVEL_5, MVTradesTags.ENDERIAN_LEVEL_5);

        register(context, ENGINEER_LEVEL_1, MVTradesTags.ENGINEER_LEVEL_1);
        register(context, ENGINEER_LEVEL_2, MVTradesTags.ENGINEER_LEVEL_2);
        register(context, ENGINEER_LEVEL_3, MVTradesTags.ENGINEER_LEVEL_3);
        register(context, ENGINEER_LEVEL_4, MVTradesTags.ENGINEER_LEVEL_4);
        register(context, ENGINEER_LEVEL_5, MVTradesTags.ENGINEER_LEVEL_5);

        register(context, FLORIST_LEVEL_1, MVTradesTags.FLORIST_LEVEL_1);
        register(context, FLORIST_LEVEL_2, MVTradesTags.FLORIST_LEVEL_2);
        register(context, FLORIST_LEVEL_3, MVTradesTags.FLORIST_LEVEL_3);
        register(context, FLORIST_LEVEL_4, MVTradesTags.FLORIST_LEVEL_4);
        register(context, FLORIST_LEVEL_5, MVTradesTags.FLORIST_LEVEL_5);

        register(context, HUNTER_LEVEL_1, MVTradesTags.HUNTER_LEVEL_1);
        register(context, HUNTER_LEVEL_2, MVTradesTags.HUNTER_LEVEL_2);
        register(context, HUNTER_LEVEL_3, MVTradesTags.HUNTER_LEVEL_3);
        register(context, HUNTER_LEVEL_4, MVTradesTags.HUNTER_LEVEL_4);
        register(context, HUNTER_LEVEL_5, MVTradesTags.HUNTER_LEVEL_5);

        register(context, MINER_LEVEL_1, MVTradesTags.MINER_LEVEL_1);
        register(context, MINER_LEVEL_2, MVTradesTags.MINER_LEVEL_2);
        register(context, MINER_LEVEL_3, MVTradesTags.MINER_LEVEL_3);
        register(context, MINER_LEVEL_4, MVTradesTags.MINER_LEVEL_4);
        register(context, MINER_LEVEL_5, MVTradesTags.MINER_LEVEL_5);

        return null;
    }

    public static Holder.Reference<TradeSet> register(
        final BootstrapContext<TradeSet> context, final ResourceKey<TradeSet> resourceKey, final TagKey<VillagerTrade> tradeTag
    ) {
        return register(context, resourceKey, tradeTag, ContextIntProviders.exactly(2));
    }

    public static Holder.Reference<TradeSet> register(
        final BootstrapContext<TradeSet> context, final ResourceKey<TradeSet> resourceKey, final TagKey<VillagerTrade> tradeTag, final Holder<ContextIntProvider> numberProvider
    ) {
        return context.register(
            resourceKey,
            new TradeSet(
                context.lookup(Registries.VILLAGER_TRADE).getOrThrow(tradeTag), numberProvider, false, Optional.of(resourceKey.identifier().withPrefix("trade_set/"))
            )
        );
    }

    public static ResourceKey<TradeSet> resourceKey(final String path) {
        return ResourceKey.create(Registries.TRADE_SET, MoreVillagers.id(path));
    }
}
