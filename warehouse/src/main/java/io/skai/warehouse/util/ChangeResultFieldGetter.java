package io.skai.warehouse.util;

import com.kenshoo.pl.entity.*;
import org.springframework.stereotype.Component;

@Component
public class ChangeResultFieldGetter {

    public <T, E extends AbstractEntityType<E>> T get(EntityChangeResult<E, Identifier<E>, CreateEntityCommand<E>> result,
                                                       EntityField<E, T> field) {
        return result.getCommand().get(field);
    }
}