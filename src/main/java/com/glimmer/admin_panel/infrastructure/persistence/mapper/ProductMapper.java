package com.glimmer.admin_panel.infrastructure.persistence.mapper;

import com.glimmer.admin_panel.domain.model.Product;
import com.glimmer.admin_panel.infrastructure.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
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

    public Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .costPrice(entity.getCostPrice())
                .listPrice(entity.getListPrice())
                .cashPrice(entity.getCashPrice())
                .transferPrice(entity.getTransferPrice())
                .imageUrl(entity.getImageUrl())
                .detail(entity.getDetail())
                .categoryId(entity.getCategoryId())
                .build();
    }
}