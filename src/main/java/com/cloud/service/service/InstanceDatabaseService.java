package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import com.cloud.service.repository.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstanceDatabaseService implements InstanceService {

    private InstanceAdapterService service;
    private InstanceRepository repository;

    @Autowired
    public InstanceDatabaseService(InstanceAdapterService service, InstanceRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public Instance get(String remoteId) {
        return repository.findByRemoteId(remoteId);
    }

    public Instance save(Instance entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {

    }

    public Instance get(Long id) {
        return null;
    }

    public List<Instance> getAll() {
        return null;
    }
}
