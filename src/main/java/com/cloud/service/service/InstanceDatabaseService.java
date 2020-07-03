package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import com.cloud.service.exception.LockedException;
import com.cloud.service.exception.ResourceNotFoundException;
import com.cloud.service.repository.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstanceDatabaseService implements InstanceService {

    private InstanceAdapterService provider;
    private InstanceRepository repository;

    @Autowired
    public InstanceDatabaseService(InstanceAdapterService provider, InstanceRepository repository) {
        this.provider = provider;
        this.repository = repository;
    }

    public Instance get(String remoteId) throws ResourceNotFoundException {
        return repository.findByRemoteId(remoteId).orElseThrow(()
                -> new ResourceNotFoundException(remoteId));
    }

    public Instance get(Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public Instance create(Instance entity) {
        return repository.save(entity);
    }

    public Instance update(Long id, Instance entity) throws ResourceNotFoundException, LockedException {
        Instance instance = get(id);
        if (instance.isLocked()) {
            throw new LockedException(entity.getName());
        }
        instance.setName(entity.getName());
        return repository.save(instance);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        repository.delete(get(id));
    }

    public Page<Instance> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
