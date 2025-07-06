package com.glimmer.admin_panel.infrastructure.persistence.mapper;

import com.glimmer.admin_panel.domain.model.Sale;
import com.glimmer.admin_panel.domain.model.SaleItem;
import com.glimmer.admin_panel.infrastructure.persistence.entity.SaleEntity;
import com.glimmer.admin_panel.infrastructure.persistence.entity.SaleItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaleMapper {

    public SaleEntity toEntity(Sale sale) {
        return SaleEntity.builder()
                .id(sale.getId())
                .date(sale.getDate())
                .paymentMethod(sale.getPaymentMethod())
                .status(sale.getStatus())
                .items(sale.getItems().stream()
                        .map(i -> SaleItemEntity.builder()
                                .productId(i.getProductId())
                                .quantity(i.getQuantity())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public Sale toDomain(SaleEntity entity) {
        return Sale.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .paymentMethod(entity.getPaymentMethod())
                .status(entity.getStatus())
                .items(entity.getItems().stream()
                        .map(i -> SaleItem.builder()
                                .productId(i.getProductId())
                                .quantity(i.getQuantity())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}