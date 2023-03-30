package io.skai.accounting.service.impl;

import io.skai.accounting.dto.model.ModelRequestDto;
import io.skai.accounting.dto.model.ModelResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.pojos.Model;
import io.skai.accounting.jooq.tables.records.ModelRecord;
import io.skai.accounting.mappers.ModelMapper;
import io.skai.accounting.service.ModelService;
import io.skai.accounting.validators.impl.brand.BrandExistsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.skai.accounting.jooq.Tables.MODEL;

@Service
@Log4j2
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final DSLContext dslContext;
    private final ModelMapper modelMapper;
    private final BrandExistsValidator brandExistsValidator;

    @Override
    public ModelResponseDto create(final ModelRequestDto dto) {
        log.debug("brand id is {}", dto.getBrandId());
        brandExistsValidator.validate(new Brand(dto.getBrandId(),null));

        ModelRecord modelRecord = dslContext.insertInto(MODEL)
                .set(MODEL.BRAND_ID, dto.getBrandId())
                .set(MODEL.NAME, dto.getName())
                .returning()
                .fetchOne();

        return modelMapper.toModelResponseDto(modelRecord);
    }

    @Override
    public List<ModelResponseDto> findAllDtoByBrandId(final Long brandId) {
        log.trace("Find all models DTO by brand id call");
        List<Model> models = findAllByBrandId(brandId);
        return modelMapper.toModelResponseDtoList(models);
    }

    @Override
    public List<Model> findAllByBrandId(final Long brandId) {
        log.trace("Find all models by brand id call");
        return dslContext.selectFrom(MODEL)
                .where(MODEL.BRAND_ID.eq(brandId))
                .fetchInto(Model.class);
    }
}
