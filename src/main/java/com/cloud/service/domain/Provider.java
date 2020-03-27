package com.cloud.service.domain;

public enum Provider {
    AMAZON,
    MICROSOFT;

    public static Provider getIfPresent(String name) {
        for (Provider provider : Provider.values()) {
            if (provider.name().equalsIgnoreCase(name)) {
                return provider;
            }
        }
        return Provider.AMAZON;
    }
}