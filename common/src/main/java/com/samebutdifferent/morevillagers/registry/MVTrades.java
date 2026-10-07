package com.samebutdifferent.morevillagers.registry;

import com.samebutdifferent.morevillagers.MoreVillagers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.item.trading.VillagerTrades;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraft.world.level.saveddata.maps.MapDecorationTypes;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;

public class MVTrades {
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_1_PRISMARINE = resourceKey("oceanographer/1/prismarine");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_1_SEA_LANTERN = resourceKey("oceanographer/1/sea_lantern");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_2_PRISMARINE_BRICKS = resourceKey("oceanographer/2/prismarine_bricks");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_2_SPONGE = resourceKey("oceanographer/2/sponge");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_3_DARK_PRISMARINE = resourceKey("oceanographer/3/dark_prismarine");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_3_MAP = resourceKey("oceanographer/3/buried_treasure_map");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_4_NAUTILUS = resourceKey("oceanographer/4/nautilus_shell");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_4_HEART = resourceKey("oceanographer/4/heart_of_the_sea");
    public static final ResourceKey<VillagerTrade> OCEANOGRAPHER_5_TRIDENT = resourceKey("oceanographer/5/trident");

    public static final ResourceKey<VillagerTrade> NETHERIAN_1_BASALT = resourceKey("netherian/1/basalt");
    public static final ResourceKey<VillagerTrade> NETHERIAN_1_BRICK = resourceKey("netherian/1/nether_brick");
    public static final ResourceKey<VillagerTrade> NETHERIAN_2_BLACKSTONE = resourceKey("netherian/2/blackstone");
    public static final ResourceKey<VillagerTrade> NETHERIAN_2_QUARTZ = resourceKey("netherian/2/quartz_ore");
    public static final ResourceKey<VillagerTrade> NETHERIAN_3_OBSIDIAN = resourceKey("netherian/3/obsidian");
    public static final ResourceKey<VillagerTrade> NETHERIAN_3_MAP = resourceKey("netherian/3/fortress_map");
    public static final ResourceKey<VillagerTrade> NETHERIAN_4_GOLD = resourceKey("netherian/4/gold_ingot");
    public static final ResourceKey<VillagerTrade> NETHERIAN_4_BASTION = resourceKey("netherian/4/bastion_map");
    public static final ResourceKey<VillagerTrade> NETHERIAN_5_PIGSTEP = resourceKey("netherian/5/pigstep");

    public static final ResourceKey<VillagerTrade> WOODWORKER_1_OAK_SAPLING = resourceKey("woodworker/1/oak_sapling");
    public static final ResourceKey<VillagerTrade> WOODWORKER_1_OAK_LOG = resourceKey("woodworker/1/oak_log");
    public static final ResourceKey<VillagerTrade> WOODWORKER_1_BIRCH_SAPLING = resourceKey("woodworker/1/birch_sapling");
    public static final ResourceKey<VillagerTrade> WOODWORKER_1_BIRCH_LOG = resourceKey("woodworker/1/birch_log");
    public static final ResourceKey<VillagerTrade> WOODWORKER_2_SPRUCE_SAPLING = resourceKey("woodworker/2/spruce_sapling");
    public static final ResourceKey<VillagerTrade> WOODWORKER_2_SPRUCE_LOG = resourceKey("woodworker/2/spruce_log");
    public static final ResourceKey<VillagerTrade> WOODWORKER_2_DARK_OAK_SAPLING = resourceKey("woodworker/2/dark_oak_sapling");
    public static final ResourceKey<VillagerTrade> WOODWORKER_2_DARK_OAK_LOG = resourceKey("woodworker/2/dark_oak_log");
    public static final ResourceKey<VillagerTrade> WOODWORKER_3_ACACIA_SAPLING = resourceKey("woodworker/3/acacia_sapling");
    public static final ResourceKey<VillagerTrade> WOODWORKER_3_ACACIA_LOG = resourceKey("woodworker/3/acacia_log");
    public static final ResourceKey<VillagerTrade> WOODWORKER_3_JUNGLE_SAPLING = resourceKey("woodworker/3/jungle_sapling");
    public static final ResourceKey<VillagerTrade> WOODWORKER_3_JUNGLE_LOG = resourceKey("woodworker/3/jungle_log");
    public static final ResourceKey<VillagerTrade> WOODWORKER_4_WARPED_STEM = resourceKey("woodworker/4/warped_stem");
    public static final ResourceKey<VillagerTrade> WOODWORKER_4_CRIMSON_STEM = resourceKey("woodworker/4/crimson_stem");
    public static final ResourceKey<VillagerTrade> WOODWORKER_5_AXE = resourceKey("woodworker/5/diamond_axe");
    public static final ResourceKey<VillagerTrade> WOODWORKER_5_HOE = resourceKey("woodworker/5/diamond_hoe");

