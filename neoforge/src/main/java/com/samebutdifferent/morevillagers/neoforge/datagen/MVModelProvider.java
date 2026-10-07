package com.samebutdifferent.morevillagers.neoforge.datagen;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.datagen.MVModels;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

public class MVModelProvider extends ModelProvider {
    public MVModelProvider(PackOutput output) {
        super(output, MoreVillagers.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blocks, ItemModelGenerators items) {
        MVModels.generate((block, definition) -> {
            Identifier model = definition.template().create(block, definition.textures(), blocks.modelOutput);
            blocks.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, BlockModelGenerators.plainVariant(model)));
            blocks.registerSimpleItemModel(block, model);
        });
    }
}
