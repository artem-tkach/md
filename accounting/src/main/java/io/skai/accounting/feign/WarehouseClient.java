package io.skai.accounting.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient(name = "warehouse",
        url = "http://localhost:8082/")
public interface WarehouseClient {

    @PutMapping(value = "/component")
    Boolean writeComponents(Map<Long, Integer> components);
}
