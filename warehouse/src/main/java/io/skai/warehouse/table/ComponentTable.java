package io.skai.warehouse.table;

import com.kenshoo.jooq.AbstractDataTable;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.SQLDataType;

public class ComponentTable extends AbstractDataTable<ComponentTable> {

    public static final ComponentTable TABLE = new ComponentTable();

    public final TableField<Record, Long> id = createPKField("id", SQLDataType.BIGINT.identity(true));

    public final TableField<Record, String> name = createField("name", SQLDataType.VARCHAR.length(255));

    private ComponentTable() {
        super("component");
    }
    @Override
    public ComponentTable as(String alias) {
        return new ComponentTable();
    }
}
