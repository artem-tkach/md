package io.skai.accounting.controller;

import io.skai.accounting.dto.repair.RepairRequestDto;
import io.skai.accounting.jooq.tables.pojos.Repair;
import io.skai.accounting.service.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repair")
@Slf4j
@RequiredArgsConstructor
public class RepairController {

    private final RepairService repairService;

    @PostMapping
    public Repair create(@RequestBody RepairRequestDto repair) {
        return repairService.findOrCreate(repair);
    }
}