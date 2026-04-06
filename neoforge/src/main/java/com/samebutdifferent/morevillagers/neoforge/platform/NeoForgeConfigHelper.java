package com.samebutdifferent.morevillagers.neoforge.platform;

import com.samebutdifferent.morevillagers.platform.ConfigHelper;
import com.samebutdifferent.morevillagers.neoforge.registry.MVConfigNeoForge;

public class NeoForgeConfigHelper implements ConfigHelper {
    public boolean generatePlainsHouses() {
        return MVConfigNeoForge.GENERATE_PLAINS_HOUSES.get();
    }

    public boolean generateTaigaHouses() {
        return MVConfigNeoForge.GENERATE_TAIGA_HOUSES.get();
    }

    public boolean generateSavannaHouses() {
        return MVConfigNeoForge.GENERATE_SAVANNA_HOUSES.get();
    }

    public boolean generateSnowyHouses() {
        return MVConfigNeoForge.GENERATE_SNOWY_HOUSES.get();
    }

    public boolean generateDesertHouses() {
        return MVConfigNeoForge.GENERATE_DESERT_HOUSES.get();
    }

    public int woodworkerHouseWeight() {
        return MVConfigNeoForge.WOODWORKER_HOUSE_WEIGHT.get();
    }

    public int oceanographerHouseWeight() {
        return MVConfigNeoForge.OCEANOGRAPHER_HOUSE_WEIGHT.get();
    }

    public int floristHouseWeight() {
        return MVConfigNeoForge.FLORIST_HOUSE_WEIGHT.get();
    }

    public int hunterHouseWeight() {
        return MVConfigNeoForge.HUNTER_HOUSE_WEIGHT.get();
    }

    public int engineerHouseWeight() {
        return MVConfigNeoForge.ENGINEER_HOUSE_WEIGHT.get();
    }
}
