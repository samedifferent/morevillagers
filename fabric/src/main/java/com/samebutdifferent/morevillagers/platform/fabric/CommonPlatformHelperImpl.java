package com.samebutdifferent.morevillagers.platform.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class CommonPlatformHelperImpl {
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        var registry = Registry.register(Registry.BLOCK, new ResourceLocation(MoreVillagers.MOD_ID, name), block.get());
        return () -> registry;
    }

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        var registry = Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagers.MOD_ID, name), item.get());
        return () -> registry;
    }

    public static Supplier<VillagerProfession> registerProfession(String name, Supplier<VillagerProfession> profession) {
        var registry = Registry.register(Registry.VILLAGER_PROFESSION, new ResourceLocation(MoreVillagers.MOD_ID, name), profession.get());
        return () -> registry;
    }

    public static Supplier<PoiType> registerPoiType(String name, Supplier<PoiType> poiType) {
        var registry = Registry.register(Registry.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, name), poiType.get());
        return () -> registry;
    }

    public static CreativeModeTab registerCreativeModeTab(ResourceLocation name, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(name, icon);
    }
}
