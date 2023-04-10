package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Client;
import io.skai.accounting.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.skai.accounting.jooq.Tables.CLIENT;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
    private final DSLContext dslContext;

    @Override
    public Client create(Client client) {
        return dslContext.insertInto(CLIENT)
                .set(CLIENT.NAME, client.getName())
                .set(CLIENT.EMAIL, client.getEmail())
                .returning()
                .fetchOptional()
                .orElseThrow()
                .into(Client.class);
    }

    @Override
    public List<Client> findAll() {
        return dslContext.selectFrom(CLIENT)
                .fetchInto(Client.class);
    }

    @Override
    public Client findOne(Long id) {
        return dslContext.selectFrom(CLIENT)
                .where(CLIENT.ID.eq(id))
                .fetchOneInto(Client.class);
    }
}
