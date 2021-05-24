package io.github.pheonixvx.morevillagersfabric;

import io.github.pheonixvx.morevillagersfabric.init.BlockInit;
import io.github.pheonixvx.morevillagersfabric.init.ItemInit;
import io.github.pheonixvx.morevillagersfabric.init.VillagerInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class MoreVillagersFabric implements ModInitializer {

    public static final String MOD_ID = "morevillagers";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(Items.EMERALD))
            .build();

    @Override
    public void onInitialize() {
        BlockInit.initBlocks();
        ItemInit.initItems();
        VillagerInit.fillTradeData();
    }
}
