package com.samebutdifferent.morevillagers.neoforge;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.datagen.MVTradesTagsProvider;
import com.samebutdifferent.morevillagers.datagen.MVAdvancements;
import com.samebutdifferent.morevillagers.datagen.MVLootTables;
import com.samebutdifferent.morevillagers.datagen.MVRecipeProvider;
import com.samebutdifferent.morevillagers.datagen.MVTagsProviders;
import com.samebutdifferent.morevillagers.neoforge.datagen.MVModelProvider;
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

        container.registerConfig(ModConfig.Type.SYNCED, MVConfigNeoForge.COMMON_CONFIG);

        CREATIVE_MODE_TABS.register(container.getEventBus());
        NeoForgePlatformHelper.BLOCKS.register(container.getEventBus());
        NeoForgePlatformHelper.ITEMS.register(container.getEventBus());
        NeoForgePlatformHelper.POI_TYPES.register(container.getEventBus());
        NeoForgePlatformHelper.PROFESSIONS.register(container.getEventBus());

        container.getEventBus().addListener(this::gatherData);
        container.getEventBus().addListener(this::gatherClientData);

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
        gatherDataProviders(event);
    }

    private void gatherClientData(GatherDataEvent.Client event) {
        gatherDataProviders(event);
        event.createProvider(MVModelProvider::new);
    }

    private void gatherDataProviders(GatherDataEvent event) {
        event.createWorldRegistryObjects(
            new RegistrySetBuilder()
            .add(Registries.TRADE_SET, MVTradeSets::bootstrap)
            .add(Registries.VILLAGER_TRADE, MVTrades::bootstrap)
        );
        event.createReloadableRegistryObjects(new RegistrySetBuilder()
            .add(Registries.LOOT_TABLE, MVLootTables::bootstrap)
            .add(Registries.ADVANCEMENT, MVAdvancements::bootstrap)
            .add(MVRecipeProvider.create()));
        event.createProvider(packOutput -> new MVTradesTagsProvider(packOutput, event.getReloadableLookupProvider()));
        event.createProvider(packOutput -> new MVTagsProviders.Blocks(packOutput, event.getWorldLookupProvider()));
        event.createProvider(packOutput -> new MVTagsProviders.PoiTypes(packOutput, event.getWorldLookupProvider()));
        event.createProvider(packOutput -> new MVTagsProviders.Structures(packOutput, event.getWorldLookupProvider()));
    }
}
