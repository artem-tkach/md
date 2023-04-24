package io.skai.warehouse.command.builder;

import io.skai.warehouse.command.CreateBrandCommand;
import io.skai.warehouse.dto.BrandDto;
import io.skai.warehouse.model.BrandEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandCommandsBuilder {

    public List<CreateBrandCommand> buildCreateCommands(List<BrandDto> dtos) {
        return dtos.stream()
                .map(this::buildCreateCommand)
                .toList();

    }

    private CreateBrandCommand buildCreateCommand(BrandDto dto) {
        CreateBrandCommand command = new CreateBrandCommand();
        command.set(BrandEntity.NAME, dto.name());
        command.set(BrandEntity.COUNTRY, dto.country());
        command.set(BrandEntity.URL, dto.url());
        return command;
    }
}