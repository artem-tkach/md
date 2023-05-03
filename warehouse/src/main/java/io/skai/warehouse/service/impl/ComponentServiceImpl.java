package io.skai.warehouse.service.impl;

import com.kenshoo.pl.entity.CreateResult;
import com.kenshoo.pl.entity.Identifier;
import io.skai.warehouse.command.builder.ComponentCommandsBuilder;
import io.skai.warehouse.command.entity.component.CreateComponentCommand;
import io.skai.warehouse.command.entity.component.InsertOnDuplicateUpdateComponentCommand;
import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.mapper.ComponentMapper;
import io.skai.warehouse.model.component.Component;
import io.skai.warehouse.model.component.ComponentEntity;
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

    @Override
    public Boolean updateResidues(List<ComponentDto> components) {
        List<ComponentDto> dtosToWrite = calculateResidues(components);
        Long wrongDtoCount = getCountOfNegative(dtosToWrite);

        if (wrongDtoCount == 0) {
            List<InsertOnDuplicateUpdateComponentCommand> commands =
                    componentCommandsBuilder.buildUpsertCommands(dtosToWrite);

            componentPersistence.insertOnDuplicateUpdate(commands);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private List<ComponentDto> calculateResidues(List<ComponentDto> components) {
        return components.stream()
                .map(this::calculateResidue)
                .toList();
    }

    public ComponentDto calculateResidue(ComponentDto dto) {
        Component component = componentPersistence.find(dto.id());
        return new ComponentDto(component.id(), component.name(),
                component.count() - dto.count(), component.reserved());
    }

    private Long getCountOfNegative(List<ComponentDto> components) {
        return components.stream()
                .filter(dto -> dto.count() < 0)
                .count();
    }
}