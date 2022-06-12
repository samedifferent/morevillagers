package com.samebutdifferent.morevillagers.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class MoreVillagersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MoreVillagers.init();
        ServerLifecycleEvents.SERVER_STARTING.register(MoreVillagers::registerJigsaws);
    }

}