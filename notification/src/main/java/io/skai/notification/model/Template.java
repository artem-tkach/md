package io.skai.notification.model;

import io.skai.notification.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.skai.notification.util.ValidationMessages.*;

@Entity
@Table(name="template")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @NotNull(message = NULL_ORDER_STATUS)
    private OrderStatus status;
    @Column
    @NotBlank(message = BLANK_TEMPLATE_BODY)
    private String body;
    @Column
    @NotBlank(message = BLANK_SUBJECT)
    private String subject;
}