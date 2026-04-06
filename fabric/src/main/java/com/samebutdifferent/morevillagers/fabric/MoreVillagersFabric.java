package com.samebutdifferent.morevillagers.fabric;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.fabric.platform.FabricPlatformHelper;
import com.samebutdifferent.morevillagers.fabric.registry.MVConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MoreVillagersFabric implements ModInitializer {
    public static final CreativeModeTab CREATIVE_MODE_TAB = FabricCreativeModeTab.builder()
        .icon(() -> new ItemStack(Items.EMERALD))
        .title(Component.translatable("itemGroup." + MoreVillagers.MOD_ID + ".tab"))
        .displayItems((_, output) -> {
            FabricPlatformHelper.REGISTERED_ITEMS.forEach(item -> {
               output.accept(item.get());
            });
        })
        .build();

    @Override
    public void onInitialize() {
        AutoConfig.register(MVConfigFabric.class, GsonConfigSerializer::new);
        MoreVillagers.init();
        ServerLifecycleEvents.SERVER_STARTING.register(MoreVillagers::registerJigsaws);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MoreVillagers.TAB, CREATIVE_MODE_TAB);
    }
}