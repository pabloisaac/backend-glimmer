package com.glimmer.admin_panel.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Datos para actualizar un producto")
public class ProductUpdateDTO {

    @NotBlank
    @Schema(description = "Código del producto")
    private String code;

    @NotBlank
    @Schema(description = "Nombre del producto")
    private String name;

    @NotNull
    @Min(0)
    @Schema(description = "Cantidad")
    private Integer quantity;

    @NotNull
    @DecimalMin("0.0")
    @Schema(description = "Precio de costo")
    private BigDecimal costPrice;

    @Schema(description = "URL de imagen")
    private String imageUrl;

    @Schema(description = "Detalle del producto")
    private String detail;

    @Schema(description = "ID de la categoría")
    private String categoryId;
}