package com.samebutdifferent.morevillagers.fabric.platform;

import com.google.common.collect.ImmutableSet;
import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.PlatformHelper;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class FabricPlatformHelper implements PlatformHelper {
    public static List<Supplier<Item>> REGISTERED_ITEMS = new ArrayList<>();

    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        var registry = Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MoreVillagers.MOD_ID, name), block.get());
        return () -> registry;
    }

    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        var registry = Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreVillagers.MOD_ID, name), item.get());
        REGISTERED_ITEMS.add(() -> registry);
        return () -> registry;
    }

    public Supplier<VillagerProfession> registerProfession(ResourceKey<VillagerProfession> villagerProfessionKey, Supplier<PoiType> poiType, SoundEvent soundEvent, Int2ObjectMap<ResourceKey<TradeSet>> tradeSetsByLevel) {
        var registry = Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, villagerProfessionKey, new VillagerProfession(
            Component.translatable("entity.minecraft.villager.morevillagers." + villagerProfessionKey.identifier().getPath()),
            holder -> holder.value().equals(poiType.get()), holder -> holder.value().equals(poiType.get()), ImmutableSet.of(), ImmutableSet.of(), soundEvent, tradeSetsByLevel));
        return () -> registry;
    }

    public Supplier<PoiType> registerPoiType(String name, Supplier<Set<BlockState>> matchingStates) {
        ResourceKey<PoiType> resourceKey = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath(MoreVillagers.MOD_ID, name));
        var registry = Registry.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, resourceKey, new PoiType(matchingStates.get(), 1, 1));
        PoiTypesInvoker.invokeRegisterBlockStates(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getOrThrow(resourceKey), matchingStates.get());
        return () -> registry;
    }
}
