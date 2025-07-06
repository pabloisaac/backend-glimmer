package com.glimmer.admin_panel.domain.port.in;

import com.glimmer.admin_panel.domain.model.Sale;
import java.util.List;

public interface SaleServicePort {
    Sale registerSale(Sale sale);
    void cancelSale(String id);
    Sale getSaleById(String id);
    List<Sale> getAllSales();
}