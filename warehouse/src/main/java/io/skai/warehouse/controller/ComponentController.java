package io.skai.warehouse.controller;

import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/component")
@RequiredArgsConstructor
public class ComponentController {

    private final ComponentService componentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ComponentDto> create(@RequestBody List<ComponentDto> components){
        return componentService.create(components);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody List<ComponentDto> components){
        if (componentService.updateResidues(components)){
            return ResponseEntity.ok(Boolean.TRUE);
        }
        return ResponseEntity.badRequest().body(Boolean.FALSE);
    }
}