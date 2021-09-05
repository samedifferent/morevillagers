package io.github.pheonixvx.morevillagersfabric.config;

import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = MoreVillagersFabric.MOD_ID)
public class MoreVillagersConfig implements ConfigData {
    // Settings
    public boolean GENERATE_PLAINS_HOUSES = true;
    public boolean GENERATE_TAIGA_HOUSES = true;
    public boolean GENERATE_SAVANNA_HOUSES = true;
    public boolean GENERATE_SNOWY_HOUSES = true;
    public boolean GENERATE_DESERT_HOUSES = true;
}
