package io.skai.accounting.controller;

import io.skai.accounting.dto.model.ModelRequestDto;
import io.skai.accounting.dto.model.ModelResponseDto;
import io.skai.accounting.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
@CrossOrigin
public class ModelsController {
    private final ModelService modelService;

    @PostMapping
    public ModelResponseDto create(final @RequestBody ModelRequestDto dto) {
        return modelService.create(dto);
    }

    @GetMapping
    public List<ModelResponseDto> findAllById(final @RequestParam Long brandId){
        return modelService.findAllDto(brandId);
    }
}
