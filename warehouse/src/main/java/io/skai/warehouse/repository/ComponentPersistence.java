package io.skai.warehouse.repository;

import com.kenshoo.pl.entity.*;
import io.skai.warehouse.command.entity.component.CreateComponentCommand;
import io.skai.warehouse.model.component.Component;
import io.skai.warehouse.model.component.ComponentEntity;
import jakarta.annotation.Resource;

import java.util.Collection;
import java.util.List;

public class ComponentPersistence {

    private final PersistenceLayer<ComponentEntity> persistenceLayer;

    @Resource
    private PLContext plContext;

    public ComponentPersistence(PLContext settings) {
        this.plContext = settings;
        this.persistenceLayer = new PersistenceLayer<>(settings);
    }

    public CreateResult<ComponentEntity, Identifier<ComponentEntity>> create(Collection<CreateComponentCommand> commands) {
        return persistenceLayer.create(commands, flowBuilder().build());
    }

    public <ID extends Identifier<ComponentEntity>>
    InsertOnDuplicateUpdateResult<ComponentEntity, ID> insertOnDuplicateUpdate(
            List<? extends InsertOnDuplicateUpdateCommand<ComponentEntity, ID>> commands) {
        return persistenceLayer.upsert(commands, flowBuilder().build());
    }

    public Component find(Long id) {
        return plContext.select(ComponentEntity.ID, ComponentEntity.NAME, ComponentEntity.RESERVED, ComponentEntity.COUNT)
                .from(ComponentEntity.INSTANCE)
                .where(ComponentEntity.ID.eq(id))
                .fetch()
                .stream()
                .findFirst()
                .map(this::buildComponent)
                .orElseThrow();
    }

    private ChangeFlowConfig.Builder<ComponentEntity> flowBuilder() {
        return ChangeFlowConfigBuilderFactory
                .newInstance(plContext, ComponentEntity.INSTANCE);
    }

    private Component buildComponent(CurrentEntityState currentEntityState) {
        return new Component(currentEntityState.get(ComponentEntity.ID), currentEntityState.get(ComponentEntity.NAME),
                currentEntityState.get(ComponentEntity.COUNT), currentEntityState.get(ComponentEntity.RESERVED));
    }
}