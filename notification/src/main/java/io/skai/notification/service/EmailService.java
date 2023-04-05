package io.skai.notification.service;

public interface EmailService {
    void sendTest();

    void sendMail(final String subject, final String receiver, final String text);
}
