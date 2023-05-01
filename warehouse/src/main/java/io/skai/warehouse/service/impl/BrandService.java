package io.skai.warehouse.service.impl;

import com.kenshoo.pl.entity.*;
import io.skai.warehouse.command.CreateBrandCommand;
import io.skai.warehouse.command.builder.BrandCommandsBuilder;
import io.skai.warehouse.dto.BrandDto;
import io.skai.warehouse.mapper.BrandMapper;
import io.skai.warehouse.model.BrandEntity;
import io.skai.warehouse.repository.BrandPersistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandService {

    private final BrandPersistence brandPersistence;
    private final BrandCommandsBuilder brandCommandsBuilder;
    private final BrandMapper brandMapper;

    public List<BrandDto> create(List<BrandDto> dto) {
        List<CreateBrandCommand> commands = brandCommandsBuilder.buildCreateCommands(dto);

        CreateResult<BrandEntity, Identifier<BrandEntity>> result = brandPersistence.create(commands);

        return result.getChangeResults()
                .stream()
                .map(brandMapper::toBrandDto)
                .toList();
    }
}