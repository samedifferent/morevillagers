package io.github.pheonixvx.morevillagersfabric.init;

import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockInit {

    public static final Block OCEANOGRAPHY_TABLE = new Block(AbstractBlock.Settings.copy(Blocks.CARTOGRAPHY_TABLE));
    public static final Block WOODWORKING_TABLE = new Block(AbstractBlock.Settings.copy(Blocks.CARTOGRAPHY_TABLE));
    public static final Block DECAYED_WORKBRENCH = new Block(AbstractBlock.Settings.copy(Blocks.CARTOGRAPHY_TABLE));
    public static final Block PURPUR_ALTAR = new Block(AbstractBlock.Settings.copy(Blocks.END_STONE));
    public static final Block BLUEPRINT_TABLE = new Block(AbstractBlock.Settings.copy(Blocks.CARTOGRAPHY_TABLE));
    public static final Block GARDENING_TABLE = new Block(AbstractBlock.Settings.copy(Blocks.CARTOGRAPHY_TABLE));
    public static final Block HUNTING_POST = new Block(AbstractBlock.Settings.copy(Blocks.CARTOGRAPHY_TABLE));

    public static void initBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(MoreVillagersFabric.MOD_ID, "oceanography_table"), OCEANOGRAPHY_TABLE);
        Registry.register(Registry.BLOCK, new Identifier(MoreVillagersFabric.MOD_ID, "woodworking_table"), WOODWORKING_TABLE);
        Registry.register(Registry.BLOCK, new Identifier(MoreVillagersFabric.MOD_ID, "decayed_workbench"), DECAYED_WORKBRENCH);
        Registry.register(Registry.BLOCK, new Identifier(MoreVillagersFabric.MOD_ID, "purpur_altar"), PURPUR_ALTAR);
        Registry.register(Registry.BLOCK, new Identifier(MoreVillagersFabric.MOD_ID, "blueprint_table"), BLUEPRINT_TABLE);
        Registry.register(Registry.BLOCK, new Identifier(MoreVillagersFabric.MOD_ID, "gardening_table"), GARDENING_TABLE);
        Registry.register(Registry.BLOCK, new Identifier(MoreVillagersFabric.MOD_ID, "hunting_post"), HUNTING_POST);
    }
}
