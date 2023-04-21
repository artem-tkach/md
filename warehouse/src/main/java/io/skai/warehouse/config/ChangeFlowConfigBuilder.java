package io.skai.warehouse.config;

import com.kenshoo.pl.entity.ChangeFlowConfig;
import com.kenshoo.pl.entity.ChangeFlowConfigBuilderFactory;
import com.kenshoo.pl.entity.EntityType;
import com.kenshoo.pl.entity.PLContext;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ChangeFlowConfigBuilder {

    @Resource
    private PLContext plContext;

    public <E extends EntityType<E>> ChangeFlowConfig.Builder<E> newInstance(E entityType) {
        return ChangeFlowConfigBuilderFactory.newInstance(plContext, entityType);
    }
}