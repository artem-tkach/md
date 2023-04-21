package io.skai.warehouse.controller;

import io.skai.warehouse.dto.BrandDto;
import io.skai.warehouse.service.brand.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<BrandDto> create(@RequestBody List<BrandDto> brands){
        return brandService.create(brands);
    }
}