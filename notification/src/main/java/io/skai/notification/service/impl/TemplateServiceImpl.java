package io.skai.notification.service.impl;

import io.skai.notification.enums.OrderStatus;
import io.skai.notification.model.Template;
import io.skai.notification.repository.TemplateRepository;
import io.skai.notification.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    @Override
    public Template create(Template template) {
        return templateRepository.save(template);
    }

    @Override
    public List<Template> getAll() {
        return templateRepository.findAll();
    }

    @Override
    public List<Template> getAll(OrderStatus orderStatus) {
        return templateRepository.findAllByStatus(orderStatus);
    }

    @Override
    public Template findLast(OrderStatus status) {
        return templateRepository.findFirstByStatusOrderByIdDesc(status);
    }
}