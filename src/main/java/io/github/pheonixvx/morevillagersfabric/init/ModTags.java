package io.github.pheonixvx.morevillagersfabric.init;

import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;

public class ModTags {
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_BURIED_TREASURE_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_buried_treasure_explorer_maps");
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_FORTRESS_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_fortress_explorer_maps");
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_BASTION_REMNANT_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_bastion_remnant_explorer_maps");
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_END_CITY_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_end_city_explorer_maps");
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_SWAMP_HUT_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_swamp_hut_explorer_maps");
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_JUNGLE_TEMPLE_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_jungle_temple_explorer_maps");
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_PILLAGER_OUTPOST_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_pillager_outpost_explorer_maps");
    public static final TagKey<ConfiguredStructureFeature<?, ?>> ON_MINESHAFT_EXPLORER_MAPS = createConfiguredStructureFeatureTag("on_mineshaft_explorer_maps");

    private static TagKey<ConfiguredStructureFeature<?, ?>> createConfiguredStructureFeatureTag(String name) {
        return TagKey.create(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY, new ResourceLocation(MoreVillagersFabric.MOD_ID, name));
    }
}
