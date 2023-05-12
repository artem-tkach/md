package io.skai.accounting.repository;

import io.skai.accounting.dto.delivery.DeliveryRequestDto;
import io.skai.accounting.jooq.tables.pojos.Delivery;
import io.skai.accounting.jooq.tables.records.DeliveryRecord;

import java.util.List;

public interface DeliveryRepository {

    Delivery findOrCreate(DeliveryRequestDto delivery);

    DeliveryRecord createDeliveryRecord(DeliveryRequestDto delivery);

    List<Delivery> getAll();
}