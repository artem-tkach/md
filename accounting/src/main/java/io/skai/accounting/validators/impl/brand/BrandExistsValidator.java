package io.skai.accounting.validators.impl.brand;

import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.validators.BrandValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import static io.skai.accounting.jooq.Tables.BRAND;
import static io.skai.accounting.util.ExceptionMessages.BRAND_NOT_FOUND_BY_ID;

@Component
@RequiredArgsConstructor
@Log4j2
public class BrandExistsValidator implements BrandValidator {
    private final DSLContext dslContext;

    @Override
    public Boolean validate(final Brand brand) {
        dslContext.selectFrom(BRAND)
                .where(BRAND.ID.eq(brand.getId()))
                .fetchOptional()
                .ifPresentOrElse(t->{},()->throwEntityNotFoundException(brand.getId()));
        return true;
    }

    private void throwEntityNotFoundException(Long brandId){
        throw new EntityNotFoundException(String.format(BRAND_NOT_FOUND_BY_ID, brandId));
    }
}
