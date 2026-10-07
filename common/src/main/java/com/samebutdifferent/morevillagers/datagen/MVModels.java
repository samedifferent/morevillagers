package com.samebutdifferent.morevillagers.datagen;

import com.samebutdifferent.morevillagers.registry.MVBlocks;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import java.util.function.BiConsumer;

public class MVModels {
    public record Definition(ModelTemplate template, TextureMapping textures) {}

    public static void generate(BiConsumer<Block, Definition> models) {
        bottomTop(models, MVBlocks.DECAYED_WORKBENCH.get());
        bottomTop(models, MVBlocks.GARDENING_TABLE.get());
        cube(models, MVBlocks.MINING_BENCH.get(), "bottom", "front", "back", "right", "left", "top", "bottom");
        cube(models, MVBlocks.HUNTING_POST.get(), "bottom", "back", "front", "right", "left", "top", "bottom");
        cube(models, MVBlocks.PURPUR_ALTAR.get(), "bottom", "back", "front", "right", "left", "top", "bottom");
        cube(models, MVBlocks.BLUEPRINT_TABLE.get(), "front", "front", "side", "side", "front", "top", "bottom");
        cube(models, MVBlocks.OCEANOGRAPHY_TABLE.get(), "side", "back", "front", "side", "side", "top", "minecraft:block/barrel_bottom");
        cube(models, MVBlocks.WOODWORKING_TABLE.get(), "side", "front", "back", "side", "side2", "top", "minecraft:block/beehive_end");
    }

    private static void bottomTop(BiConsumer<Block, Definition> models, Block block) {
        TexturedModel model = TexturedModel.CUBE_BOTTOM_TOP.get(block);
        models.accept(block, new Definition(model.getTemplate(), model.getMapping()));
    }

    private static void cube(BiConsumer<Block, Definition> models, Block block, String... textures) {
        TextureSlot[] slots = {TextureSlot.PARTICLE, TextureSlot.NORTH, TextureSlot.SOUTH, TextureSlot.EAST,
            TextureSlot.WEST, TextureSlot.UP, TextureSlot.DOWN};
        TextureMapping mapping = new TextureMapping();
        for (int i = 0; i < slots.length; i++) {
            Material texture = textures[i].contains(":") ? new Material(Identifier.parse(textures[i])) : TextureMapping.getBlockTexture(block, "_" + textures[i]);
            mapping.put(slots[i], texture);
        }
        models.accept(block, new Definition(ModelTemplates.CUBE, mapping));
    }

}
