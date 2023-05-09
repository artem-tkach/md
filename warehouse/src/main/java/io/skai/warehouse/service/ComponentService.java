package io.skai.warehouse.service;

import io.skai.warehouse.dto.ComponentDto;

import java.util.List;
import java.util.Map;

public interface ComponentService {

    List<ComponentDto> create(List<ComponentDto> components);

    Boolean updateResidues(Map<Long, Double> components);
}