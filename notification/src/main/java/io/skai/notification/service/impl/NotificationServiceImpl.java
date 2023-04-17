package io.skai.notification.service.impl;

import io.skai.notification.config.GmailProperties;
import io.skai.notification.model.Notification;
import io.skai.notification.model.Template;
import io.skai.notification.service.EmailService;
import io.skai.notification.service.NotificationService;
import io.skai.notification.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final TemplateService templateService;
    private final EmailService emailService;
    private final GmailProperties gmailProperties;

    @Override
    public void notify(Notification notification) {
        Template template = templateService.findLast(notification.orderStatus());
        String subject = processTemplate(template.getSubject(), notification);
        String body = processTemplate(template.getBody(), notification);
        SimpleMailMessage emailMessage = emailService.buildMailMessage(gmailProperties.getUsername(), notification.email(), subject, body);
        emailService.sendMail(emailMessage);
    }

    @Override
    public String processTemplate(String bodyTemplate, Notification notification) {
        return String.format(bodyTemplate, notification.brand(), notification.brandId(),
                notification.model(), notification.modelId(), notification.orderId(), notification.orderStatus(),
                notification.defect());
    }
}