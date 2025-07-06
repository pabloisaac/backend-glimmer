package com.glimmer.admin_panel.application.service;

import com.glimmer.admin_panel.domain.model.Product;
import com.glimmer.admin_panel.domain.port.in.ProductServicePort;
import com.glimmer.admin_panel.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductServiceImpl is the application service that handles business logic
 * related to products. It communicates with the domain's repository port.
 */
@Service
public class ProductServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepository;

    public ProductServiceImpl(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.findAll().stream()
                .filter(p -> p.getQuantity() != null && p.getQuantity() <= threshold)
                .toList();
    }
}