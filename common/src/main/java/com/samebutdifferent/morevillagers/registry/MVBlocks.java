package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public class MVBlocks {
    public static void init() {}

    public static final Supplier<Block> OCEANOGRAPHY_TABLE = registerBlock("oceanography_table", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE));
    public static final Supplier<Block> WOODWORKING_TABLE = registerBlock("woodworking_table", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE));
    public static final Supplier<Block> DECAYED_WORKBENCH = registerBlock("decayed_workbench", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE));
    public static final Supplier<Block> PURPUR_ALTAR = registerBlock("purpur_altar", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE));
    public static final Supplier<Block> BLUEPRINT_TABLE = registerBlock("blueprint_table", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE));
    public static final Supplier<Block> GARDENING_TABLE = registerBlock("gardening_table", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE));
    public static final Supplier<Block> HUNTING_POST = registerBlock("hunting_post", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CARTOGRAPHY_TABLE));
    public static final Supplier<Block> MINING_BENCH = registerBlock("mining_bench", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static <T extends Block> Supplier<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block, BlockBehaviour.Properties properties) {
        Identifier identifier = Identifier.fromNamespaceAndPath(MoreVillagers.MOD_ID, name);
        Supplier<T> toReturn = CommonPlatformHelper.registerBlock(name, () -> block.apply(
            properties.setId(ResourceKey.create(Registries.BLOCK, identifier))
        ));
        CommonPlatformHelper.registerItem(name, () -> new BlockItem(toReturn.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, identifier))));
        return toReturn;
    }
}
