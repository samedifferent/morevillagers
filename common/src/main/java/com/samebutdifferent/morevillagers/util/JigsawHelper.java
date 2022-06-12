package com.samebutdifferent.morevillagers.util;

import com.mojang.datafixers.util.Pair;
import com.samebutdifferent.morevillagers.mixin.StructureTemplatePoolAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.ArrayList;
import java.util.List;

public class JigsawHelper {
    public static void registerJigsaw(MinecraftServer server, ResourceLocation poolLocation, ResourceLocation nbtLocation, int weight) {
        RegistryAccess manager = server.registryAccess();
        Registry<StructureTemplatePool> pools = manager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY);
        StructureTemplatePool pool = pools.get(poolLocation);

        StructureProcessorList processorList = manager.registryOrThrow(Registry.PROCESSOR_LIST_REGISTRY).getOptional(poolLocation).orElse(ProcessorLists.EMPTY.value());
        List<StructurePoolElement> templates = ((StructureTemplatePoolAccessor) pool).getTemplates();

        StructurePoolElement template = StructurePoolElement.legacy(nbtLocation.toString(), Holder.direct(processorList)).apply(StructureTemplatePool.Projection.RIGID);
        for (int i = 0; i < weight; i++) {
            templates.add(template);
        }

        List<Pair<StructurePoolElement, Integer>> rawTemplates = new ArrayList<>(((StructureTemplatePoolAccessor) pool).getRawTemplates());

        templates.addAll(((StructureTemplatePoolAccessor) pool).getTemplates());
        rawTemplates.addAll(((StructureTemplatePoolAccessor) pool).getRawTemplates());

        ((StructureTemplatePoolAccessor) pool).setTemplates(templates);
        ((StructureTemplatePoolAccessor) pool).setRawTemplates(rawTemplates);
    }
}