package com.glimmer.admin_panel.application.service;

import com.glimmer.admin_panel.domain.model.Sale;
import com.glimmer.admin_panel.domain.port.in.SaleTrackingServicePort;
import com.glimmer.admin_panel.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTrackingServiceImpl implements SaleTrackingServicePort {

    private final SaleRepositoryPort saleRepository;

    public SaleTrackingServiceImpl(SaleRepositoryPort saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getAllSalesWithDetails() {
        return saleRepository.findAll();
    }
}