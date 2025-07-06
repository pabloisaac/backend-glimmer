package com.glimmer.admin_panel.application.service;

import com.glimmer.admin_panel.domain.model.Sale;
import com.glimmer.admin_panel.domain.model.SaleItem;
import com.glimmer.admin_panel.domain.model.SaleStatus;
import com.glimmer.admin_panel.domain.port.in.SaleServicePort;
import com.glimmer.admin_panel.domain.port.out.ProductRepositoryPort;
import com.glimmer.admin_panel.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleServicePort {

    private final SaleRepositoryPort saleRepository;

    private final ProductRepositoryPort productRepository;

    public SaleServiceImpl(SaleRepositoryPort saleRepository, ProductRepositoryPort productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Sale registerSale(Sale sale) {
        sale.setDate(LocalDateTime.now());
        sale.setStatus(SaleStatus.PROCESADA);

        // Restar stock
        for (SaleItem item : sale.getItems()) {
            var product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getProductId()));

            if (product.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Stock insuficiente para producto: " + product.getName());
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepository.save(product);
        }

        return saleRepository.save(sale);
    }


    @Override
    public void cancelSale(String id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        if (sale.getStatus() == SaleStatus.CANCELADA) return;

        // Reponer stock
        for (SaleItem item : sale.getItems()) {
            var product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getProductId()));

            product.setQuantity(product.getQuantity() + item.getQuantity());
            productRepository.save(product);
        }

        sale.setStatus(SaleStatus.CANCELADA);
        saleRepository.save(sale);
    }


    @Override
    public Sale getSaleById(String id) {
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
}