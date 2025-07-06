package com.glimmer.admin_panel.infrastructure.web.mapper;

import com.glimmer.admin_panel.domain.model.Product;
import com.glimmer.admin_panel.infrastructure.web.dto.ProductCreateDTO;
import com.glimmer.admin_panel.infrastructure.web.dto.ProductDTO;
import com.glimmer.admin_panel.infrastructure.web.dto.ProductUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOMapper {

    public ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .quantity(product.getQuantity())
                .costPrice(product.getCostPrice())
                .listPrice(product.getListPrice())
                .cashPrice(product.getCashPrice())
                .transferPrice(product.getTransferPrice())
                .imageUrl(product.getImageUrl())
                .detail(product.getDetail())
                .categoryId(product.getCategoryId())
                .build();
    }

    public Product toDomain(ProductCreateDTO dto) {
        return Product.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .costPrice(dto.getCostPrice())
                .imageUrl(dto.getImageUrl())
                .detail(dto.getDetail())
                .categoryId(dto.getCategoryId())
                .build();
    }

    public Product toDomain(String id, ProductUpdateDTO dto) {
        return Product.builder()
                .id(id)
                .code(dto.getCode())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .costPrice(dto.getCostPrice())
                .imageUrl(dto.getImageUrl())
                .detail(dto.getDetail())
                .categoryId(dto.getCategoryId())
                .build();
    }

}