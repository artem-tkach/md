package io.skai.accounting.repository.impl;

import io.skai.accounting.dto.delivery.DeliveryRequestDto;
import io.skai.accounting.jooq.tables.pojos.Delivery;
import io.skai.accounting.jooq.tables.records.DeliveryRecord;
import io.skai.accounting.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.skai.accounting.jooq.Tables.DELIVERY;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final DSLContext dslContext;

    @Override
    public Delivery findOrCreate(DeliveryRequestDto delivery) {
        return dslContext.selectFrom(DELIVERY)
                .where(DELIVERY.ORDER_ID.eq(delivery.orderId()))
                .fetchOptional()
                .orElseGet(() -> createDeliveryRecord(delivery))
                .into(Delivery.class);
    }

    @Override
    public DeliveryRecord createDeliveryRecord(DeliveryRequestDto delivery) {
        return dslContext.insertInto(DELIVERY)
                .set(DELIVERY.ORDER_ID, delivery.orderId())
                .set(DELIVERY.MANAGER_ID, delivery.managerId())
                .set(DELIVERY.GUID, delivery.guid())
                .set(DELIVERY.SUM, delivery.sum())
                .returning()
                .fetchSingle();
    }

    @Override
    public List<Delivery> getAll() {
        return dslContext.selectFrom(DELIVERY)
                .fetchInto(Delivery.class);
    }
}