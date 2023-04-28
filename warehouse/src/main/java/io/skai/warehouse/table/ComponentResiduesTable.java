package io.skai.warehouse.table;

import com.kenshoo.jooq.AbstractDataTable;
import org.jooq.TableField;
import org.jooq.impl.SQLDataType;
import org.jooq.Record;

public class ComponentResiduesTable extends AbstractDataTable<ComponentResiduesTable> {

    public static final ComponentResiduesTable TABLE = new ComponentResiduesTable();

    public final TableField<Record, Long> id = createPKField("id", SQLDataType.BIGINT.identity(true));

    public final TableField<Record, Long> componentId = createFKField("component_id", ComponentTable.TABLE.id);

    public final TableField<Record, Double> count = createField("count", SQLDataType.DOUBLE);

    public final TableField<Record, Double> reserved = createField("reserved", SQLDataType.DOUBLE);

    private ComponentResiduesTable() {
        super("component_residues");
    }

    @Override
    public ComponentResiduesTable as(String alias) {
        return new ComponentResiduesTable();
    }
}