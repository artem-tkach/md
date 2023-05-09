package io.skai.warehouse.controller;

import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.model.component.Component;
import io.skai.warehouse.service.ComponentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
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

    @GetMapping
    public List<Component> findAll() {
        return componentService.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Component getById(@PathVariable("id") Long id) {
        return componentService.findById(id);
    }
}