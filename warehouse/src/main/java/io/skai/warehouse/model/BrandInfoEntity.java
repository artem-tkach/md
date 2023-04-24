package io.skai.warehouse.model;

import com.kenshoo.jooq.DataTable;
import com.kenshoo.pl.entity.AbstractEntityType;
import com.kenshoo.pl.entity.EntityField;
import com.kenshoo.pl.entity.annotation.Id;
import com.kenshoo.pl.entity.annotation.Immutable;
import com.kenshoo.pl.entity.annotation.Required;
import io.skai.warehouse.table.BrandInfoTable;

import static com.kenshoo.pl.entity.annotation.RequiredFieldType.RELATION;

public class BrandInfoEntity extends AbstractEntityType<BrandInfoEntity> {
    public static final BrandInfoEntity INSTANCE = new BrandInfoEntity();

    @Id
    @Immutable
    public static final EntityField<BrandInfoEntity, Long> ID = INSTANCE.field(BrandInfoTable.TABLE.id);

    @Required
    @Immutable
    public static final EntityField<BrandInfoEntity, String> COUNTRY = INSTANCE.field(BrandInfoTable.TABLE.country);

    @Required
    @Immutable
    public static final EntityField<BrandInfoEntity, String> URL = INSTANCE.field(BrandInfoTable.TABLE.url);

    @Required(RELATION)
    @Immutable
    public static final EntityField<BrandInfoEntity, Long> BRAND_ID = INSTANCE.field(BrandInfoTable.TABLE.brandId);

    protected BrandInfoEntity() {
        super("brand_info");
    }

    @Override
    public DataTable getPrimaryTable() {
        return BrandInfoTable.TABLE;
    }
}