package io.skai.accounting.repo;

import io.skai.accounting.jooq.tables.pojos.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepo {
    Brand create(String name);
    List<Brand> findAll();
    Optional<Brand> findOneOptional(Long id);
    Brand findOne(Long id);

}
