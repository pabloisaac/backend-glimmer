package com.glimmer.admin_panel.infrastructure.web.dto;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class SaleRequestDTO {
    private OffsetDateTime date;
    private List<SaleItemRequestDTO> items;
    private String paymentMethod;
}