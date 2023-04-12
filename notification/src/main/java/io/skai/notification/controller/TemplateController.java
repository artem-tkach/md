package io.skai.notification.controller;

import io.skai.notification.dto.template.TemplateRequestDto;
import io.skai.notification.dto.template.TemplateResponseDto;
import io.skai.notification.service.TemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TemplateResponseDto create(@Valid @RequestBody TemplateRequestDto dto) {
        return templateService.create(dto);
    }

    @GetMapping
    public List<TemplateResponseDto> getAll() {
        return templateService.getAll();
    }
}