    public static final ResourceKey<VillagerTrade> ENDERIAN_1_END_STONE = resourceKey("enderian/1/end_stone");
    public static final ResourceKey<VillagerTrade> ENDERIAN_1_END_ROD = resourceKey("enderian/1/end_rod");
    public static final ResourceKey<VillagerTrade> ENDERIAN_2_CHORUS = resourceKey("enderian/2/popped_chorus");
    public static final ResourceKey<VillagerTrade> ENDERIAN_2_MEMBRANE = resourceKey("enderian/2/phantom_membrane");
    public static final ResourceKey<VillagerTrade> ENDERIAN_3_PEARL = resourceKey("enderian/3/ender_pearl");
    public static final ResourceKey<VillagerTrade> ENDERIAN_3_FIREWORK = resourceKey("enderian/3/firework");
    public static final ResourceKey<VillagerTrade> ENDERIAN_4_BREATH = resourceKey("enderian/4/dragon_breath");
    public static final ResourceKey<VillagerTrade> ENDERIAN_4_MAP = resourceKey("enderian/4/end_city_map");
    public static final ResourceKey<VillagerTrade> ENDERIAN_5_SHULKER = resourceKey("enderian/5/shulker_shell");
    public static final ResourceKey<VillagerTrade> ENDERIAN_5_HEAD = resourceKey("enderian/5/dragon_head");

    public static final ResourceKey<VillagerTrade> ENGINEER_1_REDSTONE = resourceKey("engineer/1/redstone");
    public static final ResourceKey<VillagerTrade> ENGINEER_1_REPEATER = resourceKey("engineer/1/repeater");
    public static final ResourceKey<VillagerTrade> ENGINEER_2_TORCH = resourceKey("engineer/2/redstone_torch");
    public static final ResourceKey<VillagerTrade> ENGINEER_2_DROPPER = resourceKey("engineer/2/dropper");
    public static final ResourceKey<VillagerTrade> ENGINEER_2_DISPENSER = resourceKey("engineer/2/dispenser");
    public static final ResourceKey<VillagerTrade> ENGINEER_3_LAMP = resourceKey("engineer/3/redstone_lamp");
    public static final ResourceKey<VillagerTrade> ENGINEER_3_OBSERVER = resourceKey("engineer/3/observer");
    public static final ResourceKey<VillagerTrade> ENGINEER_3_COMPARATOR = resourceKey("engineer/3/comparator");
    public static final ResourceKey<VillagerTrade> ENGINEER_4_PISTON = resourceKey("engineer/4/piston");
    public static final ResourceKey<VillagerTrade> ENGINEER_4_STICKY = resourceKey("engineer/4/sticky_piston");
    public static final ResourceKey<VillagerTrade> ENGINEER_5_DAYLIGHT = resourceKey("engineer/5/daylight_detector");
    public static final ResourceKey<VillagerTrade> ENGINEER_5_HOPPER = resourceKey("engineer/5/hopper");

