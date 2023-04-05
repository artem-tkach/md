package io.skai.accounting.repository;

import io.skai.accounting.jooq.tables.pojos.Model;

import java.util.List;

public interface ModelRepository {
    Model create(Long brandId, String name);
    List<Model> findAll(Long brandId);

}
