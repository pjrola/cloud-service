package com.cloud.service.service;

public interface InstanceAdapterService<T> {
    void process(T request);
}
