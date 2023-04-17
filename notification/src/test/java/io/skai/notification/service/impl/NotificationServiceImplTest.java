package io.skai.notification.service.impl;

import io.skai.notification.config.GmailProperties;
import io.skai.notification.model.Notification;
import io.skai.notification.model.Template;
import io.skai.notification.service.EmailService;
import io.skai.notification.service.NotificationService;
import io.skai.notification.service.TemplateService;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;

import static io.skai.notification.enums.OrderStatus.NEW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class NotificationServiceImplTest {
    TemplateService templateService = mock(TemplateService.class);
    EmailService emailService = mock(EmailService.class);
    GmailProperties gmailProperties = mock(GmailProperties.class);
    NotificationService notificationService = new NotificationServiceImpl(templateService, emailService, gmailProperties);

    @Test
    void shouldReturnBody() {
        String template = "--%1$s--%2$s--%3$s--%4$s--%5$s--%6$s--%7$s";
        String expected = "--one--two--three--four--five--six--seven";
        String result = String.format(template, "one", "two", "three", "four", "five", "six", "seven");
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionBody() {
        String wrongTemplate = "--%1$s--%2$s--%3$s--%4$s--%5$s--%6$s--%78$s";
        Notification notification = new Notification(238L, 1L, NEW, 1L, "Samsung", 1L, "Galaxy", "some defect", "client@mail.com");

        assertThatThrownBy(() -> notificationService.formEmailBody(wrongTemplate, notification))
                .isInstanceOf(IllegalFormatException.class);
    }

    @Test
    void shouldReturnSubject() {
        String subjectTemplate = "subject template";
        String result = notificationService.formEmailSubject(subjectTemplate);
        assertThat(result)
                .isEqualTo(subjectTemplate);
    }

    @Test
    void shouldCallEmailService() {
        String emailBody = "Body";
        String emailSubject = "Subject";
        Template template = new Template(1L, NEW, emailBody, emailSubject);
        String user = "user@email.com";
        Notification notification = new Notification(238L, 1L, NEW, 1L, "Samsung", 1L, "Galaxy", "some defect", "client@mail.com");

        when(templateService.findLast(NEW)).thenReturn(template);
        when(gmailProperties.getUsername()).thenReturn(user);

        notificationService.notify(notification);
        verify(emailService).sendMail(user, notification.email(), emailSubject, emailBody);
    }
}