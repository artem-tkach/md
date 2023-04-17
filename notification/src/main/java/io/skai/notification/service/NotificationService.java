package io.skai.notification.service;

import io.skai.notification.model.Notification;

public interface NotificationService {
    void notify(Notification notification);

    String processTemplate(String bodyTemplate, Notification notification);
}