package io.skai.warehouse.service.impl;

import com.kenshoo.pl.entity.*;
import io.skai.warehouse.command.CreateComponentCommand;
import io.skai.warehouse.command.builder.ComponentCommandsBuilder;
import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.model.ComponentEntity;
import io.skai.warehouse.repository.ComponentPersistence;
import io.skai.warehouse.service.ComponentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.lambda.Seq.seq;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComponentServiceImpl implements ComponentService {

    private final ComponentPersistence componentPersistence;
    private final ComponentCommandsBuilder componentCommandsBuilder;

    @Override
    public List<ComponentDto> create(List<ComponentDto> components) {
        List<CreateComponentCommand> commands = componentCommandsBuilder.buildCreateCommands(components);

        CreateResult<ComponentEntity, Identifier<ComponentEntity>> result = componentPersistence.create(commands);

        return seq(result.getChangeResults())
                .stream()
                .map(this::mapResults)
                .toList();
    }

    private ComponentDto mapResults(EntityChangeResult<ComponentEntity, Identifier<ComponentEntity>, CreateEntityCommand<ComponentEntity>> result) {
        Long id = getValuefromResult(result, ComponentEntity.ID);
        String name = getValuefromResult(result, ComponentEntity.NAME);
        Double count = getValuefromResult(result, ComponentEntity.COUNT);
        Double reserved = getValuefromResult(result, ComponentEntity.RESERVED);

        return new ComponentDto(id, name,count, reserved);
    }

    private <T> T getValuefromResult(EntityChangeResult<ComponentEntity, Identifier<ComponentEntity>, CreateEntityCommand<ComponentEntity>> result,
                                     EntityField<ComponentEntity, T> field) {
        return result.getCommand().get(field);
    }
}