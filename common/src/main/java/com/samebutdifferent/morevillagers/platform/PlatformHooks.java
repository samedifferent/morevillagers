package com.samebutdifferent.morevillagers.platform;

import java.util.ServiceLoader;

public class PlatformHooks {
    public static final PlatformHelper PLATFORM_HELPER = load(PlatformHelper.class);
    public static final ConfigHelper CONFIG_HELPER = load(ConfigHelper.class);

    public static <T> T load(Class<T> service) {
        return ServiceLoader.load(service)
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("No implementation found for " + service.getName()));
    }
}
