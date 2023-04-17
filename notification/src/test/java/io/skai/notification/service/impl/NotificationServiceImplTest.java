package io.skai.notification.service.impl;

import io.skai.notification.config.GmailProperties;
import io.skai.notification.model.Notification;
import io.skai.notification.model.Template;
import io.skai.notification.service.EmailService;
import io.skai.notification.service.NotificationService;
import io.skai.notification.service.TemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;

import java.util.IllegalFormatException;

import static io.skai.notification.enums.OrderStatus.NEW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class NotificationServiceImplTest {

    private final Notification notification = new Notification(238L, 23L, NEW, 1L, "Samsung", 11L, "Galaxy", "some defect", "client@mail.com");
    private final TemplateService templateService = mock(TemplateService.class);
    private final EmailService emailService = mock(EmailService.class);
    private final GmailProperties gmailProperties = mock(GmailProperties.class);
    private final NotificationService notificationService = new NotificationServiceImpl(templateService, emailService, gmailProperties);

    @Test
    void shouldReturnBody() {
        String template = "brand is:%1$s, brand id:%2$s, model is:%3$s, model id::%4$s, order id is: %5$s, order status is:%6$s, defect is:%7$s";
        String expected = "brand is:Samsung, brand id:1, model is:Galaxy, model id::11, order id is: 23, order status is:NEW, defect is:some defect";

        String result = notificationService.processTemplate(template, notification);
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionBody() {
        String wrongTemplate = "--%1$s--%2$s--%3$s--%4$s--%5$s--%6$s--%78$s";

        assertThatThrownBy(() -> notificationService.processTemplate(wrongTemplate, notification))
                .isInstanceOf(IllegalFormatException.class);
    }

    @Test
    void shouldReturnSubject() {
        String subjectTemplate = "subject template";
        String result = notificationService.processTemplate(subjectTemplate, notification);
        assertThat(result)
                .isEqualTo(subjectTemplate);
    }

    @Test
    void shouldCallEmailService() {
        String emailBody = "Body";
        String emailSubject = "Subject";
        Template template = new Template(1L, NEW, emailBody, emailSubject);
        String user = "user@email.com";

        when(templateService.findLast(NEW)).thenReturn(template);
        when(gmailProperties.getUsername()).thenReturn(user);

        notificationService.notify(notification);
        SimpleMailMessage emailMessage = emailService.buildMailMessage(user, notification.email(), emailSubject, emailBody);

        verify(emailService).sendMail(emailMessage);
    }
}