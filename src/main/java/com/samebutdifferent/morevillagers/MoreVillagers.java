package com.samebutdifferent.morevillagers;

import com.samebutdifferent.morevillagers.event.JigsawHelper;
import com.samebutdifferent.morevillagers.init.BlockInit;
import com.samebutdifferent.morevillagers.init.ItemInit;
import com.samebutdifferent.morevillagers.init.VillagerInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        VillagerInit.VILLAGER_PROFESSIONS.register(bus);
        VillagerInit.POINT_OF_INTEREST_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(FMLServerAboutToStartEvent event) {
        JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                new ResourceLocation("morevillagers:village/plains/plains_woodworker"), 6);
        JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                new ResourceLocation("morevillagers:village/plains/plains_oceanographer"), 3);
    }
}
