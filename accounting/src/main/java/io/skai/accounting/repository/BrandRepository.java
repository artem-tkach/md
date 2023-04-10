package io.skai.accounting.repository;

import io.skai.accounting.jooq.tables.pojos.Brand;

import java.util.List;

public interface BrandRepository {
    Brand create(String name);

    List<Brand> findAll();

    Brand findOne(Long id);

}
