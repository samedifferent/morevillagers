package com.samebutdifferent.morevillagers.forge;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.platform.forge.CommonPlatformHelperImpl;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.registry.forge.MVConfigForge;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.lang.reflect.InvocationTargetException;

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
    public void onServerAboutToStartEvent(FMLServerAboutToStartEvent event) {
        MoreVillagers.registerJigsaws(event.getServer());
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MVProfessions.fillTradeData();
            registerPOIs();
        });
    }

    void registerPOIs() {
        for (RegistryObject<PoiType> poi : CommonPlatformHelperImpl.POI_TYPES.getEntries()) {
            try {
                ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, poi.get());
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}