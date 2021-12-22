package com.samebutdifferent.morevillagers.event;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.init.ModPoiTypes;
import com.samebutdifferent.morevillagers.init.ModProfessions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = MoreVillagers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModProfessions.fillTradeData();
            ModPoiTypes.registerPOIs();
        });
    }
}
