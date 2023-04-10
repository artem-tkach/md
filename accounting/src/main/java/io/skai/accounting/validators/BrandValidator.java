package io.skai.accounting.validators;

import io.skai.accounting.jooq.tables.pojos.Brand;

public interface BrandValidator {
    void validate(final Brand brand);
}
