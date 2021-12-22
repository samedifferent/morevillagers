package io.github.pheonixvx.morevillagersfabric.init;

import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item OCEANOGRAPHY_TABLE = new BlockItem(ModBlocks.OCEANOGRAPHY_TABLE, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));
    public static final Item WOODWORKING_TABLE = new BlockItem(ModBlocks.WOODWORKING_TABLE, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));
    public static final Item DECAYED_WORKBENCH = new BlockItem(ModBlocks.DECAYED_WORKBRENCH, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));
    public static final Item PURPUR_ALTAR = new BlockItem(ModBlocks.PURPUR_ALTAR, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));
    public static final Item BLUEPRINT_TABLE = new BlockItem(ModBlocks.BLUEPRINT_TABLE, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));
    public static final Item GARDENING_TABLE = new BlockItem(ModBlocks.GARDENING_TABLE, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));
    public static final Item HUNTING_POST = new BlockItem(ModBlocks.HUNTING_POST, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));
    public static final Item MINING_BENCH = new BlockItem(ModBlocks.MINING_BENCH, new Item.Properties().tab(MoreVillagersFabric.ITEM_GROUP));

    public static void initItems() {
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "oceanography_table"), OCEANOGRAPHY_TABLE);
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "woodworking_table"), WOODWORKING_TABLE);
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "decayed_workbench"), DECAYED_WORKBENCH);
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "purpur_altar"), PURPUR_ALTAR);
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "blueprint_table"), BLUEPRINT_TABLE);
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "gardening_table"), GARDENING_TABLE);
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "hunting_post"), HUNTING_POST);
        Registry.register(Registry.ITEM, new ResourceLocation(MoreVillagersFabric.MOD_ID, "mining_bench"), MINING_BENCH);
    }
}
