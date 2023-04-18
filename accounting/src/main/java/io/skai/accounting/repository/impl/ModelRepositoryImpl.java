package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Model;
import io.skai.accounting.jooq.tables.records.ModelRecord;
import io.skai.accounting.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.skai.accounting.jooq.Tables.MODEL;

@Repository
@RequiredArgsConstructor
public class ModelRepositoryImpl implements ModelRepository {
    private final DSLContext dslContext;

    @Override
    public Model findOrCreate(Long brandId, String name) {
        return dslContext.selectFrom(MODEL)
                .where(MODEL.BRAND_ID.eq(brandId))
                .and(MODEL.NAME.eq(name))
                .fetchOptional()
                .orElseGet(()-> createNewModel(brandId, name))
                .into(Model.class);
    }

    @Override
    public List<Model> findAll(Long brandId) {
        return dslContext.selectFrom(MODEL)
                .where(MODEL.BRAND_ID.eq(brandId))
                .fetchInto(Model.class);
    }

    private ModelRecord createNewModel(Long brandId, String name){
        return dslContext.insertInto(MODEL)
                .set(MODEL.BRAND_ID, brandId)
                .set(MODEL.NAME, name)
                .returning()
                .fetchOne();
    }
}