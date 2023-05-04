package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Repair;
import io.skai.accounting.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static io.skai.accounting.jooq.Tables.REPAIR;

@Repository
@RequiredArgsConstructor
public class RepairRepositoryImpl implements RepairRepository {

    private final DSLContext dslContext;

    @Override
    public Optional<Repair> find(String guid) {
        return dslContext.selectFrom(REPAIR)
                .where(REPAIR.GUID.eq(guid))
                .fetchOptionalInto(Repair.class);
    }
}