package com.cloud.service.domain;

public enum InstanceState {
    PENDING,
    PROVISIONING,
    RUNNING,
    STOPPING,
    STOPPED,
    UNKNOWN,
    TERMINATED;

    public static InstanceState getIfPresent(String name) {
        for (InstanceState state : InstanceState.values()) {
            if (state.name().equalsIgnoreCase(name)) {
                return state;
            }
        }
        return InstanceState.UNKNOWN;
    }
}