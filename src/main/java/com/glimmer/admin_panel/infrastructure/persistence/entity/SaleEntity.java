package com.glimmer.admin_panel.infrastructure.persistence.entity;

import com.glimmer.admin_panel.domain.model.PaymentMethod;
import com.glimmer.admin_panel.domain.model.SaleStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("sales")
public class SaleEntity {
    @Id
    private String id;
    private LocalDateTime date;
    private List<SaleItemEntity> items;
    private PaymentMethod paymentMethod;
    private SaleStatus status;
}