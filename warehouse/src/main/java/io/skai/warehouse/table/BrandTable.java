package io.skai.warehouse.table;

import com.kenshoo.jooq.AbstractDataTable;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.SQLDataType;

public class BrandTable extends AbstractDataTable<BrandTable> {

    public static final BrandTable TABLE = new BrandTable();

    public final TableField<Record, Long> id = createPKField("id", SQLDataType.BIGINT.identity(true));

    public final TableField<Record, String> name = createField("name", SQLDataType.VARCHAR.length(255));

    private BrandTable() {
        super("brand");
    }

    @Override
    public BrandTable as(String alias) {
        return new BrandTable();
    }
}