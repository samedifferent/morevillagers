package com.samebutdifferent.morevillagers.init;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreVillagers.MOD_ID);

    // BLOCK ITEMS
    public static final RegistryObject<BlockItem> OCEANOGRAPHY_TABLE = ITEMS.register("oceanography_table",
            () -> new BlockItem(BlockInit.OCEANOGRAPHY_TABLE.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> WOODWORKING_TABLE = ITEMS.register("woodworking_table",
            () -> new BlockItem(BlockInit.WOODWORKING_TABLE.get(), new Item.Properties().tab(MoreVillagers.GROUP)));

    public static final RegistryObject<BlockItem> DECAYED_WORKBENCH = ITEMS.register("decayed_workbench",
            () -> new BlockItem(BlockInit.DECAYED_WORKBENCH.get(), new Item.Properties().tab(MoreVillagers.GROUP)));
}
