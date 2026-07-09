package com.samebutdifferent.morevillagers.fabric.datagen;

import com.samebutdifferent.morevillagers.datagen.MVTradesTagEntries;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.concurrent.CompletableFuture;

public class MVTradesFabricTagsProvider extends FabricTagsProvider<VillagerTrade> {
    public MVTradesFabricTagsProvider(final FabricPackOutput output, final CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.VILLAGER_TRADE, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        MVTradesTagEntries.addTo((tag, trades) -> tag(tag).add(trades));
    }
}
