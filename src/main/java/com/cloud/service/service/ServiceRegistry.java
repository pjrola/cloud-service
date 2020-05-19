package com.cloud.service.service;

public interface ServiceRegistry {
    InstanceAdapterService getService(String name);
}
