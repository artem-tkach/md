package io.skai.warehouse.command;

import com.kenshoo.pl.entity.CreateEntityCommand;
import io.skai.warehouse.model.BrandEntity;

public class CreateBrandCommand extends CreateEntityCommand<BrandEntity> {

    public CreateBrandCommand() {
        super(BrandEntity.INSTANCE);
    }
}