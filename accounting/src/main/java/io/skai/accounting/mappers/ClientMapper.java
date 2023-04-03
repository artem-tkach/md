package io.skai.accounting.mappers;

import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.dto.client.ClientResponseDto;
import io.skai.accounting.jooq.tables.pojos.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    Client toClient(ClientRequestDto dto);
    ClientResponseDto toResponseDto(Client client);

    List<ClientResponseDto> toResponseDtoList(List<Client> clients);
}
