package com.samebutdifferent.morevillagers.platform.forge;

import com.samebutdifferent.morevillagers.registry.forge.MVConfigForge;

public class ConfigHelperImpl {
    public static boolean generatePlainsHouses() {
        return MVConfigForge.GENERATE_PLAINS_HOUSES.get();
    }

    public static boolean generateTaigaHouses() {
        return MVConfigForge.GENERATE_TAIGA_HOUSES.get();
    }

    public static boolean generateSavannaHouses() {
        return MVConfigForge.GENERATE_SAVANNA_HOUSES.get();
    }

    public static boolean generateSnowyHouses() {
        return MVConfigForge.GENERATE_SNOWY_HOUSES.get();
    }

    public static boolean generateDesertHouses() {
        return MVConfigForge.GENERATE_DESERT_HOUSES.get();
    }

    public static int woodworkerHouseWeight() {
        return MVConfigForge.WOODWORKER_HOUSE_WEIGHT.get();
    }

    public static int oceanographerHouseWeight() {
        return MVConfigForge.OCEANOGRAPHER_HOUSE_WEIGHT.get();
    }

    public static int floristHouseWeight() {
        return MVConfigForge.FLORIST_HOUSE_WEIGHT.get();
    }

    public static int hunterHouseWeight() {
        return MVConfigForge.HUNTER_HOUSE_WEIGHT.get();
    }

    public static int engineerHouseWeight() {
        return MVConfigForge.ENGINEER_HOUSE_WEIGHT.get();
    }
}
