package com.cloud.service.domain;

public enum InstanceState {
    PENDING,
    RUNNING,
    TERMINATED,
    STOPPING,
    STOPPED,
    UNKNOWN,
    STARTING;

    public static InstanceState getIfPresent(String name) {
        for (InstanceState state : InstanceState.values()) {
            if (state.name().equalsIgnoreCase(name)) {
                return state;
            }
        }
        return InstanceState.UNKNOWN;
    }
}