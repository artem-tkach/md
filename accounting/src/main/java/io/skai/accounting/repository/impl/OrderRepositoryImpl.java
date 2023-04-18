package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Order;
import io.skai.accounting.jooq.tables.records.OrderRecord;
import io.skai.accounting.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static io.skai.accounting.enums.OrderStatus.NEW;
import static io.skai.accounting.jooq.Tables.ORDER;
import static io.skai.accounting.jooq.Tables.ORDER_STATUS;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final DSLContext dslContext;

    @Override
    public Order findOrCreate(Order order) {
        return dslContext.selectFrom(ORDER)
                .where(ORDER.GUID.eq(order.getGuid()))
                .fetchOptional()
                .orElseGet(() -> saveNewOrder(order))
                .into(Order.class);

    }

    private OrderRecord saveNewOrder(Order order) {
        return dslContext.transactionResult(trx -> {
            OrderRecord savedOrder = dslContext.insertInto(ORDER)
                    .set(ORDER.CLIENT_ID, order.getClientId())
                    .set(ORDER.MANAGER_ID, order.getManagerId())
                    .set(ORDER.DEFECT, order.getDefect())
                    .set(ORDER.SERIAL_NUMBER, order.getSerialNumber())
                    .set(ORDER.MODEL_ID, order.getModelId())
                    .set(ORDER.GUID, order.getGuid())
                    .returning()
                    .fetchOptional()
                    .orElseThrow();

            dslContext.insertInto(ORDER_STATUS)
                    .set(ORDER_STATUS.STATUS, NEW.toString())
                    .set(ORDER_STATUS.ORDER_ID, savedOrder.getId())
                    .execute();
            return savedOrder;
        });
    }
}