package io.skai.notification.controller;

import io.skai.notification.model.Template;
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
    public Template create(@Valid @RequestBody Template template) {
        return templateService.create(template);
    }

    @GetMapping
    public List<Template> getAll() {
        return templateService.getAll();
    }
}