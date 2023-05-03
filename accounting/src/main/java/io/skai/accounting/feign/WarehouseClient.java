package io.skai.accounting.feign;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Map;

@FeignClient(name = "warehouse",
        url = "http://localhost:8082/",
        configuration = FeignConfig.class)
public interface WarehouseClient {
    @RequestLine("PUT /component")
    Boolean writeComponents(Map<Long, Integer> components);
}
