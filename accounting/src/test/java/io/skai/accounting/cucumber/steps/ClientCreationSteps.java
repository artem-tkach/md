package io.skai.accounting.cucumber.steps;

import groovy.util.logging.Slf4j;
import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.skai.accounting.cucumber.CucumberBootstrap;
import io.skai.accounting.dto.client.ClientDto;
import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.service.ClientService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static io.skai.accounting.jooq.Tables.CLIENT;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@CucumberContextConfiguration
public class ClientCreationSteps extends CucumberBootstrap {

    @Autowired
    private DSLContext dslContext;

    @Autowired
    private ClientService clientService;

    @When("^Call to create new client$")
    public void createNewBrand(ClientRequestDto client) throws URISyntaxException {
        URI uri = new URI("/clients");
        ResponseEntity<ClientDto> result = testRestTemplate.postForEntity(uri, client, ClientDto.class);
        assertThat(result.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Then("Client is stored in database$")
    public void getCreatedClient(List<ClientDto> expected) {
        List<ClientDto> results = clientService.getAll();
        assertThat(results).hasSize(1);
        assertThat(results).isEqualTo(expected);
    }

    @DataTableType
    public ClientRequestDto ClientRequestDtoTransformer(Map<String, String> row) {
        return new ClientRequestDto(
                row.get("name"),
                row.get("email"));
    }

    @DataTableType
    public ClientDto ClientDtoTransformer(Map<String, String> row) {
        return new ClientDto(
                Long.parseLong(row.get("id")),
                row.get("name"),
                row.get("email"));
    }

    @After
    public void truncateTableClient() {
        dslContext
                .truncate(CLIENT)
                .execute();
    }
}