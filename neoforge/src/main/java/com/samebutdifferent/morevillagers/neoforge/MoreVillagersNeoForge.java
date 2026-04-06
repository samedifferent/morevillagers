package com.samebutdifferent.morevillagers.neoforge;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.datagen.MVTradesTagsProvider;
import com.samebutdifferent.morevillagers.neoforge.platform.NeoForgePlatformHelper;
import com.samebutdifferent.morevillagers.registry.MVTradeSets;
import com.samebutdifferent.morevillagers.registry.MVTrades;
import com.samebutdifferent.morevillagers.neoforge.registry.MVConfigNeoForge;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(MoreVillagers.MOD_ID)
public class MoreVillagersNeoForge {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB.identifier(), MoreVillagers.MOD_ID);

    public MoreVillagersNeoForge(ModContainer container) {
        MoreVillagers.init();

        container.registerConfig(ModConfig.Type.COMMON, MVConfigNeoForge.COMMON_CONFIG);

        CREATIVE_MODE_TABS.register(container.getEventBus());
        NeoForgePlatformHelper.BLOCKS.register(container.getEventBus());
        NeoForgePlatformHelper.ITEMS.register(container.getEventBus());
        NeoForgePlatformHelper.POI_TYPES.register(container.getEventBus());
        NeoForgePlatformHelper.PROFESSIONS.register(container.getEventBus());

        container.getEventBus().addListener(this::gatherData);

        NeoForge.EVENT_BUS.register(this);

        CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MoreVillagers.MOD_ID + ".tab"))
            .icon(() -> new ItemStack(Items.EMERALD))
            .displayItems((_, output) -> {
                for (DeferredHolder<Item, ?> item : NeoForgePlatformHelper.ITEMS.getEntries()) {
                    output.accept(item.get());
                }
            })
            .build());
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(ServerAboutToStartEvent event) {
        MoreVillagers.registerJigsaws(event.getServer());
    }

    private void gatherData(GatherDataEvent.Server event) {
        event.createDatapackRegistryObjects(
            new RegistrySetBuilder()
                .add(Registries.TRADE_SET, MVTradeSets::bootstrap)
                .add(Registries.VILLAGER_TRADE, MVTrades::bootstrap)
        );
        event.createProvider(packOutput -> new MVTradesTagsProvider(packOutput, event.getLookupProvider()));
    }
}