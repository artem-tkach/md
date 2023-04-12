package io.skai.notification.model;

import io.skai.notification.enums.OrderStatus;
import jakarta.persistence.*;

@Entity
@Table(name="template")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column
    private String body;
    @Column
    private String subject;
}