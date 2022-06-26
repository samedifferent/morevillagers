package com.samebutdifferent.morevillagers.registry;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.samebutdifferent.morevillagers.mixin.VillagerProfessionInvoker;
import com.samebutdifferent.morevillagers.platform.CommonPlatformHelper;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.function.Supplier;

public class MVProfessions {
    public static void init() {}

    public static final Supplier<VillagerProfession> OCEANOGRAPHER = CommonPlatformHelper.registerProfession("oceanographer",
            () -> VillagerProfessionInvoker.invokeConstructor("oceanographer", MVPoiTypes.OCEANOGRAPHER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));
    public static final Supplier<VillagerProfession> NETHERIAN = CommonPlatformHelper.registerProfession("netherian",
            () -> VillagerProfessionInvoker.invokeConstructor("netherian", MVPoiTypes.NETHERIAN_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));
    public static final Supplier<VillagerProfession> WOODWORKER = CommonPlatformHelper.registerProfession("woodworker",
            () -> VillagerProfessionInvoker.invokeConstructor("woodworker", MVPoiTypes.WOODWORKER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LEATHERWORKER));
    public static final Supplier<VillagerProfession> ENDERIAN = CommonPlatformHelper.registerProfession("enderian",
            () -> VillagerProfessionInvoker.invokeConstructor("enderian", MVPoiTypes.ENDERIAN_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));
    public static final Supplier<VillagerProfession> ENGINEER = CommonPlatformHelper.registerProfession("engineer",
            () -> VillagerProfessionInvoker.invokeConstructor("engineer", MVPoiTypes.ENGINEER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));
    public static final Supplier<VillagerProfession> FLORIST = CommonPlatformHelper.registerProfession("florist",
            () -> VillagerProfessionInvoker.invokeConstructor("florist", MVPoiTypes.FLORIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));
    public static final Supplier<VillagerProfession> HUNTER = CommonPlatformHelper.registerProfession("hunter",
            () -> VillagerProfessionInvoker.invokeConstructor("hunter", MVPoiTypes.HUNTER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FLETCHER));

