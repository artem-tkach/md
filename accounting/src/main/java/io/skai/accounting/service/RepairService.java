package io.skai.accounting.service;

import io.skai.accounting.dto.repair.RepairRequestDto;
import io.skai.accounting.jooq.tables.pojos.Repair;

public interface RepairService {

    Repair findOrCreate(RepairRequestDto repair);
}