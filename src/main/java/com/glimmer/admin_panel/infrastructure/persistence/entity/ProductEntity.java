package com.glimmer.admin_panel.infrastructure.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class ProductEntity {

    @Id
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