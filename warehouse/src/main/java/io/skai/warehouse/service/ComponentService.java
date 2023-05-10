package io.skai.warehouse.service;

import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.model.component.Component;

import java.util.List;
import java.util.Map;

public interface ComponentService {

    List<ComponentDto> create(List<ComponentDto> components);

    Boolean updateResidues(Map<Long, Double> components);

    List<Component> findAll();

    Component findById(Long id);
}