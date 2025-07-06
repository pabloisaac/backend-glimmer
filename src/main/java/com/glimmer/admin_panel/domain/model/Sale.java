package com.glimmer.admin_panel.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    private String id;
    private LocalDateTime date;
    private List<SaleItem> items;
    private PaymentMethod paymentMethod;
    private SaleStatus status;
}