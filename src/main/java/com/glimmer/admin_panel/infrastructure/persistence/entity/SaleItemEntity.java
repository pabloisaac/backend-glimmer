package com.glimmer.admin_panel.infrastructure.persistence.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemEntity {
    private String productId;
    private int quantity;
}