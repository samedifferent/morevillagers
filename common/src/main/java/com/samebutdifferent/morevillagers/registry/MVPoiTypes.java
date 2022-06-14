package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import com.samebutdifferent.morevillagers.mixin.PoiTypesInvoker;
import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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

    public static void registerBlockStates() {
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.OCEANOGRAPHY_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "oceanography_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.WOODWORKING_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "woodworking_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.DECAYED_WORKBENCH.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "decayed_workbench"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.PURPUR_ALTAR.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "purpur_altar"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.BLUEPRINT_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "blueprint_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.GARDENING_TABLE.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "gardening_table"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.HUNTING_POST.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "hunting_post"))).get()));
        PoiTypesInvoker.invokeGetBlockStates(MVBlocks.MINING_BENCH.get()).forEach((state) -> PoiTypesInvoker.getTypeByState().put(state, Registry.POINT_OF_INTEREST_TYPE.getHolder(ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, "mining_bench"))).get()));
    }
}
