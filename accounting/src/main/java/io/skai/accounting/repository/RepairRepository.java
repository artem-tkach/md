package io.skai.accounting.repository;

import io.skai.accounting.dto.repair.RepairRequestDto;
import io.skai.accounting.jooq.tables.pojos.Repair;
import io.skai.accounting.jooq.tables.records.RepairRecord;

import java.util.Optional;

public interface RepairRepository {

    Optional<Repair> find(String guid);

    Repair findOrCreate(RepairRequestDto repair);

    RepairRecord createRepairRecord(RepairRequestDto repair);
}