package com.cloud.service.service;

public interface ServiceRegistry {
    <T> InstanceAdapterService<T> getService(String name);
}
