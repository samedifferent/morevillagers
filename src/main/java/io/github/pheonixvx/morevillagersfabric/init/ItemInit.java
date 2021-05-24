package io.github.pheonixvx.morevillagersfabric.init;

import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemInit {

    public static final Item OCEANOGRAPHY_TABLE = new BlockItem(BlockInit.OCEANOGRAPHY_TABLE, new Item.Settings().group(MoreVillagersFabric.ITEM_GROUP));
    public static final Item WOODWORKING_TABLE = new BlockItem(BlockInit.WOODWORKING_TABLE, new Item.Settings().group(MoreVillagersFabric.ITEM_GROUP));

    public static void initItems() {
        Registry.register(Registry.ITEM, new Identifier(MoreVillagersFabric.MOD_ID, "oceanography_table"), OCEANOGRAPHY_TABLE);
        Registry.register(Registry.ITEM, new Identifier(MoreVillagersFabric.MOD_ID, "woodworking_table"), WOODWORKING_TABLE);
    }
}
