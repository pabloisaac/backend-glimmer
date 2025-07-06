package com.glimmer.admin_panel.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Producto expuesto por la API")
public class ProductDTO {

    @Schema(description = "ID del producto")
    private String id;

    @Schema(description = "Código del producto")
    private String code;

    @Schema(description = "Nombre del producto")
    private String name;

    @Schema(description = "Cantidad disponible")
    private Integer quantity;

    @Schema(description = "Precio de costo")
    private BigDecimal costPrice;

    @Schema(description = "Precio de lista")
    private BigDecimal listPrice;

    @Schema(description = "Precio en efectivo")
    private BigDecimal cashPrice;

    @Schema(description = "Precio por transferencia")
    private BigDecimal transferPrice;

    @Schema(description = "URL de imagen")
    private String imageUrl;

    @Schema(description = "Descripción del producto")
    private String detail;

    @Schema(description = "ID de la categoría")
    private String categoryId;
}