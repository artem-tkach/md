package io.skai.accounting.service.impl;

import io.skai.accounting.dto.delivery.DeliveryRequestDto;
import io.skai.accounting.jooq.tables.pojos.Delivery;
import io.skai.accounting.repository.DeliveryRepository;
import io.skai.accounting.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public Delivery findOrCreate(DeliveryRequestDto delivery) {
        return deliveryRepository.findOrCreate(delivery);
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.getAll();
    }
}