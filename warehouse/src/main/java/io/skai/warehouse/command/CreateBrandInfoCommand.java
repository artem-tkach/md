package io.skai.warehouse.command;

import com.kenshoo.pl.entity.CreateEntityCommand;
import io.skai.warehouse.model.BrandInfoEntity;

public class CreateBrandInfoCommand extends CreateEntityCommand<BrandInfoEntity> {
    public CreateBrandInfoCommand() {
        super(BrandInfoEntity.INSTANCE);
    }
}