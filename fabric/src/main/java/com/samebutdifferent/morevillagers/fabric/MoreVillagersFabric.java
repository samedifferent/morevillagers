package com.samebutdifferent.morevillagers.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypeInvoker;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class MoreVillagersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
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
        PoiTypeInvoker.invokeRegisterBlockStates(MVPoiTypes.MINER_POI.get());
    }
}