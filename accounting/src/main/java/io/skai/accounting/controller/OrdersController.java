package io.skai.accounting.controller;

import io.skai.accounting.dto.order.OrderRequestDto;
import io.skai.accounting.dto.order.OrderDto;
import io.skai.accounting.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;

    @GetMapping
    String orders() {
        return "Hello from orders controller";
    }

    @PostMapping
    public OrderDto create(final @Valid @RequestBody OrderRequestDto dto) {
        return orderService.createAndNotify(dto);
    }

}
