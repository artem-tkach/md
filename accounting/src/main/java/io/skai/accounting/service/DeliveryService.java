package io.skai.accounting.service;

import io.skai.accounting.dto.delivery.DeliveryRequestDto;
import io.skai.accounting.jooq.tables.pojos.Delivery;

import java.util.List;

public interface DeliveryService {

    Delivery findOrCreate(DeliveryRequestDto delivery);

    List<Delivery> getAll();
}