package io.skai.notification.service.impl;

import io.skai.notification.model.Notification;
import io.skai.notification.model.Template;
import io.skai.notification.service.EmailService;
import io.skai.notification.service.NotificationService;
import io.skai.notification.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final TemplateService templateService;
    private final EmailService emailService;

    @Override
    public void notify(Notification notification) {
        Template template = templateService.findOneLast(notification.orderStatus());//findLast
        String subject = formEmailSubject(template.getSubject());
        String body = formEmailBody(template.getBody(), notification);
        emailService.sendMail("bla bla bla", notification.email(), subject, body);
    }

    @Override
    public String formEmailBody(String bodyTemplate, Notification notification) {
        return bodyTemplate
                .replace("[brand]", notification.brand())
                .replace("[model]", notification.model())
                .replace("[defect]", notification.defect());
    }

    @Override
    public String formEmailSubject(String subjectTemplate) {
        return subjectTemplate;
    }
}