package com.cloud.service.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, Id extends Serializable> {

    T save(T entity);

    void delete(Id id);

    T get(Id id);

    List<T> getAll();
}