    public static void fillTradeData() {
        // OCEANOGRAPHER TRADES
        VillagerTrades.ItemListing[] oceanographerLevel1 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.PRISMARINE,14,16,2),
                new VillagerTrades.ItemsForEmeralds(Items.SEA_LANTERN, 2, 4, 16, 1)
        };
        VillagerTrades.ItemListing[] oceanographerLevel2 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.PRISMARINE_BRICKS,14,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.SPONGE, 4, 2, 16, 5)
        };
        VillagerTrades.ItemListing[] oceanographerLevel3 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.DARK_PRISMARINE,12,16,20),
                new VillagerTrades.TreasureMapForEmeralds(13, StructureFeature.BURIED_TREASURE, MapDecoration.Type.RED_X, 12, 10)
        };
        VillagerTrades.ItemListing[] oceanographerLevel4 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.NAUTILUS_SHELL, 3, 1, 12, 15),
                new VillagerTrades.ItemsForEmeralds(Items.HEART_OF_THE_SEA, 8, 1, 12, 15),
        };
        VillagerTrades.ItemListing[] oceanographerLevel5 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.TRIDENT, 32, 1, 2, 30)
        };
        VillagerTrades.TRADES.put(OCEANOGRAPHER.get(),toIntMap(ImmutableMap.of(1,oceanographerLevel1,2,oceanographerLevel2,3,oceanographerLevel3,4,oceanographerLevel4,5,oceanographerLevel5)));

        // NETHERIAN TRADES
        VillagerTrades.ItemListing[] netherianLevel1 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.BASALT,24,16,2),
                new VillagerTrades.ItemsForEmeralds(Items.NETHER_BRICK, 1, 10, 16, 1)
        };
        VillagerTrades.ItemListing[] netherianLevel2 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.BLACKSTONE,24,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.NETHER_QUARTZ_ORE, 4, 1, 16, 5)
        };
        VillagerTrades.ItemListing[] netherianLevel3 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.OBSIDIAN,4,16,20),
                new VillagerTrades.TreasureMapForEmeralds(13, StructureFeature.NETHER_BRIDGE, MapDecoration.Type.BANNER_RED, 12, 10),
        };
        VillagerTrades.ItemListing[] netherianLevel4 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.GOLD_INGOT,4,16,30),
                new VillagerTrades.TreasureMapForEmeralds(14, StructureFeature.BASTION_REMNANT, MapDecoration.Type.BANNER_YELLOW, 12, 15),
        };
        VillagerTrades.ItemListing[] netherianLevel5 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.MUSIC_DISC_PIGSTEP, 20, 1, 12, 30),
        };
        VillagerTrades.TRADES.put(NETHERIAN.get(),toIntMap(ImmutableMap.of(1,netherianLevel1,2,netherianLevel2,3,netherianLevel3,4,netherianLevel4,5,netherianLevel5)));

        // WOODWORKER TRADES
        VillagerTrades.ItemListing[] woodworkerLevel1 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.OAK_SAPLING,6,16,2),
                new VillagerTrades.ItemsForEmeralds(Items.OAK_LOG, 1, 6, 16, 1),
                new VillagerTrades.EmeraldForItems(Items.BIRCH_SAPLING,6,16,2),
                new VillagerTrades.ItemsForEmeralds(Items.BIRCH_LOG, 1, 6, 16, 1),
        };
        VillagerTrades.ItemListing[] woodworkerLevel2 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.SPRUCE_SAPLING,6,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.SPRUCE_LOG, 1, 6, 16, 5),
                new VillagerTrades.EmeraldForItems(Items.DARK_OAK_SAPLING,6,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.DARK_OAK_LOG, 1, 6, 16, 5),
        };
        VillagerTrades.ItemListing[] woodworkerLevel3 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.ACACIA_SAPLING,6,16,20),
                new VillagerTrades.ItemsForEmeralds(Items.ACACIA_LOG, 1, 6, 16, 10),
                new VillagerTrades.EmeraldForItems(Items.JUNGLE_SAPLING,6,16,20),
                new VillagerTrades.ItemsForEmeralds(Items.JUNGLE_LOG, 1, 6, 16, 10),
        };
        VillagerTrades.ItemListing[] woodworkerLevel4 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.WARPED_STEM, 1, 6, 16, 15),
                new VillagerTrades.ItemsForEmeralds(Items.CRIMSON_STEM, 1, 6, 16, 15),
        };
        VillagerTrades.ItemListing[] woodworkerLevel5 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EnchantedItemForEmeralds(Items.DIAMOND_AXE, 12, 3, 15, 0.2F),
                new VillagerTrades.EnchantedItemForEmeralds(Items.DIAMOND_HOE, 12, 3, 15, 0.2F)

        };
        VillagerTrades.TRADES.put(WOODWORKER.get(),toIntMap(ImmutableMap.of(1,woodworkerLevel1,2,woodworkerLevel2,3,woodworkerLevel3,4,woodworkerLevel4,5,woodworkerLevel5)));

        // ENDERIAN TRADES
        VillagerTrades.ItemListing[] enderianLevel1 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.END_STONE,24,16,2),
                new VillagerTrades.ItemsForEmeralds(Items.END_ROD, 4, 3, 16, 1)
        };
        VillagerTrades.ItemListing[] enderianLevel2 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.POPPED_CHORUS_FRUIT,20,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.PHANTOM_MEMBRANE, 5, 1, 16, 5)
        };
        VillagerTrades.ItemListing[] enderianLevel3 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.ENDER_PEARL,14,16,20),
                new VillagerTrades.ItemsForEmeralds(Items.FIREWORK_ROCKET, 3, 8, 16, 10)
        };
        VillagerTrades.ItemListing[] enderianLevel4 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.DRAGON_BREATH, 6, 2, 12, 15),
                new VillagerTrades.TreasureMapForEmeralds(14, StructureFeature.END_CITY, MapDecoration.Type.BANNER_PURPLE, 12, 15)
        };
        VillagerTrades.ItemListing[] enderianLevel5 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.SHULKER_SHELL, 12, 1, 8, 30),
                new VillagerTrades.ItemsForEmeralds(Items.DRAGON_HEAD, 20, 1, 2, 30)
        };
        VillagerTrades.TRADES.put(ENDERIAN.get(),toIntMap(ImmutableMap.of(1,enderianLevel1,2,enderianLevel2,3,enderianLevel3,4,enderianLevel4,5,enderianLevel5)));

        // ENGINEER TRADES
        VillagerTrades.ItemListing[] engineerLevel1 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.REDSTONE,20,16,2),
                new VillagerTrades.ItemsForEmeralds(Items.REPEATER, 4, 3, 16, 1)
        };
        VillagerTrades.ItemListing[] engineerLevel2 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.REDSTONE_TORCH,12,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.DROPPER, 3, 3, 16, 5),
                new VillagerTrades.ItemsForEmeralds(Items.DISPENSER, 4, 1, 16, 5)
        };
        VillagerTrades.ItemListing[] engineerLevel3 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.REDSTONE_LAMP,4,16,20),
                new VillagerTrades.ItemsForEmeralds(Items.OBSERVER, 4, 1, 16, 10),
                new VillagerTrades.ItemsForEmeralds(Items.COMPARATOR, 5, 1, 16, 10)
        };
        VillagerTrades.ItemListing[] engineerLevel4 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.PISTON, 5, 1, 16, 15),
                new VillagerTrades.ItemsForEmeralds(Items.STICKY_PISTON, 6, 1, 16, 15)
        };
        VillagerTrades.ItemListing[] engineerLevel5 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.DAYLIGHT_DETECTOR, 5, 2, 16, 30),
                new VillagerTrades.ItemsForEmeralds(Items.HOPPER, 7, 1, 16, 30)
        };
        VillagerTrades.TRADES.put(ENGINEER.get(),toIntMap(ImmutableMap.of(1,engineerLevel1,2,engineerLevel2,3,engineerLevel3,4,engineerLevel4,5,engineerLevel5)));

        // FLORIST TRADES
        VillagerTrades.ItemListing[] floristLevel1 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.FLOWER_POT,3,16,2),
                new TagItemForEmeralds(ItemTags.FLOWERS, 8, 1, 16, 1, 0.05F)
        };
        VillagerTrades.ItemListing[] floristLevel2 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.VINE,24,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.HONEYCOMB, 3, 1, 16, 5)
        };
        VillagerTrades.ItemListing[] floristLevel3 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.LILY_PAD,24,16,20),
                new VillagerTrades.ItemsForEmeralds(Items.HONEY_BOTTLE, 6, 1, 16, 10)
        };
        VillagerTrades.ItemListing[] floristLevel4 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.SEA_PICKLE,32, 16,30),
                new VillagerTrades.TreasureMapForEmeralds(13, StructureFeature.SWAMP_HUT, MapDecoration.Type.BANNER_GREEN, 12, 15)
        };
        VillagerTrades.ItemListing[] floristLevel5 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.BEE_NEST, 6, 1, 12, 30),
                new VillagerTrades.TreasureMapForEmeralds(15, StructureFeature.JUNGLE_TEMPLE, MapDecoration.Type.BANNER_LIME, 12, 30)
        };
        VillagerTrades.TRADES.put(FLORIST.get(),toIntMap(ImmutableMap.of(1,floristLevel1,2,floristLevel2,3,floristLevel3,4,floristLevel4,5,floristLevel5)));

        // HUNTER TRADES
        VillagerTrades.ItemListing[] hunterLevel1 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.BONE,32,16,2),
                new VillagerTrades.ItemsForEmeralds(Items.SLIME_BALL, 5, 2, 16, 1)
        };
        VillagerTrades.ItemListing[] hunterLevel2 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.SPIDER_EYE,24,16,10),
                new VillagerTrades.ItemsForEmeralds(Items.FERMENTED_SPIDER_EYE, 5, 1, 16, 5)
        };
        VillagerTrades.ItemListing[] hunterLevel3 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.GUNPOWDER,20,16,20),
                new VillagerTrades.ItemsForEmeralds(Items.MAGMA_CREAM, 5, 1, 12, 10)
        };
        VillagerTrades.ItemListing[] hunterLevel4 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.BLAZE_ROD, 5, 1, 12, 15),
                new VillagerTrades.TreasureMapForEmeralds(13, StructureFeature.PILLAGER_OUTPOST, MapDecoration.Type.BANNER_BLACK, 12, 15)
        };
        VillagerTrades.ItemListing[] hunterLevel5 = new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.GHAST_TEAR, 8, 1, 12, 30),
                new VillagerTrades.ItemsForEmeralds(Items.RABBIT_FOOT, 8, 1, 12, 30)
        };
        VillagerTrades.TRADES.put(HUNTER.get(),toIntMap(ImmutableMap.of(1,hunterLevel1,2,hunterLevel2,3,hunterLevel3,4,hunterLevel4,5,hunterLevel5)));
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }

    private static class TagItemForEmeralds implements VillagerTrades.ItemListing {
        private final Tag<Item> tagSource;
        private final int quantity;
        private final int price;
        private final int maxUses;
        private final int xp;
        private final float priceMultiplier;

        private TagItemForEmeralds(Tag<Item> tagSource, int quantity, int price, int maxUses, int xp, float priceMultiplier)
        {
            this.tagSource = tagSource;
            this.quantity = quantity;
            this.price = price;
            this.maxUses = maxUses;
            this.xp = xp;
            this.priceMultiplier = priceMultiplier;
        }

        @Nullable
        @Override
        public MerchantOffer getOffer(Entity entity, Random random) {
            Item item = tagSource.getRandomElement(random);
            return new MerchantOffer(new ItemStack(Items.EMERALD, price), new ItemStack(item, quantity), this.maxUses, this.xp, this.priceMultiplier);
        }
    }
}