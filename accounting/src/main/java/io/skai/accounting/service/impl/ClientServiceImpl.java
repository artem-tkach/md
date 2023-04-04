package io.skai.accounting.service.impl;

import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.dto.client.ClientResponseDto;
import io.skai.accounting.jooq.tables.pojos.Client;
import io.skai.accounting.mappers.ClientMapper;
import io.skai.accounting.repo.ClientRepository;
import io.skai.accounting.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponseDto create(final ClientRequestDto dto) {
        log.trace("Create client call");
        Client client = clientMapper.toClient(dto);
        return clientMapper.toResponseDto(clientRepository.create(client));
    }

    @Override
    public List<ClientResponseDto> getAllDto() {
        log.trace("Get all clients as dto call");
        List<Client> clients = clientRepository.findAll();
        return clientMapper.toResponseDtoList(clients);
    }
}
