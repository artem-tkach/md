package io.skai.accounting.service.impl;

import io.skai.accounting.dto.model.ModelDto;
import io.skai.accounting.dto.model.ModelRequestDto;
import io.skai.accounting.jooq.tables.pojos.Brand;
import io.skai.accounting.jooq.tables.pojos.Model;
import io.skai.accounting.mappers.ModelMapper;
import io.skai.accounting.repository.ModelRepository;
import io.skai.accounting.service.BrandService;
import io.skai.accounting.service.ModelService;
import io.skai.accounting.validators.impl.brand.BrandExistsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelMapper modelMapper;
    private final BrandExistsValidator brandExistsValidator;
    private final ModelRepository modelRepository;
    private final BrandService brandService;

    @Override
    public ModelDto create(ModelRequestDto dto) {
        brandExistsValidator.validate(new Brand(dto.brandId(), null));
        Model model = modelRepository.findOrCreate(dto.brandId(), dto.name());
        return mapToModelDto(model);
    }

    @Override
    public List<ModelDto> findAllDto(Long brandId) {
        List<Model> models = modelRepository.findAll(brandId);
        return mapModelList(models);
    }

    private List<ModelDto> mapModelList(List<Model> models) {
        return models.stream()
                .map(this::mapToModelDto)
                .toList();
    }
    private ModelDto mapToModelDto(Model model){
        return modelMapper.toModelDto(model, brandService.findOne(model.getBrandId()));
    }
}
