package io.github.pheonixvx.morevillagersfabric.init;

import com.mojang.datafixers.util.Pair;
import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import io.github.pheonixvx.morevillagersfabric.mixin.StructurePoolAccessor;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class JigsawHelper {
    public static void registerJigsaw(MinecraftServer server, Identifier poolLocation, Identifier nbtLocation, int weight) {
        DynamicRegistryManager manager = server.getRegistryManager();
        Registry<StructurePool> pools = manager.get(Registry.STRUCTURE_POOL_KEY);
        StructurePool pool = pools.get(poolLocation);

        StructureProcessorList processorList = manager.get(Registry.STRUCTURE_PROCESSOR_LIST_KEY).getOrEmpty(poolLocation).orElse(StructureProcessorLists.EMPTY);
        List<StructurePoolElement> elements = ((StructurePoolAccessor) pool).getElements();

        StructurePoolElement element = StructurePoolElement.ofProcessedLegacySingle(nbtLocation.toString(), processorList).apply(StructurePool.Projection.RIGID);
        for (int i = 0; i < weight; i++) {
            elements.add(element);
        }

        List<Pair<StructurePoolElement, Integer>> elementCounts = new ArrayList<>(((StructurePoolAccessor) pool).getElementCounts());

        elements.addAll(((StructurePoolAccessor) pool).getElements());
        elementCounts.addAll(((StructurePoolAccessor) pool).getElementCounts());

        ((StructurePoolAccessor) pool).setElements(elements);
        ((StructurePoolAccessor) pool).setElementCounts(elementCounts);
    }

    public static void registerAll() {

        ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
            Identifier plainsPoolLocation = new Identifier("minecraft:village/plains/houses");
            Identifier desertPoolLocation = new Identifier("minecraft:village/desert/houses");
            Identifier savannaPoolLocation = new Identifier("minecraft:village/savanna/houses");
            Identifier snowyPoolLocation = new Identifier("minecraft:village/snowy/houses");
            Identifier taigaPoolLocation = new Identifier("minecraft:village/taiga/houses");

            // PLAINS VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_PLAINS_HOUSES) {
                registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_woodworker"), 12);
                registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_oceanographer"), 12);
                registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_florist"), 13);
                registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_hunter"), 15);
                registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_engineer"), 25);
            }

            // TAIGA VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_TAIGA_HOUSES) {
                registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_woodworker"), 12);
                registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_oceanographer"), 12);
                registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_florist"), 13);
                registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_hunter"), 15);
                registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_engineer"), 25);
            }

            // SAVANNA VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_SAVANNA_HOUSES) {
                registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_woodworker"), 12);
                registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_oceanographer"), 12);
                registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_florist"), 13);
                registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_hunter"), 15);
                registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_engineer"), 25);
            }

            // SNOWY VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_SNOWY_HOUSES) {
                registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_woodworker"), 12);
                registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_oceanographer"), 12);
                registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_florist"), 13);
                registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_hunter"), 15);
                registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_engineer"), 25);
            }

            // DESERT VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_DESERT_HOUSES) {
                registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_woodworker"), 12);
                registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_oceanographer"), 12);
                registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_florist"), 13);
                registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_hunter_engineer"), 15);
            }

        });
    }
}
