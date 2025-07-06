package com.glimmer.admin_panel.infrastructure.web.controller;

import com.glimmer.admin_panel.domain.port.in.PriceAdjustmentServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prices")
@Tag(name = "Precios", description = "Ajustes de márgenes y descuentos en productos")
public class PriceAdjustmentController {

    private final PriceAdjustmentServicePort service;

    public PriceAdjustmentController(PriceAdjustmentServicePort service) {
        this.service = service;
    }

    @PostMapping("/apply")
    public void applyMargin(@RequestParam String scope,
                            @RequestParam(required = false) String categoryId,
                            @RequestParam(required = false) String productId,
                            @RequestParam double margin,
                            @RequestParam double discountCash,
                            @RequestParam double discountTransfer) {

        service.applyAdjustment(scope, categoryId, productId, margin, discountCash, discountTransfer);
    }
}