package io.skai.warehouse.repository;

import com.kenshoo.pl.entity.*;
import io.skai.warehouse.config.ChangeFlowConfigBuilder;
import io.skai.warehouse.model.BrandEntity;
import io.skai.warehouse.command.CreateBrandCommand;
import io.skai.warehouse.model.BrandInfoEntity;
import jakarta.annotation.Resource;
import com.kenshoo.pl.entity.ChangeFlowConfig;
import com.kenshoo.pl.entity.ChangeFlowConfigBuilderFactory;

import java.util.Collection;

public class BrandPersistence {

    private final PersistenceLayer<BrandEntity> persistenceLayer;
    @Resource
    private PLContext settings;

    @Resource
    private ChangeFlowConfigBuilder changeFlowConfigBuilder;

    public BrandPersistence(PLContext settings) {
        this.settings = settings;
        this.persistenceLayer = new PersistenceLayer<>(settings);
    }

    public CreateResult<BrandEntity, Identifier<BrandEntity>> create(Collection<CreateBrandCommand> commands) {
        return persistenceLayer.create(commands, flowBuilder().build());
    }

    public <ID extends Identifier<BrandEntity>>
    UpdateResult<BrandEntity, ID> update(Collection<? extends UpdateEntityCommand<BrandEntity, ID>> commands) {
        return persistenceLayer.update(commands, flowBuilder().build());
    }

    private ChangeFlowConfig.Builder<BrandEntity> flowBuilder() {
        ChangeFlowConfig.Builder<BrandInfoEntity> childFlow = changeFlowConfigBuilder.newInstance(BrandInfoEntity.INSTANCE);

        return ChangeFlowConfigBuilderFactory
                .newInstance(settings, BrandEntity.INSTANCE)
                .withChildFlowBuilder(childFlow);
    }
}