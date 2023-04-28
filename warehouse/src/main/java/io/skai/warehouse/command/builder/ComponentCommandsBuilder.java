package io.skai.warehouse.command.builder;

import io.skai.warehouse.command.CreateComponentCommand;
import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.model.ComponentEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComponentCommandsBuilder {
    public List<CreateComponentCommand> buildCreateCommands(List<ComponentDto> dtos) {
        return dtos.stream()
                .map(this::buildCreateCommand)
                .toList();
    }

    private CreateComponentCommand buildCreateCommand(ComponentDto dto) {
        CreateComponentCommand command = new CreateComponentCommand();
        command.set(ComponentEntity.NAME, dto.name());
        command.set(ComponentEntity.COUNT, dto.count());
        command.set(ComponentEntity.RESERVED, dto.reserved());
        return command;
    }
}