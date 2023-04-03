package io.skai.notification.service.impl;

import io.skai.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    @Override
    public void sendTest() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("corasi1329@marikuza.com");
        msg.setFrom("art.tkach@gmail.com");
        msg.setSubject("Hello");
        msg.setText("Hello world");

        mailSender.send(msg);
    }
}
