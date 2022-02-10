package com.samebutdifferent.morevillagers.init;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MoreVillagers.MOD_ID);

    public static final RegistryObject<PoiType> OCEANOGRAPHER_POI = POI_TYPES.register("oceanographer", () -> new PoiType("oceanographer", PoiType.getBlockStates(ModBlocks.OCEANOGRAPHY_TABLE.get()), 1, 1));
    public static final RegistryObject<PoiType> NETHERIAN_POI = POI_TYPES.register("netherian", () -> new PoiType("netherian", PoiType.getBlockStates(ModBlocks.DECAYED_WORKBENCH.get()), 1, 1));
    public static final RegistryObject<PoiType> WOODWORKER_POI = POI_TYPES.register("woodworker", () -> new PoiType("woodworker", PoiType.getBlockStates(ModBlocks.WOODWORKING_TABLE.get()), 1, 1));
    public static final RegistryObject<PoiType> ENDERIAN_POI = POI_TYPES.register("enderian", () -> new PoiType("enderian", PoiType.getBlockStates(ModBlocks.PURPUR_ALTAR.get()), 1, 1));
    public static final RegistryObject<PoiType> ENGINEER_POI = POI_TYPES.register("engineer", () -> new PoiType("engineer", PoiType.getBlockStates(ModBlocks.BLUEPRINT_TABLE.get()), 1, 1));
    public static final RegistryObject<PoiType> FLORIST_POI = POI_TYPES.register("florist", () -> new PoiType("florist", PoiType.getBlockStates(ModBlocks.GARDENING_TABLE.get()), 1, 1));
    public static final RegistryObject<PoiType> HUNTER_POI = POI_TYPES.register("hunter", () -> new PoiType("hunter", PoiType.getBlockStates(ModBlocks.HUNTING_POST.get()), 1, 1));
    public static final RegistryObject<PoiType> MINER_POI = POI_TYPES.register("miner", () -> new PoiType("miner", PoiType.getBlockStates(ModBlocks.MINING_BENCH.get()), 1, 1));

    public static void registerPOIs() {
        for (RegistryObject<PoiType> poi : POI_TYPES.getEntries()) {
            try {
                ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, poi.get());
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
