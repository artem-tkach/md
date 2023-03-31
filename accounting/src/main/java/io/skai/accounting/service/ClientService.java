package io.skai.accounting.service;

import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.dto.client.ClientResponseDto;

import java.util.List;

public interface ClientService {
    ClientResponseDto create(ClientRequestDto dto);
    List<ClientResponseDto> getAllDto();
}
