package io.skai.accounting.controller;

import io.skai.accounting.dto.repair.RepairRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repair")
@Slf4j
public class RepairController {
    @PostMapping
    public void create(@RequestBody RepairRequestDto repair) {
        log.info("New repair:::{}", repair);
    }
}