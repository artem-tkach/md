package io.skai.warehouse.command.entity.component;

import com.kenshoo.pl.entity.InsertOnDuplicateUpdateCommand;
import io.skai.warehouse.model.component.ComponentEntity;

public class InsertOnDuplicateUpdateComponentCommand extends
        InsertOnDuplicateUpdateCommand<ComponentEntity, ComponentEntity.Key> {

    public InsertOnDuplicateUpdateComponentCommand(Long id) {
        super(ComponentEntity.INSTANCE, new ComponentEntity.Key(id));
    }
}