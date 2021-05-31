package io.github.pheonixvx.morevillagersfabric;

import com.mojang.datafixers.util.Pair;
import io.github.pheonixvx.morevillagersfabric.init.BlockInit;
import io.github.pheonixvx.morevillagersfabric.init.ItemInit;
import io.github.pheonixvx.morevillagersfabric.init.VillagerInit;
import io.github.pheonixvx.morevillagersfabric.mixin.StructurePoolAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class MoreVillagersFabric implements ModInitializer {

    public static final String MOD_ID = "morevillagers";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(Items.EMERALD))
            .build();

    public static void registerJigsaw(MinecraftServer server, Identifier poolLocation, Identifier nbtLocation, int weight) {
        DynamicRegistryManager manager = server.getRegistryManager();
        MutableRegistry<StructurePool> pools = manager.get(Registry.TEMPLATE_POOL_WORLDGEN);
        StructurePool pool = pools.get(poolLocation);

        StructureProcessorList processorList = manager.get(Registry.PROCESSOR_LIST_WORLDGEN).getOrEmpty(poolLocation).orElse(StructureProcessorLists.EMPTY);
        List<StructurePoolElement> elements = ((StructurePoolAccessor) pool).getElements();

        StructurePoolElement element = StructurePoolElement.method_30426(nbtLocation.toString(), processorList).apply(StructurePool.Projection.RIGID);
        for (int i = 0; i < weight; i++) {
            elements.add(element);
        }

        List<Pair<StructurePoolElement, Integer>> elementCounts = new ArrayList<>(((StructurePoolAccessor) pool).getElementCounts());

        elements.addAll(((StructurePoolAccessor) pool).getElements());
        elementCounts.addAll(((StructurePoolAccessor) pool).getElementCounts());

        ((StructurePoolAccessor) pool).setElements(elements);
        ((StructurePoolAccessor) pool).setElementCounts(elementCounts);
    }

    @Override
    public void onInitialize() {
        BlockInit.initBlocks();
        ItemInit.initItems();
        VillagerInit.fillTradeData();

        ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
            Identifier plainsPoolLocation = new Identifier("minecraft:village/plains/houses");
            Identifier desertPoolLocation = new Identifier("minecraft:village/desert/houses");
            Identifier savannaPoolLocation = new Identifier("minecraft:village/savanna/houses");
            Identifier snowyPoolLocation = new Identifier("minecraft:village/snowy/houses");
            Identifier taigaPoolLocation = new Identifier("minecraft:village/taiga/houses");

            // PLAINS VILLAGE HOUSES
            registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_woodworker"), 12);
            registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_oceanographer"), 12);
            registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_florist"), 13);
            registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_hunter"), 15);
            registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_engineer"), 15);

            // TAIGA VILLAGE HOUSES
            registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_woodworker"), 12);
            registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_oceanographer"), 12);
            registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_florist"), 13);
            registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_hunter"), 15);
            registerJigsaw(server, taigaPoolLocation, new Identifier("morevillagers:village/taiga/taiga_engineer"), 15);

            // SAVANNA VILLAGE HOUSES
            registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_woodworker"), 12);
            registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_oceanographer"), 12);
            registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_florist"), 13);
            registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_hunter"), 15);
            registerJigsaw(server, savannaPoolLocation, new Identifier("morevillagers:village/savanna/savanna_engineer"), 15);

            // SNOWY VILLAGE HOUSES
            registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_woodworker"), 12);
            registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_oceanographer"), 12);
            registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_florist"), 13);
            registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_hunter"), 15);
            registerJigsaw(server, snowyPoolLocation, new Identifier("morevillagers:village/snowy/snowy_engineer"), 15);

            // DESERT VILLAGE HOUSES
            registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_woodworker"), 12);
            registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_oceanographer"), 12);
            registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_florist"), 13);
            registerJigsaw(server, desertPoolLocation, new Identifier("morevillagers:village/desert/desert_hunter_hunter_engineer"), 15);
        });
    }
}
