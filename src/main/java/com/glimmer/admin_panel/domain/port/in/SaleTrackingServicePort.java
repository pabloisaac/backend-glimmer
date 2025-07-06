package com.glimmer.admin_panel.domain.port.in;

import com.glimmer.admin_panel.domain.model.Sale;

import java.util.List;

public interface SaleTrackingServicePort {
    List<Sale> getAllSalesWithDetails(); // Por ahora es igual a getAll, luego se puede enriquecer
}