package com.samebutdifferent.morevillagers.registry.forge;

import net.neoforged.neoforge.common.ModConfigSpec;

public class MVConfigForge {
    public static ModConfigSpec COMMON_CONFIG;

    public static final String CATEGORY_HOUSES = "houses";
    public static final String CATEGORY_WEIGHTS = "weights";
    public static final ModConfigSpec.BooleanValue GENERATE_PLAINS_HOUSES;
    public static final ModConfigSpec.BooleanValue GENERATE_TAIGA_HOUSES;
    public static final ModConfigSpec.BooleanValue GENERATE_SAVANNA_HOUSES;
    public static final ModConfigSpec.BooleanValue GENERATE_SNOWY_HOUSES;
    public static final ModConfigSpec.BooleanValue GENERATE_DESERT_HOUSES;
    public static final ModConfigSpec.IntValue WOODWORKER_HOUSE_WEIGHT;
    public static final ModConfigSpec.IntValue OCEANOGRAPHER_HOUSE_WEIGHT;
    public static final ModConfigSpec.IntValue FLORIST_HOUSE_WEIGHT;
    public static final ModConfigSpec.IntValue HUNTER_HOUSE_WEIGHT;
    public static final ModConfigSpec.IntValue ENGINEER_HOUSE_WEIGHT;

    static {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

        COMMON_BUILDER.comment("House generation settings").push(CATEGORY_HOUSES);
        GENERATE_PLAINS_HOUSES = COMMON_BUILDER.comment("Should More Villagers houses generate in plains biome villages?")
                .define("generatePlainsHouses", true);
        GENERATE_TAIGA_HOUSES = COMMON_BUILDER.comment("Should More Villagers houses generate in taiga biome villages?")
                .define("generateTaigaHouses", true);
        GENERATE_SAVANNA_HOUSES = COMMON_BUILDER.comment("Should More Villagers houses generate in savanna biome villages?")
                .define("generateSavannaHouses", true);
        GENERATE_SNOWY_HOUSES = COMMON_BUILDER.comment("Should More Villagers houses generate in snowy biome villages?")
                .define("generateSnowyHouses", true);
        GENERATE_DESERT_HOUSES = COMMON_BUILDER.comment("Should More Villagers houses generate in desert biome villages?")
                .define("generateDesertHouses", true);

        COMMON_BUILDER.comment("House weights (spawn frequency)").push(CATEGORY_WEIGHTS);
        WOODWORKER_HOUSE_WEIGHT = COMMON_BUILDER.comment("Woodworker house spawn chance").defineInRange("woodworkerHouseWeight", 10, 0, Integer.MAX_VALUE);
        OCEANOGRAPHER_HOUSE_WEIGHT = COMMON_BUILDER.comment("Oceanographer house spawn chance").defineInRange("oceanographerHouseWeight", 10, 0, Integer.MAX_VALUE);
        FLORIST_HOUSE_WEIGHT = COMMON_BUILDER.comment("Florist house spawn chance").defineInRange("floristHouseWeight", 10, 0, Integer.MAX_VALUE);
        HUNTER_HOUSE_WEIGHT = COMMON_BUILDER.comment("Hunter house spawn chance").defineInRange("hunterHouseWeight", 10, 0, Integer.MAX_VALUE);
        ENGINEER_HOUSE_WEIGHT = COMMON_BUILDER.comment("Engineer house spawn chance").defineInRange("engineerHouseWeight", 10, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
