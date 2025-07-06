package com.glimmer.admin_panel.infrastructure.web.controller;

import com.glimmer.admin_panel.domain.model.Sale;
import com.glimmer.admin_panel.domain.port.in.SaleTrackingServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
@Tag(name = "Tracking", description = "Trazabilidad de ventas")
public class SaleTrackingController {

    private final SaleTrackingServicePort saleTrackingService;

    public SaleTrackingController(SaleTrackingServicePort saleTrackingService) {
        this.saleTrackingService = saleTrackingService;
    }

    @GetMapping("/sales")
    public List<Sale> getAllTrackedSales() {
        return saleTrackingService.getAllSalesWithDetails();
    }
}