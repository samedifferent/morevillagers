package com.samebutdifferent.morevillagers.fabric.platform;

import com.samebutdifferent.morevillagers.platform.ConfigHelper;
import com.samebutdifferent.morevillagers.fabric.registry.MVConfigFabric;
import me.shedaniel.autoconfig.AutoConfig;

public class FabricConfigHelper implements ConfigHelper {

    MVConfigFabric config = AutoConfig.getConfigHolder(MVConfigFabric.class).getConfig();

    public boolean generatePlainsHouses() {
        return config.houses.generatePlainsHouses;
    }

    public boolean generateTaigaHouses() {
        return config.houses.generateTaigaHouses;
    }

    public boolean generateSavannaHouses() {
        return config.houses.generateSavannaHouses;
    }

    public boolean generateSnowyHouses() {
        return config.houses.generateSnowyHouses;
    }

    public boolean generateDesertHouses() {
        return config.houses.generateDesertHouses;
    }

    public int woodworkerHouseWeight() {
        return config.weights.woodworkerHouseWeight;
    }

    public int oceanographerHouseWeight() {
        return config.weights.oceanographerHouseWeight;
    }

    public int floristHouseWeight() {
        return config.weights.floristHouseWeight;
    }

    public int hunterHouseWeight() {
        return config.weights.hunterHouseWeight;
    }

    public int engineerHouseWeight() {
        return config.weights.engineerHouseWeight;
    }
}
