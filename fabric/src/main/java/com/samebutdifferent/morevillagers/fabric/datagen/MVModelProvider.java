package com.samebutdifferent.morevillagers.fabric.datagen;

import com.samebutdifferent.morevillagers.datagen.MVModels;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.resources.Identifier;

public class MVModelProvider extends FabricModelProvider {
    public MVModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators models) {
        MVModels.generate((block, definition) -> {
            Identifier model = definition.template().create(block, definition.textures(), models.modelOutput);
            models.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, BlockModelGenerators.plainVariant(model)));
            models.registerSimpleItemModel(block, model);
        });
    }

    @Override
    public void generateItemModels(ItemModelGenerators models) {
    }
}
