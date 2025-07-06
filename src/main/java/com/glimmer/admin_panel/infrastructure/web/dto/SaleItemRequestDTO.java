package com.glimmer.admin_panel.infrastructure.web.dto;

import lombok.Data;

@Data
public class SaleItemRequestDTO {
    private String productId;
    private Integer quantity;
}
