package io.skai.accounting.controller;

import io.skai.accounting.dto.delivery.DeliveryRequestDto;
import io.skai.accounting.jooq.tables.pojos.Delivery;
import io.skai.accounting.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
@CrossOrigin
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public Delivery create(@RequestBody @Valid DeliveryRequestDto delivery){
        return deliveryService.findOrCreate(delivery);
    }

    @GetMapping
    public List<Delivery> getAll(){
        return deliveryService.getAll();
    }
}