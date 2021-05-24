package io.github.pheonixvx.morevillagersfabric.init;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Blocks;
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
    public static final PointOfInterestType NETHERIAN_POI = PointOfInterestType.register("netherian", PointOfInterestType.getAllStatesOf(Blocks.CHISELED_POLISHED_BLACKSTONE), 1, 1);
    public static final PointOfInterestType WOODWORKER_POI = PointOfInterestType.register("woodworker", PointOfInterestType.getAllStatesOf(BlockInit.WOODWORKING_TABLE), 1, 1);
    public static final PointOfInterestType ENDERIAN_POI = PointOfInterestType.register("enderian",  PointOfInterestType.getAllStatesOf(Blocks.PURPUR_PILLAR), 1, 1);
    public static final PointOfInterestType ENGINEER_POI = PointOfInterestType.register("engineer", PointOfInterestType.getAllStatesOf(Blocks.REDSTONE_BLOCK), 1, 1);

    // Villager Professions
    public static final VillagerProfession OCEANOGRAPHER = VillagerProfession.register("oceanographer", OCEANOGRAPHER_POI, SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER);
    public static final VillagerProfession NETHERIAN = VillagerProfession.register("netherian", NETHERIAN_POI, SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER);
    public static final VillagerProfession WOODWORKER = VillagerProfession.register("woodworker", WOODWORKER_POI, SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);
    public static final VillagerProfession ENDERIAN = VillagerProfession.register("enderian", ENDERIAN_POI, SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER);
    public static final VillagerProfession ENGINEER = VillagerProfession.register("engineer", ENGINEER_POI, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);

    public static void fillTradeData() {
        TradeOffers.Factory[] oceanographerLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PRISMARINE, 14, 16, 2), new TradeOffers.SellItemFactory(Items.SEA_LANTERN, 1, 4, 16, 1)};
        TradeOffers.Factory[] oceanographerLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.PRISMARINE_BRICKS, 14, 16, 10), new TradeOffers.SellItemFactory(Items.SPONGE, 1, 2, 16, 5)};
        TradeOffers.Factory[] oceanographerLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DARK_PRISMARINE, 12, 16, 20), new TradeOffers.SellMapFactory(13, StructureFeature.BURIED_TREASURE, MapIcon.Type.RED_X, 12, 10)};
        TradeOffers.Factory[] oceanographerLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.NAUTILUS_SHELL, 3, 1, 12, 15), new TradeOffers.SellItemFactory(Items.HEART_OF_THE_SEA, 6, 1, 3, 15)};
        TradeOffers.Factory[] oceanographerLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.TRIDENT, 32, 1, 3, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(OCEANOGRAPHER, VillagerInit.toIntMap(ImmutableMap.of(1, oceanographerLevel1, 2, oceanographerLevel2, 3, oceanographerLevel3, 4, oceanographerLevel4, 5, oceanographerLevel5)));
        TradeOffers.Factory[] netherianLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BASALT, 20, 16, 2), new TradeOffers.SellItemFactory(Items.NETHER_BRICK, 1, 10, 16, 1)};
        TradeOffers.Factory[] netherianLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.BLACKSTONE, 20, 16, 10), new TradeOffers.SellItemFactory(Items.NETHER_QUARTZ_ORE, 4, 1, 16, 5)};
        TradeOffers.Factory[] netherianLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.OBSIDIAN, 2, 16, 20), new TradeOffers.SellMapFactory(13, StructureFeature.FORTRESS, MapIcon.Type.BANNER_RED, 12, 10)};
        TradeOffers.Factory[] netherianLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellMapFactory(13, StructureFeature.BASTION_REMNANT, MapIcon.Type.BANNER_YELLOW, 12, 15), new TradeOffers.SellItemFactory(Items.MUSIC_DISC_PIGSTEP, 12, 1, 3, 15)};
        TradeOffers.Factory[] netherianLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.WITHER_SKELETON_SKULL, 64, 1, 1, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(NETHERIAN, VillagerInit.toIntMap(ImmutableMap.of(1, netherianLevel1, 2, netherianLevel2, 3, netherianLevel3, 4, netherianLevel4, 5, netherianLevel5)));
        TradeOffers.Factory[] woodworkerLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.OAK_SAPLING, 6, 16, 2), new TradeOffers.SellItemFactory(Items.OAK_LOG, 1, 6, 16, 1), new TradeOffers.BuyForOneEmeraldFactory(Items.BIRCH_SAPLING, 6, 16, 2), new TradeOffers.SellItemFactory(Items.BIRCH_LOG, 1, 6, 16, 1)};
        TradeOffers.Factory[] woodworkerLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SPRUCE_SAPLING, 6, 16, 10), new TradeOffers.SellItemFactory(Items.SPRUCE_LOG, 1, 6, 16, 5), new TradeOffers.BuyForOneEmeraldFactory(Items.DARK_OAK_SAPLING, 6, 16, 10), new TradeOffers.SellItemFactory(Items.DARK_OAK_LOG, 1, 6, 16, 5)};
        TradeOffers.Factory[] woodworkerLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.ACACIA_SAPLING, 6, 16, 20), new TradeOffers.SellItemFactory(Items.ACACIA_LOG, 1, 6, 16, 10), new TradeOffers.BuyForOneEmeraldFactory(Items.JUNGLE_SAPLING, 6, 16, 20), new TradeOffers.SellItemFactory(Items.JUNGLE_LOG, 1, 6, 16, 10)};
        TradeOffers.Factory[] woodworkerLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.WARPED_STEM, 1, 6, 16, 15), new TradeOffers.SellItemFactory(Items.CRIMSON_STEM, 1, 6, 16, 15)};
        TradeOffers.Factory[] woodworkerLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 12, 3, 15, 0.2f), new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HOE, 12, 3, 15, 0.2f)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(WOODWORKER, VillagerInit.toIntMap(ImmutableMap.of(1, woodworkerLevel1, 2, woodworkerLevel2, 3, woodworkerLevel3, 4, woodworkerLevel4, 5, woodworkerLevel5)));
        TradeOffers.Factory[] enderianLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.END_STONE, 20, 16, 2), new TradeOffers.SellItemFactory(Items.DRAGON_BREATH, 1, 3, 16, 1)};
        TradeOffers.Factory[] enderianLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.POPPED_CHORUS_FRUIT, 28, 16, 10), new TradeOffers.SellItemFactory(Items.PHANTOM_MEMBRANE, 4, 1, 16, 5)};
        TradeOffers.Factory[] enderianLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.ENDER_PEARL, 12, 16, 20), new TradeOffers.SellMapFactory(13, StructureFeature.END_CITY, MapIcon.Type.BANNER_PURPLE, 12, 10)};
        TradeOffers.Factory[] enderianLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.SHULKER_SHELL, 6, 1, 6, 15), new TradeOffers.SellItemFactory(Items.DRAGON_HEAD, 12, 1, 2, 15)};
        TradeOffers.Factory[] enderianLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.ELYTRA, 64, 1, 1, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(ENDERIAN, VillagerInit.toIntMap(ImmutableMap.of(1, enderianLevel1, 2, enderianLevel2, 3, enderianLevel3, 4, enderianLevel4, 5, enderianLevel5)));
        TradeOffers.Factory[] engineerLevel1 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.REDSTONE, 20, 16, 2), new TradeOffers.SellItemFactory(Items.REPEATER, 2, 1, 16, 1)};
        TradeOffers.Factory[] engineerLevel2 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.REDSTONE_TORCH, 12, 16, 10), new TradeOffers.SellItemFactory(Items.DROPPER, 1, 3, 16, 5), new TradeOffers.SellItemFactory(Items.DISPENSER, 1, 1, 16, 5)};
        TradeOffers.Factory[] engineerLevel3 = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.REDSTONE_LAMP, 1, 16, 20), new TradeOffers.SellItemFactory(Items.OBSERVER, 2, 1, 16, 10), new TradeOffers.SellItemFactory(Items.COMPARATOR, 3, 1, 16, 10)};
        TradeOffers.Factory[] engineerLevel4 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.PISTON, 2, 1, 16, 15), new TradeOffers.SellItemFactory(Items.STICKY_PISTON, 3, 1, 16, 15)};
        TradeOffers.Factory[] engineerLevel5 = new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(Items.DAYLIGHT_DETECTOR, 5, 2, 16, 30), new TradeOffers.SellItemFactory(Items.HOPPER, 6, 1, 16, 30)};
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(ENGINEER, VillagerInit.toIntMap(ImmutableMap.of(1, engineerLevel1, 2, engineerLevel2, 3, engineerLevel3, 4, engineerLevel4, 5, engineerLevel5)));
    }

    private static Int2ObjectMap<TradeOffers.Factory[]> toIntMap(ImmutableMap<Integer, TradeOffers.Factory[]> trades) {
        return new Int2ObjectOpenHashMap<>(trades);
    }
}
