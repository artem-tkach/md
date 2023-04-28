package io.skai.accounting.service;

import io.skai.accounting.dto.repair.RepairRequestDto;

public interface RepairService {
    RepairRequestDto create(RepairRequestDto repair);
}