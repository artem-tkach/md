package io.skai.notification.service;

import io.skai.notification.enums.OrderStatus;
import io.skai.notification.model.Template;

import java.util.List;

public interface TemplateService {

    Template create(Template template);

    List<Template>getAll();

    List<Template> getAll(OrderStatus orderStatus);

    Template findOneLast(OrderStatus status);
}