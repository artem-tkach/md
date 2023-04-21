package io.skai.warehouse.service.brand;

import com.kenshoo.pl.entity.*;
import io.skai.warehouse.command.CreateBrandCommand;
import io.skai.warehouse.command.builder.BrandCommandsBuilder;
import io.skai.warehouse.dto.BrandDto;
import io.skai.warehouse.model.BrandEntity;
import io.skai.warehouse.repository.BrandPersistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.lambda.Seq.seq;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandService {

    private final BrandPersistence brandPersistence;
    private final BrandCommandsBuilder brandCommandsBuilder;

    public List<BrandDto> create(List<BrandDto> dto) {
        List<CreateBrandCommand> commands = brandCommandsBuilder.buildCreateCommands(dto);

        CreateResult<BrandEntity, Identifier<BrandEntity>> result = brandPersistence.create(commands);

        return seq(result.getChangeResults())
                .stream()
                .map(this::mapResults)
                .toList();
    }

    private BrandDto mapResults(EntityChangeResult<BrandEntity, Identifier<BrandEntity>, CreateEntityCommand<BrandEntity>> result) {
        String name = getValuefromResult(result, BrandEntity.NAME);
        String country = getValuefromResult(result, BrandEntity.COUNTRY);
        String url = getValuefromResult(result, BrandEntity.URL);
        Long id = getValuefromResult(result, BrandEntity.ID);

        return new BrandDto(id, name, country, url);
    }

    private <T> T getValuefromResult(EntityChangeResult<BrandEntity, Identifier<BrandEntity>, CreateEntityCommand<BrandEntity>> result,
                                     EntityField<BrandEntity, T> field) {
        return result.getCommand().get(field);
    }
}