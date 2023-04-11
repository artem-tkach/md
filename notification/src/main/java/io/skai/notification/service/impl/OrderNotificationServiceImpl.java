package io.skai.notification.service.impl;

import io.skai.notification.dto.NewOrderNotificationRequestDto;
import io.skai.notification.service.EmailService;
import io.skai.notification.service.OrderNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderNotificationServiceImpl implements OrderNotificationService {
    private final EmailService emailService;
    @Override
    public void notifyAboutNewOrder(NewOrderNotificationRequestDto dto) {
        log.debug("starting notification");
        emailService.sendMail(String.format("New order with id %d created", dto.orderId()),
                "corasi1329@marikuza.com", String.format("New order with id %d created", dto.orderId()));
    }
}
