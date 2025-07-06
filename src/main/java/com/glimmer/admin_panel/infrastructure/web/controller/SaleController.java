package com.glimmer.admin_panel.infrastructure.web.controller;

import com.glimmer.admin_panel.domain.model.PaymentMethod;
import com.glimmer.admin_panel.domain.model.Sale;
import com.glimmer.admin_panel.domain.model.SaleItem;
import com.glimmer.admin_panel.domain.model.SaleStatus;
import com.glimmer.admin_panel.domain.port.in.SaleServicePort;
import com.glimmer.admin_panel.infrastructure.web.dto.SaleRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@Tag(name = "Sales", description = "Gestión de ventas")
public class SaleController {

    private final SaleServicePort saleService;

    public SaleController(SaleServicePort saleService) {
        this.saleService = saleService;
    }

    @Operation(summary = "Registrar una nueva venta")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale create(@RequestBody SaleRequestDTO request) {
        List<SaleItem> items = request.getItems().stream()
                .map(i -> new SaleItem(i.getProductId(), i.getQuantity()))
                .toList();

        Sale sale = Sale.builder()
                .date(request.getDate().toLocalDateTime())
                .items(items)
                .paymentMethod(PaymentMethod.valueOf(request.getPaymentMethod().toUpperCase()))
                .status(SaleStatus.PROCESADA)
                .build();

        return saleService.registerSale(sale);
    }

    @Operation(summary = "Cancelar una venta")
    @PostMapping("/{id}/cancel")
    public void cancel(@PathVariable String id) {
        saleService.cancelSale(id);
    }

    @Operation(summary = "Obtener una venta por ID")
    @GetMapping("/{id}")
    public Sale get(@PathVariable String id) {
        return saleService.getSaleById(id);
    }

    @Operation(summary = "Listar todas las ventas")
    @GetMapping
    public List<Sale> getAll() {
        return saleService.getAllSales();
    }
}