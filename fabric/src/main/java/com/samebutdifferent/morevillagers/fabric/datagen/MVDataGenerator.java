package com.samebutdifferent.morevillagers.fabric.datagen;

import com.samebutdifferent.morevillagers.datagen.MVTradesTagsProvider;
import com.samebutdifferent.morevillagers.registry.MVTradeSets;
import com.samebutdifferent.morevillagers.registry.MVTrades;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MVDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(MVRegistryProvider::new);
        pack.addProvider(MVTradesFabricTagsProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.TRADE_SET, MVTradeSets::bootstrap);
        registryBuilder.add(Registries.VILLAGER_TRADE, MVTrades::bootstrap);
    }
}
