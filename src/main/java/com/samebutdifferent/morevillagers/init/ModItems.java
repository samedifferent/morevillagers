package com.samebutdifferent.morevillagers.init;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreVillagers.MOD_ID);

    // BLOCK ITEMS
    public static final RegistryObject<BlockItem> OCEANOGRAPHY_TABLE = ITEMS.register("oceanography_table",
            () -> new BlockItem(ModBlocks.OCEANOGRAPHY_TABLE.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> WOODWORKING_TABLE = ITEMS.register("woodworking_table",
            () -> new BlockItem(ModBlocks.WOODWORKING_TABLE.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> DECAYED_WORKBENCH = ITEMS.register("decayed_workbench",
            () -> new BlockItem(ModBlocks.DECAYED_WORKBENCH.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> PURPUR_ALTAR = ITEMS.register("purpur_altar",
            () -> new BlockItem(ModBlocks.PURPUR_ALTAR.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> BLUEPRINT_TABLE = ITEMS.register("blueprint_table",
            () -> new BlockItem(ModBlocks.BLUEPRINT_TABLE.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> GARDENING_TABLE = ITEMS.register("gardening_table",
            () -> new BlockItem(ModBlocks.GARDENING_TABLE.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> HUNTING_POST = ITEMS.register("hunting_post",
            () -> new BlockItem(ModBlocks.HUNTING_POST.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> MINING_BENCH = ITEMS.register("mining_bench",
            () -> new BlockItem(ModBlocks.MINING_BENCH.get(), new Item.Properties().tab(MoreVillagers.GROUP)));
}
