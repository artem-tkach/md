package io.skai.warehouse.table;

import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.SQLDataType;

public class BrandInfoTable extends com.kenshoo.jooq.AbstractDataTable<BrandInfoTable> {

    public static final BrandInfoTable TABLE = new BrandInfoTable();

    public final TableField<Record, Long> id = createPKField("id", SQLDataType.BIGINT.identity(true));

    public final TableField<Record, Long> brandId = createFKField("brand_id",BrandTable.TABLE.id);

    public final TableField<Record, String> country = createField("country", SQLDataType.VARCHAR.length(255));

    public final TableField<Record, String> url = createField("url", SQLDataType.VARCHAR.length(255));

    private BrandInfoTable() {
        super("brand_info");
    }

    @Override
    public BrandInfoTable as(String alias) {
        return new BrandInfoTable();
    }
}