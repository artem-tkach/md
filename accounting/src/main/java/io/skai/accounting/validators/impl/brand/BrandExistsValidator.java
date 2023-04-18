package io.skai.accounting.validators.impl.brand;

import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.validators.BrandValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import static io.skai.accounting.jooq.Tables.BRAND;
import static io.skai.accounting.util.ExceptionMessages.BRAND_NOT_FOUND_BY_ID;

@Component
@RequiredArgsConstructor
@Slf4j
public class BrandExistsValidator implements BrandValidator {
    private final DSLContext dslContext;

    @Override
    public void validate(final Brand brand) {
        boolean exists = dslContext.fetchExists(
                dslContext.selectFrom(BRAND)
                        .where(BRAND.ID.eq(brand.getId())));
        if (!exists) {
            throw new EntityNotFoundException(String.format(BRAND_NOT_FOUND_BY_ID, brand.getId()));
        }
    }
}
