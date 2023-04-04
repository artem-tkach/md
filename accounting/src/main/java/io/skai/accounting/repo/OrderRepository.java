package io.skai.accounting.repo;

import io.skai.accounting.jooq.tables.pojos.Order;

public interface OrderRepository {
    Order create(Order order);
}
