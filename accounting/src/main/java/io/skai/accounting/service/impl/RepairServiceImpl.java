package io.skai.accounting.service.impl;

import io.skai.accounting.dto.repair.RepairRequestDto;
import io.skai.accounting.feign.WarehouseClient;
import io.skai.accounting.jooq.tables.pojos.Repair;
import io.skai.accounting.repository.RepairRepository;
import io.skai.accounting.service.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;
    private final WarehouseClient warehouseClient;

    @Override
    public Repair findOrCreate(RepairRequestDto repair) {
        Boolean result = warehouseClient.writeComponents(repair.components());
        if (result == Boolean.TRUE) {
            return repairRepository.findOrCreate(repair);
        }
        return null;
    }
}