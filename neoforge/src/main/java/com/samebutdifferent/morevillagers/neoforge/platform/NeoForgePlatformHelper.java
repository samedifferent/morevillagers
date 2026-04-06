package com.samebutdifferent.morevillagers.neoforge.platform;

import com.google.common.collect.ImmutableSet;
import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.platform.PlatformHelper;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.function.Supplier;

public class NeoForgePlatformHelper implements PlatformHelper {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, MoreVillagers.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, MoreVillagers.MOD_ID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, MoreVillagers.MOD_ID);
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, MoreVillagers.MOD_ID);


    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    public Supplier<VillagerProfession> registerProfession(ResourceKey<VillagerProfession> villagerProfessionKey, Supplier<PoiType> poiType, SoundEvent soundEvent, Int2ObjectMap<ResourceKey<TradeSet>> tradeSetsByLevel) {
        return PROFESSIONS.register(villagerProfessionKey.identifier().getPath(), () -> new VillagerProfession(
            Component.translatable("entity.minecraft.villager.morevillagers." + villagerProfessionKey.identifier().getPath()),
            holder -> holder.value().equals(poiType.get()), holder -> holder.value().equals(poiType.get()), ImmutableSet.of(), ImmutableSet.of(), soundEvent, tradeSetsByLevel));
    }

    public Supplier<PoiType> registerPoiType(String name, Supplier<Set<BlockState>> matchingStates) {
        return POI_TYPES.register(name, () -> new PoiType(matchingStates.get(), 1, 1));
    }
}