    public static final ResourceKey<VillagerTrade> FLORIST_1_POT = resourceKey("florist/1/flower_pot");
    public static final ResourceKey<VillagerTrade> FLORIST_1_HONEYCOMB = resourceKey("florist/1/honeycomb");
    public static final ResourceKey<VillagerTrade> FLORIST_2_VINE = resourceKey("florist/2/vine");
    public static final ResourceKey<VillagerTrade> FLORIST_2_BERRIES = resourceKey("florist/2/glow_berries");
    public static final ResourceKey<VillagerTrade> FLORIST_3_DRIPLEAF = resourceKey("florist/3/dripleaf");
    public static final ResourceKey<VillagerTrade> FLORIST_3_BOTTLE = resourceKey("florist/3/honey_bottle");
    public static final ResourceKey<VillagerTrade> FLORIST_4_MOSS = resourceKey("florist/4/moss");
    public static final ResourceKey<VillagerTrade> FLORIST_4_MAP = resourceKey("florist/4/swamp_map");
    public static final ResourceKey<VillagerTrade> FLORIST_5_NEST = resourceKey("florist/5/bee_nest");
    public static final ResourceKey<VillagerTrade> FLORIST_5_JUNGLE = resourceKey("florist/5/jungle_map");

    public static final ResourceKey<VillagerTrade> HUNTER_1_BONE = resourceKey("hunter/1/bone");
    public static final ResourceKey<VillagerTrade> HUNTER_1_SLIME = resourceKey("hunter/1/slime");
    public static final ResourceKey<VillagerTrade> HUNTER_2_EYE = resourceKey("hunter/2/spider_eye");
    public static final ResourceKey<VillagerTrade> HUNTER_2_FERMENTED = resourceKey("hunter/2/fermented_eye");
    public static final ResourceKey<VillagerTrade> HUNTER_3_GUNPOWDER = resourceKey("hunter/3/gunpowder");
    public static final ResourceKey<VillagerTrade> HUNTER_3_MAGMA = resourceKey("hunter/3/magma");
    public static final ResourceKey<VillagerTrade> HUNTER_4_BLAZE = resourceKey("hunter/4/blaze");
    public static final ResourceKey<VillagerTrade> HUNTER_4_MAP = resourceKey("hunter/4/outpost_map");
    public static final ResourceKey<VillagerTrade> HUNTER_5_GHAST = resourceKey("hunter/5/ghast");
    public static final ResourceKey<VillagerTrade> HUNTER_5_RABBIT = resourceKey("hunter/5/rabbit");

    public static final ResourceKey<VillagerTrade> MINER_1_DEEPSLATE = resourceKey("miner/1/deepslate");
    public static final ResourceKey<VillagerTrade> MINER_1_CALCITE = resourceKey("miner/1/calcite");
    public static final ResourceKey<VillagerTrade> MINER_2_COPPER = resourceKey("miner/2/copper");
    public static final ResourceKey<VillagerTrade> MINER_2_IRON = resourceKey("miner/2/iron");
    public static final ResourceKey<VillagerTrade> MINER_3_GOLD = resourceKey("miner/3/gold");
    public static final ResourceKey<VillagerTrade> MINER_3_AMETHYST = resourceKey("miner/3/amethyst");
    public static final ResourceKey<VillagerTrade> MINER_4_TORCH = resourceKey("miner/4/torch");
    public static final ResourceKey<VillagerTrade> MINER_4_MAP = resourceKey("miner/4/mineshaft_map");
    public static final ResourceKey<VillagerTrade> MINER_5_PICKAXE = resourceKey("miner/5/pickaxe");
    public static final ResourceKey<VillagerTrade> MINER_5_CITY = resourceKey("miner/5/ancient_city_map");


