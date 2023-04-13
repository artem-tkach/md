package io.skai.notification.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendMail(String from, String receiver, String subject, String body);

    SimpleMailMessage buildMailMessage(String from, String receiver, String subject, String body);
}