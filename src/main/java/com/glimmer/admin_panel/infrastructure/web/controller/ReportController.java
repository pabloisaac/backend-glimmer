package com.glimmer.admin_panel.infrastructure.web.controller;

import com.glimmer.admin_panel.domain.dto.MonthlyReport;
import com.glimmer.admin_panel.domain.port.in.ReportServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@Tag(name = "Reports", description = "Reportes de caja y ganancias")
public class ReportController {

    private final ReportServicePort reportService;

    public ReportController(ReportServicePort reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/monthly")
    public MonthlyReport getReport(@RequestParam int year,
                                   @RequestParam int month,
                                   @RequestParam double expenses) {
        return reportService.getMonthlyReport(year, month, expenses);
    }
}