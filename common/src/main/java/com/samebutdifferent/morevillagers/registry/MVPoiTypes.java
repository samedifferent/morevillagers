package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.function.Supplier;

public class MVPoiTypes {
    public static void init() {}

    public static final Supplier<PoiType> OCEANOGRAPHER_POI = CommonPlatformHelper.registerPoiType("oceanographer", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.OCEANOGRAPHY_TABLE.get()), 1, 1));
    public static final Supplier<PoiType> NETHERIAN_POI = CommonPlatformHelper.registerPoiType("netherian", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.DECAYED_WORKBENCH.get()), 1, 1));
    public static final Supplier<PoiType> WOODWORKER_POI = CommonPlatformHelper.registerPoiType("woodworker", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.WOODWORKING_TABLE.get()), 1, 1));
    public static final Supplier<PoiType> ENDERIAN_POI = CommonPlatformHelper.registerPoiType("enderian", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.PURPUR_ALTAR.get()), 1, 1));
    public static final Supplier<PoiType> ENGINEER_POI = CommonPlatformHelper.registerPoiType("engineer", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.BLUEPRINT_TABLE.get()), 1, 1));
    public static final Supplier<PoiType> FLORIST_POI = CommonPlatformHelper.registerPoiType("florist", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.GARDENING_TABLE.get()), 1, 1));
    public static final Supplier<PoiType> HUNTER_POI = CommonPlatformHelper.registerPoiType("hunter", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.HUNTING_POST.get()), 1, 1));
    public static final Supplier<PoiType> MINER_POI = CommonPlatformHelper.registerPoiType("miner", () -> new PoiType(PoiTypesInvoker.invokeGetBlockStates(MVBlocks.MINING_BENCH.get()), 1, 1));
}
