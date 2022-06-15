package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class MVTags {
    public static final TagKey<Structure> ON_FORTRESS_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_fortress_explorer_maps");
    public static final TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_bastion_remnant_explorer_maps");
    public static final TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_end_city_explorer_maps");
    public static final TagKey<Structure> ON_SWAMP_HUT_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_swamp_hut_explorer_maps");
    public static final TagKey<Structure> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_jungle_temple_explorer_maps");
    public static final TagKey<Structure> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_pillager_outpost_explorer_maps");
    public static final TagKey<Structure> ON_MINESHAFT_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_mineshaft_explorer_maps");
    public static final TagKey<Structure> ON_ANCIENT_CITY_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_ancient_city_explorer_maps");

    private static TagKey<Structure> createConfiguredStructureFeatureTag(String name) {
        return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation(MoreVillagers.MOD_ID, name));
    }
}
