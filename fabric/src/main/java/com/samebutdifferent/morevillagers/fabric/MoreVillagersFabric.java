package com.samebutdifferent.morevillagers.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.platform.fabric.CommonPlatformHelperImpl;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.registry.fabric.MVConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MoreVillagersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(MVConfigFabric.class, GsonConfigSerializer::new);
        MoreVillagers.init();
        MVProfessions.fillTradeData();
        ServerLifecycleEvents.SERVER_STARTING.register(MoreVillagers::registerJigsaws);
        List<ItemStack> stacks = new ArrayList<>();
        for (Supplier<Block> registeredBlock : CommonPlatformHelperImpl.REGISTERED_BLOCKS) {
            Block block = registeredBlock.get();
            if (block != null) {
                stacks.add(new ItemStack(block));
            }
        }
        ItemGroupEvents.modifyEntriesEvent(MoreVillagers.TAB).register(content -> {
            content.acceptAll(stacks);
        });
    }
}