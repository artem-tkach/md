package io.skai.notification.repository;

import io.skai.notification.enums.OrderStatus;
import io.skai.notification.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateRepository extends JpaRepository<Template, Long> {

    List<Template> findAllByStatus(OrderStatus status);
}