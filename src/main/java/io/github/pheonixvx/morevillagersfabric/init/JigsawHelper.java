package io.github.pheonixvx.morevillagersfabric.init;

import com.mojang.datafixers.util.Pair;
import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import io.github.pheonixvx.morevillagersfabric.mixin.StructureTemplatePoolAccessor;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.ArrayList;
import java.util.List;

public class JigsawHelper {
    public static void registerJigsaw(MinecraftServer server, ResourceLocation poolLocation, ResourceLocation nbtLocation, int weight) {
        RegistryAccess manager = server.registryAccess();
        Registry<StructureTemplatePool> pools = manager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY);
        StructureTemplatePool pool = pools.get(poolLocation);

        StructureProcessorList processorList = manager.registryOrThrow(Registry.PROCESSOR_LIST_REGISTRY).getOptional(poolLocation).orElse(ProcessorLists.EMPTY);
        List<StructurePoolElement> templates = ((StructureTemplatePoolAccessor) pool).getTemplates();

        StructurePoolElement template = StructurePoolElement.legacy(nbtLocation.toString(), processorList).apply(StructureTemplatePool.Projection.RIGID);
        for (int i = 0; i < weight; i++) {
            templates.add(template);
        }

        List<Pair<StructurePoolElement, Integer>> rawTemplates = new ArrayList<>(((StructureTemplatePoolAccessor) pool).getRawTemplates());

        templates.addAll(((StructureTemplatePoolAccessor) pool).getTemplates());
        rawTemplates.addAll(((StructureTemplatePoolAccessor) pool).getRawTemplates());

        ((StructureTemplatePoolAccessor) pool).setTemplates(templates);
        ((StructureTemplatePoolAccessor) pool).setRawTemplates(rawTemplates);
    }

    public static void registerAll() {

        ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
            ResourceLocation plainsPoolLocation = new ResourceLocation("minecraft:village/plains/houses");
            ResourceLocation desertPoolLocation = new ResourceLocation("minecraft:village/desert/houses");
            ResourceLocation savannaPoolLocation = new ResourceLocation("minecraft:village/savanna/houses");
            ResourceLocation snowyPoolLocation = new ResourceLocation("minecraft:village/snowy/houses");
            ResourceLocation taigaPoolLocation = new ResourceLocation("minecraft:village/taiga/houses");

            // PLAINS VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_PLAINS_HOUSES) {
                registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_woodworker"), 12);
                registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_oceanographer"), 12);
                registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_florist"), 13);
                registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_hunter"), 15);
                registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_engineer"), 25);
            }

            // TAIGA VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_TAIGA_HOUSES) {
                registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_woodworker"), 12);
                registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_oceanographer"), 12);
                registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_florist"), 13);
                registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_hunter"), 15);
                registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_engineer"), 25);
            }

            // SAVANNA VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_SAVANNA_HOUSES) {
                registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_woodworker"), 12);
                registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_oceanographer"), 12);
                registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_florist"), 13);
                registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_hunter"), 15);
                registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_engineer"), 25);
            }

            // SNOWY VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_SNOWY_HOUSES) {
                registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_woodworker"), 12);
                registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_oceanographer"), 12);
                registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_florist"), 13);
                registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_hunter"), 15);
                registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_engineer"), 25);
            }

            // DESERT VILLAGE HOUSES
            if (MoreVillagersFabric.config.GENERATE_DESERT_HOUSES) {
                registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_woodworker"), 12);
                registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_oceanographer"), 12);
                registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_florist"), 13);
                registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_hunter_engineer"), 15);
            }

        });
    }
}
