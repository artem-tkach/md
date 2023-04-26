package io.skai.warehouse.model;

import com.kenshoo.jooq.DataTable;
import com.kenshoo.pl.entity.AbstractEntityType;
import com.kenshoo.pl.entity.EntityField;
import com.kenshoo.pl.entity.annotation.Id;
import com.kenshoo.pl.entity.annotation.Immutable;
import com.kenshoo.pl.entity.annotation.Required;
import io.skai.warehouse.table.BrandInfoTable;
import io.skai.warehouse.table.BrandTable;

public class BrandEntity extends AbstractEntityType<BrandEntity> {

    public static final BrandEntity INSTANCE = new BrandEntity();

    @Id
    @Immutable
    public static final EntityField<BrandEntity, Long> ID = INSTANCE.field(BrandTable.TABLE.id);

    @Required
    @Immutable
    public static final EntityField<BrandEntity, String> NAME = INSTANCE.field(BrandTable.TABLE.name);//

    @Required
    @Immutable
    public static final EntityField<BrandEntity, String> COUNTRY = INSTANCE.field(BrandInfoTable.TABLE.country);

    @Required
    @Immutable
    public static final EntityField<BrandEntity, String> URL = INSTANCE.field(BrandInfoTable.TABLE.url);

    protected BrandEntity() {
        super("brandEntity");
    }

    @Override
    public DataTable getPrimaryTable() {
        return BrandTable.TABLE;
    }
}