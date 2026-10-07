package com.samebutdifferent.morevillagers.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class MVRegistryProvider extends FabricDynamicRegistryProvider {

    public MVRegistryProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        entries.addAll(provider.lookupOrThrow(Registries.TRADE_SET));
        entries.addAll(provider.lookupOrThrow(Registries.VILLAGER_TRADE));
        entries.addAll(provider.lookupOrThrow(Registries.LOOT_TABLE));
        entries.addAll(provider.lookupOrThrow(Registries.ADVANCEMENT));
        entries.addAll(provider.lookupOrThrow(Registries.RECIPE));
    }

    @Override
    public String getName() {
        return "MoreVillagers Registries";
    }
}
