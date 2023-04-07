package io.skai.accounting.service.impl;

import io.skai.accounting.dto.client.ClientDto;
import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.jooq.tables.pojos.Client;
import io.skai.accounting.mappers.ClientMapper;
import io.skai.accounting.repository.ClientRepository;
import io.skai.accounting.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto create(ClientRequestDto dto) {
        log.trace("Create client call");
        Client client = clientMapper.toClient(dto);
        return clientMapper.toResponseDto(clientRepository.create(client));
    }

    @Override
    public List<ClientDto> getAllDto() {
        log.trace("Get all clients as dto call");
        List<Client> clients = clientRepository.findAll();
        return clientMapper.toResponseDtoList(clients);
    }
}
