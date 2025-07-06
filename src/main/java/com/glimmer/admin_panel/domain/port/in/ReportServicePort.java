package com.glimmer.admin_panel.domain.port.in;

import com.glimmer.admin_panel.domain.dto.MonthlyReport;

public interface ReportServicePort {
    MonthlyReport getMonthlyReport(int year, int month, double manualExpenses);
}