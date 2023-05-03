package io.skai.accounting.repository.impl;

import io.skai.accounting.dto.repair.RepairRequestDto;
import io.skai.accounting.jooq.tables.pojos.Repair;
import io.skai.accounting.jooq.tables.records.RepairRecord;
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

    @Override
    public Repair findOrCreate(RepairRequestDto repair) {
        return dslContext.selectFrom(REPAIR)
                .where(REPAIR.GUID.eq(repair.guid()))
                .fetchOptional()
                .orElseGet(() -> createRepairRecord(repair))
                .into(Repair.class);
    }

    @Override
    public RepairRecord createRepairRecord(RepairRequestDto repair) {
        return dslContext.insertInto(REPAIR)
                .set(REPAIR.ORDER_ID, repair.orderId())
                .set(REPAIR.MASTER_ID, repair.masterId())
                .set(REPAIR.GUID, repair.guid())
                .set(REPAIR.RESULT, repair.result().toString())
                .set(REPAIR.SUM, repair.sum())
                .set(REPAIR.COMMENT, repair.comment())
                .returning()
                .fetchOne();
    }
}