package io.skai.accounting.service.impl;

import io.skai.accounting.dto.model.ModelRequestDto;
import io.skai.accounting.dto.model.ModelResponseDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.pojos.Model;
import io.skai.accounting.mappers.ModelMapper;
import io.skai.accounting.repo.ModelRepository;
import io.skai.accounting.service.BrandService;
import io.skai.accounting.service.ModelService;
import io.skai.accounting.validators.impl.brand.BrandExistsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelMapper modelMapper;
    private final BrandExistsValidator brandExistsValidator;
    private final ModelRepository modelRepository;
    private final BrandService brandService;

    @Override
    public ModelResponseDto create(final ModelRequestDto dto) {
        log.debug("brand id is {}", dto.getBrandId());

        brandExistsValidator.validate(new Brand(dto.getBrandId(), null));
        Model model = modelRepository.create(dto.getBrandId(), dto.getName());
        return modelMapper.toModelResponseDto(model);
    }

    @Override
    public List<ModelResponseDto> findAllDtoByBrandId(final Long brandId) {
        log.trace("Find all models DTO by brand id call");
        List<Model> models = modelRepository.findAllByBrandId(brandId);
        //return modelMapper.toModelResponseDtoList(models);
        return mapModelList(models);
    }

    private List<ModelResponseDto> mapModelList(List<Model> models) {
        //Todo:: move brands query in map<Long, Brand>
        //Todo::Look redis
        return models.stream()
                .map(model -> modelMapper.toModelResponseDto(model, brandService.findById(model.getBrandId())))
                .toList();
    }
}
