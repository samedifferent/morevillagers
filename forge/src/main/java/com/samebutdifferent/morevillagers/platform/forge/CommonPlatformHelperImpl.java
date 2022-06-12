package com.samebutdifferent.morevillagers.platform.forge;

import com.google.common.collect.ImmutableSet;
import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypeInvoker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.function.Supplier;

public class CommonPlatformHelperImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreVillagers.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreVillagers.MOD_ID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, MoreVillagers.MOD_ID);
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MoreVillagers.MOD_ID);

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    public static Supplier<VillagerProfession> registerProfession(String name, Supplier<PoiType> poiType, @Nullable SoundEvent workSound) {
        return PROFESSIONS.register(name, () -> new VillagerProfession(name, poiType.get(), ImmutableSet.of(), ImmutableSet.of(), workSound));
    }

    public static Supplier<PoiType> registerPoiType(String name, Set<BlockState> matchingStates, int maxTickets, int validRange) {
        return POI_TYPES.register(name, () -> PoiTypeInvoker.invokeRegisterBlockStates(new PoiType(name, matchingStates, maxTickets, validRange)));
    }

    public static CreativeModeTab registerCreativeModeTab(ResourceLocation name, Supplier<ItemStack> icon) {
        return new CreativeModeTab(name.getNamespace() + "." + name.getPath()) {
            @Override
            public ItemStack makeIcon() {
                return icon.get();
            }
        };
    }
}
