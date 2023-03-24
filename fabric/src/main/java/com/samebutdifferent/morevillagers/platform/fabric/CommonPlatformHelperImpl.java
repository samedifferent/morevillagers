package com.samebutdifferent.morevillagers.platform.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
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

import java.util.ArrayList;
import java.util.List;
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

    public static Supplier<PoiType> registerPoiType(String name, Supplier<PoiType> poiType) {
        ResourceKey<PoiType> resourceKey = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, name));
        var registry = Registry.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, resourceKey, poiType.get());
        return () -> registry;
    }

    public static CreativeModeTab getCreativeModeTab(ResourceLocation name, Supplier<ItemStack> icon) {
        return FabricItemGroup.builder(name).icon(icon).build();
    }
}
