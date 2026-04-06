package com.samebutdifferent.morevillagers;

import com.samebutdifferent.morevillagers.platform.PlatformHooks;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.util.JigsawHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class MoreVillagers
{
	public static final String MOD_ID = "morevillagers";
	public static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(MOD_ID, "tab"));

	public static void init() {
		MVBlocks.init();
		MVPoiTypes.init();
		MVProfessions.init();
	}

	public static void registerJigsaws(MinecraftServer server) {
		Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().lookupOrThrow(Registries.TEMPLATE_POOL);
		Registry<StructureProcessorList> processorListRegistry = server.registryAccess().lookupOrThrow(Registries.PROCESSOR_LIST);

		Identifier plainsPoolLocation = Identifier.parse("minecraft:village/plains/houses");
		Identifier desertPoolLocation = Identifier.parse("minecraft:village/desert/houses");
		Identifier savannaPoolLocation = Identifier.parse("minecraft:village/savanna/houses");
		Identifier snowyPoolLocation = Identifier.parse("minecraft:village/snowy/houses");
		Identifier taigaPoolLocation = Identifier.parse("minecraft:village/taiga/houses");

		// PLAINS VILLAGE HOUSES
		if (PlatformHooks.CONFIG_HELPER.generatePlainsHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_woodworker", PlatformHooks.CONFIG_HELPER.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_oceanographer", PlatformHooks.CONFIG_HELPER.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_florist", PlatformHooks.CONFIG_HELPER.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_hunter", PlatformHooks.CONFIG_HELPER.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_engineer", PlatformHooks.CONFIG_HELPER.engineerHouseWeight());
		}

		// TAIGA VILLAGE HOUSES
		if (PlatformHooks.CONFIG_HELPER.generateTaigaHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_woodworker", PlatformHooks.CONFIG_HELPER.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_oceanographer", PlatformHooks.CONFIG_HELPER.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_florist", PlatformHooks.CONFIG_HELPER.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_hunter", PlatformHooks.CONFIG_HELPER.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_engineer", PlatformHooks.CONFIG_HELPER.engineerHouseWeight());
		}

		// SAVANNA VILLAGE HOUSES
		if (PlatformHooks.CONFIG_HELPER.generateSavannaHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_woodworker", PlatformHooks.CONFIG_HELPER.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_oceanographer", PlatformHooks.CONFIG_HELPER.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_florist", PlatformHooks.CONFIG_HELPER.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_hunter", PlatformHooks.CONFIG_HELPER.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_engineer", PlatformHooks.CONFIG_HELPER.engineerHouseWeight());
		}

		// SNOWY VILLAGE HOUSES
		if (PlatformHooks.CONFIG_HELPER.generateSnowyHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_woodworker", PlatformHooks.CONFIG_HELPER.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_oceanographer", PlatformHooks.CONFIG_HELPER.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_florist", PlatformHooks.CONFIG_HELPER.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_hunter", PlatformHooks.CONFIG_HELPER.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_engineer", PlatformHooks.CONFIG_HELPER.engineerHouseWeight());
		}

		// DESERT VILLAGE HOUSES
		if (PlatformHooks.CONFIG_HELPER.generateDesertHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_woodworker", PlatformHooks.CONFIG_HELPER.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_oceanographer", PlatformHooks.CONFIG_HELPER.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_florist", PlatformHooks.CONFIG_HELPER.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_hunter", PlatformHooks.CONFIG_HELPER.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_hunter_engineer", PlatformHooks.CONFIG_HELPER.engineerHouseWeight());
		}
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}