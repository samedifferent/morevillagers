package com.samebutdifferent.morevillagers.platform.fabric;

import com.google.common.collect.ImmutableSet;
import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypeInvoker;
import com.samebutdifferent.morevillagers.mixin.fabric.VillagerProfessionInvoker;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
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

    public static Supplier<VillagerProfession> registerProfession(String name, Supplier<PoiType> poiType, @Nullable SoundEvent workSound) {
        var registry = Registry.register(Registry.VILLAGER_PROFESSION, new ResourceLocation(MoreVillagers.MOD_ID, name), VillagerProfessionInvoker.invokeConstructor(name, poiType.get(), ImmutableSet.of(), ImmutableSet.of(), workSound));
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
