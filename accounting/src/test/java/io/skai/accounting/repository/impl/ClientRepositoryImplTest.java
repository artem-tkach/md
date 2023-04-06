package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Client;
import org.assertj.core.groups.Tuple;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static io.skai.accounting.jooq.Tables.CLIENT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
class ClientRepositoryImplTest {
    @Autowired
    private ClientRepositoryImpl clientRepository;
    @Autowired
    private DSLContext dslContext;

    @BeforeEach
    void prepareTables() {
        clearTableClient();
        addTestRecords();
    }

    private void clearTableClient() {
        dslContext
                .truncate(CLIENT)
                .execute();
    }

    private void addTestRecords() {
        dslContext.insertInto(CLIENT, CLIENT.ID, CLIENT.NAME, CLIENT.EMAIL)
                .values(1L, "John", "john@somemail.com")
                .values(2L, "Sara", "sara@somemail.com")
                .values(3L, "Mike", "mike@somemail.com")
                .execute();
    }

    @Test
    void whenDataInsertedFindAllAndReturnIt() {
        List<Client> clients = clientRepository.findAll();

        assertThat(clients)
                .hasSize(3)
                .doesNotHaveDuplicates()
                .extracting(Client::getId, Client::getName, Client::getEmail)
                .contains(Tuple.tuple(1L, "John", "john@somemail.com"),
                        Tuple.tuple(2L, "Sara", "sara@somemail.com"),
                        Tuple.tuple(3L, "Mike", "mike@somemail.com"))
                .doesNotContainNull()
                .doesNotContain(Tuple.tuple(4L, "Robert", "robert@somemail.com"));

    }

    @Test
    void whenDataInsertedCreateNewThenReturnIt() {
        Client client = new Client(null, "Bill", "bill@somemail.com");
        assertThat(clientRepository.create(client))
                .isNotNull()
                .isInstanceOf(Client.class)
                .hasFieldOrPropertyWithValue("name", "Bill")
                .hasFieldOrPropertyWithValue("email", "bill@somemail.com")
                .satisfies(c -> assertThat(c.getId())
                        .isPositive());
    }

        @Test
    void whenDataInsertedCreateDuplicateThenThrownException() {
        Client client = new Client(null, "Sara", "sara@somemail.com");
        assertThatThrownBy(()->clientRepository.create(client))
                .isInstanceOf(DuplicateKeyException.class);
    }
}