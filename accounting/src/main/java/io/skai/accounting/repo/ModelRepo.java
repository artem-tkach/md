package io.skai.accounting.repo;

import io.skai.accounting.jooq.tables.pojos.Model;

import java.util.List;

public interface ModelRepo {
    Model create(Long brandId, String name);
    List<Model> findAllByBrandId(Long brandId);

}
