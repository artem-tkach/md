package io.skai.notification.controller;

import io.skai.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
public class HomeController {
    private final EmailService emailService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    String homeRequest() {
        return "hello from notify";
    }

    @GetMapping("/newOrder")
    String testSending(){
        emailService.sendTest();
        return "ok";
    };
}

