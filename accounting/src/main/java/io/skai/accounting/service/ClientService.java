package io.skai.accounting.service;

import io.skai.accounting.dto.client.ClientDto;
import io.skai.accounting.dto.client.ClientRequestDto;

import java.util.List;

public interface ClientService {
    ClientDto create(ClientRequestDto dto);
    List<ClientDto> getAll();
    ClientDto find(Long id);
}
