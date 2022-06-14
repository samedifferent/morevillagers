package com.samebutdifferent.morevillagers.forge;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.forge.CommonPlatformHelperImpl;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.registry.forge.MVConfigForge;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreVillagers.MOD_ID)
public class MoreVillagersForge {
    public MoreVillagersForge() {
        MoreVillagers.init();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MVConfigForge.COMMON_CONFIG);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CommonPlatformHelperImpl.BLOCKS.register(bus);
        CommonPlatformHelperImpl.ITEMS.register(bus);
        CommonPlatformHelperImpl.POI_TYPES.register(bus);
        CommonPlatformHelperImpl.PROFESSIONS.register(bus);

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(ServerAboutToStartEvent event) {
        MoreVillagers.registerJigsaws(event.getServer());
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MVProfessions.fillTradeData();
            registerBlockStates();
        });
    }

    public static void registerBlockStates() {
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.OCEANOGRAPHY_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "oceanography_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.WOODWORKING_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "woodworking_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.DECAYED_WORKBENCH.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "decayed_workbench"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.PURPUR_ALTAR.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "purpur_altar"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.BLUEPRINT_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "blueprint_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.GARDENING_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "gardening_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.HUNTING_POST.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "hunting_post"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.MINING_BENCH.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "mining_bench"))).get()));
    }
}