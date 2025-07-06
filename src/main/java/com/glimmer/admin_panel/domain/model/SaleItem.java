package com.glimmer.admin_panel.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItem {
    private String productId;
    private int quantity;
}