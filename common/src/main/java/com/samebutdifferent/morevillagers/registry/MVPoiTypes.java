package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.PlatformHooks;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.function.Supplier;

public class MVPoiTypes {
    public static void init() {}

    public static final Supplier<PoiType> OCEANOGRAPHER_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("oceanographer", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.OCEANOGRAPHY_TABLE.get()));
    public static final Supplier<PoiType> NETHERIAN_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("netherian", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.DECAYED_WORKBENCH.get()));
    public static final Supplier<PoiType> WOODWORKER_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("woodworker", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.WOODWORKING_TABLE.get()));
    public static final Supplier<PoiType> ENDERIAN_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("enderian", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.PURPUR_ALTAR.get()));
    public static final Supplier<PoiType> ENGINEER_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("engineer", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.BLUEPRINT_TABLE.get()));
    public static final Supplier<PoiType> FLORIST_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("florist", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.GARDENING_TABLE.get()));
    public static final Supplier<PoiType> HUNTER_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("hunter", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.HUNTING_POST.get()));
    public static final Supplier<PoiType> MINER_POI = PlatformHooks.PLATFORM_HELPER.registerPoiType("miner", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.MINING_BENCH.get()));
}
