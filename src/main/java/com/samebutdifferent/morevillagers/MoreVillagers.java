package com.samebutdifferent.morevillagers;

import com.samebutdifferent.morevillagers.event.JigsawHelper;
import com.samebutdifferent.morevillagers.init.BlockInit;
import com.samebutdifferent.morevillagers.init.Config;
import com.samebutdifferent.morevillagers.init.ItemInit;
import com.samebutdifferent.morevillagers.init.VillagerInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreVillagers.MOD_ID)
public class MoreVillagers {
    private static final Logger LOGGER = LogManager.getLogger();
    // MOD ID
    public static final String MOD_ID = "morevillagers";
    // CREATE CREATIVE TAB
    public static final ItemGroup GROUP = new ItemGroup(MoreVillagers.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.EMERALD);
        }
    };

    public MoreVillagers() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        VillagerInit.VILLAGER_PROFESSIONS.register(bus);
        VillagerInit.POINT_OF_INTEREST_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(FMLServerAboutToStartEvent event) {
        // PLAINS VILLAGE HOUSES
        if (Config.GENERATE_PLAINS_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_woodworker"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_oceanographer"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_florist"), 13);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_hunter"), 15);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_engineer"), 25);
        }
        // TAIGA VILLAGE HOUSES
        if (Config.GENERATE_TAIGA_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_woodworker"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_oceanographer"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_florist"), 13);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_hunter"), 15);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_engineer"), 25);
        }
        // SAVANNA VILLAGE HOUSES
        if (Config.GENERATE_SAVANNA_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_woodworker"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_oceanographer"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_florist"), 13);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_hunter"), 15);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_engineer"), 25);
        }
        // SNOWY VILLAGE HOUSES
        if (Config.GENERATE_SNOWY_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_woodworker"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_oceanographer"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_florist"), 13);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_hunter"), 15);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_engineer"), 25);
        }
        // DESERT VILLAGE HOUSES
        if (Config.GENERATE_DESERT_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_woodworker"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_oceanographer"), 12);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_florist"), 13);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_hunter"), 13);
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_engineer"), 15);
        }
    }
}
