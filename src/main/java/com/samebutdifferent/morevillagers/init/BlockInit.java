package com.samebutdifferent.morevillagers.init;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreVillagers.MOD_ID);

    // BLOCKS
    public static final RegistryObject<Block> OCEANOGRAPHY_TABLE = BLOCKS.register("oceanography_table",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> WOODWORKING_TABLE = BLOCKS.register("woodworking_table",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> DECAYED_WORKBENCH = BLOCKS.register("decayed_workbench",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

    public static final RegistryObject<Block> PURPUR_ALTAR = BLOCKS.register("purpur_altar",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.END_STONE)));

    public static final RegistryObject<Block> BLUEPRINT_TABLE = BLOCKS.register("blueprint_table",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));

}
