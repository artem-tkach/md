package io.skai.warehouse.repository;

import com.kenshoo.pl.entity.*;
import io.skai.warehouse.command.CreateComponentCommand;
import io.skai.warehouse.model.ComponentEntity;
import jakarta.annotation.Resource;

import java.util.Collection;

public class ComponentPersistence {

    private final PersistenceLayer<ComponentEntity> persistenceLayer;
    @Resource
    private PLContext settings;

    public ComponentPersistence(PLContext settings) {
        this.settings = settings;
        this.persistenceLayer = new PersistenceLayer<>(settings);
    }

    public CreateResult<ComponentEntity, Identifier<ComponentEntity>> create(Collection<CreateComponentCommand> commands) {
        return persistenceLayer.create(commands, flowBuilder().build());
    }

    public <ID extends Identifier<ComponentEntity>>
    UpdateResult<ComponentEntity, ID> update(Collection<? extends UpdateEntityCommand<ComponentEntity, ID>> commands) {
        return persistenceLayer.update(commands, flowBuilder().build());
    }

    private ChangeFlowConfig.Builder<ComponentEntity> flowBuilder() {
        return ChangeFlowConfigBuilderFactory
                .newInstance(settings, ComponentEntity.INSTANCE);
    }
}