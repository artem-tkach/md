package io.skai.accounting.repository;

import io.skai.accounting.jooq.tables.pojos.Repair;

import java.util.Optional;

public interface RepairRepository {
    Optional<Repair> find(String guid);
}