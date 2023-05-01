package io.skai.warehouse.mapper;

import com.kenshoo.pl.entity.*;
import io.skai.warehouse.dto.ComponentDto;
import io.skai.warehouse.model.ComponentEntity;
import io.skai.warehouse.util.ChangeResultFieldGetter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ComponentMapper {

    private final ChangeResultFieldGetter fieldGetter;

    public ComponentDto toComponentDto(EntityChangeResult<ComponentEntity, Identifier<ComponentEntity>, CreateEntityCommand<ComponentEntity>> result) {
        Long id = fieldGetter.get(result, ComponentEntity.ID);
        String name = fieldGetter.get(result, ComponentEntity.NAME);
        Double count = fieldGetter.get(result, ComponentEntity.COUNT);
        Double reserved = fieldGetter.get(result, ComponentEntity.RESERVED);

        return new ComponentDto(id, name, count, reserved);
    }
}