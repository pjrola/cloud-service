package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import com.cloud.service.domain.InstanceState;
import com.cloud.service.domain.Provider;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class InstanceDatabaseService implements InstanceService {
    @Override
    public Instance get(String name) {
        return null;
    }

    @Override
    public Instance get(UUID uuid) {
        return null;
    }

    @Override
    public Instance save(Instance entity) {
        Instance instance = new Instance();
        instance.setName("test");
        instance.setProvider(Provider.AWS);
        instance.setState(InstanceState.PENDING);
        return instance;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Instance get(Long id) {
        return null;
    }

    @Override
    public List<Instance> getAll() {
        return null;
    }
}
