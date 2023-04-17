package io.skai.notification.service.impl;

import io.skai.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendMail(SimpleMailMessage message) {
        mailSender.send(message);
        log.info("E-mail send successfully to {}", Arrays.toString(message.getTo()));
    }

    @Override
    public SimpleMailMessage buildMailMessage(String from, String receiver, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(receiver);
        msg.setFrom(from);
        msg.setSubject(subject);
        msg.setText(body);
        return msg;
    }
}