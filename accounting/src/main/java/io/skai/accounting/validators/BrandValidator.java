package io.skai.accounting.validators;

import io.skai.accounting.jooq.tables.pojos.Brand;

public interface BrandValidator {
    Boolean validate(final Brand brand);
}
