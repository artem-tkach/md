package io.skai.accounting.feign.clients;

import feign.RequestLine;
import io.skai.accounting.dto.notification.OrderNotificationDto;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "notifications",
        url = "http://localhost:8081/",
        configuration = NotificationClientConfig.class)
public interface NotificationClient {
    @RequestLine("POST /notifications/new-order")
    void notifyAboutNewOrder(OrderNotificationDto dto);
}

