package com.samebutdifferent.morevillagers.platform.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class CommonPlatformHelperImpl {
    public static List<Supplier<Block>> REGISTERED_BLOCKS = new ArrayList<>();

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        var registry = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MoreVillagers.MOD_ID, name), block.get());
        REGISTERED_BLOCKS.add(() -> registry);
        return () -> registry;
    }

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        var registry = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MoreVillagers.MOD_ID, name), item.get());
        return () -> registry;
    }

    public static Supplier<VillagerProfession> registerProfession(String name, Supplier<VillagerProfession> profession) {
        var registry = Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, new ResourceLocation(MoreVillagers.MOD_ID, name), profession.get());
        return () -> registry;
    }

    public static Supplier<PoiType> registerPoiType(String name, Supplier<Set<BlockState>> matchingStates) {
        ResourceKey<PoiType> resourceKey = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, name));
        var registry = Registry.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, resourceKey, new PoiType(matchingStates.get(), 1, 1));
        PoiTypesInvoker.invokeRegisterBlockStates(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolderOrThrow(resourceKey), matchingStates.get());
        return () -> registry;
    }

    public static CreativeModeTab getCreativeModeTab(ResourceLocation name, Supplier<ItemStack> icon) {
        return FabricItemGroup.builder(name).icon(icon).build();
    }
}
