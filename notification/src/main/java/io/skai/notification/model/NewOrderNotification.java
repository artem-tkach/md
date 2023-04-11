package io.skai.notification.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "new_order")
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class NewOrderNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "model_id")
    private Long modelId;
    @Column(name = "model_name")
    private String modelName;
    @Column
    private String defect;
}
