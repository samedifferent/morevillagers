package com.samebutdifferent.morevillagers.init;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreVillagers.MOD_ID);

    // BLOCKS
    public static final RegistryObject<Block> OCEANOGRAPHY_TABLE = BLOCKS.register("oceanography_table",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> WOODWORKING_TABLE = BLOCKS.register("woodworking_table",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> DECAYED_WORKBENCH = BLOCKS.register("decayed_workbench",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> PURPUR_ALTAR = BLOCKS.register("purpur_altar",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> BLUEPRINT_TABLE = BLOCKS.register("blueprint_table",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> GARDENING_TABLE = BLOCKS.register("gardening_table",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> HUNTING_POST = BLOCKS.register("hunting_post",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> MINING_BENCH = BLOCKS.register("mining_bench",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
}
