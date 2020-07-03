package com.cloud.service.service;

import com.cloud.service.exception.LockedException;
import com.cloud.service.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;

public interface GenericService<T, Id extends Serializable> {

    T create(T entity);

    T update(Id id, T entity) throws ResourceNotFoundException, LockedException;

    void delete(Id id) throws ResourceNotFoundException;

    T get(Id id) throws ResourceNotFoundException;

    Page<T> findAll(Pageable pageable);
}
