package io.github.pheonixvx.morevillagersfabric;

import io.github.pheonixvx.morevillagersfabric.config.MoreVillagersConfig;
import io.github.pheonixvx.morevillagersfabric.init.BlockInit;
import io.github.pheonixvx.morevillagersfabric.init.ItemInit;
import io.github.pheonixvx.morevillagersfabric.init.JigsawHelper;
import io.github.pheonixvx.morevillagersfabric.init.VillagerInit;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MoreVillagersFabric implements ModInitializer {

    public static final String MOD_ID = "morevillagers";
    public static final CreativeModeTab ITEM_GROUP = FabricItemGroupBuilder.create(
            new ResourceLocation(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(Items.EMERALD))
            .build();
    public static MoreVillagersConfig config;

    @Override
    public void onInitialize() {
        AutoConfig.register(MoreVillagersConfig.class, Toml4jConfigSerializer::new);
        config = AutoConfig.getConfigHolder(MoreVillagersConfig.class).getConfig();

        BlockInit.initBlocks();
        ItemInit.initItems();
        VillagerInit.fillTradeData();
        JigsawHelper.registerAll();
    }
}
