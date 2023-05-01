package io.skai.warehouse.mapper;

import com.kenshoo.pl.entity.CreateEntityCommand;
import com.kenshoo.pl.entity.EntityChangeResult;
import com.kenshoo.pl.entity.Identifier;
import io.skai.warehouse.dto.BrandDto;
import io.skai.warehouse.model.BrandEntity;
import io.skai.warehouse.util.ChangeResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BrandMapper {

    private final ChangeResultUtils fieldGetter;

    public BrandDto toBrandDto(EntityChangeResult<BrandEntity, Identifier<BrandEntity>,
            CreateEntityCommand<BrandEntity>> result) {
        String name = fieldGetter.get(result, BrandEntity.NAME);
        String country = fieldGetter.get(result, BrandEntity.COUNTRY);
        String url = fieldGetter.get(result, BrandEntity.URL);
        Long id = fieldGetter.get(result, BrandEntity.ID);

        return new BrandDto(id, name, country, url);
    }
}