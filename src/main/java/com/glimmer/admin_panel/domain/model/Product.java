package com.glimmer.admin_panel.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String id;
    private String code;
    private String name;
    private Integer quantity;
    private BigDecimal costPrice;
    private BigDecimal listPrice;
    private BigDecimal cashPrice;
    private BigDecimal transferPrice;
    private String imageUrl;
    private String detail;
    private String categoryId;
}