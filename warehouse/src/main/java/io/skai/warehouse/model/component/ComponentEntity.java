package io.skai.warehouse.model.component;

import com.kenshoo.jooq.DataTable;
import com.kenshoo.pl.entity.AbstractEntityType;
import com.kenshoo.pl.entity.EntityField;
import com.kenshoo.pl.entity.SingleUniqueKey;
import com.kenshoo.pl.entity.SingleUniqueKeyValue;
import com.kenshoo.pl.entity.annotation.Id;
import com.kenshoo.pl.entity.annotation.Immutable;
import com.kenshoo.pl.entity.annotation.Required;
import io.skai.warehouse.table.ComponentResiduesTable;
import io.skai.warehouse.table.ComponentTable;

public class ComponentEntity extends AbstractEntityType<ComponentEntity> {

    public static final ComponentEntity INSTANCE = new ComponentEntity();

    @Id
    @Immutable
    public static final EntityField<ComponentEntity, Long> ID = INSTANCE.field(ComponentTable.TABLE.id);

    @Required
    @Immutable
    public static final EntityField<ComponentEntity, String> NAME = INSTANCE.field(ComponentTable.TABLE.name);

    public static final EntityField<ComponentEntity, Double> COUNT = INSTANCE.field(ComponentResiduesTable.TABLE.count);

    public static final EntityField<ComponentEntity, Double> RESERVED = INSTANCE.field(ComponentResiduesTable.TABLE.reserved);

    protected ComponentEntity() {
        super("componentEntity");
    }

    @Override
    public DataTable getPrimaryTable() {
        return ComponentTable.TABLE;
    }

    public static class Key extends SingleUniqueKeyValue<ComponentEntity, Long> {
        public static final SingleUniqueKey<ComponentEntity, Long> DEFINITION =
                new SingleUniqueKey<>(ID) {
                    @Override
                    protected ComponentEntity.Key createValue(Long id) {
                        return new ComponentEntity.Key(id);
                    }
                };

        public Key(long id) {
            super(DEFINITION, id);
        }
    }
}