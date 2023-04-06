package io.skai.accounting.repository.impl;

import io.skai.accounting.jooq.tables.pojos.Client;
import io.skai.accounting.repository.ClientRepository;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static io.skai.accounting.jooq.Tables.CLIENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ActiveProfiles("test")
class ClientRepositoryHamcrestTest {
    @Autowired
    private DSLContext dslContext;
    @Autowired
    private ClientRepository clientRepository;

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
        String[] properties = {"id", "name", "email"};
        assertThat(clients, hasSize(3));
        assertThat(clients, contains(hasProperties(properties, 1L, "John", "john@somemail.com"),
                hasProperties(properties, 2L, "Sara", "sara@somemail.com"),
                hasProperties(properties, 3L, "Mike", "mike@somemail.com")
        ));
    }

    public static <T> Matcher<? super T> hasProperties(String[] properties, Object... values) {
        List<Matcher<? super T>> matchers = new ArrayList<>();
        for (int i = 0; i < properties.length; i++) {
            String property = properties[i];
            matchers.add(Matchers.hasProperty(property, equalTo(values[i])));
        }
        return Matchers.allOf(matchers);
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
