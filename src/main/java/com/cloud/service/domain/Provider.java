package com.cloud.service.domain;

public enum Provider {
    AWS(TypeConstants.AWS),
    MICROSOFT(TypeConstants.MICROSOFT);

    private final String providerName;

    Provider(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return this.providerName.toLowerCase();
    }

    public interface TypeConstants {
        String AWS = "aws";
        String MICROSOFT = "azure";
    }
}
