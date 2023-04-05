package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Order;
import io.skai.accounting.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static io.skai.accounting.jooq.Tables.ORDER;
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final DSLContext dslContext;
    @Override
    public Order create(Order order) {
        return dslContext.insertInto(ORDER)
                .set(ORDER.CLIENT_ID, order.getClientId())
                .set(ORDER.MANAGER_ID, order.getManagerId())
                .set(ORDER.DEFECT, order.getDefect())
                .set(ORDER.SERIAL_NUMBER, order.getSerialNumber())
                .set(ORDER.MODEL_ID, order.getModelId())
                .returning()
                .fetchOptional()
                .orElseThrow()
                .into(Order.class);
    }
}
