package com.glimmer.admin_panel.domain.port.in;

import com.glimmer.admin_panel.domain.model.Product;
import java.util.List;

public interface ProductServicePort {
    Product create(Product product);
    Product update(String id, Product product);
    void delete(String id);
    Product getById(String id);
    List<Product> getAll();
    List<Product> getLowStockProducts(int threshold);
}