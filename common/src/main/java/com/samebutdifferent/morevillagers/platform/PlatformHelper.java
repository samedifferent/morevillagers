package com.samebutdifferent.morevillagers.platform;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;
import java.util.function.Supplier;

public interface PlatformHelper {
    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block);

    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item);

    Supplier<VillagerProfession> registerProfession(ResourceKey<VillagerProfession> villagerProfessionKey, Supplier<PoiType> poiType, SoundEvent soundEvent, Int2ObjectMap<ResourceKey<TradeSet>> tradeSetsByLevel);

    Supplier<PoiType> registerPoiType(String name, Supplier<Set<BlockState>> matchingStates);
}
