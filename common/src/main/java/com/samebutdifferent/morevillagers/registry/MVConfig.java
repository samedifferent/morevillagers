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
        public boolean GENERATE_PLAINS_HOUSES = true;

        @Comment("Should More Villagers houses generate in taiga biome villages?")
        public boolean GENERATE_TAIGA_HOUSES = true;

        @Comment("Should More Villagers houses generate in savanna biome villages?")
        public boolean GENERATE_SAVANNA_HOUSES = true;

        @Comment("Should More Villagers houses generate in snowy biome villages?")
        public boolean GENERATE_SNOWY_HOUSES = true;

        @Comment("Should More Villagers houses generate in desert biome villages?")
        public boolean GENERATE_DESERT_HOUSES = true;
    }

    public static class Weights {
        @Comment("Woodworker house spawn chance")
        public int WOODWORKER_HOUSE_WEIGHT = 10;

        @Comment("Oceanographer house spawn chance")
        public int OCEANOGRAPHER_HOUSE_WEIGHT = 10;

        @Comment("Oceanographer house spawn chance")
        public int FLORIST_HOUSE_WEIGHT = 10;

        @Comment("Hunter house spawn chance")
        public int HUNTER_HOUSE_WEIGHT = 10;

        @Comment("Engineer house spawn chance")
        public int ENGINEER_HOUSE_WEIGHT = 10;
    }
}