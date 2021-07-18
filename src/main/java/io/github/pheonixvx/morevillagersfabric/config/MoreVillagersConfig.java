package io.github.pheonixvx.morevillagersfabric.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MoreVillagersConfig {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    // Settings
    public boolean GENERATE_PLAINS_HOUSES = true;
    public boolean GENERATE_TAIGA_HOUSES = true;
    public boolean GENERATE_SAVANNA_HOUSES = true;
    public boolean GENERATE_SNOWY_HOUSES = true;
    public boolean GENERATE_DESERT_HOUSES = true;

    public static MoreVillagersConfig loadConfig(File file) {
        MoreVillagersConfig config;

        if (file.exists() && file.isFile()) {
            try (
                    FileInputStream fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
            ) {
                config = GSON.fromJson(bufferedReader, MoreVillagersConfig.class);
            } catch (IOException e) {
                throw new RuntimeException("[MoreVillagers] Failed to load config", e);
            }
        } else {
            config = new MoreVillagersConfig();
        }

        config.saveConfig(file);
        return config;
    }

    public void saveConfig(File config) {
        try {
            FileOutputStream stream = new FileOutputStream(config);
            Writer writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8);

            GSON.toJson(this, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
