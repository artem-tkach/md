package io.skai.warehouse.model;

import com.kenshoo.jooq.DataTable;
import com.kenshoo.pl.entity.AbstractEntityType;
import com.kenshoo.pl.entity.EntityField;
import com.kenshoo.pl.entity.annotation.Id;
import com.kenshoo.pl.entity.annotation.Immutable;
import com.kenshoo.pl.entity.annotation.Required;
import io.skai.warehouse.table.ComponentResiduesTable;

public class ComponentResiduesEntity extends AbstractEntityType<ComponentResiduesEntity> {

    public static final ComponentResiduesEntity INSTANCE = new ComponentResiduesEntity();

    @Id
    @Immutable
    public static final EntityField<ComponentResiduesEntity, Long> ID = INSTANCE.field(ComponentResiduesTable.TABLE.id);

    @Required
    @Immutable
    public static final EntityField<ComponentResiduesEntity, Long> NAME = INSTANCE.field(ComponentResiduesTable.TABLE.componentId);

    public static final EntityField<ComponentResiduesEntity, Double> COUNT = INSTANCE.field(ComponentResiduesTable.TABLE.count);

    public static final EntityField<ComponentResiduesEntity, Double> RESERVED = INSTANCE.field(ComponentResiduesTable.TABLE.reserved);

    protected ComponentResiduesEntity() {
        super("ComponentResiduesEntity");
    }

    @Override
    public DataTable getPrimaryTable() {
        return ComponentResiduesTable.TABLE;
    }
}