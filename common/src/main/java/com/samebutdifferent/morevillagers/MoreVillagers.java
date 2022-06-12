package com.samebutdifferent.morevillagers;

import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import com.samebutdifferent.morevillagers.registry.MVBlocks;
import com.samebutdifferent.morevillagers.registry.MVConfig;
import com.samebutdifferent.morevillagers.registry.MVPoiTypes;
import com.samebutdifferent.morevillagers.registry.MVProfessions;
import com.samebutdifferent.morevillagers.util.JigsawHelper;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

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

		ResourceLocation plainsPoolLocation = new ResourceLocation("minecraft:village/plains/houses");
		ResourceLocation desertPoolLocation = new ResourceLocation("minecraft:village/desert/houses");
		ResourceLocation savannaPoolLocation = new ResourceLocation("minecraft:village/savanna/houses");
		ResourceLocation snowyPoolLocation = new ResourceLocation("minecraft:village/snowy/houses");
		ResourceLocation taigaPoolLocation = new ResourceLocation("minecraft:village/taiga/houses");

		// PLAINS VILLAGE HOUSES
		if (config.houses.generatePlainsHouses) {
			JigsawHelper.registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_woodworker"), config.weights.woodworkerHouseWeight);
			JigsawHelper.registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_oceanographer"), config.weights.oceanographerHouseWeight);
			JigsawHelper.registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_florist"), config.weights.floristHouseWeight);
			JigsawHelper.registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_hunter"), config.weights.hunterHouseWeight);
			JigsawHelper.registerJigsaw(server, plainsPoolLocation, new ResourceLocation("morevillagers:village/plains/plains_engineer"), config.weights.engineerHouseWeight);
		}

		// TAIGA VILLAGE HOUSES
		if (config.houses.generateTaigaHouses) {
			JigsawHelper.registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_woodworker"), config.weights.woodworkerHouseWeight);
			JigsawHelper.registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_oceanographer"), config.weights.oceanographerHouseWeight);
			JigsawHelper.registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_florist"), config.weights.floristHouseWeight);
			JigsawHelper.registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_hunter"), config.weights.hunterHouseWeight);
			JigsawHelper.registerJigsaw(server, taigaPoolLocation, new ResourceLocation("morevillagers:village/taiga/taiga_engineer"), config.weights.engineerHouseWeight);
		}

		// SAVANNA VILLAGE HOUSES
		if (config.houses.generateSavannaHouses) {
			JigsawHelper.registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_woodworker"), config.weights.woodworkerHouseWeight);
			JigsawHelper.registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_oceanographer"), config.weights.oceanographerHouseWeight);
			JigsawHelper.registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_florist"), config.weights.floristHouseWeight);
			JigsawHelper.registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_hunter"), config.weights.hunterHouseWeight);
			JigsawHelper.registerJigsaw(server, savannaPoolLocation, new ResourceLocation("morevillagers:village/savanna/savanna_engineer"), config.weights.engineerHouseWeight);
		}

		// SNOWY VILLAGE HOUSES
		if (config.houses.generateSnowyHouses) {
			JigsawHelper.registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_woodworker"), config.weights.woodworkerHouseWeight);
			JigsawHelper.registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_oceanographer"), config.weights.oceanographerHouseWeight);
			JigsawHelper.registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_florist"), config.weights.floristHouseWeight);
			JigsawHelper.registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_hunter"), config.weights.hunterHouseWeight);
			JigsawHelper.registerJigsaw(server, snowyPoolLocation, new ResourceLocation("morevillagers:village/snowy/snowy_engineer"), config.weights.engineerHouseWeight);
		}

		// DESERT VILLAGE HOUSES
		if (config.houses.generateDesertHouses) {
			JigsawHelper.registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_woodworker"), config.weights.woodworkerHouseWeight);
			JigsawHelper.registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_oceanographer"), config.weights.oceanographerHouseWeight);
			JigsawHelper.registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_florist"), config.weights.floristHouseWeight);
			JigsawHelper.registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_hunter"), config.weights.hunterHouseWeight);
			JigsawHelper.registerJigsaw(server, desertPoolLocation, new ResourceLocation("morevillagers:village/desert/desert_hunter_engineer"), config.weights.engineerHouseWeight);
		}
	}
}