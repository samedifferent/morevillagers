package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class MVTags {
    public static final TagKey<Structure> ON_FORTRESS_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_fortress_explorer_maps");
    public static final TagKey<Structure> ON_BASTION_REMNANT_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_bastion_remnant_explorer_maps");
    public static final TagKey<Structure> ON_END_CITY_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_end_city_explorer_maps");

    private static TagKey<Structure> createConfiguredStructureFeatureTag(String name) {
        return TagKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(MoreVillagers.MOD_ID, name));
    }
}
