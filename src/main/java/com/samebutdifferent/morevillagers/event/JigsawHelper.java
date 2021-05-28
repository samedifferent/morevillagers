package com.samebutdifferent.morevillagers.event;

import com.mojang.datafixers.util.Pair;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraft.world.gen.feature.template.StructureProcessorList;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;

public class JigsawHelper {
    public static void registerJigsaw(MinecraftServer server, ResourceLocation poolLocation, ResourceLocation nbtLocation, int weight) {
        DynamicRegistries manager = server.registryAccess();
        MutableRegistry<JigsawPattern> pools = manager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY);
        JigsawPattern pool = pools.get(poolLocation);

        StructureProcessorList processorList = manager.registryOrThrow(Registry.PROCESSOR_LIST_REGISTRY).getOptional(poolLocation).orElse(ProcessorLists.EMPTY);
        List<JigsawPiece> elements = (ObfuscationReflectionHelper.getPrivateValue(JigsawPattern.class, pool, "templates"));

        JigsawPiece element = JigsawPiece.legacy(nbtLocation.toString(), processorList).apply(JigsawPattern.PlacementBehaviour.RIGID);
        for (int i = 0; i < weight; i++) {
            elements.add(element);
        }

        List<Pair<JigsawPiece, Integer>> elementCounts = new ArrayList(ObfuscationReflectionHelper.getPrivateValue(JigsawPattern.class, pool, "rawTemplates"));

        elements.addAll(ObfuscationReflectionHelper.getPrivateValue(JigsawPattern.class, pool, "templates"));
        elementCounts.addAll(ObfuscationReflectionHelper.getPrivateValue(JigsawPattern.class, pool, "rawTemplates"));

        ObfuscationReflectionHelper.setPrivateValue(JigsawPattern.class, pool, elements, "templates");
        ObfuscationReflectionHelper.setPrivateValue(JigsawPattern.class, pool, elementCounts, "rawTemplates");
    }
}
