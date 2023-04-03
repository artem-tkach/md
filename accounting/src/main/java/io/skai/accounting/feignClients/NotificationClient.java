package io.skai.accounting.feignClients;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "notifications",
        url = "http://localhost:8081/",
        configuration = NotificationConfig.class)
public interface NotificationClient {
    @RequestLine("GET /notify")
    String getNotifyGreeting();

    @RequestLine("GET /notify/newOrder")
    String notifyAboutNewOrder();
}

