package io.skai.accounting.mappers;

import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.dto.client.ClientDto;
import io.skai.accounting.jooq.tables.pojos.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    Client toClient(ClientRequestDto dto);

    ClientDto toResponseDto(Client client);

    List<ClientDto> toResponseDtoList(List<Client> clients);
}
