package io.skai.notification.controller;

import io.skai.notification.dto.NewOrderRequestDto;
import io.skai.notification.service.EmailService;
import io.skai.notification.service.OrderNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationsController {
    private final EmailService emailService;
    private final OrderNotificationService orderNotificationService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    String homeRequest() {
        return "hello from notify";
    }

    @GetMapping("/newOrder")
    String testSending(){
        emailService.sendTest();
        return "ok";
    }

    @PostMapping("/newOrder")
    @ResponseStatus(HttpStatus.CREATED)
    String notifyAboutNewOrder(final @RequestBody NewOrderRequestDto dto){
        orderNotificationService.notifyAboutNewOrder(dto);
        return "success";
    }

}

