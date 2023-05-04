package io.skai.warehouse.controller;

import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/component")
@RequiredArgsConstructor
public class ComponentController {

    private final ComponentService componentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ComponentDto> create(@RequestBody List<ComponentDto> components) {
        return componentService.create(components);
    }

    @PutMapping
    public Boolean update(@RequestBody Map<Long, Double> components) {
        return componentService.updateResidues(components);
    }
}