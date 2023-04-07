package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static io.skai.accounting.jooq.Tables.BRAND;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {
    private final DSLContext dslContext;

    @Override
    public Brand create(String name) {
        return dslContext.insertInto(BRAND, BRAND.NAME)
                .values(name)
                .returning()
                .fetchOptional()
                .orElseThrow()
                .into(Brand.class);
    }

    @Override
    public List<Brand> findAll() {
        return dslContext.selectFrom(BRAND)
                .fetchInto(Brand.class);
    }

    @Override
    public Optional<Brand> findOneOptional(Long id) {
        return dslContext.selectFrom(BRAND)
                .where(BRAND.ID.eq(id))
                .fetchOptionalInto(Brand.class);
    }

    @Override
    public Brand findOne(Long id) {
        return dslContext.selectFrom(BRAND)
                .where(BRAND.ID.eq(id))
                .fetchOneInto(Brand.class);
    }
}
