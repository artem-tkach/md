package io.skai.notification.service;

import io.skai.notification.model.Notification;

public interface NotificationService {
    void notify(Notification notification);

    String formEmailBody(String bodyTemplate, Notification notification);

    String formEmailSubject(String subjectTemplate);
}