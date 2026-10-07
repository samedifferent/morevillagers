package com.samebutdifferent.morevillagers.datagen;

import com.samebutdifferent.morevillagers.registry.MVBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.List;

public class MVLootTables {
    public static void bootstrap(BootstrapContext<LootTable> context) {
        for (Block block : List.of(MVBlocks.OCEANOGRAPHY_TABLE.get(), MVBlocks.WOODWORKING_TABLE.get(),
            MVBlocks.DECAYED_WORKBENCH.get(), MVBlocks.PURPUR_ALTAR.get(), MVBlocks.BLUEPRINT_TABLE.get(),
            MVBlocks.GARDENING_TABLE.get(), MVBlocks.HUNTING_POST.get(), MVBlocks.MINING_BENCH.get())) {
            context.register(block.getLootTable().orElseThrow(), LootTable.lootTable()
                .setParamSet(LootContextParamSets.BLOCK)
                .withPool(LootPool.lootPool().setRolls(ContextIntProviders.exactly(1))
                    .add(LootItem.lootTableItem(block).apply(CopyNameFunction.copyName(LootContext.BlockEntityTarget.BLOCK_ENTITY)))
                    .when(ExplosionCondition.survivesExplosion())).build());
        }
        chest(context, "hunter", Items.ARROW, Items.SPIDER_EYE, Items.ENDER_PEARL, Items.LEATHER, Items.APPLE);
        chest(context, "oceanographer", Items.PRISMARINE_CRYSTALS, Items.PAPER, Items.SEA_PICKLE, Items.MAP, Items.DRIED_KELP);
    }

    private static void chest(BootstrapContext<LootTable> context, String profession, Item... items) {
        LootPool.Builder pool = LootPool.lootPool().setRolls(ContextIntProviders.between(1, 5))
            .add(LootItem.lootTableItem(Items.EMERALD));
        int[] weights = {2, 6, 2, 6, 6};
        for (int i = 0; i < items.length; i++) {
            pool.add(LootItem.lootTableItem(items[i]).setWeight(weights[i])
                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))));
        }
        context.register(ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath("morevillagers", "chests/village/village_" + profession)),
            LootTable.lootTable().setParamSet(LootContextParamSets.CHEST).withPool(pool).build());
    }
}
