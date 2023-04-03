package io.skai.accounting.repo;

import io.skai.accounting.jooq.tables.pojos.Order;

public interface OrderRepo {
    Order create(Order order);
}
