package io.skai.warehouse.service.impl;

import com.kenshoo.pl.entity.CreateResult;
import com.kenshoo.pl.entity.Identifier;
import io.skai.warehouse.cache.CacheStore;
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
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComponentServiceImpl implements ComponentService {

    private final ComponentPersistence componentPersistence;
    private final ComponentCommandsBuilder componentCommandsBuilder;
    private final ComponentMapper componentMapper;
    private final CacheStore<Component> cache;

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
    public Boolean updateResidues(Map<Long, Double> components) {
        List<ComponentDto> decrementedResidues = calculateResidues(components);
        Long countWithNegativeResidues = getCountOfNegative(decrementedResidues);

        if (countWithNegativeResidues == 0) {
            List<InsertOnDuplicateUpdateComponentCommand> commands = componentCommandsBuilder.buildUpsertCommands(decrementedResidues);

            componentPersistence.insertOnDuplicateUpdate(commands);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Component> findAll() {
        return componentPersistence.findAll();
    }

    @Override
    public Component findById(Long id) {
        return cache.get(id).orElseGet(() -> findAndCache(id));
    }

    private Component findAndCache(Long id) {
        Component component = componentPersistence.find(id);
        cache.add(id, component);
        return component;
    }

    private List<ComponentDto> calculateResidues(Map<Long, Double> components) {
        return components.entrySet()
                .stream()
                .map(this::calculateResidue)
                .toList();
    }

    public ComponentDto calculateResidue(Map.Entry<Long, Double> dto) {
        Component component = componentPersistence.find(dto.getKey());
        return new ComponentDto(component.id(), component.name(),
                component.count() - dto.getValue(), component.reserved());
    }

    private Long getCountOfNegative(List<ComponentDto> components) {
        return components.stream()
                .filter(dto -> dto.count() < 0)
                .count();
    }
}