package io.skai.accounting.repository.impl;

import io.skai.accounting.dto.model.ModelInfoDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.pojos.Model;
import io.skai.accounting.jooq.tables.records.ModelRecord;
import io.skai.accounting.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.skai.accounting.jooq.Tables.BRAND;
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
                .orElseGet(() -> createNewModel(brandId, name))
                .into(Model.class);
    }

    @Override
    public List<Model> findAll(Long brandId) {
        return dslContext.selectFrom(MODEL)
                .where(MODEL.BRAND_ID.eq(brandId))
                .fetchInto(Model.class);
    }

    @Override
    public ModelInfoDto findModelInfo(Long id) {
        return dslContext.select()
                .from(MODEL)
                .innerJoin(BRAND).on(MODEL.BRAND_ID.eq(BRAND.ID))
                .where(MODEL.ID.eq(id))
                .fetch(this::recordToImmutablePair)
                .stream()
                .map(this::toModelInfo)
                .findFirst()
                .orElseThrow();
    }

    private ModelRecord createNewModel(Long brandId, String name) {
        return dslContext.insertInto(MODEL)
                .set(MODEL.BRAND_ID, brandId)
                .set(MODEL.NAME, name)
                .returning()
                .fetchOne();
    }

    private ModelInfoDto toModelInfo(ImmutablePair<Brand, Model> pair) {
        return new ModelInfoDto(pair.right.getId(), pair.right.getName(), pair.left.getId(), pair.left.getName());
    }

    private ImmutablePair<Brand, Model> recordToImmutablePair(Record modelRecord){
        Brand brand = modelRecord.into(BRAND).into(Brand.class);
        Model model = modelRecord.into(MODEL).into(Model.class);
        return new ImmutablePair<>(brand, model);
    }
}