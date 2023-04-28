package io.skai.warehouse.command;

import com.kenshoo.pl.entity.CreateEntityCommand;
import io.skai.warehouse.model.ComponentEntity;

public class CreateComponentCommand extends CreateEntityCommand<ComponentEntity> {
    public CreateComponentCommand() {
        super(ComponentEntity.INSTANCE);
    }
}