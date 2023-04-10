package io.skai.accounting.service.impl;

import io.skai.accounting.dto.client.ClientDto;
import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.jooq.tables.pojos.Client;
import io.skai.accounting.mappers.ClientMapper;
import io.skai.accounting.repository.ClientRepository;
import io.skai.accounting.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientServiceImplTest {
    private final ClientRequestDto dto = new ClientRequestDto("Sara Marshal", "sara@someMail.com");
    private final Client SARA_IN_DB = new Client(1L, "Sara Marshal", "sara@someMail.com");
    private final Client SARA_NOT_IN_DB = new Client(null, "Sara Marshal", "sara@someMail.com");
    private final Client ALFRED_IN_DB = new Client(2L, "Alfred", "alfred@someMail.com");
    private final ClientDto SARA_DTO = ClientDto.builder().id(1L).name("Sara Marshal").email("sara@someMail.com").build();
    private final ClientDto ALFRED_DTO = ClientDto.builder().id(2L).name("Alfred").email("alfred@someMail.com").build();

    ClientRepository clientRepository = mock(ClientRepository.class);
    ClientMapper clientMapper = mock(ClientMapper.class);
    ClientService clientService = new ClientServiceImpl(clientRepository, clientMapper);

    @Test
    void whenClientIsNotInDbThenCreateItAndReturn() {
        when(clientRepository.create(any(Client.class))).thenReturn(SARA_IN_DB);
        when(clientMapper.toClientDto(SARA_IN_DB)).thenReturn(SARA_DTO);
        when(clientMapper.toClient(dto)).thenReturn(SARA_NOT_IN_DB);
        ClientDto result = clientService.create(dto);
        assertThat(result, equalTo(SARA_DTO));
    }

    @Test
    void whenClientIsInDbThenThrowException() {
        when(clientMapper.toClient(dto)).thenReturn(SARA_NOT_IN_DB);
        when(clientRepository.create(any(Client.class))).thenThrow(DuplicateKeyException.class);

        assertThrows(DuplicateKeyException.class, () -> clientService.create(dto));
    }

    @Test
    void whenClientsArePresentInDBThenGeThemThenReturn(){
        when(clientRepository.findAll())
                .thenReturn(List.of(SARA_IN_DB, ALFRED_IN_DB));
        when(clientMapper.toResponseDtoList(any()))
                .thenReturn(List.of(SARA_DTO, ALFRED_DTO));

        List<ClientDto> results = clientService.getAllDto();
        assertThat(results, containsInAnyOrder(SARA_DTO, ALFRED_DTO));
    }
}
