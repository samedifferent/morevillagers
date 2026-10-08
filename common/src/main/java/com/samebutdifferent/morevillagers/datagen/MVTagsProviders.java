package com.samebutdifferent.morevillagers.datagen;

import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class MVTagsProviders {
    public static class Blocks extends TagsProvider<Block> {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, Registries.BLOCK, registries);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            for (Block block : List.of(MVBlocks.OCEANOGRAPHY_TABLE.get(), MVBlocks.WOODWORKING_TABLE.get(),
                MVBlocks.DECAYED_WORKBENCH.get(), MVBlocks.BLUEPRINT_TABLE.get(), MVBlocks.GARDENING_TABLE.get(), MVBlocks.HUNTING_POST.get())) {
                tag(BlockTags.MINEABLE_WITH_AXE).add(BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow());
            }
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BuiltInRegistries.BLOCK.getResourceKey(MVBlocks.PURPUR_ALTAR.get()).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(MVBlocks.MINING_BENCH.get()).orElseThrow());
        }
    }

    public static class PoiTypes extends TagsProvider<PoiType> {
        public PoiTypes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, Registries.POINT_OF_INTEREST_TYPE, registries);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            for (PoiType poi : List.of(MVPoiTypes.OCEANOGRAPHER_POI.get(), MVPoiTypes.NETHERIAN_POI.get(),
                MVPoiTypes.WOODWORKER_POI.get(), MVPoiTypes.ENDERIAN_POI.get(), MVPoiTypes.ENGINEER_POI.get(),
                MVPoiTypes.FLORIST_POI.get(), MVPoiTypes.HUNTER_POI.get(), MVPoiTypes.MINER_POI.get())) {
                tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(poi).orElseThrow());
            }
        }
    }

    public static class Structures extends TagsProvider<Structure> {
        public Structures(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, Registries.STRUCTURE, registries);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            tag(MVTags.ON_FORTRESS_EXPLORER_MAPS).add(BuiltinStructures.FORTRESS);
            tag(MVTags.ON_BASTION_REMNANT_EXPLORER_MAPS).add(BuiltinStructures.BASTION_REMNANT);
            tag(MVTags.ON_END_CITY_EXPLORER_MAPS).add(BuiltinStructures.END_CITY);
            tag(MVTags.ON_PILLAGER_OUTPOST_EXPLORER_MAPS).add(BuiltinStructures.PILLAGER_OUTPOST);
        }
    }
}
