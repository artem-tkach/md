package io.skai.accounting.repository;

import io.skai.accounting.jooq.tables.pojos.Order;

public interface OrderRepository {
    Order findOrCreate(Order order);
}
