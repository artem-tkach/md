package io.skai.notification.service.impl;

import io.skai.notification.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmailServiceImplTest {

    private final JavaMailSender sender = mock(JavaMailSender.class);
    private final EmailService emailService = new EmailServiceImpl(sender);

    @Test
    void shouldReturnSimpleMailMessage() {
        String from = "from@mail.com";
        String receiver = "receiver@mail.com";
        String body = "some body";
        String subject = "some subject";
        SimpleMailMessage expected = prepareMailMessage();

        SimpleMailMessage result = emailService.buildMailMessage(from, receiver, subject, body);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldCallEmailSending() {
        String from = "from@mail.com";
        String receiver = "receiver@mail.com";
        String body = "some body";
        String subject = "some subject";
        SimpleMailMessage msg = prepareMailMessage();

        doNothing().when(sender).send(any(SimpleMailMessage.class));

        emailService.sendMail(emailService.buildMailMessage(from, receiver, subject, body));
        verify(sender).send(msg);
    }

    private SimpleMailMessage prepareMailMessage() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("from@mail.com");
        msg.setTo("receiver@mail.com");
        msg.setSubject("some subject");
        msg.setText("some body");
        return msg;
    }
}