package io.skai.accounting.service;

import io.skai.accounting.jooq.tables.pojos.Order;

public interface NotificationService {
    void notifyAboutNewOrder(Order order);
}
