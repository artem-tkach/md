package io.skai.accounting.controller;

import io.skai.accounting.dto.brand.BrandRequestDto;
import io.skai.accounting.dto.brand.BrandResponseDto;
import io.skai.accounting.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandsController {
    private final BrandService brandService;
    @PostMapping
    public String create(@RequestBody BrandRequestDto dto){
        brandService.create(dto);
        return "aaaa";
    }
    @GetMapping
    public List<BrandResponseDto> getAll(){
        return brandService.getAll();
    }
}
