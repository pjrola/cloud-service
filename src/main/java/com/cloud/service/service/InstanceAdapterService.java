package com.cloud.service.service;

import com.cloud.service.domain.Instance;

public interface InstanceAdapterService {
    Instance process(Instance request);
}
