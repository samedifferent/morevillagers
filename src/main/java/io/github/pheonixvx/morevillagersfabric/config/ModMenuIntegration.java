package io.github.pheonixvx.morevillagersfabric.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.pheonixvx.morevillagersfabric.MoreVillagersFabric;
import me.shedaniel.clothconfiglite.api.ConfigScreen;
import net.minecraft.text.TranslatableText;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigScreen screen = ConfigScreen.create(new TranslatableText("text.morevillagers.config.title"), parent);
            screen.add(
                    new TranslatableText("text.morevillagers.generate_plains_houses"),
                    MoreVillagersFabric.config.GENERATE_PLAINS_HOUSES,
                    () -> false,
                    o -> {
                        MoreVillagersFabric.config.GENERATE_PLAINS_HOUSES = (boolean) o;
                        MoreVillagersFabric.saveConfig();
                    }
            );

            screen.add(
                    new TranslatableText("text.morevillagers.generate_taiga_houses"),
                    MoreVillagersFabric.config.GENERATE_TAIGA_HOUSES,
                    () -> false,
                    o -> {
                        MoreVillagersFabric.config.GENERATE_TAIGA_HOUSES = (boolean) o;
                        MoreVillagersFabric.saveConfig();
                    }
            );

            screen.add(
                    new TranslatableText("text.morevillagers.generate_savanna_houses"),
                    MoreVillagersFabric.config.GENERATE_SAVANNA_HOUSES,
                    () -> false,
                    o -> {
                        MoreVillagersFabric.config.GENERATE_SAVANNA_HOUSES = (boolean) o;
                        MoreVillagersFabric.saveConfig();
                    }
            );

            screen.add(
                    new TranslatableText("text.morevillagers.generate_snowy_houses"),
                    MoreVillagersFabric.config.GENERATE_SNOWY_HOUSES,
                    () -> false,
                    o -> {
                        MoreVillagersFabric.config.GENERATE_SNOWY_HOUSES = (boolean) o;
                        MoreVillagersFabric.saveConfig();
                    }
            );

            screen.add(
                    new TranslatableText("text.morevillagers.generate_desert_houses"),
                    MoreVillagersFabric.config.GENERATE_DESERT_HOUSES,
                    () -> false,
                    o -> {
                        MoreVillagersFabric.config.GENERATE_DESERT_HOUSES = (boolean) o;
                        MoreVillagersFabric.saveConfig();
                    }
            );

            return screen.get();
        };
    }
}
