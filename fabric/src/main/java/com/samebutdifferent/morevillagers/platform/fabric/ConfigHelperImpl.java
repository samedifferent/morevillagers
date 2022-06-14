package com.samebutdifferent.morevillagers.platform.fabric;

import com.samebutdifferent.morevillagers.registry.fabric.MVConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;

public class ConfigHelperImpl {

    static MVConfigFabric config = AutoConfig.getConfigHolder(MVConfigFabric.class).getConfig();

    public static boolean generatePlainsHouses() {
        return config.houses.generatePlainsHouses;
    }

    public static boolean generateTaigaHouses() {
        return config.houses.generateTaigaHouses;
    }

    public static boolean generateSavannaHouses() {
        return config.houses.generateSavannaHouses;
    }

    public static boolean generateSnowyHouses() {
        return config.houses.generateSnowyHouses;
    }

    public static boolean generateDesertHouses() {
        return config.houses.generateDesertHouses;
    }

    public static int woodworkerHouseWeight() {
        return config.weights.woodworkerHouseWeight;
    }

    public static int oceanographerHouseWeight() {
        return config.weights.oceanographerHouseWeight;
    }

    public static int floristHouseWeight() {
        return config.weights.floristHouseWeight;
    }

    public static int hunterHouseWeight() {
        return config.weights.hunterHouseWeight;
    }

    public static int engineerHouseWeight() {
        return config.weights.engineerHouseWeight;
    }
}
