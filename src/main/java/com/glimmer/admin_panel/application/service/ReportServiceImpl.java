package com.glimmer.admin_panel.application.service;

import com.glimmer.admin_panel.domain.dto.MonthlyReport;
import com.glimmer.admin_panel.domain.model.*;
import com.glimmer.admin_panel.domain.port.in.ReportServicePort;
import com.glimmer.admin_panel.domain.port.out.ProductRepositoryPort;
import com.glimmer.admin_panel.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportServicePort {

    private final SaleRepositoryPort saleRepository;
    private final ProductRepositoryPort productRepository;

    public ReportServiceImpl(SaleRepositoryPort saleRepository, ProductRepositoryPort productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    @Override
    public MonthlyReport getMonthlyReport(int year, int month, double manualExpenses) {
        List<Sale> allSales = saleRepository.findAll().stream()
                .filter(s -> s.getDate().getYear() == year && s.getDate().getMonthValue() == month)
                .filter(s -> s.getStatus() == SaleStatus.PROCESADA)
                .toList();

        Map<String, BigDecimal> totalByPaymentMethod = new HashMap<>();
        BigDecimal totalRevenue = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Sale sale : allSales) {
            BigDecimal saleTotal = BigDecimal.ZERO;
            BigDecimal saleCost = BigDecimal.ZERO;

            for (SaleItem item : sale.getItems()) {
                var productOpt = productRepository.findById(item.getProductId());
                if (productOpt.isEmpty()) continue;
                var product = productOpt.get();

                // Precio de venta según método de pago
                BigDecimal price = switch (sale.getPaymentMethod()) {
                    case EFECTIVO -> product.getCashPrice();
                    case TRANSFERENCIA -> product.getTransferPrice();
                    case QR, TARJETA_CREDITO, TARJETA_DEBITO -> product.getListPrice();
                };

                BigDecimal qty = BigDecimal.valueOf(item.getQuantity());
                saleTotal = saleTotal.add(price.multiply(qty));
                saleCost = saleCost.add(product.getCostPrice().multiply(qty));
            }

            totalRevenue = totalRevenue.add(saleTotal);
            totalCost = totalCost.add(saleCost);

            String paymentKey = sale.getPaymentMethod().name();
            totalByPaymentMethod.put(paymentKey,
                    totalByPaymentMethod.getOrDefault(paymentKey, BigDecimal.ZERO).add(saleTotal));
        }

        BigDecimal expenses = BigDecimal.valueOf(manualExpenses);
        BigDecimal profit = totalRevenue.subtract(totalCost).subtract(expenses);

        return MonthlyReport.builder()
                .month(Month.of(month).name())
                .totalByPaymentMethod(totalByPaymentMethod)
                .totalRevenue(totalRevenue)
                .totalCost(totalCost)
                .totalExpenses(expenses)
                .profit(profit)
                .build();
    }
}