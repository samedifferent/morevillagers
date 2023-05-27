package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.function.Supplier;

public class MVPoiTypes {
    public static void init() {}

    public static final Supplier<PoiType> OCEANOGRAPHER_POI = CommonPlatformHelper.registerPoiType("oceanographer", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.OCEANOGRAPHY_TABLE.get()));
    public static final Supplier<PoiType> NETHERIAN_POI = CommonPlatformHelper.registerPoiType("netherian", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.DECAYED_WORKBENCH.get()));
    public static final Supplier<PoiType> WOODWORKER_POI = CommonPlatformHelper.registerPoiType("woodworker", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.WOODWORKING_TABLE.get()));
    public static final Supplier<PoiType> ENDERIAN_POI = CommonPlatformHelper.registerPoiType("enderian", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.PURPUR_ALTAR.get()));
    public static final Supplier<PoiType> ENGINEER_POI = CommonPlatformHelper.registerPoiType("engineer", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.BLUEPRINT_TABLE.get()));
    public static final Supplier<PoiType> FLORIST_POI = CommonPlatformHelper.registerPoiType("florist", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.GARDENING_TABLE.get()));
    public static final Supplier<PoiType> HUNTER_POI = CommonPlatformHelper.registerPoiType("hunter", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.HUNTING_POST.get()));
    public static final Supplier<PoiType> MINER_POI = CommonPlatformHelper.registerPoiType("miner", () -> PoiTypesInvoker.invokeGetBlockStates(MVBlocks.MINING_BENCH.get()));
}
