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

    @Override
    public void onInitialize() {
        BlockInit.initBlocks();
        ItemInit.initItems();
        VillagerInit.fillTradeData();

        ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
            Identifier plainsPoolLocation = new Identifier("minecraft:village/plains/houses");

            registerJigsaw(server, plainsPoolLocation, new Identifier("morevillagers:village/plains/plains_woodworker"), 2);
        });
    }

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

        List<Pair<StructurePoolElement, Integer>> elementCounts = new ArrayList(((StructurePoolAccessor) pool).getElementCounts());

        elements.addAll(((StructurePoolAccessor) pool).getElements());
        elementCounts.addAll(((StructurePoolAccessor) pool).getElementCounts());

        ((StructurePoolAccessor) pool).setElements(elements);
        ((StructurePoolAccessor) pool).setElementCounts(elementCounts);
    }
}
