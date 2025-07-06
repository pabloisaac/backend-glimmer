package com.glimmer.admin_panel.domain.port.out;

import com.glimmer.admin_panel.domain.model.Sale;
import java.util.List;
import java.util.Optional;

public interface SaleRepositoryPort {
    Sale save(Sale sale);
    Optional<Sale> findById(String id);
    List<Sale> findAll();
    void deleteById(String id);
}