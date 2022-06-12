package com.samebutdifferent.morevillagers.registry;

import blue.endless.jankson.Comment;
import com.samebutdifferent.morevillagers.MoreVillagers;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = MoreVillagers.MOD_ID)
public class MVConfig implements ConfigData {
    // Settings
    @ConfigEntry.Gui.CollapsibleObject
    public Houses houses = new Houses();

    @ConfigEntry.Gui.CollapsibleObject
    public Weights weights = new Weights();

    public static class Houses {
        @Comment("Should More Villagers houses generate in plains biome villages?")
        public boolean generatePlainsHouses = true;

        @Comment("Should More Villagers houses generate in taiga biome villages?")
        public boolean generateTaigaHouses = true;

        @Comment("Should More Villagers houses generate in savanna biome villages?")
        public boolean generateSavannaHouses = true;

        @Comment("Should More Villagers houses generate in snowy biome villages?")
        public boolean generateSnowyHouses = true;

        @Comment("Should More Villagers houses generate in desert biome villages?")
        public boolean generateDesertHouses = true;
    }

    public static class Weights {
        @Comment("Woodworker house spawn chance")
        public int woodworkerHouseWeight = 10;

        @Comment("Oceanographer house spawn chance")
        public int oceanographerHouseWeight = 10;

        @Comment("Oceanographer house spawn chance")
        public int floristHouseWeight = 10;

        @Comment("Hunter house spawn chance")
        public int hunterHouseWeight = 10;

        @Comment("Engineer house spawn chance")
        public int engineerHouseWeight = 10;
    }
}