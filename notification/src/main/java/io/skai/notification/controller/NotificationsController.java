package io.skai.notification.controller;

import io.skai.notification.model.Notification;
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

    @GetMapping("/new-order")
    String testSending(){
        emailService.sendTest();
        return "ok";
    }

    @PostMapping("/new-order")
    @ResponseStatus(HttpStatus.CREATED)
    String notifyAboutNewOrder(final @RequestBody Notification notification){
        orderNotificationService.notifyAboutNewOrder(notification);
        return "success";
    }

}

