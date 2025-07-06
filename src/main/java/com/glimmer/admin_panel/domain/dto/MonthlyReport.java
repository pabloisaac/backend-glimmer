package com.glimmer.admin_panel.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
public class MonthlyReport {
    private String month;
    private Map<String, BigDecimal> totalByPaymentMethod;
    private BigDecimal totalCost;
    private BigDecimal totalRevenue;
    private BigDecimal totalExpenses;
    private BigDecimal profit;
}