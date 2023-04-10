package io.skai.accounting.controller;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
@CrossOrigin
public class BrandsController {

    private final BrandService brandService;

    @PostMapping
    public BrandDto create(@Valid @RequestBody BrandRequestDto dto){
        return brandService.create(dto);
    }

    @GetMapping
    public List<BrandDto> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public Brand get(@PathVariable Long id){
        return brandService.findOne(id);
    }
}
