package io.skai.accounting.service.impl;

import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.dto.client.ClientResponseDto;
import io.skai.accounting.jooq.tables.pojos.Client;
import io.skai.accounting.mappers.ClientMapper;
import io.skai.accounting.repo.ClientRepo;
import io.skai.accounting.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponseDto create(final ClientRequestDto dto) {
        log.trace("Create client call");
        Client client = clientMapper.toClient(dto);
        return clientMapper.toResponseDto(clientRepo.create(client));
    }

    @Override
    public List<ClientResponseDto> getAllDto() {
        log.trace("Get all clients as dto call");
        List<Client> clients = clientRepo.findAll();
        return clientMapper.toResponseDtoList(clients);
    }
}
