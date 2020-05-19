package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import java.util.UUID;

public interface InstanceService extends GenericService<Instance, Long> {
    Instance get(String name);
    Instance get(UUID uuid);
}
