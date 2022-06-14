package com.samebutdifferent.morevillagers.registry;

import com.google.common.collect.ImmutableSet;
import com.samebutdifferent.morevillagers.mixin.PoiTypeInvoker;
import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;
import java.util.function.Supplier;

public class MVPoiTypes {
    public static void init() {}

    public static final Supplier<PoiType> OCEANOGRAPHER_POI = CommonPlatformHelper.registerPoiType("oceanographer", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.OCEANOGRAPHY_TABLE), 1, 1));
    public static final Supplier<PoiType> NETHERIAN_POI = CommonPlatformHelper.registerPoiType("netherian", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.DECAYED_WORKBENCH), 1, 1));
    public static final Supplier<PoiType> WOODWORKER_POI = CommonPlatformHelper.registerPoiType("woodworker", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.WOODWORKING_TABLE), 1, 1));
    public static final Supplier<PoiType> ENDERIAN_POI = CommonPlatformHelper.registerPoiType("enderian", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.PURPUR_ALTAR), 1, 1));
    public static final Supplier<PoiType> ENGINEER_POI = CommonPlatformHelper.registerPoiType("engineer", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.BLUEPRINT_TABLE), 1, 1));
    public static final Supplier<PoiType> FLORIST_POI = CommonPlatformHelper.registerPoiType("florist", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.GARDENING_TABLE), 1, 1));
    public static final Supplier<PoiType> HUNTER_POI = CommonPlatformHelper.registerPoiType("hunter", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.HUNTING_POST), 1, 1));
    public static final Supplier<PoiType> MINER_POI = CommonPlatformHelper.registerPoiType("miner", () -> PoiTypeInvoker.invokeConstructor(getBlockStates(MVBlocks.MINING_BENCH), 1, 1));

    private static Set<BlockState> getBlockStates(Supplier<Block> block) {
        return ImmutableSet.copyOf(block.get().getStateDefinition().getPossibleStates());
    }
}
