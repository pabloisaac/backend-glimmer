package com.glimmer.admin_panel.application.service;

import com.glimmer.admin_panel.domain.model.Product;
import com.glimmer.admin_panel.domain.port.in.PriceAdjustmentServicePort;
import com.glimmer.admin_panel.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PriceAdjustmentServiceImpl implements PriceAdjustmentServicePort {

    private final ProductRepositoryPort productRepository;

    public PriceAdjustmentServiceImpl(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void applyAdjustment(String scope, String categoryId, String productId,
                                double margin, double discountCash, double discountTransfer) {

        List<Product> products = switch (scope.toLowerCase()) {
            case "all" -> productRepository.findAll();
            case "category" -> productRepository.findAll().stream()
                    .filter(p -> categoryId != null && categoryId.equals(p.getCategoryId()))
                    .toList();
            case "product" -> productRepository.findById(productId)
                    .map(List::of)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            default -> throw new IllegalArgumentException("Scope inválido: debe ser all, category o product");
        };

        for (Product product : products) {
            BigDecimal cost = product.getCostPrice();
            BigDecimal list = cost.add(cost.multiply(BigDecimal.valueOf(margin / 100.0)));
            BigDecimal cash = list.subtract(list.multiply(BigDecimal.valueOf(discountCash / 100.0)));
            BigDecimal transfer = list.subtract(list.multiply(BigDecimal.valueOf(discountTransfer / 100.0)));

            product.setListPrice(list);
            product.setCashPrice(cash);
            product.setTransferPrice(transfer);
            productRepository.save(product);
        }
    }
}