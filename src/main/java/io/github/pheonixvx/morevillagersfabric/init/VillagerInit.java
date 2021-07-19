package io.github.pheonixvx.morevillagersfabric.init;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.item.Items;
import net.minecraft.item.map.MapIcon;
import net.minecraft.sound.SoundEvents;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.poi.PointOfInterestType;

public class VillagerInit {
    // Points of Interest
    public static final PointOfInterestType OCEANOGRAPHER_POI = PointOfInterestType.register("oceanographer", PointOfInterestType.getAllStatesOf(BlockInit.OCEANOGRAPHY_TABLE), 1, 1);
    public static final PointOfInterestType NETHERIAN_POI = PointOfInterestType.register("netherian", PointOfInterestType.getAllStatesOf(BlockInit.DECAYED_WORKBRENCH), 1, 1);
    public static final PointOfInterestType WOODWORKER_POI = PointOfInterestType.register("woodworker", PointOfInterestType.getAllStatesOf(BlockInit.WOODWORKING_TABLE), 1, 1);
    public static final PointOfInterestType ENDERIAN_POI = PointOfInterestType.register("enderian", PointOfInterestType.getAllStatesOf(BlockInit.PURPUR_ALTAR), 1, 1);
    public static final PointOfInterestType ENGINEER_POI = PointOfInterestType.register("engineer", PointOfInterestType.getAllStatesOf(BlockInit.BLUEPRINT_TABLE), 1, 1);
    public static final PointOfInterestType FLORIST_POI = PointOfInterestType.register("florist", PointOfInterestType.getAllStatesOf(BlockInit.GARDENING_TABLE), 1, 1);
    public static final PointOfInterestType HUNTER_POI = PointOfInterestType.register("hunter", PointOfInterestType.getAllStatesOf(BlockInit.HUNTING_POST), 1, 1);

    // Villager Professions
    public static final VillagerProfession OCEANOGRAPHER = VillagerProfession.register("oceanographer", OCEANOGRAPHER_POI, SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER);
    public static final VillagerProfession NETHERIAN = VillagerProfession.register("netherian", NETHERIAN_POI, SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER);
    public static final VillagerProfession WOODWORKER = VillagerProfession.register("woodworker", WOODWORKER_POI, SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);
    public static final VillagerProfession ENDERIAN = VillagerProfession.register("enderian", ENDERIAN_POI, SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER);
    public static final VillagerProfession ENGINEER = VillagerProfession.register("engineer", ENGINEER_POI, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);
    public static final VillagerProfession FLORIST = VillagerProfession.register("florist", FLORIST_POI, SoundEvents.ENTITY_VILLAGER_WORK_FARMER);
    public static final VillagerProfession HUNTER = VillagerProfession.register("hunter", HUNTER_POI, SoundEvents.ENTITY_VILLAGER_WORK_FLETCHER);

