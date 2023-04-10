package io.skai.accounting.controller;

import io.skai.accounting.dto.client.ClientRequestDto;
import io.skai.accounting.dto.client.ClientDto;
import io.skai.accounting.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@CrossOrigin
public class ClientsController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ClientDto create(@Valid @RequestBody ClientRequestDto dto){
        return clientService.create(dto);
    }

    @GetMapping
    List<ClientDto> getAll(){
        return clientService.getAllDto();
    }
}
