package io.skai.warehouse.command.entity.component;

import com.kenshoo.pl.entity.CreateEntityCommand;
import io.skai.warehouse.model.component.ComponentEntity;

public class CreateComponentCommand extends CreateEntityCommand<ComponentEntity> {

    public CreateComponentCommand() {
        super(ComponentEntity.INSTANCE);
    }
}