package com.samebutdifferent.morevillagers.util;

import com.mojang.datafixers.util.Pair;
import com.samebutdifferent.morevillagers.mixin.StructureTemplatePoolAccessor;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.structures.SinglePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;

import java.util.ArrayList;
import java.util.List;

public class JigsawHelper {
    public static void addBuildingToPool(WritableRegistry<StructureTemplatePool> templatePoolRegistry, ResourceLocation poolRL, String nbtPieceRL, int weight) {
        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        if (pool == null) return;

        SinglePoolElement piece = SinglePoolElement.single(nbtPieceRL).apply(StructureTemplatePool.Projection.RIGID);

        for (int i = 0; i < weight; i++) {
            ((StructureTemplatePoolAccessor) pool).getTemplates().add(piece);
        }

        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(((StructureTemplatePoolAccessor) pool).getRawTemplates());
        listOfPieceEntries.add(new Pair<>(piece, weight));
        ((StructureTemplatePoolAccessor) pool).setRawTemplates(listOfPieceEntries);
    }
}