    public static Holder<VillagerTrade> bootstrap(BootstrapContext<VillagerTrade> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

        register(context, OCEANOGRAPHER_1_PRISMARINE, tradeBuy(Items.PRISMARINE, 14, 16, 2));
        register(context, OCEANOGRAPHER_1_SEA_LANTERN, tradeSell(Items.SEA_LANTERN, 2, 4, 16, 1));

        register(context, OCEANOGRAPHER_2_PRISMARINE_BRICKS, tradeBuy(Items.PRISMARINE_BRICKS, 14, 16, 10));
        register(context, OCEANOGRAPHER_2_SPONGE, tradeSell(Items.SPONGE, 4, 2, 16, 5));

        register(context, OCEANOGRAPHER_3_DARK_PRISMARINE, tradeBuy(Items.DARK_PRISMARINE, 12, 16, 20));
        register(context, OCEANOGRAPHER_3_MAP, tradeMap(context, 13, structures.getOrThrow(StructureTags.ON_TREASURE_MAPS), "filled_map.buried_treasure", MapDecorationTypes.RED_X, 12, 10));

        register(context, OCEANOGRAPHER_4_NAUTILUS, tradeSellSingle(Items.NAUTILUS_SHELL, 3, 12, 15));
        register(context, OCEANOGRAPHER_4_HEART, tradeSellSingle(Items.HEART_OF_THE_SEA, 8, 12, 15));

        register(context, OCEANOGRAPHER_5_TRIDENT, tradeSellSingle(Items.TRIDENT, 32, 2, 30));


        register(context, NETHERIAN_1_BASALT, tradeBuy(Items.BASALT, 24, 16, 2));
        register(context, NETHERIAN_1_BRICK, tradeSell(Items.NETHER_BRICK, 1, 10, 16, 1));

        register(context, NETHERIAN_2_BLACKSTONE, tradeBuy(Items.BLACKSTONE, 24, 16, 10));
        register(context, NETHERIAN_2_QUARTZ, tradeSellSingle(Items.NETHER_QUARTZ_ORE, 4, 16, 5));

        register(context, NETHERIAN_3_OBSIDIAN, tradeBuy(Items.OBSIDIAN, 4, 16, 20));
        register(context, NETHERIAN_3_MAP, tradeMap(context, 13, structures.getOrThrow(MVTags.ON_FORTRESS_EXPLORER_MAPS), "filled_map.fortress", MapDecorationTypes.RED_BANNER, 12, 10));

        register(context, NETHERIAN_4_GOLD, tradeBuy(Items.GOLD_INGOT, 4, 16, 30));
        register(context, NETHERIAN_4_BASTION, tradeMap(context, 14, structures.getOrThrow(MVTags.ON_BASTION_REMNANT_EXPLORER_MAPS), "filled_map.bastion_remnant", MapDecorationTypes.YELLOW_BANNER, 12, 15));

        register(context, NETHERIAN_5_PIGSTEP, tradeSellSingle(Items.MUSIC_DISC_PIGSTEP, 20, 12, 30));


        register(context, WOODWORKER_1_OAK_SAPLING, tradeBuy(Items.OAK_SAPLING, 6, 16, 2));
        register(context, WOODWORKER_1_OAK_LOG, tradeSell(Items.OAK_LOG, 1, 6, 16, 1));
        register(context, WOODWORKER_1_BIRCH_SAPLING, tradeBuy(Items.BIRCH_SAPLING, 6, 16, 2));
        register(context, WOODWORKER_1_BIRCH_LOG, tradeSell(Items.BIRCH_LOG, 1, 6, 16, 1));

        register(context, WOODWORKER_2_SPRUCE_SAPLING, tradeBuy(Items.SPRUCE_SAPLING, 6, 16, 10));
        register(context, WOODWORKER_2_SPRUCE_LOG, tradeSell(Items.SPRUCE_LOG, 1, 6, 16, 5));
        register(context, WOODWORKER_2_DARK_OAK_SAPLING, tradeBuy(Items.DARK_OAK_SAPLING, 6, 16, 10));
        register(context, WOODWORKER_2_DARK_OAK_LOG, tradeSell(Items.DARK_OAK_LOG, 1, 6, 16, 5));

        register(context, WOODWORKER_3_ACACIA_SAPLING, tradeBuy(Items.ACACIA_SAPLING, 6, 16, 20));
        register(context, WOODWORKER_3_ACACIA_LOG, tradeSell(Items.ACACIA_LOG, 1, 6, 16, 10));
        register(context, WOODWORKER_3_JUNGLE_SAPLING, tradeBuy(Items.JUNGLE_SAPLING, 6, 16, 20));
        register(context, WOODWORKER_3_JUNGLE_LOG, tradeSell(Items.JUNGLE_LOG, 1, 6, 16, 10));

        register(context, WOODWORKER_4_WARPED_STEM, tradeSell(Items.WARPED_STEM, 1, 6, 16, 15));
        register(context, WOODWORKER_4_CRIMSON_STEM, tradeSell(Items.CRIMSON_STEM, 1, 6, 16, 15));

        register(context, WOODWORKER_5_AXE, tradeEnchanted(context, Items.DIAMOND_AXE, 12, 3, 15));
        register(context, WOODWORKER_5_HOE, tradeEnchanted(context, Items.DIAMOND_HOE, 12, 3, 15));


        register(context, ENDERIAN_1_END_STONE, tradeBuy(Items.END_STONE, 24, 16, 2));
        register(context, ENDERIAN_1_END_ROD, tradeSell(Items.END_ROD, 4, 3, 16, 1));

        register(context, ENDERIAN_2_CHORUS, tradeBuy(Items.POPPED_CHORUS_FRUIT, 20, 16, 10));
        register(context, ENDERIAN_2_MEMBRANE, tradeSellSingle(Items.PHANTOM_MEMBRANE, 5, 16, 5));

        register(context, ENDERIAN_3_PEARL, tradeBuy(Items.ENDER_PEARL, 14, 16, 20));
        register(context, ENDERIAN_3_FIREWORK, tradeSell(Items.FIREWORK_ROCKET, 3, 8, 16, 10));

        register(context, ENDERIAN_4_BREATH, tradeSell(Items.DRAGON_BREATH, 6, 2, 12, 15));
        register(context, ENDERIAN_4_MAP, tradeMap(context, 14, structures.getOrThrow(MVTags.ON_END_CITY_EXPLORER_MAPS), "filled_map.endcity", MapDecorationTypes.PURPLE_BANNER, 12, 15));

        register(context, ENDERIAN_5_SHULKER, tradeSellSingle(Items.SHULKER_SHELL, 12, 8, 30));
        register(context, ENDERIAN_5_HEAD, tradeSellSingle(Items.DRAGON_HEAD, 20, 2, 30));


        register(context, ENGINEER_1_REDSTONE, tradeBuy(Items.REDSTONE, 20, 16, 2));
        register(context, ENGINEER_1_REPEATER, tradeSell(Items.REPEATER, 4, 3, 16, 1));

        register(context, ENGINEER_2_TORCH, tradeBuy(Items.REDSTONE_TORCH, 12, 16, 10));
        register(context, ENGINEER_2_DROPPER, tradeSell(Items.DROPPER, 3, 3, 16, 5));
        register(context, ENGINEER_2_DISPENSER, tradeSellSingle(Items.DISPENSER, 4, 16, 5));

        register(context, ENGINEER_3_LAMP, tradeBuy(Items.REDSTONE_LAMP, 4, 16, 20));
        register(context, ENGINEER_3_OBSERVER, tradeSellSingle(Items.OBSERVER, 4, 16, 10));
        register(context, ENGINEER_3_COMPARATOR, tradeSellSingle(Items.COMPARATOR, 5, 16, 10));

        register(context, ENGINEER_4_PISTON, tradeSellSingle(Items.PISTON, 5, 16, 15));
        register(context, ENGINEER_4_STICKY, tradeSellSingle(Items.STICKY_PISTON, 6, 16, 15));

        register(context, ENGINEER_5_DAYLIGHT, tradeSell(Items.DAYLIGHT_DETECTOR, 5, 2, 16, 30));
        register(context, ENGINEER_5_HOPPER, tradeSellSingle(Items.HOPPER, 7, 16, 30));


        register(context, FLORIST_1_POT, tradeBuy(Items.FLOWER_POT, 3, 16, 2));
        register(context, FLORIST_1_HONEYCOMB, tradeSellSingle(Items.HONEYCOMB, 3, 16, 1));

        register(context, FLORIST_2_VINE, tradeBuy(Items.VINE, 24, 16, 10));
        register(context, FLORIST_2_BERRIES, tradeSell(Items.GLOW_BERRIES, 1, 2, 16, 5));

        register(context, FLORIST_3_DRIPLEAF, tradeSell(Items.SMALL_DRIPLEAF, 1, 2, 16, 10));
        register(context, FLORIST_3_BOTTLE, tradeSellSingle(Items.HONEY_BOTTLE, 6, 16, 10));

        register(context, FLORIST_4_MOSS, tradeBuy(Items.MOSS_BLOCK, 32, 16, 30));
        register(context, FLORIST_4_MAP, tradeMap(context, 13, structures.getOrThrow(MVTags.ON_SWAMP_HUT_EXPLORER_MAPS), "filled_map.swamp_hut", MapDecorationTypes.GREEN_BANNER, 12, 15));

        register(context, FLORIST_5_NEST, tradeSellSingle(Items.BEE_NEST, 6, 12, 30));
        register(context, FLORIST_5_JUNGLE, tradeMap(context, 15, structures.getOrThrow(MVTags.ON_JUNGLE_TEMPLE_EXPLORER_MAPS), "filled_map.jungle_pyramid", MapDecorationTypes.LIME_BANNER, 12, 30));


        register(context, HUNTER_1_BONE, tradeBuy(Items.BONE, 32, 16, 2));
        register(context, HUNTER_1_SLIME, tradeSell(Items.SLIME_BALL, 5, 2, 16, 1));

        register(context, HUNTER_2_EYE, tradeBuy(Items.SPIDER_EYE, 24, 16, 10));
        register(context, HUNTER_2_FERMENTED, tradeSellSingle(Items.FERMENTED_SPIDER_EYE, 5, 16, 5));

        register(context, HUNTER_3_GUNPOWDER, tradeBuy(Items.GUNPOWDER, 20, 16, 20));
        register(context, HUNTER_3_MAGMA, tradeSellSingle(Items.MAGMA_CREAM, 5, 12, 10));

        register(context, HUNTER_4_BLAZE, tradeSellSingle(Items.BLAZE_ROD, 5, 12, 15));
        register(context, HUNTER_4_MAP, tradeMap(context, 13, structures.getOrThrow(MVTags.ON_PILLAGER_OUTPOST_EXPLORER_MAPS), "filled_map.pillager_outpost", MapDecorationTypes.BLACK_BANNER, 12, 15));

        register(context, HUNTER_5_GHAST, tradeSellSingle(Items.GHAST_TEAR, 8, 12, 30));
        register(context, HUNTER_5_RABBIT, tradeSellSingle(Items.RABBIT_FOOT, 8, 12, 30));


        register(context, MINER_1_DEEPSLATE, tradeBuy(Items.DEEPSLATE, 20, 16, 2));
        register(context, MINER_1_CALCITE, tradeSell(Items.CALCITE, 1, 16, 16, 1));

        register(context, MINER_2_COPPER, tradeBuy(Items.RAW_COPPER, 15, 16, 10));
        register(context, MINER_2_IRON, tradeBuy(Items.RAW_IRON, 12, 16, 10));

        register(context, MINER_3_GOLD, tradeBuy(Items.RAW_GOLD, 10, 16, 20));
        register(context, MINER_3_AMETHYST, tradeSell(Items.AMETHYST_SHARD, 1, 2, 12, 10));

        register(context, MINER_4_TORCH, tradeBuy(Items.TORCH, 50, 12, 30));
        register(context, MINER_4_MAP, tradeMap(context, 13, structures.getOrThrow(MVTags.ON_MINESHAFT_EXPLORER_MAPS), "filled_map.mineshaft", MapDecorationTypes.BROWN_BANNER, 12, 15));

        register(context, MINER_5_PICKAXE, tradeEnchanted(context, Items.DIAMOND_PICKAXE, 12, 3, 15));
        register(context, MINER_5_CITY, tradeMap(context, 15, structures.getOrThrow(MVTags.ON_ANCIENT_CITY_EXPLORER_MAPS), "filled_map.ancient_city", MapDecorationTypes.BLUE_BANNER, 12, 15));

        return null;
    }

