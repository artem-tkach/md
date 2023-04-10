package io.skai.accounting.service.impl;

import io.skai.accounting.dto.client.ClientDto;
import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.jooq.tables.pojos.Client;
import io.skai.accounting.mappers.ClientMapper;
import io.skai.accounting.repository.ClientRepository;
import io.skai.accounting.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto create(ClientRequestDto dto) {
        Client client = clientMapper.toClient(dto);
        return clientMapper.toClientDto(clientRepository.create(client));
    }

    @Override
    public List<ClientDto> getAllDto() {
        List<Client> clients = clientRepository.findAll();
        return clientMapper.toResponseDtoList(clients);
    }
}
