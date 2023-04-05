package io.skai.notification.service.impl;

import io.skai.notification.dto.NewOrderRequestDto;
import io.skai.notification.service.EmailService;
import io.skai.notification.service.OrderNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderNotificationServiceImpl implements OrderNotificationService {
    private final EmailService emailService;
    @Override
    public void notifyAboutNewOrder(NewOrderRequestDto dto) {
        log.debug("starting notification");
        emailService.sendMail(String.format("New order with id %d created", dto.getOrderId()),
                "corasi1329@marikuza.com", String.format("New order with id %d created", dto.getOrderId()));
    }
}
