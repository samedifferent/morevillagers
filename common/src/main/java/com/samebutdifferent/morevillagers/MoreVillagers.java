package com.samebutdifferent.morevillagers;

import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVConfig;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.util.JigsawHelper;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
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
		AutoConfig.register(MVConfig.class, GsonConfigSerializer::new);
		MVBlocks.init();
		MVPoiTypes.init();
		MVProfessions.init();
	}

	public static void registerJigsaws(MinecraftServer server) {
		MVConfig config = AutoConfig.getConfigHolder(MVConfig.class).getConfig();
		Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().registry(Registry.TEMPLATE_POOL_REGISTRY).orElseThrow();
		Registry<StructureProcessorList> processorListRegistry = server.registryAccess().registry(Registry.PROCESSOR_LIST_REGISTRY).orElseThrow();

		ResourceLocation plainsPoolLocation = new ResourceLocation("minecraft:village/plains/houses");
		ResourceLocation desertPoolLocation = new ResourceLocation("minecraft:village/desert/houses");
		ResourceLocation savannaPoolLocation = new ResourceLocation("minecraft:village/savanna/houses");
		ResourceLocation snowyPoolLocation = new ResourceLocation("minecraft:village/snowy/houses");
		ResourceLocation taigaPoolLocation = new ResourceLocation("minecraft:village/taiga/houses");

		// PLAINS VILLAGE HOUSES
		if (config.houses.generatePlainsHouses) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_woodworker", config.weights.woodworkerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_oceanographer", config.weights.oceanographerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_florist", config.weights.floristHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_hunter", config.weights.hunterHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "morevillagers:village/plains/plains_engineer", config.weights.engineerHouseWeight);
		}

		// TAIGA VILLAGE HOUSES
		if (config.houses.generateTaigaHouses) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_woodworker", config.weights.woodworkerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_oceanographer", config.weights.oceanographerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_florist", config.weights.floristHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_hunter", config.weights.hunterHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "morevillagers:village/taiga/taiga_engineer", config.weights.engineerHouseWeight);
		}

		// SAVANNA VILLAGE HOUSES
		if (config.houses.generateSavannaHouses) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_woodworker", config.weights.woodworkerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_oceanographer", config.weights.oceanographerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_florist", config.weights.floristHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_hunter", config.weights.hunterHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "morevillagers:village/savanna/savanna_engineer", config.weights.engineerHouseWeight);
		}

		// SNOWY VILLAGE HOUSES
		if (config.houses.generateSnowyHouses) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_woodworker", config.weights.woodworkerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_oceanographer", config.weights.oceanographerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_florist", config.weights.floristHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_hunter", config.weights.hunterHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "morevillagers:village/snowy/snowy_engineer", config.weights.engineerHouseWeight);
		}

		// DESERT VILLAGE HOUSES
		if (config.houses.generateDesertHouses) {
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_woodworker", config.weights.woodworkerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_oceanographer", config.weights.oceanographerHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_florist", config.weights.floristHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_hunter", config.weights.hunterHouseWeight);
			JigsawHelper.addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "morevillagers:village/desert/desert_hunter_engineer", config.weights.engineerHouseWeight);
		}
	}
}