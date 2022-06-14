package com.samebutdifferent.morevillagers;

import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import com.samebutdifferent.morevillagers.platform.ConfigHelper;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.util.JigsawHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class MoreVillagers
{
	public static final String MOD_ID = "morevillagers";
	public static final CreativeModeTab TAB = CommonPlatformHelper.registerCreativeModeTab(new ResourceLocation(MOD_ID, "tab"), () -> new ItemStack(Items.EMERALD));

	public static void init() {
		MVBlocks.init();
		MVPoiTypes.init();
		MVProfessions.init();
	}

	public static void registerJigsaws(MinecraftServer server) {
		Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().registry(Registry.TEMPLATE_POOL_REGISTRY).orElseThrow();
		Registry<StructureProcessorList> processorListRegistry = server.registryAccess().registry(Registry.PROCESSOR_LIST_REGISTRY).orElseThrow();

		ResourceLocation plainsPoolLocation = new ResourceLocation("minecraft:village/plains/houses");
		ResourceLocation desertPoolLocation = new ResourceLocation("minecraft:village/desert/houses");
		ResourceLocation savannaPoolLocation = new ResourceLocation("minecraft:village/savanna/houses");
		ResourceLocation snowyPoolLocation = new ResourceLocation("minecraft:village/snowy/houses");
		ResourceLocation taigaPoolLocation = new ResourceLocation("minecraft:village/taiga/houses");

		// PLAINS VILLAGE HOUSES
		if (ConfigHelper.generatePlainsHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_woodworker", ConfigHelper.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_oceanographer", ConfigHelper.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_florist", ConfigHelper.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_hunter", ConfigHelper.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_engineer", ConfigHelper.engineerHouseWeight());
		}

		// TAIGA VILLAGE HOUSES
		if (ConfigHelper.generateTaigaHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_woodworker", ConfigHelper.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_oceanographer", ConfigHelper.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_florist", ConfigHelper.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_hunter", ConfigHelper.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_engineer", ConfigHelper.engineerHouseWeight());
		}

		// SAVANNA VILLAGE HOUSES
		if (ConfigHelper.generateSavannaHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_woodworker", ConfigHelper.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_oceanographer", ConfigHelper.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_florist", ConfigHelper.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_hunter", ConfigHelper.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_engineer", ConfigHelper.engineerHouseWeight());
		}

		// SNOWY VILLAGE HOUSES
		if (ConfigHelper.generateSnowyHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_woodworker", ConfigHelper.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_oceanographer", ConfigHelper.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_florist", ConfigHelper.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_hunter", ConfigHelper.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_engineer", ConfigHelper.engineerHouseWeight());
		}

		// DESERT VILLAGE HOUSES
		if (ConfigHelper.generateDesertHouses()) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_woodworker", ConfigHelper.woodworkerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_oceanographer", ConfigHelper.oceanographerHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_florist", ConfigHelper.floristHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_hunter", ConfigHelper.hunterHouseWeight());
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_hunter_engineer", ConfigHelper.engineerHouseWeight());
		}
	}
}