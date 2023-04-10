package io.skai.accounting.repository.impl;

import io.skai.accounting.BaseApplicationContext;
import io.skai.accounting.jooq.tables.pojos.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.skai.accounting.jooq.Tables.CLIENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ClientRepositoryHamcrestTest extends BaseApplicationContext {
    private final Client JOHN = new Client(1L, "John", "john@somemail.com");
    private final Client SARA = new Client(2L, "Sara", "sara@somemail.com");
    private final Client MIKE = new Client(3L, "Mike", "mike@somemail.com");

    @AfterEach
    void clearTableClient() {
        dslContext
                .truncate(CLIENT)
                .execute();
    }

    @BeforeEach
    void addTestRecords() {
        dslContext.insertInto(CLIENT, CLIENT.ID, CLIENT.NAME, CLIENT.EMAIL)
                .values(JOHN.getId(), JOHN.getName(), JOHN.getEmail())
                .values(SARA.getId(), SARA.getName(), SARA.getEmail())
                .values(MIKE.getId(), MIKE.getName(), MIKE.getEmail())
                .execute();
    }

    @Test
    void whenDataInsertedFindAllAndReturnIt() {
        List<Client> clients = clientRepository.findAll();

        assertThat(clients, containsInAnyOrder(SARA, MIKE, JOHN));
    }

    @Test
    void whenDataInsertedCreateNewThenReturnIt() {
        Client client = new Client(null, "Bill", "bill@somemail.com");
        Client resultClient = clientRepository.create(client);
        assertThat(resultClient, notNullValue());
        assertThat(resultClient, hasProperty("name", equalTo("Bill")));
        assertThat(resultClient, hasProperty("email", equalTo("bill@somemail.com")));
        assertThat(resultClient, hasProperty("id", greaterThan(0L)));
    }
}