    private static VillagerTrade tradeBuy(Item item, int count, int maxUses, int xp) {
        return VillagerTrade.builder(
                new TradeCost(item, count),
                new ItemStackTemplate(Items.EMERALD),
                maxUses, xp, 0.05F)
            .build();
    }

    private static VillagerTrade tradeSell(Item item, int emeralds, int count, int maxUses, int xp) {
        return VillagerTrade.builder(
                new TradeCost(Items.EMERALD, emeralds),
                new ItemStackTemplate(item, count),
                maxUses, xp, 0.05F)
            .build();
    }

    private static VillagerTrade tradeSellSingle(Item item, int emeralds, int maxUses, int xp) {
        return tradeSell(item, emeralds, 1, maxUses, xp);
    }

    private static VillagerTrade tradeMap(BootstrapContext<VillagerTrade> context, int emeralds, HolderSet<Structure> destination, String nameKey, Holder<MapDecorationType> mapDecoration, int maxUses, int xp) {
        HolderGetter<Item> items = context.lookup(Registries.ITEM);

        return VillagerTrade.builder(
            new TradeCost(Items.EMERALD, emeralds),
            new TradeCost(Items.COMPASS, 1),
            new ItemStackTemplate(Items.MAP),
            maxUses, xp, 0.2F
        ).addModifiers(
            Holder.direct(
                ExplorationMapFunction
                    .makeExplorationMap(destination)
                    .setMapDecoration(mapDecoration)
                    .setSearchRadius(100)
                    .setSkipKnownStructures(true)
                    .build()
            ),
            Holder.direct(
                SetNameFunction
                    .setName(Component.translatable(nameKey), SetNameFunction.Target.ITEM_NAME)
                    .build()
            ),
            VillagerTrades.discardItemIfItsNot(VillagerTrades.anyValidMap())
        ).build();
    }

    private static VillagerTrade tradeEnchanted(BootstrapContext<VillagerTrade> context, Item item, int emeralds, int maxUses, int xp) {
        HolderSet<Enchantment> enchantmentsForTradedEquipment = context.lookup(Registries.ENCHANTMENT).getOrThrow(EnchantmentTags.ON_TRADED_EQUIPMENT);
        HolderGetter<Item> items = context.lookup(Registries.ITEM);

        return VillagerTrade.builder(
                new TradeCost(Items.EMERALD, emeralds),
                new ItemStackTemplate(item),
                maxUses, xp, 0.2F
            )
            .addModifiers(VillagerTrades.enchantedItem(items, enchantmentsForTradedEquipment, item))
            .build();
    }

    public static ResourceKey<VillagerTrade> resourceKey(String path) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, MoreVillagers.id(path));
    }

    public static Holder.Reference<VillagerTrade> register(
        final BootstrapContext<VillagerTrade> context, final ResourceKey<VillagerTrade> resourceKey, final VillagerTrade villagerTrade
    ) {
        return context.register(resourceKey, villagerTrade);
    }
}
