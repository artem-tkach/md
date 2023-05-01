package io.skai.warehouse.service.impl;

import com.kenshoo.pl.entity.CreateResult;
import com.kenshoo.pl.entity.Identifier;
import io.skai.warehouse.command.CreateComponentCommand;
import io.skai.warehouse.command.builder.ComponentCommandsBuilder;
import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.mapper.ComponentMapper;
import io.skai.warehouse.model.ComponentEntity;
import io.skai.warehouse.repository.ComponentPersistence;
import io.skai.warehouse.service.ComponentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComponentServiceImpl implements ComponentService {

    private final ComponentPersistence componentPersistence;
    private final ComponentCommandsBuilder componentCommandsBuilder;
    private final ComponentMapper componentMapper;

    @Override
    public List<ComponentDto> create(List<ComponentDto> components) {
        List<CreateComponentCommand> commands = componentCommandsBuilder.buildCreateCommands(components);

        CreateResult<ComponentEntity, Identifier<ComponentEntity>> result = componentPersistence.create(commands);

        return result.getChangeResults()
                .stream()
                .map(componentMapper::toComponentDto)
                .toList();
    }
}