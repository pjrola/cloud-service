package com.cloud.service.service;

import com.cloud.service.domain.Instance;

public interface InstanceAdapterService {
    Instance create(Instance request);
    Instance update(Instance request);
    void delete(Instance request);
    Instance find(String remoteId);
}
