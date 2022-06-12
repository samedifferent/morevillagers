package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class MVBlocks {
    public static void init() {}

    public static final Supplier<Block> OCEANOGRAPHY_TABLE = registerBlock("oceanography_table", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    public static final Supplier<Block> WOODWORKING_TABLE = registerBlock("woodworking_table", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    public static final Supplier<Block> DECAYED_WORKBENCH = registerBlock("decayed_workbench", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    public static final Supplier<Block> PURPUR_ALTAR = registerBlock("purpur_altar", () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final Supplier<Block> BLUEPRINT_TABLE = registerBlock("blueprint_table", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    public static final Supplier<Block> GARDENING_TABLE = registerBlock("gardening_table", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    public static final Supplier<Block> HUNTING_POST = registerBlock("hunting_post", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    public static final Supplier<Block> MINING_BENCH = registerBlock("mining_bench", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> toReturn = CommonPlatformHelper.registerBlock(name, block);
        CommonPlatformHelper.registerItem(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(MoreVillagers.TAB)));
        return toReturn;
    }
}
