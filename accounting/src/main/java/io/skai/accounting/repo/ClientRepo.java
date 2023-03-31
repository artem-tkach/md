package io.skai.accounting.repo;

import io.skai.accounting.jooq.tables.pojos.Client;

import java.util.List;

public interface ClientRepo {
    Client create(Client client);
    List<Client> findAll();
}
