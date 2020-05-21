package com.cloud.service.repository;

import com.cloud.service.domain.Instance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstanceRepository extends PagingAndSortingRepository<Instance, Long> {
    Instance findByRemoteId(String remoteId);
    Instance findByName(String name);
}
