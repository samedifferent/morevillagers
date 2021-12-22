package com.samebutdifferent.morevillagers;

import com.samebutdifferent.morevillagers.init.*;
import com.samebutdifferent.morevillagers.util.JigsawHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreVillagers.MOD_ID)
public class MoreVillagers {
    private static final Logger LOGGER = LogManager.getLogger();
    // MOD ID
    public static final String MOD_ID = "morevillagers";
    // CREATE CREATIVE TAB
    public static final CreativeModeTab GROUP = new CreativeModeTab(MoreVillagers.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.EMERALD);
        }
    };

    public MoreVillagers() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.COMMON_CONFIG);

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModProfessions.PROFESSIONS.register(bus);
        ModPoiTypes.POI_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(ServerAboutToStartEvent event) {
        // PLAINS VILLAGE HOUSES
        if (ModConfig.GENERATE_PLAINS_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_woodworker"), ModConfig.WOODWORKER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_oceanographer"), ModConfig.OCEANOGRAPHER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_florist"), ModConfig.FLORIST_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_hunter"), ModConfig.HUNTER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                    new ResourceLocation("morevillagers:village/plains/plains_engineer"), ModConfig.ENGINEER_HOUSE_WEIGHT.get());
        }
        // TAIGA VILLAGE HOUSES
        if (ModConfig.GENERATE_TAIGA_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_woodworker"), ModConfig.WOODWORKER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_oceanographer"), ModConfig.OCEANOGRAPHER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_florist"), ModConfig.FLORIST_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_hunter"), ModConfig.HUNTER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/taiga/houses"),
                    new ResourceLocation("morevillagers:village/taiga/taiga_engineer"), ModConfig.ENGINEER_HOUSE_WEIGHT.get());
        }
        // SAVANNA VILLAGE HOUSES
        if (ModConfig.GENERATE_SAVANNA_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_woodworker"), ModConfig.WOODWORKER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_oceanographer"), ModConfig.OCEANOGRAPHER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_florist"), ModConfig.FLORIST_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_hunter"), ModConfig.HUNTER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/savanna/houses"),
                    new ResourceLocation("morevillagers:village/savanna/savanna_engineer"), ModConfig.ENGINEER_HOUSE_WEIGHT.get());
        }
        // SNOWY VILLAGE HOUSES
        if (ModConfig.GENERATE_SNOWY_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_woodworker"), ModConfig.WOODWORKER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_oceanographer"), ModConfig.OCEANOGRAPHER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_florist"), ModConfig.FLORIST_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_hunter"), ModConfig.HUNTER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/snowy/houses"),
                    new ResourceLocation("morevillagers:village/snowy/snowy_engineer"), ModConfig.ENGINEER_HOUSE_WEIGHT.get());
        }
        // DESERT VILLAGE HOUSES
        if (ModConfig.GENERATE_DESERT_HOUSES.get()) {
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_woodworker"), ModConfig.WOODWORKER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_oceanographer"), ModConfig.OCEANOGRAPHER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_florist"), ModConfig.FLORIST_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_hunter"), ModConfig.HUNTER_HOUSE_WEIGHT.get());
            JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/desert/houses"),
                    new ResourceLocation("morevillagers:village/desert/desert_engineer"), ModConfig.ENGINEER_HOUSE_WEIGHT.get());
        }
    }
}
