package io.skai.notification.service.impl;

import io.skai.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    @Override
    public void sendTest() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("hexit41293@raotus.com");
        msg.setFrom("art.tkach@gmail.com");
        msg.setSubject("Hello");
        msg.setText("Hello world");

        mailSender.send(msg);
    }

    @Override
    public void sendMail(String subject, String receiver, String text) {
        log.debug("Start sending email to {}", receiver);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(receiver);
        msg.setFrom("art.tkach@gmail.com");
        msg.setSubject(subject);
        msg.setText(text);

        mailSender.send(msg);
        log.debug("E-mail send successfully to {}", receiver);
    }
}
