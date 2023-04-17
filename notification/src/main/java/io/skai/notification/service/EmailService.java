package io.skai.notification.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendMail(SimpleMailMessage simpleMailMessage);

    SimpleMailMessage buildMailMessage(String from, String receiver, String subject, String body);
}