package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import com.cloud.service.exception.ResourceNotFoundException;

public interface InstanceService extends GenericService<Instance, Long> {
    Instance get(String remoteId) throws ResourceNotFoundException;
}
