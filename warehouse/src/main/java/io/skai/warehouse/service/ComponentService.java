package io.skai.warehouse.service;

import io.skai.warehouse.dto.ComponentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComponentService {

    List<ComponentDto> create(List<ComponentDto> components);

    Boolean updateResidues(List<ComponentDto> components);

    ResponseEntity<Boolean> updateResiduesAndWrapToResponseStatus(List<ComponentDto> components);
}