    public static void fillTradeData() {
        // Oceanographer trades
        TradeOffers.Factory[] oceanographerLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PRISMARINE, 14, 16, 2), new TradeOffers.SellItemFactory(Items.SEA_LANTERN, 2, 4, 16, 1)};
        TradeOffers.Factory[] oceanographerLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PRISMARINE_BRICKS, 14, 16, 10), new TradeOffers.SellItemFactory(Items.SPONGE, 4, 2, 16, 5)};
        TradeOffers.Factory[] oceanographerLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DARK_PRISMARINE, 12, 16, 20), new TradeOffers.SellMapFactory(13, StructureFeature.BURIED_TREASURE, MapIcon.Type.RED_X, 12, 10)};
        TradeOffers.Factory[] oceanographerLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.NAUTILUS_SHELL, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.HEART_OF_THE_SEA, 8, 1, 12, 15)};
        TradeOffers.Factory[] oceanographerLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.TRIDENT, 32, 1, 2, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(OCEANOGRAPHER, VillagerInit.toIntMap(ImmutableMap.of(1, oceanographerLevel1, 2, oceanographerLevel2, 3, oceanographerLevel3, 4, oceanographerLevel4, 5, oceanographerLevel5)));
        // Netherian trades
        TradeOffers.Factory[] netherianLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BASALT, 24, 16, 2), new TradeOffers.SellItemFactory(Items.NETHER_BRICK, 1, 10, 16, 1)};
        TradeOffers.Factory[] netherianLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BLACKSTONE, 24, 16, 10), new TradeOffers.SellItemFactory(Items.NETHER_QUARTZ_ORE, 4, 1, 16, 5)};
        TradeOffers.Factory[] netherianLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.OBSIDIAN, 4, 16, 20), new TradeOffers.SellMapFactory(13, StructureFeature.FORTRESS, MapIcon.Type.BANNER_RED, 12, 10)};
        TradeOffers.Factory[] netherianLevel4 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT,4,16,30), new TradeOffers.SellMapFactory(14, StructureFeature.BASTION_REMNANT, MapIcon.Type.BANNER_YELLOW, 12, 15),};
        TradeOffers.Factory[] netherianLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.MUSIC_DISC_PIGSTEP, 20, 1, 12, 30),};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(NETHERIAN, VillagerInit.toIntMap(ImmutableMap.of(1, netherianLevel1, 2, netherianLevel2, 3, netherianLevel3, 4, netherianLevel4, 5, netherianLevel5)));
        // Woodworker trades
        TradeOffers.Factory[] woodworkerLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.OAK_SAPLING, 6, 16, 2), new TradeOffers.SellItemFactory(Items.OAK_LOG, 1, 6, 16, 1), new TradeOffers.BuyForOneEmeraldFactory(Items.BIRCH_SAPLING, 6, 16, 2), new TradeOffers.SellItemFactory(Items.BIRCH_LOG, 1, 6, 16, 1)};
        TradeOffers.Factory[] woodworkerLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SPRUCE_SAPLING, 6, 16, 10), new TradeOffers.SellItemFactory(Items.SPRUCE_LOG, 1, 6, 16, 5), new TradeOffers.BuyForOneEmeraldFactory(Items.DARK_OAK_SAPLING, 6, 16, 10), new TradeOffers.SellItemFactory(Items.DARK_OAK_LOG, 1, 6, 16, 5)};
        TradeOffers.Factory[] woodworkerLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.ACACIA_SAPLING, 6, 16, 20), new TradeOffers.SellItemFactory(Items.ACACIA_LOG, 1, 6, 16, 10), new TradeOffers.BuyForOneEmeraldFactory(Items.JUNGLE_SAPLING, 6, 16, 20), new TradeOffers.SellItemFactory(Items.JUNGLE_LOG, 1, 6, 16, 10)};
        TradeOffers.Factory[] woodworkerLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.WARPED_STEM, 1, 6, 16, 15), new TradeOffers.SellItemFactory(Items.CRIMSON_STEM, 1, 6, 16, 15)};
        TradeOffers.Factory[] woodworkerLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 12, 3, 15, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HOE, 12, 3, 15, 0.2f)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(WOODWORKER, VillagerInit.toIntMap(ImmutableMap.of(1, woodworkerLevel1, 2, woodworkerLevel2, 3, woodworkerLevel3, 4, woodworkerLevel4, 5, woodworkerLevel5)));
        // Enderian trades
        TradeOffers.Factory[] enderianLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.END_STONE,24,16,2), new TradeOffers.SellItemFactory(Items.END_ROD, 4, 3, 16, 1)};
        TradeOffers.Factory[] enderianLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.POPPED_CHORUS_FRUIT,20,16,10), new TradeOffers.SellItemFactory(Items.PHANTOM_MEMBRANE, 5, 1, 16, 5)};
        TradeOffers.Factory[] enderianLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.ENDER_PEARL,14,16,20), new TradeOffers.SellItemFactory(Items.FIREWORK_ROCKET, 3, 8, 16, 10)};
        TradeOffers.Factory[] enderianLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.DRAGON_BREATH, 6, 2, 12, 15), new TradeOffers.SellMapFactory(14, StructureFeature.END_CITY, MapIcon.Type.BANNER_PURPLE, 12, 15)};

        TradeOffers.Factory[] enderianLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.SHULKER_SHELL, 12, 1, 8, 30), new TradeOffers.SellItemFactory(Items.DRAGON_HEAD, 20, 1, 2, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(ENDERIAN, VillagerInit.toIntMap(ImmutableMap.of(1, enderianLevel1, 2, enderianLevel2, 3, enderianLevel3, 4, enderianLevel4, 5, enderianLevel5)));
        // Engineer trades
        TradeOffers.Factory[] engineerLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.REDSTONE,20,16,2), new TradeOffers.SellItemFactory(Items.REPEATER, 4, 3, 16, 1)};
        TradeOffers.Factory[] engineerLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.REDSTONE_TORCH,12,16,10), new TradeOffers.SellItemFactory(Items.DROPPER, 3, 3, 16, 5), new TradeOffers.SellItemFactory(Items.DISPENSER, 4, 1, 16, 5)};
        TradeOffers.Factory[] engineerLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.REDSTONE_LAMP, 4, 16, 20), new TradeOffers.SellItemFactory(Items.OBSERVER, 4, 1, 16, 10), new TradeOffers.SellItemFactory(Items.COMPARATOR, 5, 1, 16, 10)};
        TradeOffers.Factory[] engineerLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.PISTON, 5, 1, 16, 15), new TradeOffers.SellItemFactory(Items.STICKY_PISTON, 6, 1, 16, 15)};
        TradeOffers.Factory[] engineerLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.DAYLIGHT_DETECTOR, 5, 2, 16, 30), new TradeOffers.SellItemFactory(Items.HOPPER, 7, 1, 16, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(ENGINEER, VillagerInit.toIntMap(ImmutableMap.of(1, engineerLevel1, 2, engineerLevel2, 3, engineerLevel3, 4, engineerLevel4, 5, engineerLevel5)));
        // Florist trades
        TradeOffers.Factory[] floristLevel1 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.DANDELION, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.POPPY, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.BLUE_ORCHID, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.ALLIUM, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.AZURE_BLUET, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.RED_TULIP, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.ORANGE_TULIP, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.WHITE_TULIP, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.PINK_TULIP, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.OXEYE_DAISY, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.CORNFLOWER, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.LILY_OF_THE_VALLEY, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.SUNFLOWER, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.LILAC, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.ROSE_BUSH, 1, 8, 16, 1), new TradeOffers.SellItemFactory(Items.PEONY, 1, 8, 16, 1)};
        TradeOffers.Factory[] floristLevel2 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.DANDELION, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.POPPY, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.BLUE_ORCHID, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.ALLIUM, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.AZURE_BLUET, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.RED_TULIP, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.ORANGE_TULIP, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.WHITE_TULIP, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.PINK_TULIP, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.OXEYE_DAISY, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.CORNFLOWER, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.LILY_OF_THE_VALLEY, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.SUNFLOWER, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.LILAC, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.ROSE_BUSH, 1, 8, 16, 5), new TradeOffers.SellItemFactory(Items.PEONY, 1, 8, 16, 5)};
        TradeOffers.Factory[] floristLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.VINE, 30, 16, 20), new TradeOffers.SellItemFactory(Items.HONEY_BOTTLE, 6, 1, 16, 10)};
        TradeOffers.Factory[] floristLevel4 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FLOWER_POT,3,16,30), new TradeOffers.SellMapFactory(13, StructureFeature.SWAMP_HUT, MapIcon.Type.BANNER_GREEN, 12, 15)};
        TradeOffers.Factory[] floristLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.BEE_NEST, 6, 1, 12, 30), new TradeOffers.SellMapFactory(15, StructureFeature.JUNGLE_PYRAMID, MapIcon.Type.BANNER_LIME, 12, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(FLORIST, VillagerInit.toIntMap(ImmutableMap.of(1, floristLevel1, 2, floristLevel2, 3, floristLevel3, 4, floristLevel4, 5, floristLevel5)));
        // Hunter trades
        TradeOffers.Factory[] hunterLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BONE, 32, 16, 2), new TradeOffers.SellItemFactory(Items.SLIME_BALL, 5, 2, 16, 1)};
        TradeOffers.Factory[] hunterLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SPIDER_EYE, 24, 16, 10), new TradeOffers.SellItemFactory(Items.FERMENTED_SPIDER_EYE, 5, 1, 16, 5)};
        TradeOffers.Factory[] hunterLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GUNPOWDER, 20, 16, 20), new TradeOffers.SellItemFactory(Items.MAGMA_CREAM, 5, 1, 12, 10)};
        TradeOffers.Factory[] hunterLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.BLAZE_ROD, 5, 1, 12, 15), new TradeOffers.SellMapFactory(13, StructureFeature.PILLAGER_OUTPOST, MapIcon.Type.BANNER_BLACK, 12, 15)};
        TradeOffers.Factory[] hunterLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.GHAST_TEAR, 8, 1, 12, 30), new TradeOffers.SellItemFactory(Items.RABBIT_FOOT, 8, 1, 12, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(HUNTER, VillagerInit.toIntMap(ImmutableMap.of(1, hunterLevel1, 2, hunterLevel2, 3, hunterLevel3, 4, hunterLevel4, 5, hunterLevel5)));
    }

    private static Int2ObjectMap<TradeOffers.Factory[]> toIntMap(ImmutableMap<Integer, TradeOffers.Factory[]> trades) {
        return new Int2ObjectOpenHashMap<>(trades);
    }
}
