package com.samebutdifferent.morevillagers.forge;

import java.util.ArrayList;
import java.util.List;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.forge.CommonPlatformHelperImpl;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.registry.forge.MVConfigForge;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod(MoreVillagers.MOD_ID)
public class MoreVillagersForge {
    public static CreativeModeTab TAB = null;

    public MoreVillagersForge() {
        MoreVillagers.init();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MVConfigForge.COMMON_CONFIG);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CommonPlatformHelperImpl.BLOCKS.register(bus);
        CommonPlatformHelperImpl.ITEMS.register(bus);
        CommonPlatformHelperImpl.POI_TYPES.register(bus);
        CommonPlatformHelperImpl.PROFESSIONS.register(bus);

        bus.addListener(this::addCreativeModeTab);
        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(ServerAboutToStartEvent event) {
        MoreVillagers.registerJigsaws(event.getServer());
    }

    private void addCreativeModeTab(CreativeModeTabEvent.Register event) {
        List<ItemStack> stacks = new ArrayList<>();
        for (RegistryObject<Block> registeredBlock : CommonPlatformHelperImpl.BLOCKS.getEntries()) {
            Block block = registeredBlock.get();
            if (block != null) {
                stacks.add(new ItemStack(block));
            }
        }
        TAB = event.registerCreativeModeTab(new ResourceLocation(MoreVillagers.MOD_ID, "tab"), builder -> {
            builder
                    .title(Component.translatable("itemGroup." + MoreVillagers.MOD_ID + ".tab"))
                    .icon(() -> new ItemStack(Items.EMERALD))
                    .displayItems((enabledFlags, populator) -> {
                        populator.acceptAll(stacks);
                    });
        });
    }


    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MVProfessions.fillTradeData();
            registerBlockStates();
        });
    }

    public static void registerBlockStates() {
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.OCEANOGRAPHY_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "oceanography_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.WOODWORKING_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "woodworking_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.DECAYED_WORKBENCH.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "decayed_workbench"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.PURPUR_ALTAR.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "purpur_altar"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.BLUEPRINT_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "blueprint_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.GARDENING_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "gardening_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.HUNTING_POST.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "hunting_post"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.MINING_BENCH.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(MoreVillagers.MOD_ID, "mining_bench"))).get()));
    }
}