package com.cloud.service.repository;

import com.cloud.service.domain.Instance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InstanceRepository extends PagingAndSortingRepository<Instance, Long> {
    Optional<Instance> findByRemoteId(String remoteId);
    Optional<Instance> findByName(String name);
}
