package com.samebutdifferent.morevillagers.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypeInvoker;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.registry.fabric.MVConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class MoreVillagersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(MVConfigFabric.class, GsonConfigSerializer::new);
        MoreVillagers.init();
        MVProfessions.fillTradeData();
        registerPOIs();
        ServerLifecycleEvents.SERVER_STARTING.register(MoreVillagers::registerJigsaws);
    }

    void registerPOIs() {
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.OCEANOGRAPHER_POI.get());
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.NETHERIAN_POI.get());
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.WOODWORKER_POI.get());
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.ENDERIAN_POI.get());
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.ENGINEER_POI.get());
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.FLORIST_POI.get());
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.HUNTER_POI.get());
    }
}