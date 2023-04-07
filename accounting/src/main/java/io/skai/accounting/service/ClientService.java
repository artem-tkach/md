package io.skai.accounting.service;

import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.dto.client.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto create(ClientRequestDto dto);
    List<ClientDto> getAllDto();
}
