package io.skai.accounting.repository;

import io.skai.accounting.jooq.tables.pojos.Client;

import java.util.List;

public interface ClientRepository {
    Client create(Client client);
    List<Client> findAll();
}
