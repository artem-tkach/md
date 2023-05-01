package io.skai.warehouse.service;

import io.skai.warehouse.dto.ComponentDto;

import java.util.List;

public interface ComponentService {

    List<ComponentDto> create(List<ComponentDto> components);
}