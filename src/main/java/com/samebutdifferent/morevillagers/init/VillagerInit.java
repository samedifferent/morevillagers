package com.samebutdifferent.morevillagers.init;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.samebutdifferent.morevillagers.MoreVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Blocks;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.storage.MapDecoration;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;

public class VillagerInit {
    // REGISTER WORKSTATIONS AND PROFESSIONS
    public static final DeferredRegister<PointOfInterestType> POINT_OF_INTEREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MoreVillagers.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, MoreVillagers.MOD_ID);

    // CREATE OCEANOGRAPHER WORKSTATION AND PROFESSION
    public static final RegistryObject<PointOfInterestType> OCEANOGRAPHER_POI = POINT_OF_INTEREST_TYPES.register("oceanographer",
            () -> new PointOfInterestType("oceanographer", PointOfInterestType.getBlockStates(BlockInit.OCEANOGRAPHY_TABLE.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> OCEANOGRAPHER = VILLAGER_PROFESSIONS.register("oceanographer",
            () -> new VillagerProfession("oceanographer", OCEANOGRAPHER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));
    public static void registerOceanographerPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, OCEANOGRAPHER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // CREATE NETHERIAN WORKSTATION AND PROFESSION
    public static final RegistryObject<PointOfInterestType> NETHERIAN_POI = POINT_OF_INTEREST_TYPES.register("netherian",
            () -> new PointOfInterestType("netherian", PointOfInterestType.getBlockStates(Blocks.CHISELED_POLISHED_BLACKSTONE), 1, 1));
    public static final RegistryObject<VillagerProfession> NETHERIAN = VILLAGER_PROFESSIONS.register("netherian",
            () -> new VillagerProfession("netherian", NETHERIAN_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));
    public static void registerNetherianPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, NETHERIAN_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // CREATE WOODWORKER WORKSTATION AND PROFESSION
    public static final RegistryObject<PointOfInterestType> WOODWORKER_POI = POINT_OF_INTEREST_TYPES.register("woodworker",
            () -> new PointOfInterestType("woodworker", PointOfInterestType.getBlockStates(BlockInit.WOODWORKING_TABLE.get()), 1, 1));
    public static final RegistryObject<VillagerProfession> WOODWORKER = VILLAGER_PROFESSIONS.register("woodworker",
            () -> new VillagerProfession("woodworker", WOODWORKER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LEATHERWORKER));
    public static void registerWoodworkerPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, WOODWORKER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // CREATE ENDERIAN WORKSTATION AND PROFESSION
    public static final RegistryObject<PointOfInterestType> ENDERIAN_POI = POINT_OF_INTEREST_TYPES.register("enderian",
            () -> new PointOfInterestType("enderian", PointOfInterestType.getBlockStates(Blocks.PURPUR_PILLAR), 1, 1));
    public static final RegistryObject<VillagerProfession> ENDERIAN = VILLAGER_PROFESSIONS.register("enderian",
            () -> new VillagerProfession("enderian", ENDERIAN_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));
    public static void registerEnderianPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, ENDERIAN_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // CREATE ENGINEER WORKSTATION AND PROFESSION
    public static final RegistryObject<PointOfInterestType> ENGINEER_POI = POINT_OF_INTEREST_TYPES.register("engineer",
            () -> new PointOfInterestType("engineer", PointOfInterestType.getBlockStates(Blocks.REDSTONE_BLOCK), 1, 1));
    public static final RegistryObject<VillagerProfession> ENGINEER = VILLAGER_PROFESSIONS.register("engineer",
            () -> new VillagerProfession("engineer", ENGINEER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));
    public static void registerEngineerPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, ENGINEER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    // TRADE LISTS
    public static void fillTradeData() {
        // OCEANOGRAPHER TRADES
        VillagerTrades.ITrade[] oceanographerLevel1 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.PRISMARINE,14,16,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.SEA_LANTERN, 1, 4, 16, 1)
        };
        VillagerTrades.ITrade[] oceanographerLevel2 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.PRISMARINE_BRICKS,14,16,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.SPONGE, 1, 2, 16, 5)
        };
        VillagerTrades.ITrade[] oceanographerLevel3 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.DARK_PRISMARINE,12,16,20),
                new VillagerTrades.EmeraldForMapTrade(13, Structure.BURIED_TREASURE, MapDecoration.Type.RED_X, 12, 10)
        };
        VillagerTrades.ITrade[] oceanographerLevel4 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.NAUTILUS_SHELL, 3, 1, 12, 15),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.HEART_OF_THE_SEA, 6, 1, 3, 15),
        };
        VillagerTrades.ITrade[] oceanographerLevel5 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.TRIDENT, 32, 1, 3, 30)
        };
        VillagerTrades.TRADES.put(OCEANOGRAPHER.get(),toIntMap(ImmutableMap.of(1,oceanographerLevel1,2,oceanographerLevel2,3,oceanographerLevel3,4,oceanographerLevel4,5,oceanographerLevel5)));

        // NETHERIAN TRADES
        VillagerTrades.ITrade[] netherianLevel1 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.BASALT,20,16,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.NETHER_BRICK, 1, 10, 16, 1)
        };
        VillagerTrades.ITrade[] netherianLevel2 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.BLACKSTONE,20,16,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.NETHER_QUARTZ_ORE, 4, 1, 16, 5)
        };
        VillagerTrades.ITrade[] netherianLevel3 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.OBSIDIAN,2,16,20),
                new VillagerTrades.EmeraldForMapTrade(13, Structure.NETHER_BRIDGE, MapDecoration.Type.BANNER_RED, 12, 10),
        };
        VillagerTrades.ITrade[] netherianLevel4 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForMapTrade(13, Structure.BASTION_REMNANT, MapDecoration.Type.BANNER_YELLOW, 12, 15),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.MUSIC_DISC_PIGSTEP, 12, 1, 3, 15),
        };
        VillagerTrades.ITrade[] netherianLevel5 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.WITHER_SKELETON_SKULL, 64, 1, 1, 30)
        };
        VillagerTrades.TRADES.put(NETHERIAN.get(),toIntMap(ImmutableMap.of(1,netherianLevel1,2,netherianLevel2,3,netherianLevel3,4,netherianLevel4,5,netherianLevel5)));

        // WOODWORKER TRADES
        VillagerTrades.ITrade[] woodworkerLevel1 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.OAK_SAPLING,6,16,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_LOG, 1, 6, 16, 1),
                new VillagerTrades.EmeraldForItemsTrade(Items.BIRCH_SAPLING,6,16,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.BIRCH_LOG, 1, 6, 16, 1),
        };
        VillagerTrades.ITrade[] woodworkerLevel2 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.SPRUCE_SAPLING,6,16,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.SPRUCE_LOG, 1, 6, 16, 5),
                new VillagerTrades.EmeraldForItemsTrade(Items.DARK_OAK_SAPLING,6,16,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.DARK_OAK_LOG, 1, 6, 16, 5),
        };
        VillagerTrades.ITrade[] woodworkerLevel3 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.ACACIA_SAPLING,6,16,20),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.ACACIA_LOG, 1, 6, 16, 10),
                new VillagerTrades.EmeraldForItemsTrade(Items.JUNGLE_SAPLING,6,16,20),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.JUNGLE_LOG, 1, 6, 16, 10),
        };
        VillagerTrades.ITrade[] woodworkerLevel4 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.WARPED_STEM, 1, 6, 16, 15),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.CRIMSON_STEM, 1, 6, 16, 15),
        };
        VillagerTrades.ITrade[] woodworkerLevel5 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_AXE, 12, 3, 15, 0.2F),
                new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_HOE, 12, 3, 15, 0.2F)

        };
        VillagerTrades.TRADES.put(WOODWORKER.get(),toIntMap(ImmutableMap.of(1,woodworkerLevel1,2,woodworkerLevel2,3,woodworkerLevel3,4,woodworkerLevel4,5,woodworkerLevel5)));

        // ENDERIAN TRADES
        VillagerTrades.ITrade[] enderianLevel1 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.END_STONE,20,16,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.DRAGON_BREATH, 1, 3, 16, 1)
        };
        VillagerTrades.ITrade[] enderianLevel2 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.POPPED_CHORUS_FRUIT,28,16,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.PHANTOM_MEMBRANE, 4, 1, 16, 5)
        };
        VillagerTrades.ITrade[] enderianLevel3 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.ENDER_PEARL,12,16,20),
                new VillagerTrades.EmeraldForMapTrade(13, Structure.END_CITY, MapDecoration.Type.BANNER_PURPLE, 12, 10)
        };
        VillagerTrades.ITrade[] enderianLevel4 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.SHULKER_SHELL, 6, 1, 6, 15),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.DRAGON_HEAD, 12, 1, 2, 15)
        };
        VillagerTrades.ITrade[] enderianLevel5 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.ELYTRA, 64, 1, 1, 30)
        };
        VillagerTrades.TRADES.put(ENDERIAN.get(),toIntMap(ImmutableMap.of(1,enderianLevel1,2,enderianLevel2,3,enderianLevel3,4,enderianLevel4,5,enderianLevel5)));

        // ENGINEER TRADES
        VillagerTrades.ITrade[] engineerLevel1 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.REDSTONE,20,16,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.REPEATER, 2, 1, 16, 1)
        };
        VillagerTrades.ITrade[] engineerLevel2 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.REDSTONE_TORCH,12,16,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.DROPPER, 1, 3, 16, 5),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.DISPENSER, 1, 1, 16, 5)
        };
        VillagerTrades.ITrade[] engineerLevel3 = new VillagerTrades.ITrade[]{
                new VillagerTrades.EmeraldForItemsTrade(Items.REDSTONE_LAMP,1,16,20),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OBSERVER, 2, 1, 16, 10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.COMPARATOR, 3, 1, 16, 10)
        };
        VillagerTrades.ITrade[] engineerLevel4 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.PISTON, 2, 1, 16, 15),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.STICKY_PISTON, 3, 1, 16, 15)
        };
        VillagerTrades.ITrade[] engineerLevel5 = new VillagerTrades.ITrade[]{
                new VillagerTrades.ItemsForEmeraldsTrade(Items.DAYLIGHT_DETECTOR, 5, 2, 16, 30),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.HOPPER, 6, 1, 16, 30)
        };
        VillagerTrades.TRADES.put(ENGINEER.get(),toIntMap(ImmutableMap.of(1,engineerLevel1,2,engineerLevel2,3,engineerLevel3,4,engineerLevel4,5,engineerLevel5)));
    }

    private static Int2ObjectMap<VillagerTrades.ITrade[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> p_221238_0_) {
        return new Int2ObjectOpenHashMap<>(p_221238_0_);
    }
}