package io.skai.notification.controller;

import io.skai.notification.model.Notification;
import io.skai.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationsController {

    private final NotificationService notificationService;

    @PostMapping("/new-order")
    void notifyAboutNewOrder(@RequestBody Notification notification) {
        notificationService.notify(notification);
    }
}