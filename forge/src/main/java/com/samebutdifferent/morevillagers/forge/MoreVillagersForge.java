package com.samebutdifferent.morevillagers.forge;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.forge.CommonPlatformHelperImpl;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.registry.forge.MVConfigForge;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

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

        bus.addListener(this::addCreativeModeTab);
        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(ServerAboutToStartEvent event) {
        MoreVillagers.registerJigsaws(event.getServer());
    }

    private void addCreativeModeTab(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, (helper -> {
            List<ItemStack> stacks = new ArrayList<>();
            for (RegistryObject<Block> registeredBlock : CommonPlatformHelperImpl.BLOCKS.getEntries()) {
                Block block = registeredBlock.get();
                stacks.add(new ItemStack(block));
            }
            CreativeModeTab tab = CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MoreVillagers.MOD_ID + ".tab"))
                    .icon(() -> new ItemStack(Items.EMERALD))
                    .displayItems((CreativeModeTab.ItemDisplayParameters arg, CreativeModeTab.Output populator) -> populator.acceptAll(stacks))
                    .build();
            helper.register(MoreVillagers.TAB, tab);
        }));
    }


    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            MVProfessions.fillTradeData();
        });
    }
}